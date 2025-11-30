package com.wy.coupon.customer.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 用户领券
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCoupon {

    @NotNull
    private Long userId;

    @NotNull
    private Long couponTemplateId;

}
