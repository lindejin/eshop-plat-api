package com.eshop.util.platform.call.order.temu.ship;

import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.ship.dto.*;
import com.eshop.util.platform.call.order.temu.ship.vo.*;

public interface TemuOrderShipCall {

    /**
     * 加入发货台
     */
    TemuOrderShipStagingAddRespVO stagingAdd(TemuAppClientDTO temuAcDTO, TemuOrderShipStagingAddReqDTO reqDTO) throws Exception;

    /**
     * 创建发货单
     * bg.shiporderv3.create
     */
    TemuOrderShipOrderV3CreateRespVO shipOrderV3Create(TemuAppClientDTO temuAcDTO, TemuOrderShipOrderV3CreateReqDTO reqDTO) throws Exception;

    /**
     * 查询卖家发货地址
     * bg.mall.address.get
     */
    TemuOrderShipOrderMallAddressRespVO mallAddressGet(TemuAppClientDTO temuAcDTO, TemuOrderShipOrderMallAddressReqDTO reqDTO) throws Exception;

    /**
     * 查询收货地址
     * bg.shiporder.receiveaddressv2.get
     */
    TemuOrderShipOrderReceiveAddressRespVO receiveAddressV2Get(TemuAppClientDTO temuAcDTO, TemuOrderShipOrderReceiveAddressReqDTO reqDTO) throws Exception;

    /**
     * 装箱发货
     * bg.shiporder.packing.send
     */
    TemuOrderShipPackingSendRespVO packingSend(TemuAppClientDTO temuAcDTO, TemuOrderShipPackingSendReqDTO reqDTO) throws Exception;

    /**
     * 平台推荐物流
     * bg.shiporderv3.logisticsmatch.get
     */
    TemuOrderShipV3LogisticsMatchGetRespVO v3LogisticsMatchGet(TemuAppClientDTO temuAcDTO, TemuOrderShipV3LogisticsMatchGetReqDTO reqDTO) throws Exception;

    /**
     * 自行委托三方物流公司查询
     * bg.shiporder.logistics.get
     */
    TemuOrderShipLogisticsGetRespVO logisticsGet(TemuAppClientDTO temuAcDTO, TemuOrderShipLogisticsGetReqDTO reqDTO) throws Exception;


    /**
     * 查询发货台
     * bg.shiporder.staging.get
     */
    TemuOrderShipStagingGetRespVO stagingGet(TemuAppClientDTO temuAcDTO, TemuOrderShipStagingGetReqDTO reqDTO) throws Exception;

    /**
     * 查询发货单v2
     * bg.shiporderv2.get
     */
    TemuOrderShipV2GetRespVO v2Get(TemuAppClientDTO temuAcDTO, TemuOrderShipV2GetReqDTO reqDTO) throws Exception;

    /**
     *  装箱发货校验
     *  bg.shiporder.packing.match
     */
    TemuOrderShipPackingMatchRespVO packingMatch(TemuAppClientDTO temuAcDTO, TemuOrderShipPackingMatchReqDTO reqDTO) throws Exception;


    /**
     *  发货包裹编辑
     *  bg.shiporder.package.edit
     */
    TemuOrderShipPackageEditRespVO packageEdit(TemuAppClientDTO temuAcDTO, TemuOrderShipPackageEditReqDTO reqDTO) throws Exception;

    /**
     *  发货包裹查询
     *  bg.shiporder.package.get
     */
    TemuOrderShipPackageGetRespVO packageGet(TemuAppClientDTO temuAcDTO, TemuOrderShipPackageGetReqDTO reqDTO) throws Exception;

}
