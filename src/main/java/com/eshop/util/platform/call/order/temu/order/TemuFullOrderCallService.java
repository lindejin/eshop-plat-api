package com.eshop.util.platform.call.order.temu.order;

import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.order.dto.TemuFullOrderPurchaseOrderV2ReqDTO;
import com.eshop.util.platform.call.order.temu.order.vo.TemuFullOrderPurchaseOrderV2RespVO;

public interface TemuFullOrderCallService {

    /**
     * 查询备货单列表V2
     */
    TemuFullOrderPurchaseOrderV2RespVO getPurchaseOrderV2(TemuAppClientDTO tcDTO, TemuFullOrderPurchaseOrderV2ReqDTO orderListReqDTO) throws Exception;

}
