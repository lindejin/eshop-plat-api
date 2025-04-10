package com.eshop.util.platform.api.service.order.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuFullLabelCall {

    /**
     * 查询备货单列表V2
     */
    String getGoodsLabelV2(TemuAppClientDTO pubDTO, JSONObject bizDTO) throws Exception;

    /**
     * 定制商品条码查询
     */
    String getGoodsCustomLabel(TemuAppClientDTO pubDTO, JSONObject bizDTO) throws Exception;

    /**
     * 查询箱唛
     */
    String getLogisticsBoxMarkInfo(TemuAppClientDTO pubDTO, JSONObject bizDTO) throws Exception;
}
