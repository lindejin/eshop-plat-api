package com.eshop.util.platform.api.service.auth.douyin.vo;

import com.eshop.util.platform.api.structure.BaseResponseVO;

@lombok.Getter
@lombok.Setter
public class DouyinTokenCreateVO extends BaseResponseVO {

    //    "code": 10000,
    private Integer code;
    //    "msg": "success",
    private String msg;
    //    "sub_code": "",
    private String sub_code;
    //    "sub_msg": "",
    private String sub_msg;
    //    "data": {
    //        "token_type": 0,
    //        "access_token": "hfd86q0wc81lgwk7oxkf6er00001ri95-11",
    //        "scope": "SCOPE",
    //        "shop_name": "BAGSMART官方旗舰店",
    //        "toutiao_id": "676919174504088",
    //        "authority_id": null,
    //        "expires_in": 604800,
    //        "shop_biz_type": 0,
    //        "auth_subject_type": null,
    //        "encrypt_operator": "",
    //        "operator_name": "",
    //        "shop_id": 2962985,
    //        "refresh_token": "2lrj1rges01lgwk7oxkf6er00001ri95-12"
    //    },
    private DouyinTokenDataVO data;
    //    "log_id": "202512041756193F188E2A6C7F76DAC003"
    private String log_id;
}
