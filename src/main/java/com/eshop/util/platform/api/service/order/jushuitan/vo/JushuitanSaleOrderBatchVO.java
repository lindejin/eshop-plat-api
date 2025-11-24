package com.eshop.util.platform.api.service.order.jushuitan.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanSaleOrderBatchVO {

    //batch_no	string		批次号
    private String batch_no;
    //ioi_id	number		出库单商品明细单号（需开启批次2.0并且统一功能配置wms.ioiid.match.skusn）
    private Long ioi_id;
    //sku_id	string		商品编码
    private String sku_id;
    //qty	integer		数量
    private Integer qty;
    //product_date	string		批次日期
    private String product_date;
    //supplier_id	integer		供应商编号
    private Long supplier_id;
    //supplier_name	string		供应商名称
    private String supplier_name;
    //expiration_date	string		有效期至
    private String expiration_date;
    //status	string		状态
    private String status;
}
