package com.eshop.util.platform.api.service.category.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/7/11 17:00
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhGateCategoryCallImpl implements DhGateCategoryCall {

    @Resource
    private DhClient dhClient;

    //dh.category.list$2.0 (获取类目列表接口)
    @Override
    public String getCategoryList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.category.list";
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

    @Override
    public String getCategoryDetail(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.category.get";
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

    @Override
    public String getCategoriesCommissions(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.categorys.commissions";
        //调用方法接口版本
        String methodVersion = "1.0";
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
