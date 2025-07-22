package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsBrandGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsBrandGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuProductBrandCall {

    /**
     * 查询可绑定的品牌接口（bg.goods.brand.get）
     * CN
     */
    TemuGoodsBrandGetRespVO goodsDetailGet(TemuAppClientDTO temuAcDTO, TemuGoodsBrandGetReqDTO reqDTO) throws Exception;

}
