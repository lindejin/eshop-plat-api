package com.eshop.util.platform.api.service.order.temu;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.service.order.temu.dto.*;
import com.eshop.util.platform.api.service.order.temu.vo.*;
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

    @Override
    public TemuOrderPoOrderShippingInfoV2RespVO getOrderShippingInfoV2(TemuAppClientDTO temuAcDTO, TemuOrderPoOrderShippingInfoV2ReqDTO reqDTO) throws Exception {
        String type = "bg.order.shippinginfo.v2.get";
        TemuOrderPoOrderShippingInfoV2RespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderPoOrderShippingInfoV2RespVO.class,
                reqDTO
        );
        return respVO;
    }

    @Override
    public TemuOrderPoLogisticsShipmentV2RespVO getLogisticsShipmentV2(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentV2ReqDTO reqDTO) throws Exception {
        String type = "bg.logistics.shipment.v2.get";
        TemuOrderPoLogisticsShipmentV2RespVO respVO = temuApiInvoker.execute(
                tcDTO,
                type,
                TemuOrderPoLogisticsShipmentV2RespVO.class,
                reqDTO
        );
        return respVO;
    }

    @Override
    public TemuOrderPoV2LogisticsShipmentConfirmRespVO logisticsShipmentConfirmV2(TemuAppClientDTO tcDTO, TemuOrderPoV2LogisticsShipmentConfirmReqDTO reqDTO) throws Exception {
        String type = "bg.logistics.shipment.v2.confirm";
        TemuOrderPoV2LogisticsShipmentConfirmRespVO respVO = temuApiInvoker.execute(
                tcDTO,
                type,
                TemuOrderPoV2LogisticsShipmentConfirmRespVO.class,
                reqDTO
        );
        return respVO;
    }
}
