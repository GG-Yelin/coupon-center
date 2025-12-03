package com.wy.coupon.customer.feign;

import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.api.beans.SimulationOrder;
import com.wy.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "coupon-calculation-server", path = "/calculation")
public interface CalculationService {

    @PostMapping("/calculate")
    ShoppingCart calculate(ShoppingCart order);

    @PostMapping("/simulate")
    SimulationResponse simulateOrder(SimulationOrder simulator);


}
