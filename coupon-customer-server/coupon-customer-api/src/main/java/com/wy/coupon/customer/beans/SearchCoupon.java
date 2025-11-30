package com.wy.coupon.customer.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCoupon {

    @NotNull
    private Long userId;

    private Long shopId;

    private Integer couponStatus;

}
