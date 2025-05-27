package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsDetailGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsDetailGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuProductCall {

    /**
     * 货品详情查询
     * （bg.goods.detail.get）
     * CN
     */
    TemuGoodsDetailGetRespVO goodsDetailGet(TemuAppClientDTO temuAcDTO, TemuGoodsDetailGetReqDTO reqDTO) throws Exception;

}
