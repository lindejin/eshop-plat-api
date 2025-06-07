package com.eshop.util.platform.api.service.logistics.temu.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentDocumentReqDTO {
    //documentType	STRING	False	Document Type: - SHIPPING_LABEL_PDF: the document URL will return the shipping label in PDF format for all the carriers you choose if you don't input this parameter, the document URL will return the shipping label in PDF format or PNG format based on which carrier you choose.
    //文件类型：
    //- SHIPPING_LABEL_PDF:入参此参数,返回的URL加签后只返回PDF格式的面单文件
    //- 不入参，按照旧有逻辑返回面单文件，即按物流商的面单文件返回确定图片格式或PDF格式；
    //- 入不合法的参数值：接口报错，报错文案：Document type is invalid.
    private String documentType;
    //packageSnList	STRING[]	False	Package List that needs to get the shipping label
    //需要打印面单的包裹号列表
    private List<String> packageSnList;
}
