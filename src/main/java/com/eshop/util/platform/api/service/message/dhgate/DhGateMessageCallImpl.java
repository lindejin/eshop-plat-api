package com.eshop.util.platform.api.service.message.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/5/29 16:36
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhGateMessageCallImpl implements DhGateMessageCall {

    @Resource
    private DhClient dhClient;

    /**
     * 获取站内信主题列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    @Override
    public String getMessageList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.message.list";
        //调用方法接口版本
        String methodVersion = "2.0";
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDto);
        return response.getGopResponseBody();
    }

    /**
     * 获取最近更新站内信主题列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    @Override
    public String getRecentMessageList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.message.list.recent";
        //调用方法接口版本
        String methodVersion = "2.0";
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDto);
        return response.getGopResponseBody();
    }

    @Override
    public String getMessageDetail(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.message.get";
        //调用方法接口版本
        String methodVersion = "2.0";
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDto);
        return response.getGopResponseBody();
    }

    @Override
    public String replyMessage(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.message.info.reply";
        //调用方法接口版本
        String methodVersion = "2.0";
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, publicDto);
        return response.getGopResponseBody();
    }

    @Override
    public String updateMessageStatus(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.message.status.update";
        //调用方法接口版本
        String methodVersion = "2.0";
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
