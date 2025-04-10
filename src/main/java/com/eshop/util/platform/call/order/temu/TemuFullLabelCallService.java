package com.eshop.util.platform.call.order.temu;

import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullGoodsCustomLabelReqDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullGoodsLabelV2ReqDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullLogisticsBoxMarkInfoReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullGoodsCustomLabelRespVO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullGoodsLabelV2RespVO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullLogisticsBoxMarkInfoRespVO;

public interface TemuFullLabelCallService {

    /**
     * 查询备货单列表V2
     */
    TemuFullGoodsLabelV2RespVO getGoodsLabelV2(TemuAppClientDTO tcDTO, TemuFullGoodsLabelV2ReqDTO reqDTO) throws Exception;


    /**
     * 定制商品条码查询
     */
    TemuFullGoodsCustomLabelRespVO getGoodsCustomLabel(TemuAppClientDTO tcDTO, TemuFullGoodsCustomLabelReqDTO reqDTO) throws Exception;


    /**
     * 查询箱唛
     */
    TemuFullLogisticsBoxMarkInfoRespVO getLogisticsBoxMarkInfo(TemuAppClientDTO tcDTO, TemuFullLogisticsBoxMarkInfoReqDTO reqDTO) throws Exception;

}
