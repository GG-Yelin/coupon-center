package com.wy.coupon.template.api.beans;

import javax.validation.constraints.NotNull;

public class CouponTemplateInfo {

    private Long id;

    // 优惠券名称
    @NotNull
    private String name;

    // 优惠券描述
    @NotNull
    private String desc;

    // 优惠券类型
    @NotNull
    private String type;

    // 优惠券适用门店 - 若无则为全店通用券
    private Long shopId;

    // 优惠券适用规则
    @NotNull
    private TemplateRule rule;

    // 当前模版是否为可用状态
    private Boolean available;
}
