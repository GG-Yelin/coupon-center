package com.wy.coupon.template.dao;

import com.wy.coupon.template.dao.entity.CouponTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponTemplateDao extends JpaRepository<CouponTemplate, Long> {

    // 根据shopId查询出所有券模版
    List<CouponTemplate> findAllByShopId(Long shopId);

    // ID查询 + 分页支持的语法
    Page<CouponTemplate> findAllByIdIn(List<Long> ids, Pageable page);

    // 根据ShopId + 可用状态 查询店铺有多少券模版
    Integer countByShopIdAndAvailable(Long shopId, Boolean available);

    // 将优惠券设置为不可用
    @Modifying
    @Query("update CouponTemplate c set c.available = 0 where c.id = :id")
    int makeCouponUnavailable(@Param("id") Long id);

}
