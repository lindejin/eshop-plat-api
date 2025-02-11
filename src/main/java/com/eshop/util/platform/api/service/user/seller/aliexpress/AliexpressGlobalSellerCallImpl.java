package com.eshop.util.platform.api.service.user.seller.aliexpress;

import com.eshop.util.platform.api.service.user.seller.aliexpress.dto.AeGlobalSellerBrandsListDTO;
import com.eshop.util.platform.api.service.user.seller.aliexpress.dto.AeGlobalSellerRelationQueryDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressGlobalSellerEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/4/17 15:31
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressGlobalSellerCallImpl implements AliexpressGlobalSellerCall {

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("global.seller.brands.list");
        request.setHttpMethod("GET");
        request.addApiParameter("locale", "en_US");
        request.addApiParameter("category_id", "62239238");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：获取商家有发布权限的统一品牌
     */
    @Override
    public String sellerBrandsList(AeAppClientDTO acDTO, AeGlobalSellerBrandsListDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressGlobalSellerEnu.SELLER_BRANDS_LIST.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("locale", reqDTO.getLocale());
        request.addApiParameter("category_id", reqDTO.getCategory_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("global.seller.relation.query");
        request.setHttpMethod("GET");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：获取商家账号关系列表
     */
    @Override
    public String sellerRelationQuery(AeAppClientDTO acDTO, AeGlobalSellerRelationQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressGlobalSellerEnu.SELLER_RELATION_QUERY.getApiName());
        request.setHttpMethod("GET");
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
