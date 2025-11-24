package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanSaleOrderClusterInfoVO {

    //io_id	string		出库单号
    private Long io_id;
    //l_id	string		物流单子单号
    private Long l_id;
    //logistic_company	string		物流公司名称
    private String logistic_company;
    //lc_id	string		物流公司编码
    private String lc_id;
    //f_weight	number		子单号实称重量
    private Double f_weight;
    //			
}
