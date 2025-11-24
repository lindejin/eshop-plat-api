package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanSaleOrderSnVO {
    //sku_id	string		商品编码
    private String sku_id;
    //sn	string		唯一码
    private String sn;
    //certificate_no	string		国补IMEI辅助唯一码
    private String certificate_no;
    //is_pack_sn	boolean		是否箱唯一码，true是箱唯一码
    private Boolean is_pack_sn;
    //is_opened	boolean		是否开箱，true 是开箱
    private Boolean is_opened;
    //pack_sn	string		箱码
    private String pack_sn;
}
