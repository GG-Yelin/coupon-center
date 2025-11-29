package com.wy.coupon.calculation.template;

import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.template.impl.*;
import com.wy.coupon.template.api.beans.CouponTemplateInfo;
import com.wy.coupon.template.api.enums.CouponType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

// 工厂方法根据订单中的优惠券信息，返回对应的Template用于计算优惠价
@Component
@Slf4j
public class CouponTemplateFactory {


    @Autowired
    private MoneyOffTemplate moneyOffTemplate;

    @Autowired
    private DiscountTemplate discountTemplate;

    @Autowired
    private RandomReductionTemplate randomReductionTemplate;

    @Autowired
    private LonelyNightTemplate lonelyNightTemplate;

    @Autowired
    private DummyTemplate dummyTemplate;

    @Autowired
    private AntiPauTemplate antiPauTemplate;

    public RuleTemplate getTemplate(ShoppingCart order) {
        // 不使用优惠券
        if (CollectionUtils.isEmpty(order.getCouponInfos())) {
            return dummyTemplate;
        }

        CouponTemplateInfo template = order.getCouponInfos().get(0).getTemplate();
        CouponType category = CouponType.covert(template.getType());

        switch (category) {
            case MONEY_ORDER:
                return moneyOffTemplate;
            case RANDOM_DISCOUNT:
                return randomReductionTemplate;
            case LONELY_NIGHT_MONEY_OFF:
                return lonelyNightTemplate;
            case DISCOUNT:
                return discountTemplate;
            case ANTI_PUA:
                return antiPauTemplate;
            default:
                return dummyTemplate;
        }

    }


}
