package com.wy.coupon.template.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.wy.coupon.template.api.beans.CouponTemplateInfo;
import com.wy.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.wy.coupon.template.api.beans.TemplateSearchParams;
import com.wy.coupon.template.service.CouponTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/template")
public class CouponTemplateController {

    @Autowired
    private CouponTemplateService couponTemplateService;

    // 创建优惠券
    @PostMapping("/addTemplate")
    public CouponTemplateInfo addTemplate(@Valid @RequestBody CouponTemplateInfo request) {
        log.info("Create coupon template: data={}", request);
        return couponTemplateService.createTemplate(request);
    }

    // 克隆优惠券
    @PostMapping("/cloneTemplate")
    public CouponTemplateInfo cloneTemplate(@RequestParam("id") Long templateId) {
        log.info("Clone coupon template: data={}", templateId);
        return couponTemplateService.cloneTemplate(templateId);
    }

    // 读取优惠券
    @GetMapping("/getTemplate")
    @SentinelResource(value = "getTemplate")
    public CouponTemplateInfo getTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id={}", id);
        return couponTemplateService.loadTemplate(id);
    }

    // 搜索模版
    @PostMapping("/search")
    public PagedCouponTemplateInfo search(@Valid @RequestBody TemplateSearchParams request) {
        log.info("search templates, payload={}", request);
        return couponTemplateService.search(request);
    }

    // 批量获取
    @GetMapping("/getBatch")
    @SentinelResource(value = "getTemplateInBatch",
            blockHandler = "getTemplateInBatch_block",
            fallback = "getTemplateInBatch_fallback")
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids) {
        log.info("getTemplateInBatch: {}", JSON.toJSONString(ids));
        if (ids.size() == 1) {
            throw new RuntimeException();
        }
        return couponTemplateService.getTemplateInfoMap(ids);
    }

    /**
     * 在接口注解中同时使用 blockHandler 和 fallback 方法
     * 如果服务抛出 BlockException异常，则执行 blockHandler 属性指定的方法，
     * 其他异常由 fallback 属性指定的降级方法接管
     */
    public Map<Long, CouponTemplateInfo> getTemplateInBatch_fallback(
            @RequestParam("ids") Collection<Long> ids
    ) {
        log.info("接口被降级");
        return Maps.newHashMap();
    }

    public Map<Long, CouponTemplateInfo> getTemplateInBatch_block(
            @RequestParam("ids") Collection<Long> ids,
            BlockException exception
    ) {
        log.info("接口被限流");
        return Maps.newHashMap();
    }

    // 优惠券无效
    @DeleteMapping("/deleteTemplate")
    public void deleteTemplate(@RequestParam("id") Long id) {
        log.info("deleteTemplate: {}", id);
        couponTemplateService.deleteTemplate(id);
    }

}
