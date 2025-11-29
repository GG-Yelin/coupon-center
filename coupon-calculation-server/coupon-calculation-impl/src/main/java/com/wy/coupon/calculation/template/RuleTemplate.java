package com.wy.coupon.calculation.template;

import com.wy.coupon.calculation.api.beans.ShoppingCart;

public interface RuleTemplate {

    ShoppingCart calculate(ShoppingCart settlement);

}
