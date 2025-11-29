package com.wy.coupon.template.service;

import com.wy.coupon.template.api.beans.CouponTemplateInfo;
import com.wy.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.wy.coupon.template.api.beans.TemplateSearchParams;

import java.util.Collection;
import java.util.Map;

public interface CouponTemplateService {

    // 创建优惠券模版
    CouponTemplateInfo createTemplate(CouponTemplateInfo request);

    // 通过模版ID查询优惠券模版
    CouponTemplateInfo loadTemplate(Long id);

    // 克隆券模版
    CouponTemplateInfo cloneTemplate(Long templateId);

    // 模版查询（分页）
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    // 让优惠券模版失效
    void deleteTemplate(Long id);

    // 批量查询
    // Map是模版ID、模版详情
    Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids);


}
