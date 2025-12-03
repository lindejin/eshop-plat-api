package com.eshop.util.platform.api.service.auth.xiaohongshu.dto;

@lombok.Getter
@lombok.Setter
public class XiaohongshuTokenRefreshDTO {

    //参数名称	是否必选	示例值	参数释义
    //refreshToken	必选	refresh-abe******9c2b9f9	用于刷新的refreshToken

    /**
     * refreshToken	用于刷新的refreshToken
     */
    private String refreshToken;
}
