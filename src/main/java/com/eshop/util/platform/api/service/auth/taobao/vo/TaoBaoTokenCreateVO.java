package com.eshop.util.platform.api.service.auth.taobao.vo;

import com.eshop.util.platform.api.client.taobao.TaoBaoErrorResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:56
 **/

@lombok.Getter
@lombok.Setter
public class TaoBaoTokenCreateVO extends BaseResponseVO {

    /**
     * 返回错误信息
     */
    private TaoBaoErrorResponse error_response;

    /**
     * ***_response	String	请求成功返回的根节点，***为API名称的下划线模式
     * taobao.top.auth.token.create
     * 返回授权信息
     */
    private TaoBaoTokenCreateResponse top_auth_token_create_response;

    /**
     * 平台颁发的每次请求访问的唯一标识
     */
    private String request_id;

    /**
     * 解析后的授权信息
     */
    private TaoBaoTokenVO token_vo;
}