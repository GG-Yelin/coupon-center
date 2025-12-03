package com.wy.coupon.customer.feign;

import com.wy.coupon.template.api.beans.CouponTemplateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Component
@Slf4j
public class TemplateServiceFallbackFactory implements FallbackFactory<TemplateService> {

    @Override
    public TemplateService create(Throwable cause) {

        return new TemplateService() {
            @Override
            public CouponTemplateInfo geTemplateInfo(Long id) {
                log.info("fallback factory method test");
                return null;
            }

            @Override
            public Map<Long, CouponTemplateInfo> geTemplateInBatch(Collection<Long> ids) {
                log.info("fallback factory method test");
                return Collections.emptyMap();
            }
        };
    }
}
