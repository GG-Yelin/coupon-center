package com.wy.coupon.customer.feign.intercpter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenfeignSentinelInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("SentinelSource", "coupon-customer-server");
    }
}
