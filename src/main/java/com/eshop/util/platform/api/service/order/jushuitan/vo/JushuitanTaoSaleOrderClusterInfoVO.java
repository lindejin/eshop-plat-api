package com.eshop.util.platform.api.service.order.jushuitan.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoSaleOrderClusterInfoVO {

    //名称	类型	是否必须	示例值	描述
    //io_id	string			出库单号
    private Long io_id;
    //l_id	string			子单物流单号
    private String l_id;
    //logistics_company	string			子单物流公司
    private String logistics_company;
    //lc_id	string			子单物流公司编码
    private String lc_id;
}
