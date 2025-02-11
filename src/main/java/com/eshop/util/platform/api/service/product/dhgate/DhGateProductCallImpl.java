package com.eshop.util.platform.api.service.product.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/7/7 17:49
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhGateProductCallImpl implements DhGateProductCall {

    @Resource
    private DhClient dhClient;

    @Override
    public String postProduct(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.add";
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
    public String getProductList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.list";
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
    public String getProductDetail(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.get";
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
    public String getProductSkuList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.sku.list";
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
    public String getProductSkuDetail(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.sku.get";
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
    public String getProductDescription(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.html.get";
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
    public String getAfterSaleTemplateList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.aftersale.list";
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
    public String getSizeTemplateList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.template.list";
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
    public String getProductGroupList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.item.group.list";
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
