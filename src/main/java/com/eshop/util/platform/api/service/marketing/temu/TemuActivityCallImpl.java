package com.eshop.util.platform.api.service.marketing.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.service.marketing.temu.dto.TemuActivityListReqDTO;
import com.eshop.util.platform.api.service.marketing.temu.vo.TemuActivityListRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuActivityCallImpl implements TemuActivityCall {

    @Autowired
    private TemuClient temuClient;

    /**
     * bg.marketing.activity.list.get
     * 更新时间：2025-03-31 13:52:45
     * 接口介绍：卖家端查询活动列表接口
     */
    @Override
    public TemuActivityListRespVO marketingActivityListGet(TemuAppClientDTO publicDto, TemuActivityListReqDTO reqDTO) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.marketing.activity.list.get";
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
        TemuActivityListRespVO respVO = JSONObject.parseObject(respBody, TemuActivityListRespVO.class);
        if (respVO == null) {
            respVO = new TemuActivityListRespVO();
        }
        respVO.setRespBody(respBody);
        return respVO;
    }
}
