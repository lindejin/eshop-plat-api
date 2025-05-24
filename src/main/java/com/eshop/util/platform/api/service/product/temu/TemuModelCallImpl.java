package com.eshop.util.platform.api.service.product.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.service.product.temu.dto.TemuModelInfoGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuModelInfoGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TemuModelCallImpl implements TemuModelCall {

    @Autowired
    private TemuClient temuClient;

    /**
     * bg.modelinfo.get
     * 模特信息查询
     * 更新时间：2025-03-26 14:33:26
     * 接口介绍：模特信息查询
     * CN
     */
    @Override
    public TemuModelInfoGetRespVO modelInfoGet(TemuAppClientDTO publicDto, TemuModelInfoGetReqDTO reqDTO) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.modelinfo.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //业务body - json
        JSONObject bodyJson = FastJsonUtil.toJsonToJsonObj(reqDTO);
        temuRequest.setJsonParams(bodyJson);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        String respBody = temuResponse.getGopResponseBody();
        TemuModelInfoGetRespVO respVO = JSONObject.parseObject(respBody, TemuModelInfoGetRespVO.class);
        if (respVO == null) {
            respVO = new TemuModelInfoGetRespVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }
}
