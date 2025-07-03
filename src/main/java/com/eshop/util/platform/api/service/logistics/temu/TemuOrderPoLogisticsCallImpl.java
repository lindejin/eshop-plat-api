package com.eshop.util.platform.api.service.logistics.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuApiInvoker;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.service.logistics.temu.dto.*;
import com.eshop.util.platform.api.service.logistics.temu.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TemuOrderPoLogisticsCallImpl implements TemuOrderPoLogisticsCall {

    @Autowired
    private TemuClient temuClient;

    @Resource
    private TemuApiInvoker temuApiInvoker;

    // 查询卖家发货仓库基础信息接口
    // bg.logistics.warehouse.list.get
    @Override
    public TemuLogisticsWarehouseListRespVO logisticsWarehouseListGet(TemuAppClientDTO temuAcDTO, TemuLogisticsWarehouseListReqDTO reqDTO) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.warehouse.list.get";
        TemuLogisticsWarehouseListRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuLogisticsWarehouseListRespVO.class,
                reqDTO
        );
        //返回参数二次处理
        List<TemuLogisticsWarehouseListResultWarehouseVO> warehouseList = Optional.ofNullable(respVO.getResult())
                .map(TemuLogisticsWarehouseListResultVO::getWarehouseList).orElse(null);
        respVO.setWarehouseList(warehouseList);
        return respVO;
    }

    //temu.logistics.shiplogisticstype.get
    //描述：您可以通过此 API 获取所有在线发货物流类型的信息。
    // 之后，他们可以在 Temu 上调用“bg.logistics.shipment.create”来创建购买发货。
    // 一旦您选择购买发货物流类型，Temu 将自动为您选择最推荐的渠道 ID 和购买发货方式。
    @Override
    public TemuLogisticsShipLogisticsTypeRespVO logisticsShipLogisticsTypeGet(TemuAppClientDTO temuAcDTO, TemuLogisticsShipLogisticsTypeReqDTO reqDTO) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "temu.logistics.shiplogisticstype.get";
        TemuLogisticsShipLogisticsTypeRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuLogisticsShipLogisticsTypeRespVO.class,
                reqDTO
        );
        //返回参数二次处理
        TemuLogisticsShipLogisticsTypeResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setRegionId(resultVO.getRegionId());
            respVO.setShipLogisticsTypeInfoDTOList(resultVO.getShipLogisticsTypeInfoDTOList());
        }
        return respVO;
    }

    // 查询可用物流服务接口
    // bg.logistics.shippingservices.get
    @Override
    public TemuLogisticsShippingServicesRespVO logisticsShippingServicesGet(TemuAppClientDTO temuAcDTO, TemuLogisticsShippingServicesReqDTO reqDTO) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shippingservices.get";
        TemuLogisticsShippingServicesRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuLogisticsShippingServicesRespVO.class,
                reqDTO
        );
        //返回参数二次处理
        TemuLogisticsShippingServicesResultVO resultVO = Optional.ofNullable(respVO.getResult()).orElse(null);
        if (resultVO != null) {
            respVO.setOnlineChannelDtoList(resultVO.getOnlineChannelDtoList());
            respVO.setUnavailableChannelDtoList(resultVO.getUnavailableChannelDtoList());
        }
        return respVO;
    }

    // 物流在线发货下单接口
    // bg.logistics.shipment.create
    @Override
    public String logisticsShipmentCreate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.create";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }

    // 下call成功待发货包裹列表查询接口
    // bg.order.unshipped.package.get
    @Override
    public String orderUnshippedPackageGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.order.unshipped.package.get";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }

    // 确认包裹发货接口
    // bg.logistics.shipped.package.confirm
    @Override
    public String logisticsShippedPackageConfirm(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipped.package.confirm";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }

    // 物流在线发货下单查询接口
    // bg.logistics.shipment.result.get

    @Override
    public TemuLogisticsShipmentResultRespVO logisticsShipmentResultGet(TemuAppClientDTO temuAcDTO, TemuLogisticsShipmentResultReqDTO reqDTO) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.result.get";
        TemuLogisticsShipmentResultRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuLogisticsShipmentResultRespVO.class,
                reqDTO
        );
        String trackingNumber = Optional.ofNullable(respVO.getResult())
                .map(TemuLogisticsShipmentResultVO::getPackageInfoResultList)
                .map(list -> list.get(0))
                .map(TemuLogisticsShipmentResultPackageInfoVO::getTrackingNumber).orElse(null);
        respVO.setTrackingNumber(trackingNumber);
        return respVO;
    }

    // 物流在线发货重新下单接口
    // bg.logistics.shipment.update
    @Override
    public String logisticsShipmentUpdate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.update";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }

    // 物流在线发货修改物流接口
    // bg.logistics.shipment.shippingtype.update
    @Override
    public String logisticsShipmentShippingTypeUpdate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.shippingtype.update";
        String version = null;
        //请求返回的数据格式，可选参数固定为JSON
        String dataType = "JSON";

        TemuRequest temuRequest = new TemuRequest();
        temuRequest.setType(type);
        temuRequest.setDataType(dataType);
        temuRequest.setVersion(version);
        //商品实体
        temuRequest.setJsonParams(businessDto);

        TemuResponse temuResponse = temuClient.execute(temuRequest, publicDto);
        return temuResponse.getGopResponseBody();
    }

    // 物流在线发货打印面单接口
    // bg.logistics.shipment.document.get
    @Override
    public TemuLogisticsShipmentDocumentRespVO logisticsShipmentDocumentGet(TemuAppClientDTO temuAcDTO, TemuLogisticsShipmentDocumentReqDTO reqDTO) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.document.get";
        TemuLogisticsShipmentDocumentRespVO respVO = temuApiInvoker.execute(
                temuAcDTO,
                type,
                TemuLogisticsShipmentDocumentRespVO.class,
                reqDTO
        );
        //返回参数二次处理
        String url = Optional.ofNullable(respVO.getResult())
                .map(TemuLogisticsShipmentDocumentResultVO::getShippingLabelUrlList)
                .map(list -> list.get(0))
                .map(TemuLogisticsShipmentDocumentShippingLabelUrlVO::getUrl).orElse(null);
        respVO.setUrl(url);
        return respVO;
    }
}
