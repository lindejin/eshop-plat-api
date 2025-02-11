package com.eshop.util.platform.api.service.logistics.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/3/29 15:15
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Service
public class DhGateLogisticsCallImpl implements DhGateLogisticsCall {

    @Resource
    private DhClient dhClient;

    @Override
    public String declareShipment(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {

        //调用方法接口
        String apiMethod = "dh.order.delivery.save";
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
    public String declareOnlineShipment(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception {

        //调用方法接口
        String apiMethod = "dh.online.order.place";
        //调用方法接口版本
        String methodVersion = "1.0";

        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);

        //业务参数
        dhRequest.setBusinessDTO(businessDTO);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDTO);
        return response.getGopResponseBody();
    }

    @Override
    public String modifyShipment(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.online.delivery.modify";
        //调用方法接口版本
        String methodVersion = "1.0";

        //request
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
    public String getShippingDocument(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.online.label.get";
        //调用方法接口版本
        String methodVersion = "1.0";

        //request
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);

        //业务参数
        dhRequest.setBusinessDTO(businessDTO);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDTO);
        return response.getGopResponseBody();
    }

    @Override
    public String getOnlineChannelList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.online.channel.list";
        //调用方法接口版本
        String methodVersion = "1.0";

        //request
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
    public String getShippingTypeList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {

        //调用方法接口
        String apiMethod = "dh.shipping.typelist";
        //调用方法接口版本
        String methodVersion = "2.0";

        //request
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
    public String getOnlineCollectChannelList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.online.collect.channel.list";
        //调用方法接口版本
        String methodVersion = "1.0";

        //request
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
    public String getShippingTemplateList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.shipping.templates.get";
        //调用方法接口版本
        String methodVersion = "1.0";

        //request
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
    public String getShippingTemplateDetail(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.shipping.template.get";
        //调用方法接口版本
        String methodVersion = "2.0";

        //request
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
    public String getShipment(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.online.order.get";
        //调用方法接口版本
        String methodVersion = "1.0";

        //request
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);

        //业务参数
        dhRequest.setBusinessDTO(businessDTO);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDTO);
        return response.getGopResponseBody();
    }
}
