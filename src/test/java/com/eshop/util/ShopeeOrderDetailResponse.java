package com.eshop.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopeeOrderDetailResponse {
    /**
     * The list of orders.
     */
    private List<ShopeeOrderDetailItem> order_list;

}
