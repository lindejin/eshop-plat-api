package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsBrandGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsDetailGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsBrandGetRespVO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsDetailGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuProductBrandCallImpl implements TemuProductBrandCall{

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuGoodsBrandGetRespVO goodsDetailGet(TemuAppClientDTO temuAcDTO, TemuGoodsBrandGetReqDTO reqDTO) throws Exception {
        String type = "bg.goods.brand.get";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuGoodsBrandGetRespVO.class,
                reqDTO
        );
    }
}
