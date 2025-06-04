package com.eshop.util.platform.api.service.order.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderDetailV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderListV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderDetailV2RespVO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderListV2RespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TemuOrderV2CallImpl implements TemuOrderV2Call {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuOrderListV2RespVO getOrderListV2(TemuAppClientDTO temuAcDTO, TemuOrderListV2ReqDTO reqDTO) throws Exception {
        String type = "bg.order.list.v2.get";
        TemuOrderListV2RespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderListV2RespVO.class,
                reqDTO
        );
        return respVO;
    }

    @Override
    public TemuOrderDetailV2RespVO getOrderDetailV2(TemuAppClientDTO temuAcDTO, TemuOrderDetailV2ReqDTO reqDTO) throws Exception {
        String type = "bg.order.detail.v2.get";
        TemuOrderDetailV2RespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderDetailV2RespVO.class,
                reqDTO
        );
        return respVO;
    }
}
