package com.eshop.util.platform.api.service.auth.taobao.dto;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:56
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoTokenCreateDTO {
    //名称	类型	必须	示例值	描述
    //code	String	true	0_ebKICPqc6OD8RBIB0DzfnpUg2	授权 code，当 grantType==authorization_code 时需要
    private String code;
    //uuid	String	false	abc（如未使用就别传，绝大多数都不需要传这个参数）	非必填，与生成 code 的 uuid 配对，使用方式参考文档
    private String uuid;
}
