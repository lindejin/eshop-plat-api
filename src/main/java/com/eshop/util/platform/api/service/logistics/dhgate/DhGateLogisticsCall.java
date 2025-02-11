package com.eshop.util.platform.api.service.logistics.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/3/29 15:14
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateLogisticsCall {

    /**
     * 声明发货
     * 敦煌 上传运单号
     */
    String declareShipment(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 线上声明发货
     * 敦煌 用于申请运单号
     */
    String declareOnlineShipment(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 修改声明发货
     * 敦煌 修改运单号
     */
    String modifyShipment(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 查询运单标签
     * 敦煌 查询运单的标签
     */
    String getShippingDocument(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 敦煌 用于获取系统支持的渠道列表信息
     */
    String getOnlineChannelList(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 敦煌 获取回填中物流方式列表接口
     */
    String getShippingTypeList(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 敦煌 揽收渠道接口
     */
    String getOnlineCollectChannelList(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 卖家获取运费模版列表接口
     *
     * @return
     */
    String getShippingTemplateList(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 卖家获取运费模版详情接口
     */
    String getShippingTemplateDetail(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

    /**
     * 用于查询运单详情
     */
    String getShipment(DhAppClientDTO publicDTO, JSONObject businessDTO) throws Exception;

}
