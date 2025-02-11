package com.eshop.util.platform.api.service.user.seller.aliexpress;

import com.eshop.util.platform.api.service.user.seller.aliexpress.dto.AeGlobalSellerBrandsListDTO;
import com.eshop.util.platform.api.service.user.seller.aliexpress.dto.AeGlobalSellerRelationQueryDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/4/17 15:31
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressGlobalSellerCall {

    /**
     * 描述：获取商家有发布权限的统一品牌
     */
    String sellerBrandsList(AeAppClientDTO acDTO, AeGlobalSellerBrandsListDTO reqDTO) throws ApiException;

    /**
     * 描述：获取商家账号关系列表
     */
    String sellerRelationQuery(AeAppClientDTO acDTO, AeGlobalSellerRelationQueryDTO reqDTO) throws ApiException;

}
