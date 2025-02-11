package com.eshop.util.platform.api.service.product.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/7/7 17:49
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateProductCall {

    /**
     * 敦煌 产品刊登
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String postProduct(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 敦煌 获取产品数据List
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 敦煌 获取产品数据
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductDetail(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 敦煌 获取产品sku数据List
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductSkuList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 敦煌 获取产品sku数据
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductSkuDetail(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 敦煌 获取产品长描信息
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductDescription(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 敦煌 获取售后模板列表接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getAfterSaleTemplateList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;


    /**
     * 卖家获取尺码模板接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getSizeTemplateList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;


    /**
     * 卖家获取产品组列表接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getProductGroupList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
