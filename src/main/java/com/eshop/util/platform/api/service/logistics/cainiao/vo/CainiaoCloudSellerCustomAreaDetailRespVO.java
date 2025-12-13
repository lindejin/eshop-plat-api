package com.eshop.util.platform.api.service.logistics.cainiao.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;



@lombok.Getter
@lombok.Setter
public class CainiaoCloudSellerCustomAreaDetailRespVO extends BaseResponseVO {

    //    "success": false,
    private Boolean success;
    //    "errorCode": "S02",
    private String errorCode;
    //    "errorMsg": "验签或加签失败:digest sign check not pass traceId:2150407c17656300522733704e0c84"
    private String errorMsg;

    //data	CustomArea	- -	true	- -	自定义区详情
    private CainiaoCloudSellerCustomAreaDetailVO data;
}
