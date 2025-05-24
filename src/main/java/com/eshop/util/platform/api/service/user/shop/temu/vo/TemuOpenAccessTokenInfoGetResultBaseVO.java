package com.eshop.util.platform.api.service.user.shop.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuOpenAccessTokenInfoGetResultBaseVO {

    //mallId	LONG	否	access_token对应的TEMU店铺ID
    private Long mallId;
    //expiredTime	LONG   	否	过期时间，时间戳秒级
    private Long expiredTime;
    //apiScopeList	LIST	否	有权限的API列表
    private List<String> apiScopeList;
}
