package com.eshop.util.platform.api.client.taobao;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 13:47
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoErrorResponse {

    //        "code": 15,
    private Integer code;
    //        "msg": "Remote service error",
    private String msg;
    //        "sub_code": "isv.param-authorization.code.invalid",
    private String sub_code;
    //        "sub_msg": "isv.invalid authorization code",
    private String sub_msg;
    //        "request_id": "16mn0u3vmhia4"
    /**
     * 平台颁发的每次请求访问的唯一标识
     */
    private String request_id;
}
