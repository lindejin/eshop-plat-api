package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoSaleOrderBatchVO {
    //名称	类型	是否必须	示例值	描述
    //batch_no	string			批次号
    private String batch_no;
    //sku_id	string			商品编码
    private String sku_id;
    //qty	int			商品数量
    private Integer qty;
    //product_date	string			批次日期
    private String product_date;
    //supplier_id	int			供应商编号
    private Long supplier_id;
    //supplier_name	string			供应商名称
    private String supplier_name;
    //expiration_date	string			有效期至
    private String expiration_date;
    //ioi_id	int			子单号
    private Long ioi_id;
    //status	string			批次状态
    private String status;
}
