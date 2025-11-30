package com.wy.coupon.calculation.api.beans;

import com.wy.coupon.template.api.beans.CouponInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 订单信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    // 订单列表
    @NotEmpty
    private List<Product> products;

    private Long couponId;

    // 目前只支持单张优惠券，便于以后扩展
    private List<CouponInfo> couponInfos;

    // 订单的最终价格
    private long cost;

    // 用户Id
    @NotNull
    private Long userId;

}

