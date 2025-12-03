package com.wy.coupon.customer.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

//    @Bean
//    @LoadBalanced
//    public WebClient.Builder register() {
//        return WebClient.builder();
//    }

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

}
