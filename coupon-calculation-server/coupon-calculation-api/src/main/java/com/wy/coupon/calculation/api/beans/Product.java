package com.wy.coupon.calculation.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    // 价格
    private long price;

    // 数量
    private Integer count;

    // 门店ID
    private Long shopId;

}
