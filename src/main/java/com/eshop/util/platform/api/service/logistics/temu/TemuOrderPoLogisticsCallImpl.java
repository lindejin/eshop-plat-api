package com.eshop.util.platform.api.service.logistics.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuOrderPoLogisticsCallImpl implements TemuOrderPoLogisticsCall {

    @Autowired
    private TemuClient temuClient;

    // 查询卖家发货仓库基础信息接口
    // bg.logistics.warehouse.list.get
    @Override
    public String logisticsWarehouseListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.warehouse.list.get";
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

    // 查询可用物流服务接口
    // bg.logistics.shippingservices.get
    @Override
    public String logisticsShippingServicesGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shippingservices.get";
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
    public String logisticsShipmentResultGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.result.get";
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
    public String logisticsShipmentDocumentGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.document.get";
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
}
