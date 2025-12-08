package com.eshop.util.platform.api.service.auth.jdl.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
public class JdLogisticsTokenRefreshVO extends BaseResponseVO {

    //    "code": 1000,
    private Integer code;
    //    "message": "success",
    private String message;
    //    "enMessage": null,
    private String enMessage;

    private JdLogisticsTokenVO data;
}
