package com.eshop.util.platform.api.service.user.shop.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/6/26 9:46
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhGateShopCallImpl implements DhGateShopCall {

    @Resource
    private DhClient dhClient;

    @Override
    public String getUserBase(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.user.seller.get";
        //调用方法接口版本
        String methodVersion = "2.0";

        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);

        //业务参数
        dhRequest.setBusinessDTO(businessDTO);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDto);
        return response.getGopResponseBody();
    }
}
