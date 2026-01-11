package com.eshop.util.platform.api.service.logistics.taobao.vo;

import com.eshop.util.platform.api.client.taobao.TaoBaoErrorResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 16:24
 **/
@lombok.Getter
@lombok.Setter
public class CainiaoCloudprintIsvtemplatesGetRespVO extends BaseResponseVO {
    /**
     * 返回错误信息
     */
    private TaoBaoErrorResponse error_response;

    /**
     * ***_response	String	请求成功返回的根节点，***为API名称的下划线模式
     * cainiao.cloudprint.isvtemplates.get
     * 返回授权信息
     */
    private CainiaoCloudprintIsvtemplatesGetResponse cainiao_cloudprint_isvtemplates_get_response;

}
