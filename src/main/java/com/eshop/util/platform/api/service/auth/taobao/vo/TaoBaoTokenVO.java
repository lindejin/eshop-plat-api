package com.eshop.util.platform.api.service.auth.taobao.vo;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 14:09
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoTokenVO {
    //{
    //    "w1_expires_in": 31525572,
    private Long w1_expires_in;
    //    "refresh_token_valid_time": 1767841169000,
    private Long refresh_token_valid_time;
    //    "taobao_user_nick": "bagsmart%E6%97%97%E8%88%B0%E5%BA%97",
    private String taobao_user_nick;
    //    "re_expires_in": 0,
    private Long re_expires_in;
    //    "expire_time": 1799377170000,
    private Long expire_time;
    //    "token_type": "Bearer",
    private String token_type;
    //    "access_token": "6201606e950601ZZ7597e6a7ad8424395b7c2969cfc9c3d2206890150985",
    private String access_token;
    //    "taobao_open_uid": "AAGyYCniAOGL3SARbugzJ7Gs",
    private String taobao_open_uid;
    //    "w1_valid": 1799377170468,
    private Long w1_valid;
    //    "refresh_token": "62027061671e77ZZ7f507ec986b0b57a7d96ab8badc54e02206890150985",
    private String refresh_token;
    //    "w2_expires_in": 31525572,
    private Long w2_expires_in;
    //    "w2_valid": 1799377170468,
    private Long w2_valid;
    //    "r1_expires_in": 31525572,
    private Long r1_expires_in;
    //    "r2_expires_in": 31525572,
    private Long r2_expires_in;
    //    "r2_valid": 1799377170468,
    private Long r2_valid;
    //    "r1_valid": 1799377170468,
    private Long r1_valid;
    //    "taobao_user_id": "2206890150985",
    private String taobao_user_id;
    //    "expires_in": 31525571
    private Long expires_in;
    //}
}
