package com.eshop.util.platform.api.service.order.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/6/7 16:45
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhGateOrderCallImpl implements DhGateOrderCall {

    @Resource
    private DhClient dhClient;

    @Override
    public String getOrderList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.list.get";
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
    public String getOrderDetail(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.get";
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
    public String getOrderProductList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.product.get";
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
    public String getOrderShipmentTracking(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.shipping.trackinfo.get";
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

    @Override
    public String orderDisputeOpenListPage(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.disputeopen.list";
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
    public String orderDisputeCloseListPage(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.disputeclose.list";
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
    public String orderRefundList(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.refund.list";
        //调用方法接口版本
        String methodVersion = "1.1";
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
    public String canSendInvoice(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.applymoney.check";
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
    public String sendInvoice(DhAppClientDTO publicDto, JSONObject businessDTO) throws Exception {
        //调用方法接口
        String apiMethod = "dh.order.applymoney.get";
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
