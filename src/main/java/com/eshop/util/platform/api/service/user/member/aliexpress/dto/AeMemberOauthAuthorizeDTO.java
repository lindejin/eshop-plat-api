package com.eshop.util.platform.api.service.user.member.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:27
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeMemberOauthAuthorizeDTO{
    //request.addApiParameter("response_type", "code");
    private String response_type;
    //request.addApiParameter("sns_authorization_code", "afjaodfjaojdfoajdfioa");
    private String sns_authorization_code;
    //request.addApiParameter("sns_type", "ok");
    private String sns_type;
    //request.addApiParameter("auto_register", "true");
    private String auto_register;
}
