package com.eshop.util.platform.api.service.user.merchant.aliexpress;

import com.eshop.util.platform.api.service.user.merchant.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/7 9:42
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressMerchantCall {
    /**
     * 描述：全部商机的下载
     */
    String planChanceDownloadAll(AeAppClientDTO acDTO, AeMerchantPlanChanceDownloadAllDTO reqDTO) throws ApiException;

    /**
     * 描述：分页查指定商机的所有机会信息
     */
    String planChanceList(AeAppClientDTO acDTO, AeMerchantPlanChanceListDTO reqDTO) throws ApiException;

    /**
     * 描述：商家地址列表查询
     */
    String addressList(AeAppClientDTO acDTO, AeMerchantAddressListDTO reqDTO) throws ApiException;

    /**
     * 描述：商机信息列表
     */
    String arrangementPlanList(AeAppClientDTO acDTO, AeMerchantArrangementPlanListDTO reqDTO) throws ApiException;

    /**
     * 描述：批量供货
     */
    String applyAll(AeAppClientDTO acDTO, AeMerchantApplyAllDTO reqDTO) throws ApiException;

    /**
     * 描述：指定商机的下载
     */
    String planChanceDownload(AeAppClientDTO acDTO, AeMerchantPlanChanceDownloadDTO reqDTO) throws ApiException;

    /**
     * 描述：指定商机的报名状态查询
     */
    String planProductsQuery(AeAppClientDTO acDTO, AeMerchantPlanProductsQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：查询AE商家隐私文件
     */
    String privateFileGet(AeAppClientDTO acDTO, AeMerchantPrivateFileGetDTO reqDTO) throws ApiException;

    /**
     * 描述：查询卖家的资料，如国别、结算币种等
     */
    String profileGet(AeAppClientDTO acDTO, AeMerchantProfileGetDTO reqDTO) throws ApiException;

    /**
     * 描述：提供商家体检状态及预警信息。
     */
    String diagnosisQuery(AeAppClientDTO acDTO, AeMerchantDiagnosisQueryDTO reqDTO) throws ApiException;

    /**
     * 描述：统计数据读取
     */
    String planDashboardQuery(AeAppClientDTO acDTO, AeMerchantPlanDashboardQueryDTO reqDTO) throws ApiException;

}
