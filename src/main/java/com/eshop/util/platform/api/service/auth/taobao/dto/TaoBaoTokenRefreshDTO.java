package com.eshop.util.platform.api.service.auth.taobao.dto;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:56
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoTokenRefreshDTO {
    //名称	类型	必须	示例值	描述
    //refresh_token	String	true	50003401926fExdtvhBdiQ5PyVlfKjYEVWngx129d2b42DxpjypaTqrxxaWVSCluli1	当 grantType==refresh_token 时需要
    private String refresh_token;
}
