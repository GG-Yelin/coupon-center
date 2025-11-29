package com.wy.coupon.calculation.service;

import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.api.beans.SimulationOrder;
import com.wy.coupon.calculation.api.beans.SimulationResponse;

public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(ShoppingCart cart);

    SimulationResponse simulateOrder(SimulationOrder cart);

}
