package com.eshop.util.platform.api.service.im.dhpage;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @ClassName DhGateImCall
 * @Description im接口
 * @Author xxs
 * @Date 2025/5/22 9:58
 * @Version 1.0
 **/
public interface DhGateImCall {

    /**
     * 查询联系人列表
     * @param publicDto
     * @param businessDto
     * @return
     * @throws Exception
     */
    String getContactList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 查询聊天记录
     * @param dcDTO
     * @param businessDto
     * @return
     * @throws Exception
     */
    String getMsgHistory(DhAppClientDTO dcDTO, JSONObject businessDto) throws Exception;

    /**
     * 发送消息
     * @param dcDTO
     * @param businessDto
     * @return
     * @throws Exception
     */
    String getSendMsg(DhAppClientDTO dcDTO, JSONObject businessDto) throws Exception;

}
