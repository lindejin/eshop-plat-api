package com.eshop.util.platform.api.service.media.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/7/8 16:07
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhGateImageCallImpl implements DhGateImageCall {

    @Resource
    private DhClient dhClient;

    @Override
    public String imgUpload(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.album.img.upload";
        //调用方法接口版本
        String methodVersion = "2.1";

        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDto);
        return response.getGopResponseBody();
    }
}
