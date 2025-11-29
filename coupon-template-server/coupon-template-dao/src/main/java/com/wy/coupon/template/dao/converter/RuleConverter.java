package com.wy.coupon.template.dao.converter;

import com.alibaba.fastjson.JSON;
import com.wy.coupon.template.api.beans.rules.TemplateRule;

import javax.persistence.AttributeConverter;

public class RuleConverter implements AttributeConverter<TemplateRule, String> {

    @Override
    public String convertToDatabaseColumn(TemplateRule rule) {
        return JSON.toJSONString(rule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule, TemplateRule.class);
    }

}
