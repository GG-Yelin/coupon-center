package com.wy.coupon.customer;

import com.wy.coupon.customer.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponDao extends JpaRepository<Coupon, Long> {


    // 根据用户ID和Template ID，统计用户从当前优惠券模版中领取了多少张券
    long countByUserIdAndTemplateId(Long userId, Long templateId);

}
