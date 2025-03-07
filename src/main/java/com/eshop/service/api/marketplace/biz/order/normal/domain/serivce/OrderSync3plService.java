package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;


import com.eshop.entity.base.PlatformOrder3plVO;

/**
 * @author ldj
 * @date 2024/3/6 15:52
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSync3plService {

    //更新3pl 包裹记录
    void update3plPackageRecord(Long orderId, PlatformOrder3plVO platform3plVO) throws Exception;
}
