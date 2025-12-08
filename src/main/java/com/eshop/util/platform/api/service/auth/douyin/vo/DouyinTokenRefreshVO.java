package com.eshop.util.platform.api.service.auth.douyin.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
public class DouyinTokenRefreshVO  extends BaseResponseVO {

    private Integer code;
    private String msg;
    private String sub_code;
    private String sub_msg;
    private String log_id;

    private DouyinTokenDataVO data;
}
