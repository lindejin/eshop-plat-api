package com.eshop.util.platform.api.service.product.temu.dto.add;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsAddProductSaleExtAttrReqDTO {

    //inventoryRegion	INTEGER	否	备货区域，1 表示国内备货，3 表示保税仓备货
    //productSecondHandReq	OBJECT	否	货品二手信息，二手店铺传值，其他店铺不传值
    //customizedTechnologyReq	OBJECT	否	定制工艺请求
    //productNoChargerReq	OBJECT	否	货品无充电器版本信息 (从有到无要传空list清空)

    private Long inventoryRegion;
    private TemuGoodsAddProductSecondHandReqDTO productSecondHandReq;
    private TemuGoodsAddCustomizedTechnologyReqDTO customizedTechnologyReq;
    private TemuGoodsAddProductNoChargerReqDTO productNoChargerReq;
    
}
