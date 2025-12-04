package com.eshop.util.platform.api.service.auth.douyin.vo;

@lombok.Getter
@lombok.Setter
public class DouyinTokenDataVO {
    //        "token_type": 0,
    private Integer token_type;
    //        "access_token": "hfd86q0wc81lgwk7oxkf6er00001ri95-11",
    private String access_token;
    //        "scope": "SCOPE",
    private String scope;
    //        "shop_name": "BAGSMART官方旗舰店",
    private String shop_name;
    //        "toutiao_id": "676919174504088",
    private Long shop_id;
    //        "authority_id": null,
    private String toutiao_id;
    //        "expires_in": 604800,
    private Long expires_in;
    //        "shop_biz_type": 0,
    private Integer shop_biz_type;
    //        "auth_subject_type": null,
    private String auth_subject_type;
    //        "encrypt_operator": "",
    private String encrypt_operator;
    //        "operator_name": "",
    private String operator_name;
    //        "shop_id": 2962985,
    private Long authority_id;
    //        "refresh_token": "2lrj1rges01lgwk7oxkf6er00001ri95-12"
    private String refresh_token;
}
