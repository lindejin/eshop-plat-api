package com.eshop.util.platform.api.service.product.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderPoStockCall {

    /**
     * 虚拟库存查询接口
     * US/EU
     */
    String goodsQuantityGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 虚拟库存编辑接口
     * US/EU
     */
    String goodsQuantityUpdate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 半托管新增路由绑定及库存填写接口
     * US/EU
     */
    String goodsRouteStockAdd(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 根据站点查询可绑定的发货仓库信息接口
     * US/EU
     */
    String goodsWarehouseListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
