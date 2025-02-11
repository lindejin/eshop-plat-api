package com.eshop.util.platform.api.service.user.shop.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuOrderPoShopCallImpl implements TemuOrderPoShopCall{

    @Autowired
    private TemuClient temuClient;

    // bg.open.accesstoken.info.get
    // 查询店铺权限
    @Override
    public String openAccessTokenInfoGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.open.accesstoken.info.get";
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
