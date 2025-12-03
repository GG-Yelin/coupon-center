package com.wy.coupon.customer.feign;

import com.wy.coupon.template.api.beans.CouponTemplateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@FeignClient(value = "coupon-template-server", path = "/template",
        fallbackFactory = TemplateServiceFallbackFactory.class)
public interface TemplateService {

    // 查询模版
    @GetMapping("/getTemplate")
    CouponTemplateInfo geTemplateInfo(@RequestParam("id") Long id);

    // 批量获取
    @GetMapping("/getBatch")
    Map<Long, CouponTemplateInfo> geTemplateInBatch(@RequestParam("ids") Collection<Long> ids);
}
