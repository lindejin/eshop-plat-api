package com.eshop.util.platform.api.service.auth.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 9:30
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeTokenRefreshDTO {
    //request.addApiParameter("refresh_token", "50001600212wcwiOabwyjtEH11acc19aBOvQr9ZYkYDlr987D8BB88LIB8bj");
    private String refresh_token;
}
