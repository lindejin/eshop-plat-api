package com.eshop.util.platform.api.service.order.xiaohongshu.vo;

@lombok.Getter
@lombok.Setter
public class XiaohongshuOrderTransferExtendInfoDTO {

    //  internationalExpressNo	string	国际快递单号
    //	orderDeclaredAmount	number	订单申报金额
    //	paintMarker	string	大头笔
    //	collectionPlace	string	集包地
    //	threeSegmentCode	string	三段码

    private String internationalExpressNo;
    private Double orderDeclaredAmount;
    private String paintMarker;
    private String collectionPlace;
    private String threeSegmentCode;

}
