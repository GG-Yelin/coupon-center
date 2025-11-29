package com.wy.coupon.template.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CouponType {

    UNKNOWN("UNKNOWN", "0"),
    MONEY_ORDER("满减券", "1"),
    DISCOUNT("折扣券", "2"),
    RANDOM_DISCOUNT("随机减", "3"),
    LONELY_NIGHT_MONEY_OFF("晚间双倍优惠券", "4"),
    ANTI_PUA("PUA加倍奉还券", "5"),

    ;

    private String code;
    private String description;

    public static CouponType covert(String code) {
        return Stream.of(values())
                .filter(bean -> bean.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
