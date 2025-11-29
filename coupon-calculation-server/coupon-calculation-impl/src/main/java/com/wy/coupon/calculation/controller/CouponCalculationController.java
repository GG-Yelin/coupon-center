package com.wy.coupon.calculation.controller;

import com.alibaba.fastjson.JSON;
import com.wy.coupon.calculation.api.beans.ShoppingCart;
import com.wy.coupon.calculation.api.beans.SimulationOrder;
import com.wy.coupon.calculation.api.beans.SimulationResponse;
import com.wy.coupon.calculation.service.CouponCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/calculator")
public class CouponCalculationController {

    @Autowired
    private CouponCalculationService calculationService;

    @PostMapping("/calculate")
    public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart settlement) {
        log.info("do calculation: {}", JSON.toJSONString(settlement));
        return calculationService.calculateOrderPrice(settlement);
    }

    @PostMapping("/simulate")
    public SimulationResponse simulateOrder(@RequestBody SimulationOrder simulator) {
        log.info("do simulation: {}", JSON.toJSONString(simulator));
        return calculationService.simulateOrder(simulator);
    }

}
