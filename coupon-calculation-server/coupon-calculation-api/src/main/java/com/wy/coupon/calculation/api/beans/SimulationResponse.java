package com.wy.coupon.calculation.api.beans;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class SimulationResponse {

    // 最省钱的优惠券
    private Long bestCouponId;

    // 每一个优惠券对应的order价格
    private Map<Long, Long> couponToOrderPrice = Maps.newHashMap();
}
