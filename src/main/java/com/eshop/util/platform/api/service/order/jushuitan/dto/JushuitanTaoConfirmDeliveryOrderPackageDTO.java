package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderPackageDTO {
    //logisticsCode	String	SF	物流公司编码(SF=顺丰、EMS=标准快递、EYB=经济快件、ZJS=宅急送、YTO=圆通、ZTO=中通 (ZTO)、HTKY=百世汇通、 UC=优速、STO=申通、TTKDEX=天天快递、QFKD=全峰、FAST=快捷、POSTB=邮政小包、GTO=国通、YUNDA=韵达、JD=京东配送、DD=当当宅配、 AMAZON=亚马逊物流、OTHER=其他;只传英文编码)
    private String logisticsCode;
    //logisticsName	String	顺丰	物流公司名称
    private String logisticsName;
    //expressCode	String	Y1234	运单号
    private String expressCode;
    //packageCode	String	LG1234	包裹编号
    private String packageCode;
    //length	String	12.0	包裹长度(单位：厘米)
    private String length;
    //width	String	12.0	包裹宽度(单位：厘米)
    private String width;
    //height	String	12.0	包裹高度(单位：厘米)
    private String height;
    //theoreticalWeight	String	12.0	包裹理论重量(单位：千克)
    private String theoreticalWeight;
    //weight	String	12.0	包裹重量(单位：千克)
    private String weight;
    //volume	String	12.0	包裹体积(单位：升)
    private String volume;
    //invoiceNo	String	IN1234	发票号
    private String invoiceNo;
    //packageMaterialList	PackageMaterial[]		包材信息
    private List<JushuitanTaoConfirmDeliveryOrderPackageMaterialDTO> packageMaterialList;
    //items	Item[]		商品列表
    private List<JushuitanTaoConfirmDeliveryOrderPackageItemDTO> items;
    //extendProps	Map		包裹信息扩展属性
    private Map<String, String> extendProps;

}
