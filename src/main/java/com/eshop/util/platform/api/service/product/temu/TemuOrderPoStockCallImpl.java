package com.eshop.util.platform.api.service.product.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuOrderPoStockCallImpl implements TemuOrderPoStockCall {

    @Autowired
    private TemuClient temuClient;

    // bg.goods.quantity.get
    // 虚拟库存查询接口
    @Override
    public String goodsQuantityGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.goods.quantity.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }

    //bg.goods.quantity.update
    //虚拟库存编辑接口
    @Override
    public String goodsQuantityUpdate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.goods.quantity.update";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }


    // bg.goods.routestock.add
    // 半托管新增路由绑定及库存填写接口
    @Override
    public String goodsRouteStockAdd(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.goods.routestock.add";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }


    // 根据站点查询可绑定的发货仓库信息接口
    // bg.goods.warehouse.list.get
    @Override
    public String goodsWarehouseListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.goods.warehouse.list.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }
}
