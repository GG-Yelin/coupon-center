package com.wy.coupon.customer.event;

import com.wy.coupon.customer.beans.RequestCoupon;
import com.wy.coupon.customer.service.CouponCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CouponConsumer {

    @Autowired
    private CouponCustomerService customerService;

    @Bean
    public Consumer<RequestCoupon> addCoupon() {
        return request -> {
            log.info("received: {}", request);
            customerService.requestCoupon(request);
        };
    }

    @Bean
    public Consumer<String> deleteCoupon() {
        return request -> {
            log.info("received: {}", request);
            List<Long> params = Arrays.stream(request.split(","))
                    .map(Long::valueOf)
                    .collect(Collectors.toList());
            customerService.deleteCoupon(params.get(0), params.get(1));
        };
    }

    @ServiceActivator(inputChannel = "delete-coupon-topic.delete-coupon-group.errors")
    public void deleteCouponFallback(ErrorMessage errorMessage) throws Exception {
        log.info("consumer error: {}", errorMessage);

        // 抛出异常，进入死信队列
        throw new RuntimeException("重试仍失败");

    }



}
