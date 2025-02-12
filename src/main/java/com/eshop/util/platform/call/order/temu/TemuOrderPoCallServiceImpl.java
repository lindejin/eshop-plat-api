package com.eshop.util.platform.call.order.temu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.call.order.temu.dto.*;
import com.eshop.util.platform.call.order.temu.vo.*;
import com.eshop.util.platform.api.service.order.temu.TemuOrderPoCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemuOrderPoCallServiceImpl implements TemuOrderPoCallService {

    @Autowired
    private TemuOrderPoCall temuOrderPoCall;

    @Override
    public TemuOrderPoListRespVO getOrderList(TemuAppClientDTO tcDTO, TemuOrderPoListReqDTO orderListReqDTO) throws Exception {
        JSONObject jsonParams = getOrderListJsonObject(orderListReqDTO);
        String orderListBody = temuOrderPoCall.getOrderList(tcDTO, jsonParams);
        TemuOrderPoListRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoListRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoListRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    /**
     * 获取订单列表查询参数
     */
    private JSONObject getOrderListJsonObject(TemuOrderPoListReqDTO orderListReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //pageNumber	INTEGER	否	分页号，默认1，最大100
        jsonParams.put("pageNumber", orderListReqDTO.getPageNumber());
        //pageSize	INTEGER	否	分页大小，默认10，最大100
        jsonParams.put("pageSize", orderListReqDTO.getPageSize());
        //parentOrderStatus	INTEGER	否	父单状态，默认查全部枚举值如下
        jsonParams.put("parentOrderStatus", orderListReqDTO.getParentOrderStatus());
        //createAfter	INTEGER	否	父单创建时间开始查询时间，格式是秒时间戳
        jsonParams.put("createAfter", orderListReqDTO.getCreateAfter());
        //createBefore	INTEGER	否	父单创建时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
        jsonParams.put("createBefore", orderListReqDTO.getCreateBefore());
        //parentOrderSnList	LIST	否	父单号列表，单次请求最多20个
        jsonParams.put("parentOrderSnList", orderListReqDTO.getParentOrderSnList());
        //expectShipLatestTimeStart	INTEGER	否	期望最晚发货时间开始查询时间，格式是秒时间戳
        jsonParams.put("expectShipLatestTimeStart", orderListReqDTO.getExpectShipLatestTimeStart());
        //expectShipLatestTimeEnd	INTEGER	否	期望最晚发货时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
        jsonParams.put("expectShipLatestTimeEnd", orderListReqDTO.getExpectShipLatestTimeEnd());
        //updateAtStart	INTEGER	否	订单更新时间开始查询时间，格式是秒时间戳
        jsonParams.put("updateAtStart", orderListReqDTO.getUpdateAtStart());
        //updateAtEnd	INTEGER	否	订单更新时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
        jsonParams.put("updateAtEnd", orderListReqDTO.getUpdateAtEnd());
        //regionId update 	INTEGER	否	区域ID，美国-211
        jsonParams.put("regionId", orderListReqDTO.getRegionId());
        //fulfillmentTypeList 	STRING[]	否	子订单履约类型，具体枚举值如下：
        jsonParams.put("fulfillmentTypeList", orderListReqDTO.getFulfillmentTypeList());
        return jsonParams;
    }

    @Override
    public TemuOrderPoDetailRespVO getOrderDetail(TemuAppClientDTO tcDTO, TemuOrderPoDetailReqDTO orderDetailReqDTO) throws Exception {
        JSONObject jsonParams = getOrderDetailJsonObject(orderDetailReqDTO);
        String orderListBody = temuOrderPoCall.getOrderDetail(tcDTO, jsonParams);
        TemuOrderPoDetailRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoDetailRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoDetailRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    /**
     * 订单详情参数
     */
    private JSONObject getOrderDetailJsonObject(TemuOrderPoDetailReqDTO orderDetailReqDTO) {
        //parentOrderSn	INTEGER	是	父单号

        //fulfillmentTypeList  	STRING[]	否	子订单履约类型
        //支持枚举值：fulfillBySeller/fulfillByCooperativeWarehouse
        //1. 数组只传入fulfillBySeller，只返回卖家履约子订单列表
        //2. 数组只传入fulfillByCooperativeWarehouse，只返回合作仓履约子订单列表
        //3. 数组传入fulfillBySeller和fulfillByCooperativeWarehouse，返回卖家履约子订单列表+合作仓履约子订单列表
        //4. fulfillmentTypeList不传或者传了为空，默认返回卖家履约子订单列表

        JSONObject jsonParams = new JSONObject();
        jsonParams.put("parentOrderSn", orderDetailReqDTO.getParentOrderSn());
        if (CollectionUtils.isNotEmpty(orderDetailReqDTO.getFulfillmentTypeList())) {
            String json = JSON.toJSONString(orderDetailReqDTO.getFulfillmentTypeList());
            jsonParams.put("fulfillmentTypeList", json);

        }
        return jsonParams;
    }

    @Override
    public TemuOrderPoCombinedShipmentListRespVO getCombinedShipmentList(TemuAppClientDTO tcDTO, TemuOrderPoCombinedShipmentListReqDTO combinedShipmentListReqDTO) throws Exception {
        JSONObject jsonParams = getCombinedShipmentListJsonObject(combinedShipmentListReqDTO);
        String orderListBody = temuOrderPoCall.getCombinedShipmentList(tcDTO, jsonParams);
        TemuOrderPoCombinedShipmentListRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoCombinedShipmentListRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoCombinedShipmentListRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    /**
     * 可合并发货订单列表查询参数
     */
    private JSONObject getCombinedShipmentListJsonObject(TemuOrderPoCombinedShipmentListReqDTO combinedShipmentListReqDTO) {
        TemuOrderPoCombinedShipmentListGatewayContext gatewayContext = combinedShipmentListReqDTO.getGatewayContext();
        JSONObject jsonParams = new JSONObject();
        if (gatewayContext != null) {
            String gatewayContextJson = JSON.toJSONString(gatewayContext);
            jsonParams.put("gatewayContext", gatewayContextJson);
        }
        return jsonParams;
    }

    @Override
    public TemuOrderPoOrderShippingInfoRespVO getOrderShippingInfo(TemuAppClientDTO tcDTO, TemuOrderPoOrderShippingInfoReqDTO orderShippingInfoReqDTO) throws Exception {
        JSONObject jsonParams = getOrderShippingInfoJsonObject(orderShippingInfoReqDTO);
        String orderListBody = temuOrderPoCall.getOrderShippingInfo(tcDTO, jsonParams);
        TemuOrderPoOrderShippingInfoRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoOrderShippingInfoRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoOrderShippingInfoRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getOrderShippingInfoJsonObject(TemuOrderPoOrderShippingInfoReqDTO orderShippingInfoReqDTO) {
        JSONObject jsonParams = new JSONObject();
        jsonParams.put("parentOrderSn", orderShippingInfoReqDTO.getParentOrderSn());
        return jsonParams;
    }

    @Override
    public TemuOrderPoLogisticsShipmentRespVO getLogisticsShipment(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentReqDTO logisticsShipmentReqDTO) throws Exception {
        JSONObject jsonParams = getLogisticsShipmentJsonObject(logisticsShipmentReqDTO);
        String orderListBody = temuOrderPoCall.getLogisticsShipment(tcDTO, jsonParams);
        TemuOrderPoLogisticsShipmentRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoLogisticsShipmentRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoLogisticsShipmentRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getLogisticsShipmentJsonObject(TemuOrderPoLogisticsShipmentReqDTO logisticsShipmentReqDTO) {
        JSONObject jsonParams = new JSONObject();
        jsonParams.put("parentOrderSn", logisticsShipmentReqDTO.getParentOrderSn());
        jsonParams.put("orderSn", logisticsShipmentReqDTO.getOrderSn());
        return jsonParams;
    }

    @Override
    public TemuOrderPoOrderFulfillmentInfoSyncRespVO orderFulfillmentInfoSync(TemuAppClientDTO tcDTO, TemuOrderPoOrderFulfillmentInfoSyncReqDTO orderFulfillmentInfoSyncReqDTO) throws Exception {
        JSONObject jsonParams = getOrderFulfillmentInfoSyncJsonObject(orderFulfillmentInfoSyncReqDTO);
        String orderListBody = temuOrderPoCall.orderFulfillmentInfoSync(tcDTO, jsonParams);
        TemuOrderPoOrderFulfillmentInfoSyncRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoOrderFulfillmentInfoSyncRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoOrderFulfillmentInfoSyncRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getOrderFulfillmentInfoSyncJsonObject(TemuOrderPoOrderFulfillmentInfoSyncReqDTO orderFulfillmentInfoSyncReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //orderSn	STRING	是	订单号
        jsonParams.put("orderSn", orderFulfillmentInfoSyncReqDTO.getOrderSn());
        //operationTime	INTEGER	是	已发货对应仓库接收指令时间、已配送对应仓库回传运单号时间(秒级时间戳)
        jsonParams.put("operationTime", orderFulfillmentInfoSyncReqDTO.getOperationTime());
        //warehouseOperationStatus	INTEGER	是	仓库作业状态：0-已发货(仓库接收发货指令节点) 1-已配送(仓库回传运单号节点)
        jsonParams.put("warehouseOperationStatus", orderFulfillmentInfoSyncReqDTO.getWarehouseOperationStatus());
        //trackingNumber	STRING	否	运单号
        jsonParams.put("trackingNumber", orderFulfillmentInfoSyncReqDTO.getTrackingNumber());
        //warehouseBrandName	STRING	是	仓库品牌名称
        jsonParams.put("warehouseBrandName", orderFulfillmentInfoSyncReqDTO.getWarehouseBrandName());
        //warehouseName	STRING	是	仓库名称
        jsonParams.put("warehouseName", orderFulfillmentInfoSyncReqDTO.getWarehouseName());
        //warehouseRegion1	STRING	否	仓库对应一级地址
        jsonParams.put("warehouseRegion1", orderFulfillmentInfoSyncReqDTO.getWarehouseRegion1());
        //warehouseRegion2	STRING	否	仓库对应二级地址
        jsonParams.put("warehouseRegion2", orderFulfillmentInfoSyncReqDTO.getWarehouseRegion2());
        //warehouseRegion3	STRING	否	仓库对应三级地址
        jsonParams.put("warehouseRegion3", orderFulfillmentInfoSyncReqDTO.getWarehouseRegion3());
        //warehouseRegion4	STRING	否	仓库对应四级地址
        jsonParams.put("warehouseRegion4", orderFulfillmentInfoSyncReqDTO.getWarehouseRegion4());
        //warehouseAddressLine1	STRING	否	仓库对应详细地址1
        jsonParams.put("warehouseAddressLine1", orderFulfillmentInfoSyncReqDTO.getWarehouseAddressLine1());
        //warehouseAddressLine2	STRING	否	仓库对应详细地址2
        jsonParams.put("warehouseAddressLine2", orderFulfillmentInfoSyncReqDTO.getWarehouseAddressLine2());
        //warehousePostCode	STRING	否	仓库所在地对应邮编
        jsonParams.put("warehousePostCode", orderFulfillmentInfoSyncReqDTO.getWarehousePostCode());
        return jsonParams;
    }

    @Override
    public TemuOrderPoLogisticsShipmentConfirmRespVO logisticsShipmentConfirm(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentConfirmReqDTO logisticsShipmentConfirmReqDTO) throws Exception {
        JSONObject jsonParams = getLogisticsShipmentConfirmJsonObject(logisticsShipmentConfirmReqDTO);
        String orderListBody = temuOrderPoCall.logisticsShipmentConfirm(tcDTO, jsonParams);
        TemuOrderPoLogisticsShipmentConfirmRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoLogisticsShipmentConfirmRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoLogisticsShipmentConfirmRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getLogisticsShipmentConfirmJsonObject(TemuOrderPoLogisticsShipmentConfirmReqDTO logisticsShipmentConfirmReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //sendType	INTEGER	是	发货类型：0-单个运单发货 1-拆成多个运单发货 2-合并发货
        jsonParams.put("sendType", logisticsShipmentConfirmReqDTO.getSendType());
        //sendRequestList	LIST	是	包裹信息
        List<TemuOrderPoLogisticsShipmentConfirmSendRequestDTO> sendRequestList = logisticsShipmentConfirmReqDTO.getSendRequestList();
        if (CollectionUtils.isNotEmpty(sendRequestList)) {
            jsonParams.put("sendRequestList", JSON.toJSONString(sendRequestList));
        }
        return jsonParams;
    }


    @Override
    public TemuOrderPoLogisticsShipmentSubConfirmRespVO logisticsShipmentSubConfirm(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentSubConfirmReqDTO logisticsShipmentSubConfirmReqDTO) throws Exception {
        JSONObject jsonParams = getLogisticsShipmentSubConfirmJsonObject(logisticsShipmentSubConfirmReqDTO);
        String orderListBody = temuOrderPoCall.logisticsShipmentSubConfirm(tcDTO, jsonParams);
        TemuOrderPoLogisticsShipmentSubConfirmRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoLogisticsShipmentSubConfirmRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoLogisticsShipmentSubConfirmRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getLogisticsShipmentSubConfirmJsonObject(TemuOrderPoLogisticsShipmentSubConfirmReqDTO logisticsShipmentSubConfirmReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //gatewayContext	OBJECT	否	网关参数
        jsonParams.put("gatewayContext", logisticsShipmentSubConfirmReqDTO.getGatewayContext());
        //mainPackageSn	STRING	是	主包裹号，前置已经发货的包裹号，可通过 bg.logistics.shipment.get接口获取
        jsonParams.put("mainPackageSn", logisticsShipmentSubConfirmReqDTO.getMainPackageSn());
        //sendSubRequestList	LIST	否	需要补充的包裹信息
        List<TemuOrderPoLogisticsShipmentSubConfirmSendSubRequestDTO> subRequestList = logisticsShipmentSubConfirmReqDTO.getSubRequestList();
        if (CollectionUtils.isNotEmpty(subRequestList)) {
            jsonParams.put("sendSubRequestList", JSON.toJSONString(subRequestList));
        }
        return jsonParams;
    }


    @Override
    public TemuOrderPoLogisticsTemplateGetRespVO logisticsTemplateGet(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsTemplateGetReqDTO logisticsTemplateGetReqDTO) throws Exception {
        JSONObject jsonParams = getLogisticsTemplateGetJsonObject(logisticsTemplateGetReqDTO);
        String orderListBody = temuOrderPoCall.logisticsTemplateGet(tcDTO, jsonParams);
        TemuOrderPoLogisticsTemplateGetRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoLogisticsTemplateGetRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoLogisticsTemplateGetRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getLogisticsTemplateGetJsonObject(TemuOrderPoLogisticsTemplateGetReqDTO logisticsTemplateGetReqDTO) {
        List<Long> siteIds = logisticsTemplateGetReqDTO.getSiteIds();
        JSONObject jsonParams = new JSONObject();
        //siteIds  update 	LIST		站点ID列表
        if (CollectionUtils.isNotEmpty(siteIds)) {
            jsonParams.put("siteIds", JSON.toJSONString(siteIds));
        }
        return jsonParams;
    }

    @Override
    public TemuOrderPoLogisticsCompaniesGetRespVO logisticsCompaniesGet(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsCompaniesGetReqDTO logisticsCompaniesGetReqDTO) throws Exception {
        JSONObject jsonParams = getLogisticsCompaniesGetJsonObject(logisticsCompaniesGetReqDTO);
        String orderListBody = temuOrderPoCall.logisticsCompaniesGet(tcDTO, jsonParams);
        TemuOrderPoLogisticsCompaniesGetRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoLogisticsCompaniesGetRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoLogisticsCompaniesGetRespVO();
        }
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getLogisticsCompaniesGetJsonObject(TemuOrderPoLogisticsCompaniesGetReqDTO logisticsCompaniesGetReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //regionId	INTEGER	是	配送地址的regionId，默认传参211，含义是代表美国站点
        jsonParams.put("regionId", logisticsCompaniesGetReqDTO.getRegionId());
        return jsonParams;
    }

    @Override
    public TemuOrderPoAfterSalesParentAfterSalesListGetRespVO afterSalesParentAfterSalesListGet(TemuAppClientDTO tcDTO, TemuOrderPoAfterSalesParentAfterSalesListGetReqDTO afterSalesParentAfterSalesListGetReqDTO) throws Exception {
        JSONObject jsonParams = getAfterSalesParentAfterSalesListGetJsonObject(afterSalesParentAfterSalesListGetReqDTO);
        String orderListBody = temuOrderPoCall.afterSalesParentAfterSalesListGet(tcDTO, jsonParams);
        TemuOrderPoAfterSalesParentAfterSalesListGetRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoAfterSalesParentAfterSalesListGetRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoAfterSalesParentAfterSalesListGetRespVO();
        }
        System.out.println(orderListBody);
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getAfterSalesParentAfterSalesListGetJsonObject(TemuOrderPoAfterSalesParentAfterSalesListGetReqDTO afterSalesParentAfterSalesListGetReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //createAtStart	INTEGER	否	售后单创建时间起始查询时间，秒级时间戳,闭区间
        jsonParams.put("createAtStart", afterSalesParentAfterSalesListGetReqDTO.getCreateAtStart());
        //createAtEnd	INTEGER	否	售后单创建时间结束查询时间，秒级时间戳,闭区间
        jsonParams.put("createAtEnd", afterSalesParentAfterSalesListGetReqDTO.getCreateAtEnd());
        //updateAtStart	INTEGER	否	售后单状态变更时间开始查询时间，秒级时间戳,闭区间
        jsonParams.put("updateAtStart", afterSalesParentAfterSalesListGetReqDTO.getUpdateAtStart());
        //updateAtEnd	INTEGER	否	售后单状态变更时间结束查询时间，秒级时间戳,闭区间
        jsonParams.put("updateAtEnd", afterSalesParentAfterSalesListGetReqDTO.getUpdateAtEnd());
        //parentAfterSalesSnList	LIST	否	限定查询的售后父单号列表，为空时不限定售后父单号范围
        List<String> parentAfterSalesSnList = afterSalesParentAfterSalesListGetReqDTO.getParentAfterSalesSnList();
        if (CollectionUtils.isNotEmpty(parentAfterSalesSnList)) {
            jsonParams.put("parentAfterSalesSnList", JSON.toJSONString(afterSalesParentAfterSalesListGetReqDTO.getParentAfterSalesSnList()));
        }
        //parentOrderSnList	LIST	否	限定查询的订单父单号列表，为空时不限定订单父单号范围
        List<String> parentOrderSnList = afterSalesParentAfterSalesListGetReqDTO.getParentOrderSnList();
        if (CollectionUtils.isNotEmpty(parentOrderSnList)) {
            jsonParams.put("parentOrderSnList", JSON.toJSONString(afterSalesParentAfterSalesListGetReqDTO.getParentOrderSnList()));
        }
        //afterSalesStatusGroup	INTEGER	否	售后单状态分组，枚举如下:1:待处理2:已申请3:包裹已寄出4:平台审核中5:已退款6:已拒绝7:已取消
        jsonParams.put("afterSalesStatusGroup", afterSalesParentAfterSalesListGetReqDTO.getAfterSalesStatusGroup());
        //pageNo	INTEGER	否	页码,默认第1页开始
        jsonParams.put("pageNo", afterSalesParentAfterSalesListGetReqDTO.getPageNo());
        //pageSize	INTEGER	否	页面大小,默认每页10条,max<=200
        jsonParams.put("pageSize", afterSalesParentAfterSalesListGetReqDTO.getPageSize());
        return jsonParams;
    }

    @Override
    public TemuOrderPoAfterSalesAfterSalesListGetRespVO afterSalesAfterSalesListGet(TemuAppClientDTO tcDTO, TemuOrderPoAfterSalesAfterSalesListGetReqDTO afterSalesAfterSalesListGetReqDTO) throws Exception {
        JSONObject jsonParams = getAfterSalesAfterSalesListGetJsonObject(afterSalesAfterSalesListGetReqDTO);
        String orderListBody = temuOrderPoCall.afterSalesAfterSalesListGet(tcDTO, jsonParams);
        TemuOrderPoAfterSalesAfterSalesListGetRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoAfterSalesAfterSalesListGetRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoAfterSalesAfterSalesListGetRespVO();
        }
        System.out.println(orderListBody);
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getAfterSalesAfterSalesListGetJsonObject(TemuOrderPoAfterSalesAfterSalesListGetReqDTO afterSalesAfterSalesListGetReqDTO) {
        List<String> parentAfterSalesSnList = afterSalesAfterSalesListGetReqDTO.getParentAfterSalesSnList();
        JSONObject jsonParams = new JSONObject();
        //parentAfterSalesSnList	LIST	是	限定查询的售后父单号列表，为空时不限定售后父单号范围
        if (CollectionUtils.isNotEmpty(parentAfterSalesSnList)) {
            jsonParams.put("parentAfterSalesSnList", JSON.toJSONString(afterSalesAfterSalesListGetReqDTO.getParentAfterSalesSnList()));
        }
        //pageNo	INTEGER	否	页码,默认第1页开始
        jsonParams.put("pageNo", afterSalesAfterSalesListGetReqDTO.getPageNo());
        //pageSize	INTEGER	否	页面大小,默认每页10条,max<=200
        jsonParams.put("pageSize", afterSalesAfterSalesListGetReqDTO.getPageSize());
        return jsonParams;
    }

    @Override
    public TemuOrderPoAfterSalesParentReturnOrderGetRespVO afterSalesParentReturnOrderGet(TemuAppClientDTO tcDTO, TemuOrderPoAfterSalesParentReturnOrderGetReqDTO afterSalesParentReturnOrderGetReqDTO) throws Exception {
        JSONObject jsonParams = getAfterSalesParentReturnOrderGetJsonObject(afterSalesParentReturnOrderGetReqDTO);
        String orderListBody = temuOrderPoCall.afterSalesParentReturnOrderGet(tcDTO, jsonParams);
        TemuOrderPoAfterSalesParentReturnOrderGetRespVO respVO = JSONObject.parseObject(orderListBody, TemuOrderPoAfterSalesParentReturnOrderGetRespVO.class);
        if (respVO == null) {
            respVO = new TemuOrderPoAfterSalesParentReturnOrderGetRespVO();
        }
        System.out.println(orderListBody);
        respVO.setRespBody(orderListBody);
        return respVO;
    }

    private JSONObject getAfterSalesParentReturnOrderGetJsonObject(TemuOrderPoAfterSalesParentReturnOrderGetReqDTO afterSalesParentReturnOrderGetReqDTO) {
        JSONObject jsonParams = new JSONObject();
        //parentAfterSalesSn	STRING	是	售后父单号,必填
        jsonParams.put("parentAfterSalesSn", afterSalesParentReturnOrderGetReqDTO.getParentAfterSalesSn());
        //afterSalesSn	STRING	否	售后子单号,非必填
        jsonParams.put("afterSalesSn", afterSalesParentReturnOrderGetReqDTO.getAfterSalesSn());
        return jsonParams;
    }


}
