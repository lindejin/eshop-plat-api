package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;



import com.eshop.entity.base.PlatformSyncInfoResponseVO;
import com.eshop.entity.base.ShopContextVO;
import com.eshop.entity.order.TbOrder;

import java.util.List;

/**
 * @author ldj
 * @date 2023/6/26 15:21
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncFilterService {

    /**
     * 新增订单 过滤
     */
    List<PlatformSyncInfoResponseVO<TbOrder>> orderAddFilter(List<PlatformSyncInfoResponseVO<TbOrder>> poList, ShopContextVO shopContextVO) throws Exception;

    /**
     * 更新订单  过滤
     */
    List<PlatformSyncInfoResponseVO<TbOrder>> orderUpdateFilter(List<PlatformSyncInfoResponseVO<TbOrder>> poList, ShopContextVO shopContextVO) throws Exception;

    /**
     * 申请取消订单  过滤
     */
    List<PlatformSyncInfoResponseVO<TbOrder>> orderInCancelFilter(List<PlatformSyncInfoResponseVO<TbOrder>> poList, ShopContextVO shopContextVO) throws Exception;

}
