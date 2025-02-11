package com.eshop.util.platform.api.service.supply.aliexpress;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.supply.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressScpEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import com.global.iop.util.FileItem;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author xxs
 * @date 2024/9/06
 * @Description: 速卖通全托管接口对接实现
 * @Version 1.0
 */
@Service
public class AliexpressAscpCallImpl implements AliexpressAscpCall {

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/address/get");
        request.addApiParameter("systemType", "wms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("warehouseCode", "warehouseCode");
        request.addApiParameter("locale", "en");
        request.addApiParameter("addressType", "reverse");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * "Query 3pl warehouse address info"
     */
    @Override
    public String warehouseAddressGet(AeAppClientDTO acDTO, AeWarehouseAddressGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_ADDRESS_GET.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("locale", reqDTO.getLocale());
        request.addApiParameter("addressType", reqDTO.getAddressType());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/item/create/post");
        request.addApiParameter("systemType", "wms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("warehouseCode", "warehouseCode");
        request.addApiParameter("requestTime", "12312312431");
        request.addApiParameter("requestId", "asdfasdf123");
        request.addApiParameter("scItems", "scItems");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："create or update item"
     */
    @Override
    public String warehouseItemCreatePost(AeAppClientDTO acDTO, AeWarehouseItemCreatePostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_ITEM_CREATE_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("requestTime", reqDTO.getRequestTime());
        request.addApiParameter("requestId", reqDTO.getRequestId());
        request.addApiParameter("scItems", reqDTO.getScItems());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/return/fo/cancel/post");
        request.addApiParameter("systemType", "wms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("outBizId", "RWO123");
        request.addApiParameter("cancelReason", "cancelReason");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："Cancel warehouse return order"
     */
    @Override
    public String warehouseReturnFoCancelPost(AeAppClientDTO acDTO, AeWarehouseReturnFoCancelPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_RETURN_FO_CANCEL_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("cancelReason", reqDTO.getCancelReason());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/return/fo/create/post");
        request.addApiParameter("systemType", "oms");
        request.addApiParameter("warehouseCustomerId", "4px");
        request.addApiParameter("outBizId", "RWO123redsf2");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("warehouseCode", "warehouseCode");
        request.addApiParameter("realExecuteTime", "123123");
        request.addApiParameter("pickingProvider", "pickingProvider");
        request.addApiParameter("pickingOrderNumber", "pickingOrderNumber");
        request.addApiParameter("pickingOrderUrl", "url");
        request.addApiParameter("pickingCode", "123412");
        request.addApiParameter("contactPhone", "1231421");
        request.addApiParameter("contactName", "name");
        request.addApiParameter("method", "destory");
        request.addApiParameter("items", "items");
        request.addApiParameter("requestTime", "123214");
        request.addApiParameter("requestId", "asdfafwe");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："warehouse return order async post"
     */
    @Override
    public String warehouseReturnFoCreatePost(AeAppClientDTO acDTO, AeWarehouseReturnFoCreatePostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_RETURN_FO_CREATE_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("realExecuteTime", reqDTO.getRealExecuteTime());
        request.addApiParameter("pickingProvider", reqDTO.getPickingProvider());
        request.addApiParameter("pickingOrderNumber", reqDTO.getPickingOrderNumber());
        request.addApiParameter("pickingOrderUrl", reqDTO.getPickingOrderUrl());
        request.addApiParameter("pickingCode", reqDTO.getPickingCode());
        request.addApiParameter("contactPhone", reqDTO.getContactPhone());
        request.addApiParameter("contactName", reqDTO.getContactName());
        request.addApiParameter("method", reqDTO.getMethod());
        request.addApiParameter("items", reqDTO.getItems());
        request.addApiParameter("requestTime", reqDTO.getRequestTime());
        request.addApiParameter("requestId", reqDTO.getRequestId());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/reverse/fo/cancel/post");
        request.addApiParameter("systemType", "wms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("wmsOrderId", "wmsOrderId");
        request.addApiParameter("outBizId", "WH123");
        request.addApiParameter("cancelReason", "cancelReason");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："Cancel Reverse Warehouse Order"
     */
    @Override
    public String warehouseReverseFoCancelPost(AeAppClientDTO acDTO, AeWarehouseReverseFoCancelPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_REVERSE_FO_CANCEL_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("wmsOrderId", reqDTO.getWmsOrderId());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("cancelReason", reqDTO.getCancelReason());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }
    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/reverse/fo/create/post");
        request.addApiParameter("systemType", "wms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("aeTradeOrderId", "aeTradeOrderId");
        request.addApiParameter("shopName", "123");
        request.addApiParameter("outBizId", "outBizId");
        request.addApiParameter("warehouseCode", "warehouseCode");
        request.addApiParameter("senderParam", "senderParam");
        request.addApiParameter("receiverParam", "receiverParam");
        request.addApiParameter("itemList", "itemList");
        request.addApiParameter("logisticParam", "logisticParam");
        request.addApiParameter("extendParam", "extendParam");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * "Reverse warehouse order async post"
     */
    @Override
    public String warehouseReverseFoCreatePost(AeAppClientDTO acDTO, AeWarehouseReverseFoCreatePostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_REVERSE_FO_CREATE_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("aeTradeOrderId", reqDTO.getAeTradeOrderId());
        request.addApiParameter("shopName", reqDTO.getShopName());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("senderParam", reqDTO.getSenderParam());
        request.addApiParameter("receiverParam", reqDTO.getReceiverParam());
        request.addApiParameter("itemList", reqDTO.getItemList());
        request.addApiParameter("logisticParam", reqDTO.getLogisticParam());
        request.addApiParameter("extendParam", reqDTO.getExtendParam());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/baseinfo/get");
        request.addApiParameter("country", "123");
        request.addApiParameter("warehouseCustomerId", "123");
        request.addApiParameter("systemType", "oms");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："query warehouse info"
     */
    @Override
    public String qimenWarehouseBaseInfoGet(AeAppClientDTO acDTO, AeQimenWarehouseBaseInfoGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_BASEINFO_GET.getApiName());
        request.addApiParameter("country", reqDTO.getCountry());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/calculateFee/get");
        request.addApiParameter("warehouseCode", "1");
        request.addApiParameter("height", "1");
        request.addApiParameter("goodsOwnerId", "1");
        request.addApiParameter("zipcode", "1");
        request.addApiParameter("country", "1");
        request.addApiParameter("shippingMethod", "1");
        request.addApiParameter("systemType", "1");
        request.addApiParameter("length", "1");
        request.addApiParameter("width", "1");
        request.addApiParameter("warehouseCustomerId", "1");
        request.addApiParameter("weight", "1");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："Calculate the shipping fee"
     */
    @Override
    public String qimenWarehouseCalculateFeeGet(AeAppClientDTO acDTO, AeQimenWarehouseCalculateFeeGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_CALCULATE_FEE_GET.getApiName());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("height", reqDTO.getHeight());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("zipcode", reqDTO.getZipcode());
        request.addApiParameter("country", reqDTO.getCountry());
        request.addApiParameter("shippingMethod", reqDTO.getShippingMethod());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("length", reqDTO.getLength());
        request.addApiParameter("width", reqDTO.getWidth());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("weight", reqDTO.getWeight());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("/qimen/aliexpress/warehouse/fo/cancel/post");
request.addApiParameter("goodsOwnerId", "1");
request.addApiParameter("systemType", "1");
request.addApiParameter("warehouseCustomerId", "1");
request.addApiParameter("cancelReason", "1");
request.addApiParameter("wmsOrderId", "1");
IopResponse response = client.execute(request, Protocol.GOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 描述："qimen.aliexpress.warehouse.fo.cancel.post"
     */
    @Override
    public String qimenWarehouseFoCancelPost(AeAppClientDTO acDTO, AeQimenWarehouseFoCancelPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_FO_CANCEL_POST.getApiName());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("cancelReason", reqDTO.getCancelReason());
        request.addApiParameter("wmsOrderId", reqDTO.getWmsOrderId());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/fo/detail/get");
        request.addApiParameter("outBizId", "1");
        request.addApiParameter("systemType", "1");
        request.addApiParameter("warehouseCustomerId", "1");
        request.addApiParameter("wmsOrderId", "1");
        request.addApiParameter("goodsOwnerId", "1");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："qimen.aliexpress.warehouse.fo.detail.get"
     */
    @Override
    public String qimenWarehouseFoDetailGet(AeAppClientDTO acDTO, AeQimenWarehouseFoDetailGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_FO_DETAIL_GET.getApiName());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("wmsOrderId", reqDTO.getWmsOrderId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/fo/intercept/post");
        request.addApiParameter("goodsOwnerId", "1");
        request.addApiParameter("systemType", "1");
        request.addApiParameter("warehouseCustomerId", "1");
        request.addApiParameter("cancelReason", "1");
        request.addApiParameter("wmsOrderId", "1");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："qimen.aliexpress.warehouse.fo.intercept.post"
     */
    @Override
    public String qimenWarehouseFoInterceptPost(AeAppClientDTO acDTO, AeQimenWarehouseFoInterceptPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_FO_INTERCEPT_POST.getApiName());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("cancelReason", reqDTO.getCancelReason());
        request.addApiParameter("wmsOrderId", reqDTO.getWmsOrderId());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }
    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/fo/modify/post");
        request.addApiParameter("addressAddition", "123");
        request.addApiParameter("goodsOwnerId", "1");
        request.addApiParameter("aeTradeOrderId", "1");
        request.addApiParameter("outBizId", "1");
        request.addApiParameter("country", "1");
        request.addApiParameter("city", "1");
        request.addApiParameter("address2", "1");
        request.addApiParameter("address1", "1");
        request.addApiParameter("shippingMethod", "1");
        request.addApiParameter("warehouseCustomerId", "1");
        request.addApiParameter("warehouseCode", "1");
        request.addApiParameter("zipcode", "1");
        request.addApiParameter("province", "1");
        request.addApiParameter("phone", "1");
        request.addApiParameter("systemType", "1");
        request.addApiParameter("name", "1");
        request.addApiParameter("items", "1");
        request.addApiParameter("wmsOrderId", "1");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："qimen.aliexpress.warehouse.fo.modify.post"
     */
    @Override
    public String qimenWarehouseFoModifyPost(AeAppClientDTO acDTO, AeQimenWarehouseFoModifyPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_FO_MODIFY_POST.getApiName());
        request.addApiParameter("addressAddition", reqDTO.getAddressAddition());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("aeTradeOrderId", reqDTO.getAeTradeOrderId());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("country", reqDTO.getCountry());
        request.addApiParameter("city", reqDTO.getCity());
        request.addApiParameter("address2", reqDTO.getAddress2());
        request.addApiParameter("address1", reqDTO.getAddress1());
        request.addApiParameter("shippingMethod", reqDTO.getShippingMethod());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("zipcode", reqDTO.getZipcode());
        request.addApiParameter("province", reqDTO.getProvince());
        request.addApiParameter("phone", reqDTO.getPhone());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("name", reqDTO.getName());
        request.addApiParameter("items", reqDTO.getItems());
        request.addApiParameter("wmsOrderId", reqDTO.getWmsOrderId());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/inventory/get");
        request.addApiParameter("systemType", "oms");
        request.addApiParameter("warehouseCustomerId", "test");
        request.addApiParameter("goodsOwnerId", "goodsOwnerId");
        request.addApiParameter("warehouseCodeList", "[\"\u4ED3code1\", \"\u4ED3code2\", \"\u4ED3code3\"],");
        request.addApiParameter("skuIdList", "[\"wms_sku_id1\", \"wms_sku_id2\", \"wms_sku_id3\"]");
        request.addApiParameter("pageSize", "10");
        request.addApiParameter("pageNo", "1");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："query warehosue inventory"
     */
    @Override
    public String qimenWarehouseInventoryGet(AeAppClientDTO acDTO, AeQimenWarehouseInventoryGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_INVENTORY_GET.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("warehouseCodeList", reqDTO.getWarehouseCodeList());
        request.addApiParameter("skuIdList", reqDTO.getSkuIdList());
        request.addApiParameter("pageSize", reqDTO.getPageSize());
        request.addApiParameter("pageNo", reqDTO.getPageNo());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/logistics/get");
        request.addApiParameter("warehouseCustomerId", "123");
        request.addApiParameter("warehouseCode", "13");
        request.addApiParameter("systemType", "oms");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："query logistics"
     */
    @Override
    public String qimenWarehouseLogisticsGet(AeAppClientDTO acDTO, AeQimenWarehouseLogisticsGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_LOGISTICS_GET.getApiName());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/owner/id/check/get");
        request.addApiParameter("systemType", "oms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "test");
        request.addApiParameter("ownerToken", "test");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："none"
     */
    @Override
    public String qimenWarehouseOwnerIdCheckGet(AeAppClientDTO acDTO, AeQimenWarehouseOwnerIdCheckGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_OWNER_ID_CHECK_GET.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("ownerToken", reqDTO.getOwnerToken());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/sales/get");
        request.addApiParameter("shopId", "123");
        request.addApiParameter("warehouseCustomerId", "123");
        request.addApiParameter("warehouseCode", "\u4ED3code");
        request.addApiParameter("goodsOwnerId", "3321");
        request.addApiParameter("startTime", "2021.06.01 12:13:15");
        request.addApiParameter("endTime", "2021.06.10 12:13:15");
        request.addApiParameter("systemType", "oms");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："query warehouse sales"
     */
    @Override
    public String qimenWarehouseSalesGet(AeAppClientDTO acDTO, AeQimenWarehouseSalesGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_SALES_GET.getApiName());
        request.addApiParameter("shopId", reqDTO.getShopId());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("startTime", reqDTO.getStartTime());
        request.addApiParameter("endTime", reqDTO.getEndTime());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/sku/bindlist/post");
        request.addApiParameter("systemType", "systemType");
        request.addApiParameter("warehouseCustomerId", "warehouseCustomerId");
        request.addApiParameter("goodsOwnerId", "goodsOwnerId");
        request.addApiParameter("skuBindList", "skuBindList");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："add sku bindlist"
     */
    @Override
    public String qimenWarehouseSkuBindListPost(AeAppClientDTO acDTO, AeQimenWarehouseSkuBindListPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_SKU_BINDLIST_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("skuBindList", reqDTO.getSkuBindList());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/skulist/info/get");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "goodsOwnerId");
        request.addApiParameter("systemType", "oms");
        request.addApiParameter("skuIdList", "[\"wms_sku_id1\", \"wms_sku_id2\", \"wms_sku_id3\"]");
        request.addApiParameter("warehouseCode", "warehouseCode");
        request.addApiParameter("pageSize", "20");
        request.addApiParameter("pageNo", "1");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："query sku detail info"
     */
    @Override
    public String qimenWarehouseSkuListInfoGet(AeAppClientDTO acDTO, AeQimenWarehouseSkuListInfoGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_SKULIST_INFO_GET.getApiName());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("skuIdList", reqDTO.getSkuIdList());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("pageSize", reqDTO.getPageSize());
        request.addApiParameter("pageNo", reqDTO.getPageNo());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/subscribe/get");
        request.addApiParameter("shopId", "123");
        request.addApiParameter("warehouseCustomerId", "123");
        request.addApiParameter("warehouseCode", "123");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("systemType", "oms");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："query goods owner relationship"
     */
    @Override
    public String qimenWarehouseSubscribeGet(AeAppClientDTO acDTO, AeQimenWarehouseSubscribeGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_SUBSCRIBE_GET.getApiName());
        request.addApiParameter("shopId", reqDTO.getShopId());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.create");
        request.addApiParameter("purchase_order_create_request", "{\"store_code\":\"AET001\",\"merchant_code\":\"AEGDCHAIN\",\"eta\":\"1658246400000\",\"delivery_type\":\"1\",\"biz_type\":\"288000\",\"inbound_wave\":\"1\",\"request_no\":\"AET001_1658246400000\",\"remark\":\"\u5907\u6CE8\",\"items\":[{\"quantity\":\"2\",\"sc_item_id\":\"123\"},{\"quantity\":\"2\",\"sc_item_id\":\"123\"}]}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress入库单创建API
     */
    @Override
    public String ascpPoCreate(AeAppClientDTO acDTO, AeAscpPoCreateDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CREATE.getApiName());
        request.addApiParameter("purchase_order_create_request", reqDTO.getPurchase_order_create_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.cancel");
        request.addApiParameter("purchase_order_cancel_request", "{\"merchant_code\":\"AEGDCHAIN\",\"cancel_reason\":\"\u6D4B\u8BD5\",\"biz_type\":\"288000\",\"purchase_order_no\":\"POZ001\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress入库单取消API
     */
    @Override
    public String ascpPoCancel(AeAppClientDTO acDTO, AeAscpPoCancelDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CANCEL.getApiName());
        request.addApiParameter("purchase_order_cancel_request", reqDTO.getPurchase_order_cancel_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.ffo.item.query");
        request.addApiParameter("fulfillment_forward_order_item_query", "{\"biz_type\":\"123\",\"fulfillment_order_no\":\"123\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE履约发货单明细分页查询
     */
    @Override
    public String ascpFfoItemQuery(AeAppClientDTO acDTO, AeAscpFfoItemQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_FFO_ITEM_QUERY.getApiName());
        request.addApiParameter("fulfillment_forward_order_item_query", reqDTO.getFulfillment_forward_order_item_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.ffo.query");
        request.addApiParameter("fulfillment_forward_order_query", "{\"customer_order_number_list\":[\"123\",\"123\"],\"biz_type\":\"123\",\"page_index\":\"1\",\"fulfillment_order_no\":\"123\",\"page_size\":\"20\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE 履约发货单分页查询接口
     */
    @Override
    public String ascpFfoQuery(AeAppClientDTO acDTO, AeAscpFfoQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_FFO_QUERY.getApiName());
        request.addApiParameter("fulfillment_forward_order_query", reqDTO.getFulfillment_forward_order_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.item.bind");
        request.addApiParameter("param0", "{\"item_id\":\"1\",\"channel_seller_id\":\"1\",\"channel\":\"1\",\"sku_id\":\"1\",\"sc_item_id\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：商品绑定货品
     */
    @Override
    public String ascpItemBind(AeAppClientDTO acDTO, AeAscpItemBindDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_ITEM_BIND.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.item.unBind");
        request.addApiParameter("param0", "{\"item_id\":\"1\",\"channel_seller_id\":\"1\",\"channel\":\"1\",\"sku_id\":\"1\",\"sc_item_id\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：商品解绑货品
     */
    @Override
    public String ascpItemUnBind(AeAppClientDTO acDTO, AeAscpItemUnBindDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_ITEM_UNBIND.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.warehouse.inventory.query");
        request.addApiParameter("warehouse_inventory_query_dto", "{\"store_code\":\"AET0001\",\"biz_type\":\"288000\",\"page_index\":\"1\",\"sc_item_id_list\":[\"[1234,345,456]\",\"[1234,345,456]\"],\"inventory_type\":\"1\",\"page_size\":\"20\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress在仓库存查询查询API
     */
    @Override
    public String ascpWarehouseInventoryQuery(AeAppClientDTO acDTO, AeAscpWarehouseInventoryQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_WAREHOUSE_INVENTORY_QUERY.getApiName());
        request.addApiParameter("warehouse_inventory_query_dto", reqDTO.getWarehouse_inventory_query_dto());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
         IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.onway.inventory.query");
        request.addApiParameter("on_way_inventory_query_dto", "{\"outbound_store_code\":\"demo\",\"inbound_store_code\":\"demo\",\"biz_type\":\"123\",\"sc_item_id_list\":[\"demo\",\"demo\"],\"inventory_type\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress在途库存查询API
     */
    @Override
    public String ascpOnwayInventoryQuery(AeAppClientDTO acDTO, AeAscpOnwayInventoryQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_ONWAY_INVENTORY_QUERY.getApiName());
        request.addApiParameter("on_way_inventory_query_dto", reqDTO.getOn_way_inventory_query_dto());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.inventory.log.query");
        request.addApiParameter("warehouse_inventory_log_query_dto", "{\"store_code\":\"demo\",\"gmt_create_start\":\"1630425600000\",\"biz_type\":\"123\",\"page_index\":\"1\",\"biz_activity_type\":\"demo\",\"biz_trade_id\":\"demo\",\"inventory_type\":\"1\",\"operation_order_id\":\"demo\",\"gmt_create_end\":\"1630425600000\",\"page_size\":\"20\",\"sc_item_id\":\"123\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress库存流水查询API
     */
    @Override
    public String ascpInventoryLogQuery(AeAppClientDTO acDTO, AeAscpInventoryLogQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_INVENTORY_LOG_QUERY.getApiName());
        request.addApiParameter("warehouse_inventory_log_query_dto", reqDTO.getWarehouse_inventory_log_query_dto());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.scitem.create");
        request.addApiParameter("scitem_create_request", "{\"item_code\":\"23432\",\"origin_box_package\":\"true\",\"biz_type\":\"288000\",\"length\":\"1\",\"specification\":\"test-\u89C4\u683C\",\"weight\":\"1\",\"customs_unit_price\":\"1.2\",\"title\":\"\u8D27\u54C1\u540D\u79F0\",\"is_hygroscopic\":\"true\",\"gweight\":\"1\",\"whc_bar_code\":\"123\",\"is_danger\":\"true\",\"dangerous_type\":\"air_embargo\",\"feature\":\"{\\\"key\\\":\\\"value\\\"}\",\"width\":\"1\",\"nweight\":\"1\",\"include_battery\":\"1\",\"height\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress货品创建API
     */
    @Override
    public String ascpScitemCreate(AeAppClientDTO acDTO, AeAscpScitemCreateDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_SCITEM_CREATE.getApiName());
        request.addApiParameter("scitem_create_request", reqDTO.getScitem_create_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.item.query");
        request.addApiParameter("sc_item_query", "{\"sc_item_code\":\"123\",\"channel_user_id\":\"1234\",\"biz_type\":\"123\",\"page_index\":\"1\",\"channel\":\"AE_GLOBAL\",\"whc_barcode\":\"123\",\"page_size\":\"20\",\"sc_item_id\":\"123\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE货品查询API
     */
    @Override
    public String ascpItemQuery(AeAppClientDTO acDTO, AeAscpItemQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_ITEM_QUERY.getApiName());
        request.addApiParameter("sc_item_query", reqDTO.getSc_item_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.scitem.update");
        request.addApiParameter("scitem_update_request", "{\"channel_user_id\":\"111\",\"origin_box_package\":\"true\",\"biz_type\":\"288000\",\"length\":\"1\",\"specification\":\"test\u89C4\u683C\",\"weight\":\"1\",\"customs_unit_price\":\"1.2\",\"title\":\"\u6D4B\u8BD5-title\",\"is_hygroscopic\":\"true\",\"is_danger\":\"true\",\"GWeight\":\"1\",\"dangerous_type\":\"air_embargo\",\"feature\":\"{\\\"key\\\":\\\"value\\\"}\",\"width\":\"1\",\"include_battery\":\"1\",\"NWeight\":\"1\",\"sc_item_id\":\"2123423\",\"height\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AliExpress货品编辑API
     */
    @Override
    public String ascpScitemUpdate(AeAppClientDTO acDTO, AeAscpScitemUpdateDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_SCITEM_UPDATE.getApiName());
        request.addApiParameter("scitem_update_request", reqDTO.getScitem_update_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.item.query");
        request.addApiParameter("purchase_order_item_query", "{\"channel_user_id\":\"1234\",\"biz_type\":\"123\",\"page_index\":\"1\",\"purchase_order_no\":\"PON123\",\"page_size\":\"20\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE 供应链仓发 采购单明细查询
     */
    @Override
    public String ascpPoItemQuery(AeAppClientDTO acDTO, AeAscpPoItemQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_ITEM_QUERY.getApiName());
        request.addApiParameter("purchase_order_item_query", reqDTO.getPurchase_order_item_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.query");
        request.addApiParameter("purchase_order_query", "{\"biz_type\":\"100\",\"purchase_order_no\":\"PON123\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE仓发业务采购单查询
     */
    @Override
    public String ascpPoQuery(AeAppClientDTO acDTO, AeAscpPoQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_QUERY.getApiName());
        request.addApiParameter("purchase_order_query", reqDTO.getPurchase_order_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.fro.item.query");
        request.addApiParameter("fulfillment_reverse_order_item_query", "{\"biz_type\":\"123\",\"fulfillment_order_no\":\"123\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE履约销退单明细查询API
     */
    @Override
    public String ascpFroItemQuery(AeAppClientDTO acDTO, AeAscpFroItemQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_FRO_ITEM_QUERY.getApiName());
        request.addApiParameter("fulfillment_reverse_order_item_query", reqDTO.getFulfillment_reverse_order_item_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.fro.query");
        request.addApiParameter("fulfillment_reverse_order_query", "{\"customer_order_number_list\":[\"123\",\"123\"],\"biz_type\":\"123\",\"page_index\":\"1\",\"fulfillment_order_no\":\"123\",\"page_size\":\"20\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE履约销退单查询接口
     */
    @Override
    public String ascpFroQuery(AeAppClientDTO acDTO, AeAscpFroQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_FRO_QUERY.getApiName());
        request.addApiParameter("fulfillment_reverse_order_query", reqDTO.getFulfillment_reverse_order_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.ro.item.query");
        request.addApiParameter("return_order_item_query", "{\"return_order_no\":\"Ro123\",\"biz_type\":\"123\",\"page_index\":\"1\",\"page_size\":\"20\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE仓发 单个退供单明细查询
     */
    @Override
    public String ascpRoItemQuery(AeAppClientDTO acDTO, AeAscpRoItemQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_RO_ITEM_QUERY.getApiName());
        request.addApiParameter("return_order_item_query", reqDTO.getReturn_order_item_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.ro.query");
        request.addApiParameter("return_order_query", "{\"return_order_no\":\"Ro123\",\"biz_type\":\"123\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：AE仓发商家单个退供单查询接口
     */
    @Override
    public String ascpRoQuery(AeAppClientDTO acDTO, AeAscpRoQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_RO_QUERY.getApiName());
        request.addApiParameter("return_order_query", reqDTO.getReturn_order_query());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/aliexpress/warehouse/owner/create/post");
        request.addApiParameter("systemType", "wms");
        request.addApiParameter("warehouseCustomerId", "qian_xiang_box");
        request.addApiParameter("goodsOwnerId", "123");
        request.addApiParameter("shopName", "shop123");
        request.addApiParameter("method", "sign");
        request.addApiParameter("requestTime", "12312412412");
        request.addApiParameter("requestId", "fghwei23");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：create or deactivate owner to isv
     */
    @Override
    public String warehouseOwnerCreatePost(AeAppClientDTO acDTO, AeWarehouseOwnerCreatePostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.WAREHOUSE_OWNER_CREATE_POST.getApiName());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("shopName", reqDTO.getShopName());
        request.addApiParameter("method", reqDTO.getMethod());
        request.addApiParameter("requestTime", reqDTO.getRequestTime());
        request.addApiParameter("requestId", reqDTO.getRequestId());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/fo/create/async/post");
        request.addApiParameter("cpf", "1");
        request.addApiParameter("goodsOwnerId", "1");
        request.addApiParameter("aeTradeOrderId", "1");
        request.addApiParameter("outBizId", "1");
        request.addApiParameter("country", "1");
        request.addApiParameter("city", "1");
        request.addApiParameter("address2", "1");
        request.addApiParameter("address1", "1");
        request.addApiParameter("shippingMethod", "1");
        request.addApiParameter("warehouseCustomerId", "1");
        request.addApiParameter("warehouseCode", "1");
        request.addApiParameter("zipcode", "1");
        request.addApiParameter("province", "1");
        request.addApiParameter("phone", "1");
        request.addApiParameter("systemType", "1");
        request.addApiParameter("name", "1");
        request.addApiParameter("items", "1");
        request.addApiParameter("shopName", "1");
        request.addApiParameter("addressAddition", "123");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述："create fulfillment order async"
     */
    @Override
    public String qimenWarehouseFoCreateAsyncPost(AeAppClientDTO acDTO, AeQimenWarehouseFoCreateAsyncPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_FO_CREATE_ASYNC_POST.getApiName());
        request.addApiParameter("cpf", reqDTO.getCpf());
        request.addApiParameter("goodsOwnerId", reqDTO.getGoodsOwnerId());
        request.addApiParameter("aeTradeOrderId", reqDTO.getAeTradeOrderId());
        request.addApiParameter("outBizId", reqDTO.getOutBizId());
        request.addApiParameter("country", reqDTO.getCountry());
        request.addApiParameter("city", reqDTO.getCity());
        request.addApiParameter("address2", reqDTO.getAddress2());
        request.addApiParameter("address1", reqDTO.getAddress1());
        request.addApiParameter("shippingMethod", reqDTO.getShippingMethod());
        request.addApiParameter("warehouseCustomerId", reqDTO.getWarehouseCustomerId());
        request.addApiParameter("warehouseCode", reqDTO.getWarehouseCode());
        request.addApiParameter("zipcode", reqDTO.getZipcode());
        request.addApiParameter("province", reqDTO.getProvince());
        request.addApiParameter("phone", reqDTO.getPhone());
        request.addApiParameter("systemType", reqDTO.getSystemType());
        request.addApiParameter("name", reqDTO.getName());
        request.addApiParameter("items", reqDTO.getItems());
        request.addApiParameter("shopName", reqDTO.getShopName());
        request.addApiParameter("addressAddition", reqDTO.getAddressAddition());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("/qimen/aliexpress/warehouse/test/post");
        request.addApiParameter("test", "ping");
        IopResponse response = client.execute(request, Protocol.GOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：test reverse api
     */
    @Override
    public String qimenWarehouseTestPost(AeAppClientDTO acDTO, AeQimenWarehouseTestPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.QIMEN_WAREHOUSE_TEST_POST.getApiName());
        request.addApiParameter("test", reqDTO.getTest());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.updateSelfdelivery");
        request.addApiParameter("param0", "{\"return_type\":\"0\",\"appointment_license_plate\":\"\\\"\u6D59123\\\"\",\"purchase_order_no_list\":[\"[\\\"PON1234\\\",\\\"PON2345\\\"]\",\"[\\\"PON1234\\\",\\\"PON2345\\\"]\"],\"channel_user_id\":\"1234\",\"logistics_service_provider\":\"\\\"\u987A\u4E30\\\"\",\"biz_type\":\"5110000\",\"return_contact_info_dto\":{\"area\":\"-\",\"address\":\"-\",\"phone\":\"-\",\"name\":\"-\",\"address_context\":\"{\\\"provCode\\\":\\\"110000\\\",\\\"areaCode\\\":\\\"110102\\\",\\\"cityCode\\\":\\\"110100\\\",\\\"prov\\\":\\\"\u5317\u4EAC\\\",\\\"city\\\":\\\"\u5317\u4EAC\u5E02\\\",\\\"area\\\":\\\"\u897F\u57CE\u533A\\\",\\\"addressDetail\\\":\\\"\u8BE6\u7EC6\u7684\u5730\u5740\\\"}\",\"area_id\":\"-\"},\"estimate_goods_volume\":\"\\\"1\\\"\",\"appointment_phone_number\":\"17612341234\",\"logistics_mark\":\"\\\"\u5907\u6CE8\\\"\",\"self_delivery_scene_code\":\"\\\"JIT\\\"\",\"appointment_express_no_list\":[\"[\\\"sf123\\\",\\\"sf124\\\"]\",\"[\\\"sf123\\\",\\\"sf124\\\"]\"],\"self_delivery_no\":\"\\\"ZJ12345\\\"\",\"delivery_type\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：修改自寄（送）单信息
     */
    @Override
    public String ascpPoUpdateSelfdelivery(AeAppClientDTO acDTO, AeAscpPoUpdateSelfdeliveryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_UPDATE_SELFDELIVERY.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.createPickupOrder");
        request.addApiParameter("param0", "{\"return_type\":\"0\",\"estimated_volume\":\"1.1\",\"order_no_list\":[\"PON123\",\"PON123\"],\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"return_contact_info_dto\":{\"area\":\"-\",\"address\":\"-\",\"phone\":\"-\",\"name\":\"-\",\"address_context\":\"{\\\"provCode\\\":\\\"110000\\\",\\\"areaCode\\\":\\\"110102\\\",\\\"cityCode\\\":\\\"110100\\\",\\\"prov\\\":\\\"\u5317\u4EAC\\\",\\\"city\\\":\\\"\u5317\u4EAC\u5E02\\\",\\\"area\\\":\\\"\u897F\u57CE\u533A\\\",\\\"addressDetail\\\":\\\"\u8BE6\u7EC6\u7684\u5730\u5740\\\"}\",\"area_id\":\"-\"},\"contact_info_dto\":{\"area\":\"-\",\"address\":\"-\",\"phone\":\"-\",\"name\":\"-\",\"address_context\":\"{\\\"provCode\\\":\\\"110000\\\",\\\"areaCode\\\":\\\"110102\\\",\\\"cityCode\\\":\\\"110100\\\",\\\"prov\\\":\\\"\u5317\u4EAC\\\",\\\"city\\\":\\\"\u5317\u4EAC\u5E02\\\",\\\"area\\\":\\\"\u897F\u57CE\u533A\\\",\\\"addressDetail\\\":\\\"\u8BE6\u7EC6\u7684\u5730\u5740\\\"}\\u0000\",\"area_id\":\"-\"},\"estimated_fee\":\"4.24\",\"car_type\":\"2\",\"estimated_pickup_date\":\"2022-02-17\",\"shipping_method\":\"1\",\"estimated_weight\":\"1.1\",\"estimated_box_number\":\"5\",\"goods_type\":\"1\",\"order_type\":\"1\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：创建揽收单
     */
    @Override
    public String ascpPoCreatePickupOrder(AeAppClientDTO acDTO, AeAscpPoCreatePickupOrderDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CREATE_PICKUP_ORDER.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.cancelPickupOrder");
        request.addApiParameter("param0", "{\"cancel_reason\":\"\u8BA2\u5355\u9519\u8BEF\",\"system_operate\":\"true\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"pickup_order_number\":\"GF1234567\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：取消揽收单
     */
    @Override
    public String ascpPoCancelPickupOrder(AeAppClientDTO acDTO, AeAscpPoCancelPickupOrderDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CANCEL_PICKUP_ORDER.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.cancelSelfDelivery");
        request.addApiParameter("param0", "{\"cancel_reason\":\"\u4FE1\u606F\u586B\u5199\u9519\u8BEF\",\"self_delivery_no\":\"ZJ123456\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：取消自送单
     */
    @Override
    public String ascpPoCancelSelfDelivery(AeAppClientDTO acDTO, AeAscpPoCancelSelfDeliveryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CANCEL_SELF_DELIVERY.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ecowarehouse.inventory.change.get");
        request.addApiParameter("inventory_change_notify_request", "{\"quantity\":\"123\",\"warehouse_customer_id\":\"123\",\"idempotent_id\":\"123\",\"ae_trade_order_id\":\"123\",\"owner_id\":\"123\",\"warehouse_code\":\"123\",\"out_biz_id\":\"123\",\"sku_id\":\"123\",\"type\":\"123\"}");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：库存变更获取
     */
    @Override
    public String ecowarehouseInventoryChangeGet(AeAppClientDTO acDTO, AeEcowarehouseInventoryChangeGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ECOWAREHOUSE_INVENTORY_CHANGE_GET.getApiName());
        request.addApiParameter("inventory_change_notify_request", reqDTO.getInventory_change_notify_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ecowarehouse.inventory.notify.get");
        request.addApiParameter("inventory_notify_request", "{\"sku_inventory_list\":[{\"warehouse_code_inventory\":[{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"},{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"}],\"owner_id\":\"tesr\",\"sku_id\":\"12345\"},{\"warehouse_code_inventory\":[{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"},{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"}],\"owner_id\":\"tesr\",\"sku_id\":\"12345\"}],\"warehouse_customer_id\":\"tesr\",\"type\":\"tesr\"}");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：库存售罄 & 恢复 & 预警同步
     */
    @Override
    public String ecowarehouseInventoryNotifyGet(AeAppClientDTO acDTO, AeEcowarehouseInventoryNotifyGetDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ECOWAREHOUSE_INVENTORY_NOTIFY_GET.getApiName());
        request.addApiParameter("inventory_notify_request", reqDTO.getInventory_notify_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.createPickupShippingMarkPdf");
        request.addApiParameter("param0", "{\"size\":\"100_100\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"pickup_order_number\":\"-\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：打印揽收面单
     */
    @Override
    public String ascpPoCreatePickupShippingMarkPdf(AeAppClientDTO acDTO, AeAscpPoCreatePickupShippingMarkPdfDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CREATE_PICKUP_SHIPPING_MARK_PDF.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.query.createShippingMarkPdf");
        request.addApiParameter("param0", "{\"box_number\":\"1\",\"print_barcode\":\"true\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"purchase_order_no\":\"POxxx\",\"pdf_size\":\"SIZE_100_150\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：打印箱唛
     */
    @Override
    public String ascpPoQueryCreateShippingMarkPdf(AeAppClientDTO acDTO, AeAscpPoQueryCreateShippingMarkPdfDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_QUERY_CREATE_SHIPPING_MARK_PDF.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.printSelfDeliveryMarkPdf");
        request.setHttpMethod("GET");
        request.addApiParameter("param0", "{\"self_delivery_no\":\"\\\"ZJ123456\\\"\",\"channel_user_id\":\"1234\",\"print_size\":\"\\\"100_100\\\"\",\"total_box_cnt\":\"1\",\"biz_type\":\"5110000\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：打印自送面单
     */
    @Override
    public String ascpPoPrintSelfDeliveryMarkPdf(AeAppClientDTO acDTO, AeAscpPoPrintSelfDeliveryMarkPdfDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_PRINT_SELF_DELIVERY_MARK_PDF.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.createScItemBarcodePdf");
        request.addApiParameter("param0", "{\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"purchase_order_no\":\"poxxx\",\"pdf_size\":\"SIZE_60_30\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
    */

    /**
     * 描述：打印货品标签
     */
    @Override
    public String ascpPoCreateScItemBarcodePdf(AeAppClientDTO acDTO, AeAscpPoCreateScItemBarcodePdfDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CREATE_SC_ITEM_BARCODE_PDF.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.selfdelivery");
        request.addApiParameter("param0", "{\"return_type\":\"0\",\"appointment_license_plate\":\"\\\"\u6D59A6666\\\"\",\"purchase_order_no_list\":[\"[\\\"PON123456789\\\",\\\"PON223456789\\\"]\",\"[\\\"PON123456789\\\",\\\"PON223456789\\\"]\"],\"logistics_service_provider\":\"\\\"\u987A\u4E30\\\"\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"return_contact_info_dto\":{\"area\":\"-\",\"address\":\"-\",\"phone\":\"-\",\"name\":\"-\",\"address_context\":\"{\\\"provCode\\\":\\\"110000\\\",\\\"areaCode\\\":\\\"110102\\\",\\\"cityCode\\\":\\\"110100\\\",\\\"prov\\\":\\\"\u5317\u4EAC\\\",\\\"city\\\":\\\"\u5317\u4EAC\u5E02\\\",\\\"area\\\":\\\"\u897F\u57CE\u533A\\\",\\\"addressDetail\\\":\\\"\u8BE6\u7EC6\u7684\u5730\u5740\\\"}\",\"area_id\":\"-\"},\"estimate_goods_volume\":\"1\",\"appointment_phone_number\":\"\\\"17112341234\\\"\",\"logistics_mark\":\"\\\"\u8FD9\u662F\u5907\u6CE8\\\"\",\"appointment_express_no_list\":[\"\\\"SF123456\\\"\",\"\\\"SF123456\\\"\"],\"self_delivery_scene_code\":\"\\\"JIT\\\"\",\"delivery_type\":\"\u9001\u4ED3\u65B9\u5F0F\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：批量填写自行发货信息生成自送面单
     */
    @Override
    public String ascpPoSelfDelivery(AeAppClientDTO acDTO, AeAscpPoSelfDeliveryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_SELF_DELIVERY.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.aidc.pickup.costEstimate");
        request.addApiParameter("param0", "{\"estimated_volume\":\"0.01\",\"channel_user_id\":\"123\",\"biz_type\":\"5110000\",\"estimated_weight\":\"0.01\",\"city_code\":\"330300\",\"estimated_box_number\":\"1\",\"estimated_pickup_time\":\"2024-04-10\",\"order_type\":\"1\",\"related_order_number_list\":[\"[\\\"PO123876534\\\"]\",\"[\\\"PO123876534\\\"]\"]}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：揽收单预估费用
     */
    @Override
    public String aidcPickupCostEstimate(AeAppClientDTO acDTO, AeAidcPickupCostEstimateDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.AIDC_PICKUP_COST_ESTIMATE.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.ascp.po.querysSelfdelivery");
request.addApiParameter("param0", "{\"self_delivery_no\":\"\\\"ZJ123456\\\"\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 描述：查看自寄（送）单
     */
    @Override
    public String ascpPoQuerysSelfdelivery(AeAppClientDTO acDTO, AeAscpPoQuerysSelfdeliveryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_QUERYS_SELFDELIVERY.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.queryPickupOrder");
        request.addApiParameter("param0", "{\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"pickup_order_number\":\"GF002301310098\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：查询揽收单
     */
    @Override
    public String ascpPoQueryPickupOrder(AeAppClientDTO acDTO, AeAscpPoQueryPickupOrderDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_QUERY_PICKUP_ORDER.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ecowarehouse.reverse.order.upload");
        request.addFileParameter("file_stream",new FileItem("/Users/D ocuments/book.jpg"));
        request.addApiParameter("warehouse_customer_id", "123123123123");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */

    /**
     * 描述：生态仓对账上传csv文件
     */
    @Override
    public String ecowarehouseReverseOrderUpload(AeAppClientDTO acDTO, AeEcowarehouseReverseOrderUploadDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ECOWAREHOUSE_REVERSE_ORDER_UPLOAD.getApiName());
        request.addFileParameter("file_stream", new FileItem(reqDTO.getFile_name(), reqDTO.getFile_stream()));
        request.addApiParameter("warehouse_customer_id", reqDTO.getWarehouse_customer_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ecowarehouse.order.status.post");
        request.addApiParameter("send_wms_fulfill_callback_request", "{\"warehouse_customer_id\":\"DES\",\"ae_trade_order_id\":\"8145069480275002  \\t\",\"warehouse_code\":\"CUSTOM001\",\"wms_order_id\":\"order_id_test_123456\",\"owner_id\":\"111\",\"out_biz_id\":\"B2CSHIP_610000248001_2578625002\",\"reject_reason\":\"\u5BA2\u6237\u8D39\u7528\u4E0D\u591F\",\"package_list\":[{\"package_width\":\"100\",\"package_height\":\"100\",\"order_mail_no\":\"mail_no_test_123456\",\"shipping_method\":\"EUROPAK\",\"logistics_company_en\":\"DHL\",\"package_length\":\"100\",\"logistics_company_cn\":\"DHL\",\"package_weight\":\"100\",\"package_sku_list\":[{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"},{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"}]},{\"package_width\":\"100\",\"package_height\":\"100\",\"order_mail_no\":\"mail_no_test_123456\",\"shipping_method\":\"EUROPAK\",\"logistics_company_en\":\"DHL\",\"package_length\":\"100\",\"logistics_company_cn\":\"DHL\",\"package_weight\":\"100\",\"package_sku_list\":[{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"},{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"}]}],\"order_status_name\":\"teststatus\",\"order_create_time\":\"1643007221142\",\"order_outbound_time\":\"1643007221142\",\"event_code\":\"WAREHOUSE_ORDER_OUTBOUND\",\"order_status_code\":\"teststatus\",\"error_code\":\"111\",\"order_update_time\":\"1643007221142\",\"event_time\":\"1643007221142\"}");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：生态仓物流订单状态通知
     */
    @Override
    public String ecowarehouseOrderStatusPost(AeAppClientDTO acDTO, AeEcowarehouseOrderStatusPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ECOWAREHOUSE_ORDER_STATUS_POST.getApiName());
        request.addApiParameter("send_wms_fulfill_callback_request", reqDTO.getSend_wms_fulfill_callback_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ecowarehouse.reverse.order.status.post");
        request.addApiParameter("send_reverse_callback_request", "{\"warehouse_customer_id\":\"4px\",\"ae_trade_order_id\":\"123124124214\",\"wms_order_id\":\"wms_order_id\",\"warehouse_code\":\"warehouse_code\",\"out_biz_id\":\"WH123124124\",\"reject_reason\":\"rejectReason\",\"logistic_param\":{\"tracking_no\":\"123123\",\"collect_type\":\"ONLINE_WAYBILL\",\"shipping_method\":\"shipping_method\",\"consign_type\":\"consign_type\",\"bill_info_url\":\"123123\",\"qr_code\":\"123123\",\"logistics_company_name\":\"123123\",\"qr_code_url\":\"123123\"},\"order_status_name\":\"order_status_name\",\"order_create_time\":\"124124124\",\"event_code\":\"event_code\",\"item_list\":[{\"ae_sku_id\":\"42352345\",\"operate_info_list\":[{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"},{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"}],\"sku_id\":\"42352345\",\"operate_result\":\"operate_result\",\"extend_filed\":{}},{\"ae_sku_id\":\"42352345\",\"operate_info_list\":[{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"},{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"}],\"sku_id\":\"42352345\",\"operate_result\":\"operate_result\",\"extend_filed\":{}}],\"order_status_code\":\"order_status_code\",\"error_code\":\"error_code\",\"order_update_time\":\"124124214\",\"pic_for_whole_pkg\":\"true\",\"goods_owner_id\":\"ownerId\",\"event_time\":\"12312313\"}");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 生态仓逆向物流订单状态通知 描述：Reverse order status call back
     */
    @Override
    public String ecowarehouseReverseOrderStatusPost(AeAppClientDTO acDTO, AeEcowarehouseReverseOrderStatusPostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ECOWAREHOUSE_REVERSE_ORDER_STATUS_POST.getApiName());
        request.addApiParameter("send_reverse_callback_request", reqDTO.getSend_reverse_callback_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.item.detail");
        request.setHttpMethod("GET");
        request.addApiParameter("param0", "{\"channel_seller_id\":\"\u6E20\u9053seller id \uFF08\u53EF\u4EE5\u5728\u8FD9\u4E2AAPI\u4E2D\u67E5\u8BE2\uFF1Aglobal.seller.relation.query\uFF09\uFF0C \u8BF7\u4F7F\u7528 business_type \\u003d ONE_STOP_SERVICE \u7684\u5168\u6258\u7BA1\u5E97\u94FA channel_seller_id\",\"channel\":\"\u6E20\u9053\uFF08\u53EF\u4EE5\u5728\u8FD9\u4E2AAPI\u4E2D\u67E5\u8BE2\uFF1Aglobal.seller.relation.query\uFF09\",\"sc_item_id\":\"sc_item_id\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：货品详情查询
     */
    @Override
    public String ascpItemDetail(AeAppClientDTO acDTO, AeAscpItemDetailDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_ITEM_DETAIL.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ecowarehouse.reverse.order.fee.post");
        request.addApiParameter("reverse_fee_detail_callback_request", "{\"warehouse_customer_id\":\"4px\",\"time_stamp\":\"123123\",\"wms_order_id\":\"123123\",\"warehouse_code\":\"warehouse_code\",\"fee_details\":[{\"quantity\":\"1\",\"total_amount\":\"555\",\"expense_code\":\"SHIPPPING\",\"currency\":\"USD\",\"unit_price\":\"555\"},{\"quantity\":\"1\",\"total_amount\":\"555\",\"expense_code\":\"SHIPPPING\",\"currency\":\"USD\",\"unit_price\":\"555\"}],\"tracking_number\":\"123123\",\"out_biz_id\":\"WH123123\",\"goods_owner_id\":\"123123\",\"package_info\":{\"length\":\"1\",\"width\":\"2\",\"weight\":\"422\",\"height\":\"3\"}}");
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 逆向单据费用回传 描述：Reverse order fee callback
     */
    @Override
    public String ecowarehouseReverseOrderFeePost(AeAppClientDTO acDTO, AeEcowarehouseReverseOrderFeePostDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ECOWAREHOUSE_REVERSE_ORDER_FEE_POST.getApiName());
        request.addApiParameter("reverse_fee_detail_callback_request", reqDTO.getReverse_fee_detail_callback_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.pageQuery");
        request.addApiParameter("param0", "{\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"page_index\":\"1\",\"create_time_begin\":\"\u7565\",\"trade_order_id\":\"8172481060036440\",\"data_range\":\"1\",\"purchase_order_no\":\"PO123\",\"order_type\":\"10\",\"create_time_end\":\"\u7565\",\"page_size\":\"10\",\"status\":\"10\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：采购单分页查询
     */
    @Override
    public String ascpPoPageQuery(AeAppClientDTO acDTO, AeAscpPoPageQueryDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_PAGE_QUERY.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    /*
        IopClient client = new IopClient(url, appkey, appSecret);
        IopRequest request = new IopRequest();
        request.setApiName("aliexpress.ascp.po.confirmPurchaseOrder");
        request.addApiParameter("param0", "{\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"purchase_order_no\":\"PON123\",\"all_quantity_confirm\":\"true\"}");
        IopResponse response = client.execute(request, accessToken, Protocol.TOP);
        System.out.println(response.getBody());
        Thread.sleep(10);
     */
    /**
     * 描述：采购单确认
     */
    @Override
    public String ascpPoConfirmPurchaseOrder(AeAppClientDTO acDTO, AeAscpPoConfirmPurchaseOrderDTO reqDTO) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CONFIRM_PURCHASE_ORDER.getApiName());
        request.addApiParameter("param0", reqDTO.getParam0());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpPoErpPageQuery(AeAppClientDTO acDTO, AeAscpPoErpPageQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_PO_ERP_PAGE_QUERY.getApiName());
        //    channel_user_id	Number	是
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    page_index	Number	否
        request.addApiParameter("page_index", reqDto.getPage_index().toString());
        //    page_size	Number	否
        request.addApiParameter("page_size", reqDto.getPage_size().toString());
        //    gmt_create_begin	String	否
        request.addApiParameter("gmt_create_begin", reqDto.getGmt_create_begin());
        //    gmt_create_end	String	否
        request.addApiParameter("gmt_create_end", reqDto.getGmt_create_end());
        //    purchase_order_no_list	String[]	否
        if (ObjectUtil.isNotEmpty(reqDto.getPurchase_order_no_list())) {
            request.addApiParameter("purchase_order_no_list", Arrays.toString(reqDto.getPurchase_order_no_list().toArray(new String[0])));
        }
        //    biz_status	String	否
        request.addApiParameter("biz_status", reqDto.getBiz_status());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpPoErpPageQueryItem(AeAppClientDTO acDTO, AeAscpPoErpPageQueryItemDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_PO_ERP_PAGE_QUERY_ITEM.getApiName());

        //    channel_user_id	Number	是
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    page_index	Number	否
        request.addApiParameter("page_index", reqDto.getPage_index().toString());
        //    page_size	Number	否
        request.addApiParameter("page_size", reqDto.getPage_size().toString());
        //    purchase_order_no	String	是
        request.addApiParameter("purchase_order_no", reqDto.getPurchase_order_no());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpPoErpConfirm(AeAppClientDTO acDTO, AeAscpPoErpConfirmDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_PO_ERP_CONFIRM.getApiName());
        //    channel_user_id	Number	是
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    purchase_order_no	String	是
        request.addApiParameter("purchase_order_no", reqDto.getPurchase_order_no());
        //    gmt_pre_delivery	String	否
        request.addApiParameter("gmt_pre_delivery", reqDto.getGmt_pre_delivery());
        //    all_quantity_confirm	Boolean	是
        request.addApiParameter("all_quantity_confirm", reqDto.getAll_quantity_confirm().toString());
        //    reason	String	否
        request.addApiParameter("reason", reqDto.getReason());
        //   demo
        if (ObjectUtil.isNotEmpty(reqDto.getPurchase_confirm_item_list())) {
            request.addApiParameter("purchase_confirm_item_list", JSONObject.toJSONString(reqDto.getPurchase_confirm_item_list()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpCoErpCreate(AeAppClientDTO acDTO, AeAscpCoErpCreateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_CO_ERP_CREATE.getApiName());
        //    channel_user_id	Number	是	渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是	经营组织 {全托管:AECHOICE}
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    order_source_code	String	是	用于幂等。 商家操作发货一次，{order_source_code} 应该唯一。 例：ERP第一次调用接口，入参本批次发货50件。第二次再次调用接口，入参发货50件。根据该字段判断第二次调用是超时重复调用，还是商家又操作发货50件(总计2个发货单，总发货100件)。
        request.addApiParameter("order_source_code", reqDto.getOrder_source_code());
        //    purchase_order_list	Object[]	是	本次发货PO单。最大1单。(本接口为单个创建CO单接口，创建之后CO单据状态为「待发货」。本接口调用1次，会为指定PO单创建1个CO单。需要创建多个CO单请调用多次)
        if (ObjectUtil.isNotEmpty(reqDto.getPurchase_order_list())) {
//            String string = Arrays.toString(reqDto.getPurchase_order_list().toArray(new String[0]));
            request.addApiParameter("purchase_order_list", JSONObject.toJSONString(reqDto.getPurchase_order_list()));
        }
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpCoErpCancel(AeAppClientDTO acDTO, AeAscpPoErpCancelDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_CO_ERP_CANCEL.getApiName());
        //    channel_user_id	Number	是
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    consign_order_no	String	是
        request.addApiParameter("consign_order_no", reqDto.getConsign_order_no());
        //    cancel_reason	String	否
        request.addApiParameter("cancel_reason", reqDto.getCancel_reason());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpCoErpPageQuery(AeAppClientDTO acDTO, AeAscpCoErpPageQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_CO_ERP_PAGE_QUERY.getApiName());
        //    channel_user_id	Number	是
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    consign_order_no_list	String[]	否
        if (ObjectUtil.isNotEmpty(reqDto.getConsign_order_no_list())) {
            request.addApiParameter("consign_order_no_list", Arrays.toString(reqDto.getConsign_order_no_list().toArray(new String[0])));
        }
        //    purchase_order_no	String	否
        request.addApiParameter("purchase_order_no", reqDto.getPurchase_order_no());
        //    logistics_no_list	String[]	否
        if (ObjectUtil.isNotEmpty(reqDto.getLogistics_no_list())) {
            request.addApiParameter("logistics_no_list", Arrays.toString(reqDto.getLogistics_no_list().toArray(new String[0])));
        }
        //    pickup_no_list	String[]	否
        if (ObjectUtil.isNotEmpty(reqDto.getPickup_no_list())) {
            request.addApiParameter("pickup_no_list", Arrays.toString(reqDto.getPickup_no_list().toArray(new String[0])));
        }
        //    gmt_create_begin	String	否
        request.addApiParameter("gmt_create_begin", reqDto.getGmt_create_begin());
        //    gmt_create_end	String	否
        request.addApiParameter("gmt_create_end", reqDto.getGmt_create_end());
        //    page_index	Number	否
        request.addApiParameter("page_index", reqDto.getPage_index().toString());
        //    page_size	Number	否
        request.addApiParameter("page_size", reqDto.getPage_size().toString());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpCoErpPageQueryItem(AeAppClientDTO acDTO, AeAscpCoErpPageQueryItemDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ALIEXPRESS_ASCP_CO_ERP_PAGE_QUERY_ITEM.getApiName());
        //    channel_user_id	Number	是
        request.addApiParameter("channel_user_id", reqDto.getChannel_user_id().toString());
        //    merchant_code	String	是
        request.addApiParameter("merchant_code", reqDto.getMerchant_code());
        //    page_index	Number	否
        request.addApiParameter("page_index", reqDto.getPage_index().toString());
        //    page_size	Number	否
        request.addApiParameter("page_size", reqDto.getPage_size().toString());
        //    consign_order_no	String	是
        request.addApiParameter("consign_order_no", reqDto.getConsign_order_no());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    @Override
    public String ascpPickupQueryPickupAvailableDate(AeAppClientDTO acDTO, AeAscpQueryPickupAvailableDateDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressScpEnu.ASCP_PO_CONFIRM_PURCHASE_ORDER.getApiName());
        request.addApiParameter("param0", JSONUtil.toJsonStr(reqDto));
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
