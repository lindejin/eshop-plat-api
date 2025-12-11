package com.eshop.util.platform.api.service.auth.jdl.dto;


@lombok.Getter
@lombok.Setter
public class JdLogisticsTokenCreateDTO {
    //参数名称	是否必选	示例值	参数释义
    //code	必选	code-9e2*****f3b32	授权code
    /**
     * 授权码(code)
     */
    private String code;
}
