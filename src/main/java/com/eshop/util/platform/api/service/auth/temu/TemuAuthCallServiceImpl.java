package com.eshop.util.platform.api.service.auth.temu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.service.auth.temu.dto.TemuTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.temu.vo.TemuTokenCreateVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TemuAuthCallServiceImpl")
public class TemuAuthCallServiceImpl implements TemuAuthCallService {

    @Autowired
    private TemuClient temuClient;

    @Override
    public TemuTokenCreateVO tokenCreate(TemuAppClientDTO temuAcDTO, TemuTokenCreateDTO reqDTO) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.open.accesstoken.create";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        JSONObject businessDto = new JSONObject();
        //当前accessToken，初次授权时，传code值
        if (temuAcDTO.getAccessToken() != null) {
            businessDto.put("accessToken", temuAcDTO.getAccessToken());
        } else {
            businessDto.put("accessToken", reqDTO.getCode());
        }
        //授权code
        businessDto.put("code", reqDTO.getCode());

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.tokenCreateAndRefresh(temuRequest, temuAcDTO);
        String gopResponseBody = temuResponse.getGopResponseBody();
        //gopResponseBody 转成TemuTokenCreateVO fastjson
        TemuTokenCreateVO temuTokenCreateVO = JSON.parseObject(gopResponseBody, TemuTokenCreateVO.class);
        temuTokenCreateVO.setRespBody(gopResponseBody);
        return temuTokenCreateVO;
    }
}
