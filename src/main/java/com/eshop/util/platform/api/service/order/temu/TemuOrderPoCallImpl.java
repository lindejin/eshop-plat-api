package com.eshop.util.platform.api.service.order.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.temu.TemuClient;
import com.eshop.util.platform.api.client.temu.TemuRequest;
import com.eshop.util.platform.api.client.temu.TemuResponse;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemuOrderPoCallImpl implements TemuOrderPoCall {

    @Autowired
    private TemuClient temuClient;

    @Override
    public String getOrderList(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        //请求接口 API接口名，形如：bg.*
        String type = "bg.order.list.get";
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

    @Override
    public String getOrderDetail(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.order.detail.get";
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

    @Override
    public String getCombinedShipmentList(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.order.combinedshipment.list.get";
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

    @Override
    public String getOrderShippingInfo(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.order.shippinginfo.get";
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

    @Override
    public String getLogisticsShipment(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.get";
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

    @Override
    public String orderFulfillmentInfoSync(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.order.fulfillment.info.sync";
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



    @Override
    public String logisticsShipmentConfirm(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.confirm";
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
    //bg.logistics.shipment.sub.confirm

    @Override
    public String logisticsShipmentSubConfirm(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.shipment.sub.confirm";
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

    //bg.logistics.template.get
    @Override
    public String logisticsTemplateGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.template.get";
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

    //bg.logistics.companies.get
    @Override
    public String logisticsCompaniesGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.logistics.companies.get";
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

    //bg.aftersales.parentaftersales.list.get
    //查询父售后单信息
    @Override
    public String afterSalesParentAfterSalesListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.aftersales.parentaftersales.list.get";
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
    // bg.aftersales.aftersales.list.get
    // 查询子售后单信息
    @Override
    public String afterSalesAfterSalesListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.aftersales.aftersales.list.get";
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

    // bg.aftersales.parentreturnorder.get
    // 查询售后逆向物流信息
    @Override
    public String afterSalesParentReturnOrderGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        //请求接口 API接口名，形如：bg.*
        String type = "bg.aftersales.parentreturnorder.get";
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
