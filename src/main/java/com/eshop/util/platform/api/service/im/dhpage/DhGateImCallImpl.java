package com.eshop.util.platform.api.service.im.dhpage;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.dhgate.DhClient;
import com.eshop.util.platform.api.client.dhgate.DhRequest;
import com.eshop.util.platform.api.client.dhgate.DhResponse;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName DhGateImCall
 * @Description im接口
 * @Author xxs
 * @Date 2025/5/22 9:58
 * @Version 1.0
 **/
@Service
public class DhGateImCallImpl implements DhGateImCall {

    @Resource
    private DhClient dhClient;

    @Override
    public String getContactList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.im.contact.list.get";
        //调用方法接口版本
        String methodVersion = "1.0";
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
     * 查询聊天记录
     * @param dcDTO
     * @param businessDto
     * @return
     * @throws Exception
     */
    public String getMsgHistory(DhAppClientDTO dcDTO, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.im.msg.history.get";
        //调用方法接口版本
        String methodVersion = "1.0";
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, dcDTO);
        return response.getGopResponseBody();
    }

    /**
     * 发送消息
     * @param dcDTO
     * @param businessDto
     * @return
     * @throws Exception
     */
    public String getSendMsg(DhAppClientDTO dcDTO, JSONObject businessDto) throws Exception {
        //调用方法接口
        String apiMethod = "dh.im.msg.send";
        //调用方法接口版本
        String methodVersion = "1.0";
        DhRequest dhRequest = new DhRequest();
        dhRequest.setApiName(apiMethod);
        dhRequest.setApiVersion(methodVersion);
        //业务参数
        dhRequest.setBusinessDTO(businessDto);

        //执行请求
        DhResponse response = dhClient.execute(dhRequest, dcDTO);
        return response.getGopResponseBody();
    }
}
