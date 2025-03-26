package com.eshop.code.vo.op;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DhOrderProductRespVO {
    /**
     * 订单产品信息
     * 订单产品信息
     */
    private List<DhOrderProductListItem> orderProductList;
}