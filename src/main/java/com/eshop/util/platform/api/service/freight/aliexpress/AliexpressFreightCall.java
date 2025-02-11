package com.eshop.util.platform.api.service.freight.aliexpress;

import com.eshop.util.platform.api.service.freight.aliexpress.dto.AeFreightCalculateFreightDTO;
import com.eshop.util.platform.api.service.freight.aliexpress.dto.AeFreightGetFreightSettingByTemplateQueryDTO;
import com.eshop.util.platform.api.service.freight.aliexpress.dto.AeFreightListFreightTemplateDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/7 9:33
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressFreightCall {

    //用户运费模板列表信息
    /**
     * 用户运费模板列表信息
     */
    String listFreightTemplate(AeAppClientDTO acDTO, AeFreightListFreightTemplateDTO reqDto) throws ApiException;

    //运费计算
    /**
     * 运费计算
     */
    String calculateFreight(AeAppClientDTO acDTO, AeFreightCalculateFreightDTO reqDto) throws ApiException;

    //通过模板ID获取单个运费模板内容
    /**
     * 通过模板ID获取单个运费模板内容
     */
    String getFreightSettingByTemplateQuery(AeAppClientDTO acDTO, AeFreightGetFreightSettingByTemplateQueryDTO reqDto) throws ApiException;

}
