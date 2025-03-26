package com.eshop.util.platform.api.service.order.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

/**
 * 备货单
 */
public interface TemuFullOrderCall {

    /**
     * 查询备货单列表V2
     */
    String getPurchaseOrderV2(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
