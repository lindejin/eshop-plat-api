package com.eshop.util.platform.api.service.product.aliexpress;


import com.eshop.util.platform.api.service.product.aliexpress.dto.*;
import com.eshop.util.platform.api.service.product.aliexpress.vo.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/30 17:27
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressPopChoiceProductCall {

    /**
     * 半托管商品新发一阶段pop信息草稿保存接口
     */
    AePopAeProductRespVO productPopChoiceDraftPost(AeAppClientDTO acDTO, AeopAeProductPostReqDTO reqDTO) throws ApiException;

    /**
     * 半托管商品新发第二段提交
     */
    AePopChoiceProductRespVO productPopChoiceProductPost(AeAppClientDTO acDTO, AliexpressPopChoiceProductPostDTO reqDTO) throws ApiException;

    /**
     * 半托管商品编辑
     */
    String productPopChoiceProductEdit(AeAppClientDTO acDTO, AliexpressPopChoiceProductEditDTO reqDTO) throws ApiException;

    /**
     * 半托管商品草稿编辑接口
     */
    String productPopChoiceDraftEdit(AeAppClientDTO acDTO, AliexpressPopChoiceProductDraftEditDTO reqDTO) throws ApiException;

    /**
     * 半托管商品详情查询
     */
    AePopChoiceProductQueryRespVO productPopChoiceProductQuery(AeAppClientDTO acDTO, AliexpressPopChoiceProductQueryDTO reqDTO) throws ApiException;

    /**
     * 半托管库存编辑接口
     */
    String productPopChoiceProductStocksUpdate(AeAppClientDTO acDTO, AliexpressPopChoiceProductStocksUpdateDTO reqDTO) throws ApiException;

    /**
     * 半托管预存信息查询
     */
    String productPopChoicePreProductQuery(AeAppClientDTO acDTO, AliexpressPopChoicePreProductQueryDTO reqDTO) throws ApiException;

    /**
     * 商品半托管预存信息提交
     */
    String productPopChoicePreProductSubmit(AeAppClientDTO acDTO, AliexpressPopChoicePreProductSubmitDTO reqDTO) throws ApiException;

    /**
     * 商品可升级为半托管SKU信息查询
     */
    AePopChoiceProductDraftQueryRespVO productPopChoiceDraftQuery(AeAppClientDTO acDTO, AliexpressPopChoiceDraftQueryDTO reqDTO) throws ApiException;

    /**
     * 商家半托管基本信息查询
     */
    AePopChoiceInfoRespVO productPopChoiceInfoQuery(AeAppClientDTO acDTO) throws ApiException;


    /**
     * 已预存商品列表查询
     */
    String productPopChoiceCollectedProductsList(AeAppClientDTO acDTO, AliexpressPopChoiceCollectedProductsListDTO reqDTO) throws ApiException;


    /**
     * 查询半托管已加入/待加入/待预存商品列表
     */
    AePopProductRespVO productPopChoiceProductsList(AeAppClientDTO acDTO, AliexpressPopChoiceProductsListDTO reqDTO) throws ApiException;
}
