package com.eshop.util.platform.api.service.logistics.douyin.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;


@lombok.Getter
@lombok.Setter
public class DouyinTemplateListRespVO extends BaseResponseVO {
    //    "code": 10000,
    private Integer code;
    //    "msg": "success",
    private String msg;
    //    "sub_code": "",
    private String sub_code;
    //    "sub_msg": "",
    private String sub_msg;
    //    "log_id": "202512041756193F188E2A6C7F76DAC003"
    private String log_id;
    //    "data": { },
    private DouyinTemplateDataVO data;

}
