package com.wy.coupon.customer.service;

import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.api.beans.SimulationOrder;
import com.wy.coupon.calculation.api.beans.SimulationResponse;
import com.wy.coupon.customer.beans.RequestCoupon;
import com.wy.coupon.customer.beans.SearchCoupon;
import com.wy.coupon.customer.entity.Coupon;
import com.wy.coupon.template.api.beans.CouponInfo;

import java.util.List;

// 用户接口
public interface CouponCustomerService {

    // 领券接口
    Coupon requestCoupon(RequestCoupon request);

    // 核销优惠券
    ShoppingCart placeOrder(ShoppingCart info);

    // 优惠券金额试算
    SimulationResponse simulateOrderPrice(SimulationOrder order);

    // 查询用户优惠券
    List<CouponInfo> findCoupon(SearchCoupon request);

    // 删除
    void deleteCoupon(Long userId, Long couponId);

}
