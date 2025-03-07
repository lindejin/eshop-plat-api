package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;


import com.eshop.entity.base.PlatformSyncInfoResponseVO;
import com.eshop.entity.base.ShopContextVO;
import com.eshop.entity.order.TbOrder;

import java.util.List;

/**
 * @author ldj
 * @date 2023/12/8 10:57
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncCustomerService {

    /**
     * 客户先行验证
     * @param poList
     * @throws Exception
     */
    void customerProcess(ShopContextVO shopContextVO, List<PlatformSyncInfoResponseVO<TbOrder>> poList) throws Exception;
}
