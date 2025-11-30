package com.wy.coupon.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CouponCalculationImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponCalculationImplApplication.class, args);
    }

}
