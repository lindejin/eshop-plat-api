package com.eshop.util.platform.api.service.auth.temu.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuTokenCreateVO {

    private TemuTokenCreateResult result;
    private Boolean success;
    private String requestId;
    private Integer errorCode;
    private String errorMsg;

    private String respBody;

    @Getter
    @Setter
    public static class TemuTokenCreateResult {
        private String accessToken;
        private Long mallId;
        private List<String> appSubscribeEventCodeList;
        private Integer appSubscribeStatus;
        private List<String> authEventCodeList;
        private Long expiredTime;
        private List<String> apiScopeList;
    }
}
