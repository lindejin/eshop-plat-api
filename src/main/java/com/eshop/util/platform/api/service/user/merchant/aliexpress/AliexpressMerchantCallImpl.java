package com.eshop.util.platform.api.service.user.merchant.aliexpress;

import com.eshop.util.platform.api.service.user.merchant.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressMerchantEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/7 9:42
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressMerchantCallImpl implements AliexpressMerchantCall {
    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.plan.chance.download.all");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：全部商机的下载
     */
    @Override
    public String planChanceDownloadAll(AeAppClientDTO acDTO, AeMerchantPlanChanceDownloadAllDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PLAN_CHANCE_DOWNLOAD_ALL.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.plan.chance.list");
        request.addApiParameter("planId", "1");
        request.addApiParameter("current", "1");
        request.addApiParameter("pageSize", "20");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：分页查指定商机的所有机会信息
     */
    @Override
    public String planChanceList(AeAppClientDTO acDTO, AeMerchantPlanChanceListDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PLAN_CHANCE_LIST.getApiName());
        request.addApiParameter("planId", reqDTO.getPlanId());
        request.addApiParameter("current", reqDTO.getCurrent());
        request.addApiParameter("pageSize", reqDTO.getPageSize());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.merchant.Address.list");
        request.addApiParameter("param", "{\"address_types\":[\"WAREHOUSE\",\"WAREHOUSE\"],\"channel_seller_id\":\"1234\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：商家地址列表查询
     */
    @Override
    public String addressList(AeAppClientDTO acDTO, AeMerchantAddressListDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.ADDRESS_LIST.getApiName());
        request.addApiParameter("param", reqDTO.getParam());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.arrangement.plan.list");
        request.addApiParameter("planType", "12");
        request.addApiParameter("planId", "1");
        request.addApiParameter("pageNo", "-");
        request.addApiParameter("pageSize", "-");
        request.addApiParameter("sort", "-");
        request.addApiParameter("categoryPath", "-");
        request.addApiParameter("region", "-");
        request.addApiParameter("priceRange", "-");
        request.addApiParameter("priceRangeCurrency", "-");
        request.addApiParameter("opportunitySource", "-");
        request.addApiParameter("joinStatus", "-");
        request.addApiParameter("planStatus", "-");
        request.addApiParameter("hasCollected", "-");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：商机信息列表
     */
    @Override
    public String arrangementPlanList(AeAppClientDTO acDTO, AeMerchantArrangementPlanListDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.ARRANGEMENT_PLAN_LIST.getApiName());
        request.addApiParameter("planType", reqDTO.getPlanType());
        request.addApiParameter("planId", reqDTO.getPlanId());
        request.addApiParameter("pageNo", reqDTO.getPageNo());
        request.addApiParameter("pageSize", reqDTO.getPageSize());
        request.addApiParameter("sort", reqDTO.getSort());
        request.addApiParameter("categoryPath", reqDTO.getCategoryPath());
        request.addApiParameter("region", reqDTO.getRegion());
        request.addApiParameter("priceRange", reqDTO.getPriceRange());
        request.addApiParameter("priceRangeCurrency", reqDTO.getPriceRangeCurrency());
        request.addApiParameter("opportunitySource", reqDTO.getOpportunitySource());
        request.addApiParameter("joinStatus", reqDTO.getJoinStatus());
        request.addApiParameter("planStatus", reqDTO.getPlanStatus());
        request.addApiParameter("hasCollected", reqDTO.getHasCollected());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }


    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.apply.all");
        request.addApiParameter("planType", "12");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：批量供货
     */
    @Override
    public String applyAll(AeAppClientDTO acDTO, AeMerchantApplyAllDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.APPLY_ALL.getApiName());
        request.addApiParameter("planType", reqDTO.getPlanType());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.plan.chance.download");
        request.addApiParameter("planId", "2678378");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：指定商机的下载
     */
    @Override
    public String planChanceDownload(AeAppClientDTO acDTO, AeMerchantPlanChanceDownloadDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PLAN_CHANCE_DOWNLOAD.getApiName());
        request.addApiParameter("planId", reqDTO.getPlanId());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.plan.products.query");
        request.addApiParameter("planId", "-");
        request.addApiParameter("topCategoryId", "-");
        request.addApiParameter("leafCategoryId", "-");
        request.addApiParameter("categoryPath", "-");
        request.addApiParameter("countGroupEnum", "-");
        request.addApiParameter("productStatus", "-");
        request.addApiParameter("productIds", "-");
        request.addApiParameter("productName", "-");
        request.addApiParameter("productId", "-");
        request.addApiParameter("productPublishTimeStart", "-");
        request.addApiParameter("productPublishTimeEnd", "-");
        request.addApiParameter("planType", "-");
        request.addApiParameter("productApplyStatus", "-");
        request.addApiParameter("pageNo", "-");
        request.addApiParameter("pageSize", "-");
        request.addApiParameter("sort", "-");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：指定商机的报名状态查询
     */
    @Override
    public String planProductsQuery(AeAppClientDTO acDTO, AeMerchantPlanProductsQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PLAN_PRODUCTS_QUERY.getApiName());
        request.addApiParameter("planId", reqDTO.getPlanId());
        request.addApiParameter("topCategoryId", reqDTO.getTopCategoryId());
        request.addApiParameter("leafCategoryId", reqDTO.getLeafCategoryId());
        request.addApiParameter("categoryPath", reqDTO.getCategoryPath());
        request.addApiParameter("countGroupEnum", reqDTO.getCountGroupEnum());
        request.addApiParameter("productStatus", reqDTO.getProductStatus());
        request.addApiParameter("productIds", reqDTO.getProductIds());
        request.addApiParameter("productName", reqDTO.getProductName());
        request.addApiParameter("productId", reqDTO.getProductId());
        request.addApiParameter("productPublishTimeStart", reqDTO.getProductPublishTimeStart());
        request.addApiParameter("productPublishTimeEnd", reqDTO.getProductPublishTimeEnd());
        request.addApiParameter("planType", reqDTO.getPlanType());
        request.addApiParameter("productApplyStatus", reqDTO.getProductApplyStatus());
        request.addApiParameter("pageNo", reqDTO.getPageNo());
        request.addApiParameter("pageSize", reqDTO.getPageSize());
        request.addApiParameter("sort", reqDTO.getSort());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.merchant.private.file.get");
        request.addApiParameter("param0", "{\"file_name\":\"Sd58fdfb7d1f84ef9ab696ebd46b43168D.png\"}");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：查询AE商家隐私文件
     */
    @Override
    public String privateFileGet(AeAppClientDTO acDTO, AeMerchantPrivateFileGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PRIVATE_FILE_GET.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.merchant.profile.get");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：查询卖家的资料，如国别、结算币种等
     */
    @Override
    public String profileGet(AeAppClientDTO acDTO,AeMerchantProfileGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PROFILE_GET.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.merchant.diagnosis.query");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：提供商家体检状态及预警信息。
     */
    @Override
    public String diagnosisQuery(AeAppClientDTO acDTO, AeMerchantDiagnosisQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.DIAGNOSIS_QUERY.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("ae.merchant.assortment.seller.plan.dashboard.query");
        request.addApiParameter("planType", "12");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：统计数据读取
     */
    @Override
    public String planDashboardQuery(AeAppClientDTO acDTO, AeMerchantPlanDashboardQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressMerchantEnu.PLAN_DASHBOARD_QUERY.getApiName());
        request.addApiParameter("planType", reqDTO.getPlanType());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

}
