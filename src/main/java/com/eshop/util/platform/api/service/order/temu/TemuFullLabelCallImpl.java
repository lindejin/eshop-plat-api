package com.eshop.util.platform.api.service.order.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuFullLabelCallImpl implements TemuFullLabelCall {

    @Autowired
    private TemuClient temuClient;

    @Override
    public String getGoodsLabelV2(TemuAppClientDTO pubDTO, JSONObject bizDTO) throws Exception {
        //请求接口 API接口名，形如：bg.*
        // 商品条码查询v2
        String type = "bg.goods.labelv2.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(bizDTO);

        TemuResponse temuResponse = temuClient.execute(temuRequest, pubDTO);
        return temuResponse.getGopResponseBody();
    }

    @Override
    public String getGoodsCustomLabel(TemuAppClientDTO pubDTO, JSONObject bizDTO) throws Exception {
        // 定制商品条码查询
        String type = "bg.goods.custom.label.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(bizDTO);

        TemuResponse temuResponse = temuClient.execute(temuRequest, pubDTO);
        return temuResponse.getGopResponseBody();
    }

    @Override
    public String getLogisticsBoxMarkInfo(TemuAppClientDTO pubDTO, JSONObject bizDTO) throws Exception {
        // 查询箱唛
        String type = "bg.logistics.boxmarkinfo.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(bizDTO);

        TemuResponse temuResponse = temuClient.execute(temuRequest, pubDTO);
        return temuResponse.getGopResponseBody();
    }
}
