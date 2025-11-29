package com.wy.coupon.calculation.template.impl;

import com.wy.coupon.calculation.template.AbstractRuleTemplate;
import com.wy.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 打折优惠券
 */
@Component
@Slf4j
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {


    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopTotalAmount, Long quota) {
        Long newPrice = convertToDecimal(shopTotalAmount * (quota.doubleValue() / 100));
        log.debug("original price={}, new price={}", totalAmount, newPrice);
        return totalAmount - (shopTotalAmount - newPrice);
    }

}
