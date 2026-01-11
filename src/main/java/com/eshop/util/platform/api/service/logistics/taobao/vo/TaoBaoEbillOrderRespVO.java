package com.eshop.util.platform.api.service.logistics.taobao.vo;

import com.eshop.util.platform.api.client.taobao.TaoBaoErrorResponse;
import com.eshop.util.platform.api.structure.BaseResponseVO;

import java.util.List;

/**
 * @program: eshop-plat-api
 * @description:
 * @author: lindz
 * @create: 2026-01-08 11:13
 **/
@lombok.Getter
@lombok.Setter
public class TaoBaoEbillOrderRespVO extends BaseResponseVO {
    /**
     * 返回错误信息
     */
    private TaoBaoErrorResponse error_response;

    /**
     * ***_response	String	请求成功返回的根节点，***为API名称的下划线模式
     * cainiao_waybill_ii_query_by_waybillcode_response
     * 返回授权信息
     */
    private CainiaoWaybillIiQueryByWaybillcodeResponse cainiao_waybill_ii_query_by_waybillcode_response;

}
