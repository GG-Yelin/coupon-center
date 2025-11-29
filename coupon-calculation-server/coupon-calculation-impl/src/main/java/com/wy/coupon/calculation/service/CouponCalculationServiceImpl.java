package com.wy.coupon.calculation.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.api.beans.SimulationOrder;
import com.wy.coupon.calculation.api.beans.SimulationResponse;
import com.wy.coupon.calculation.template.CouponTemplateFactory;
import com.wy.coupon.calculation.template.RuleTemplate;
import com.wy.coupon.template.api.beans.CouponInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CouponCalculationServiceImpl implements CouponCalculationService{

    @Autowired
    private CouponTemplateFactory couponTemplateFactory;

    @Override
    public ShoppingCart calculateOrderPrice(ShoppingCart cart) {
        log.info("calculate order price: {}", JSON.toJSONString(cart));
        RuleTemplate ruleTemplate = couponTemplateFactory.getTemplate(cart);
        return ruleTemplate.calculate(cart);
    }

    @Override
    public SimulationResponse simulateOrder(SimulationOrder order) {
        SimulationResponse response = new SimulationResponse();
        Long minOrderPrice = Long.MAX_VALUE;

        // 计算每一张优惠券的订单价格
        for (CouponInfo coupon : order.getCouponInfos()) {
            ShoppingCart cart = new ShoppingCart();
            cart.setProducts(order.getProducts());
            cart.setCouponInfos(Lists.newArrayList(coupon));
            cart = couponTemplateFactory.getTemplate(cart).calculate(cart);

            Long couponId = coupon.getId();
            Long orderPrice = cart.getCost();

            // 设置当前优惠券对应的订单价格
            response.getCouponToOrderPrice().put(couponId, orderPrice);

            if (minOrderPrice > orderPrice) {
                response.setBestCouponId(couponId);
                minOrderPrice = orderPrice;
            }

        }

        return response;
    }
}





