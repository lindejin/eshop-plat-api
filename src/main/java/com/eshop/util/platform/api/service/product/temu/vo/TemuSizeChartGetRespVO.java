package com.eshop.util.platform.api.service.product.temu.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuSizeChartGetRespVO extends BaseResponseVO {

    private TemuSizeChartGetResultVO result;
    //    "success": true,
    private Boolean success;
    //    "requestId": "cn-c42863ef-d801-4dc7-b633-cdc509551357",
    private String requestId;
    //    "errorCode": 1000000,
    private Integer errorCode;
    //    "errorMsg": ""
    private String errorMsg;
}
