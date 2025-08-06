package com.eshop.util.platform.call.order.temu.ship;

import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.call.order.temu.ship.dto.*;
import com.eshop.util.platform.call.order.temu.ship.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class TemuOrderShipCallImpl implements TemuOrderShipCall {

    @Resource
    private TemuApiInvoker temuApiInvoker;

    @Override
    public TemuOrderShipStagingAddRespVO stagingAdd(TemuAppClientDTO temuAcDTO, TemuOrderShipStagingAddReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.staging.add";
        TemuOrderShipStagingAddRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipStagingAddRespVO.class,
                reqDTO
        );
        TemuOrderShipStagingAddResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setExistJoinErrorSubPurchase(resultVO.getExistJoinErrorSubPurchase());
            respVO.setJoinErrorList(resultVO.getJoinErrorList());
        }
        return respVO;
    }

    @Override
    public TemuOrderShipOrderV3CreateRespVO shipOrderV3Create(TemuAppClientDTO temuAcDTO, TemuOrderShipOrderV3CreateReqDTO reqDTO) throws Exception {
        String type = "bg.shiporderv3.create";
        TemuOrderShipOrderV3CreateRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipOrderV3CreateRespVO.class,
                reqDTO
        );
        TemuOrderShipOrderV3CreateResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setCancelUrgencyType(resultVO.getCancelUrgencyType());
            respVO.setIsUrgencyType(resultVO.getIsUrgencyType());
            respVO.setCancelUrgencyTypeSubPurchaseOrderSnList(resultVO.getCancelUrgencyTypeSubPurchaseOrderSnList());
            respVO.setDeliveryOrders(resultVO.getDeliveryOrders());
        }
        return respVO;
    }

    @Override
    public TemuOrderShipOrderMallAddressRespVO mallAddressGet(TemuAppClientDTO temuAcDTO, TemuOrderShipOrderMallAddressReqDTO reqDTO) throws Exception {
        String type = "bg.mall.address.get";
        TemuOrderShipOrderMallAddressRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipOrderMallAddressRespVO.class,
                reqDTO
        );
        return respVO;
    }

    @Override
    public TemuOrderShipOrderReceiveAddressRespVO receiveAddressV2Get(TemuAppClientDTO temuAcDTO, TemuOrderShipOrderReceiveAddressReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.receiveaddressv2.get";
        TemuOrderShipOrderReceiveAddressRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipOrderReceiveAddressRespVO.class,
                reqDTO
        );
        return respVO;
    }

    @Override
    public TemuOrderShipPackingSendRespVO packingSend(TemuAppClientDTO temuAcDTO, TemuOrderShipPackingSendReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.packing.send";
        TemuOrderShipPackingSendRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipPackingSendRespVO.class,
                reqDTO
        );

        TemuOrderShipPackingSendResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setExpressBatchSn(resultVO.getExpressBatchSn());
        }
        return respVO;
    }

    @Override
    public TemuOrderShipV3LogisticsMatchGetRespVO v3LogisticsMatchGet(TemuAppClientDTO temuAcDTO, TemuOrderShipV3LogisticsMatchGetReqDTO reqDTO) throws Exception {
        String type = "bg.shiporderv3.logisticsmatch.get";
        TemuOrderShipV3LogisticsMatchGetRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipV3LogisticsMatchGetRespVO.class,
                reqDTO
        );
        TemuOrderShipV3LogisticsMatchGetResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setMostUsedExpressCompany(resultVO.getMostUsedExpressCompany());
            respVO.setUsePricePrivileges(resultVO.getUsePricePrivileges());
            respVO.setList(resultVO.getList());
        }
        return respVO;
    }

    @Override
    public TemuOrderShipLogisticsGetRespVO logisticsGet(TemuAppClientDTO temuAcDTO, TemuOrderShipLogisticsGetReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.logistics.get";
        TemuOrderShipLogisticsGetRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipLogisticsGetRespVO.class,
                reqDTO
        );
        return respVO;
    }

    @Override
    public TemuOrderShipStagingGetRespVO stagingGet(TemuAppClientDTO temuAcDTO, TemuOrderShipStagingGetReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.staging.get";
        TemuOrderShipStagingGetRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipStagingGetRespVO.class,
                reqDTO
        );

        TemuOrderShipStagingGetResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setTotal(resultVO.getTotal());
            respVO.setList(resultVO.getList());
        }
        return respVO;
    }

    @Override
    public TemuOrderShipV2GetRespVO v2Get(TemuAppClientDTO temuAcDTO, TemuOrderShipV2GetReqDTO reqDTO) throws Exception {
        String type = "bg.shiporderv2.get";
        TemuOrderShipV2GetRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipV2GetRespVO.class,
                reqDTO
        );

        TemuOrderShipV2GetResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setTotal(resultVO.getTotal());
            respVO.setList(resultVO.getList());
        }
        return respVO;
    }

    @Override
    public TemuOrderShipPackageEditRespVO packageEdit(TemuAppClientDTO temuAcDTO, TemuOrderShipPackageEditReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.package.edit";
        TemuOrderShipPackageEditRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipPackageEditRespVO.class,
                reqDTO
        );

        return respVO;
    }

    @Override
    public TemuOrderShipPackageGetRespVO packageGet(TemuAppClientDTO temuAcDTO, TemuOrderShipPackageGetReqDTO reqDTO) throws Exception {
        String type = "bg.shiporder.package.get";
        TemuOrderShipPackageGetRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuOrderShipPackageGetRespVO.class,
                reqDTO
        );
        return respVO;
    }
}
