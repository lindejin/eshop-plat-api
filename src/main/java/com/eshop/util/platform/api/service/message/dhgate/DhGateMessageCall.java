package com.eshop.util.platform.api.service.message.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/5/29 16:36
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateMessageCall {

    /**
     * 获取站内信主题列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getMessageList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取最近更新站内信主题列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getRecentMessageList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;


    /**
     * 获取站内信详情接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getMessageDetail(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 站内信回复
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String replyMessage(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 修改站内信状态
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String updateMessageStatus(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;


}
