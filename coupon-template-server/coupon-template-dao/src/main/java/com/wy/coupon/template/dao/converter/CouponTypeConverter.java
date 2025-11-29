package com.wy.coupon.template.dao.converter;

import com.wy.coupon.template.api.enums.CouponType;

import javax.persistence.AttributeConverter;

public class CouponTypeConverter implements AttributeConverter<CouponType, String> {

    @Override
    public String convertToDatabaseColumn(CouponType couponCategory) {
        return couponCategory.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.covert(code);
    }

}
