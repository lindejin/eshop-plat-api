package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoDetailOrderListOrderLabelVO {
    //标签名称，具体枚举如下
    // customized_products：定制品标签
    // US_to_CA：美发加订单标签
    private String name;
    //value INTEGER 是否有标签：0=无标签，1=有标签
    private Integer label;
}
