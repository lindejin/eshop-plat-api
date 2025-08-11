package com.eshop.util.platform.api.service.product.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.product.temu.dto.add.TemuGoodsAddReqDTO;
import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsDetailGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.add.TemuGoodsAddRespVO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsDetailGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuProductCallImpl implements TemuProductCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuGoodsAddRespVO goodsAdd(TemuAppClientDTO temuAcDTO, TemuGoodsAddReqDTO reqDTO) throws Exception {
        String type = "bg.goods.add";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuGoodsAddRespVO.class,
                reqDTO
        );
    }

    @Override
    public TemuGoodsDetailGetRespVO goodsDetailGet(TemuAppClientDTO temuAcDTO, TemuGoodsDetailGetReqDTO reqDTO) throws Exception {
        String type = "bg.goods.detail.get";
        return temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuGoodsDetailGetRespVO.class,
                reqDTO
        );
    }
}
