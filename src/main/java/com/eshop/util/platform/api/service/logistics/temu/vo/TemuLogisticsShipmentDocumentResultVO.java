package com.eshop.util.platform.api.service.logistics.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuLogisticsShipmentDocumentResultVO {

    // 包裹对应的面单文件url，pdf或图片
    private List<TemuLogisticsShipmentDocumentShippingLabelUrlVO> shippingLabelUrlList;

}
