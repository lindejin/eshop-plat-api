package com.eshop.util.platform.api.service.auth.dhgate.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 18:15
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class DhTokenRefreshDTO {

    /**
     * 刷新token
     */
    private String refreshToken;
}
