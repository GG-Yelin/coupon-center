package com.wy.coupon.calculation.template.impl;

import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.template.AbstractRuleTemplate;
import com.wy.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 空实现
 */
@Slf4j
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        long orderTotalAmount = getTotalPrice(order.getProducts());

        order.setCost(orderTotalAmount);
        return order;
    }
}
