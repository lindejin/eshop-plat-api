package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductOriginReqDTO {

    //region2Id	INTEGER	否	省份，当region1ShortName为CN时，省份必传。枚举值：https://partner.kuajingmaihuo.com/document?cataId=875196199516&docId=894069632221
    //region1ShortName	STRING	是	一级区域简称 (二字简码)

    private Long region2Id;
    private String region1ShortName;

}
