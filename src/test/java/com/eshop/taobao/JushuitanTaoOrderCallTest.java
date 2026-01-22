//package com.eshop.taobao;
//
//import com.alibaba.fastjson.JSON;
//import com.bizark.multichannel.core.bean.shipment.*;
//import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
//import com.eshop.util.platform.api.service.order.jushuitan.JushuitanTaoOrderCall;
//import com.eshop.util.platform.api.service.order.jushuitan.dto.*;
//import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoConfirmDeliveryOrderRespVO;
//import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoSaleOrderListRespVO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @program: eshop-plat-api
// * @description:
// * @author: lindz
// * @create: 2026-01-18 11:27
// **/
//
//@SpringBootTest
//public class JushuitanTaoOrderCallTest {
//
//    @Autowired
//    private JushuitanTaoOrderCall jushuitanTaoOrderCall;
//
//    @Test
//    public void confirmDeliveryOrder() throws Exception {
//        //wms的 appKey
//        String appKey = "35256860";
//        //wms的 appSecret
//        String appSecret = "811bc31681a6e83edaa16901666a4603";
//        String sessionKey = "";
//        //聚水潭的 targetAppKey
//        String targetAppKey = "23060081";
//        //聚水潭绑定wms生成的 customerId
//        String customerId = "10969016";
//        //奇门调用地址
//        String apiUrl = "http://a1q40taq0j.api.taobao.com/router/qm";
//
//        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
//        appDTO.setAppKey(appKey);
//        appDTO.setAppSecret(appSecret);
//        appDTO.setSessionKey(sessionKey);
//        appDTO.setTargetAppKey(targetAppKey);
//        appDTO.setCustomerId(customerId);
//        appDTO.setApiUrl(apiUrl);
//
//
//        JushuitanTaoConfirmDeliveryOrderReqDTO reqDTO = new JushuitanTaoConfirmDeliveryOrderReqDTO();
//        extracted();
//
//        JushuitanTaoConfirmDeliveryOrderRespVO respVO = jushuitanTaoOrderCall.confirmDeliveryOrder(appDTO, reqDTO);
//        System.out.println(respVO.getRespBody());
//        System.out.println(JSON.toJSON(respVO));
//    }
//
//    private JushuitanTaoConfirmDeliveryOrderRequestDTO extracted() {
//        JushuitanTaoConfirmDeliveryOrderRequestDTO request = new JushuitanTaoConfirmDeliveryOrderRequestDTO();
//        //deliveryOrder	DeliveryOrder		发货单信息
//        JushuitanTaoConfirmDeliveryOrderDTO deliveryOrder = getDeliveryOrderDTO();
//        //packages	Package[]		包裹信息
//        List<JushuitanTaoConfirmDeliveryOrderPackageDTO> packages;
//        //orderLines	OrderLine[]		单据列表
//        List<JushuitanTaoConfirmDeliveryOrderLineDTO> orderLines;
//        //extendProps	Map		扩展属性
//        Map<String, String> extendProps;
//
//        return request;
//    }
//
//    private JushuitanTaoConfirmDeliveryOrderDTO getDeliveryOrderDTO(ChannelTrackingOrderQueue orderQueue){
//        Long id = orderQueue.getID();
//
//        //request-deliveryOrder---主节点
//        //字段名               | 描述      | 是否必填 | 备注/说明 值选项/示例
//        //-------------------|-----------|----------|-------------------------------------------------------------------------------------------|-------------------
//        //confirmType	      多次发货状态确认	是	    - 0-表示最终出库； 1-表示中间状态
//        //deliveryOrderCode	  OMS订单号	    是	    - 销售出库单-出仓单号
//        //deliveryOrderId	  WMS发货订单号	否	    - 默认不在发货时处理保存，如果有需要，请联系聚水潭-少辛开启服务商维度-发货更新仓储订单ID功能
//        //orderConfirmTime	  单据完成时间	否	    - WMS提供则作为ERP出库时间； 不提供则ERP出库时间为WMS回传发货的时间
//        //orderType	          单据类型	    是      - 出库单类型(JYCK=一般交易出库;HHCK=换货出库;BFCK=补发出库;QTCK=其他出库单)
//        //outBizCode	      外部业务编码	是	    - 外部业务编码, 消息 ID, 用于去重
//        //status	          出库单状态  	是	    - (只传英 文编码)  DELIVERED-发货完成
//        //warehouseCode	      外部仓库编码	是	    - 奇门配置-仓库代码
//        JushuitanTaoConfirmDeliveryOrderDTO deliveryOrder = new  JushuitanTaoConfirmDeliveryOrderDTO();
//        deliveryOrder.setConfirmType(0);
//        deliveryOrder.setDeliveryOrderCode();
////        deliveryOrder.setDeliveryOrderId();
//        deliveryOrder.setOrderConfirmTime();
//        deliveryOrder.setOrderType("JYCK");
//        deliveryOrder.setOutBizCode(id + "");
//        deliveryOrder.setStatus("DELIVERED");
//        return deliveryOrder;
//    }
//
//    private JushuitanTaoConfirmDeliveryOrderReqDTO getReqDTO(
//            ChannelTrackingOrderQueue orderQueue,
//            List<ChannelTrackingPackageQueue> packageQueueList,
//            List<ChannelTrackingItemQueue> itemQueueList
//    ) {
//        String orderNum = orderQueue.getORDER_NUM();
//        String shipWarehouse = orderQueue.getSHIP_WAREHOUSE();
//        Long id = orderQueue.getID();
//
//        JushuitanTaoConfirmDeliveryOrderDTO deliveryOrder = getDeliveryOrderDTO(orderQueue);
//
//
//        //商品列表 - 按运单号(TRACKING_NO)分组
//        Map<String, List<ChannelTrackingItemQueue>> trackingNoGroupMap = itemQueueList.stream()
//                .collect(Collectors.groupingBy(ChannelTrackingItemQueue::getTRACKING_NO));
//
//        List<JushuitanTaoConfirmDeliveryOrderPackageDTO> packages = new ArrayList<>();
//        for (ChannelTrackingPackageQueue packageQueue : packageQueueList) {
//            String shippingMethod = packageQueue.getSHIPPING_METHOD();
//            String trackingNo = packageQueue.getTRACKING_NO();
//
//            //request-packages-package-----订单包裹节点
//            //字段名               | 描述      | 是否必填 | 备注/说明 值选项/示例
//            //-------------------|-----------|----------|-------------------------------------------------------------------------------------------|-------------------
//            //packageCode	    包裹号	        否	        包裹级别唯一
//            //logisticsCode	    物流编码	        是	        发货物流编码	对应物流产品服务映射
//            //expressCode	    运单号	        是	        发货物流单号
//            //weight	        包裹重量	        否	        销售出库单-实际称重重量
//            JushuitanTaoConfirmDeliveryOrderPackageDTO packageDTO = new JushuitanTaoConfirmDeliveryOrderPackageDTO();
//            packageDTO.setLogisticsCode(shippingMethod);
//            packageDTO.setExpressCode(trackingNo);
//
//            //根据运单号获取包裹商品 从分组结果中获取指定运单号对应的包裹商品列表
//            List<ChannelTrackingItemQueue> itemQueuesTemp = trackingNoGroupMap.getOrDefault(trackingNo, Collections.emptyList());
//            List<JushuitanTaoConfirmDeliveryOrderPackageItemDTO> items = new ArrayList<>();
//            for (ChannelTrackingItemQueue itemQueue : itemQueuesTemp) {
//                //request-packages-package-items-item---订单包裹商品详情节点
//                //字段名               | 描述      | 是否必填 | 备注/说明 值选项/示例
//                //-------------------|-----------|----------|-------------------------------------------------------------------------------------------|-------------------
//                //itemCode	            商品编码	        是
//                //quantity	            商品数量	        是
//                //batchCode	            批次号	        否	跟踪信息-生产批次号	分批发货+批次效期业务，包裹下批次必传
//                //productDate	        生产日期	        否	跟踪信息-生产日期	分批发货+批次效期业务，包裹下批次必传
//                //actualQty	            数量	            否	跟踪信息-数量	各个批次数量相加必须等于整明细行的数量
//                JushuitanTaoConfirmDeliveryOrderPackageItemDTO itemDTO = new JushuitanTaoConfirmDeliveryOrderPackageItemDTO();
//                itemDTO.setItemCode(itemQueue.getSKU());
//                itemDTO.setQuantity(itemQueue.getQUANTITY().intValue());
//                items.add(itemDTO);
//            }
//            packageDTO.setItems(items);
//            packages.add(packageDTO);
//        }
//
//
//        List<JushuitanTaoConfirmDeliveryOrderLineDTO> orderLines = new ArrayList<>();
//        for (ChannelTrackingItemQueue itemQueue : itemQueueList) {
//            String sku = itemQueue.getSKU();
//            BigDecimal quantity = itemQueue.getQUANTITY();
//            //request-orderLines-orderLine-----商品明细节点
//            //字段名               | 描述      | 是否必填 | 备注/说明 值选项/示例
//            //-------------------|-----------|----------|-------------------------------------------------------------------------------------------|-------------------
//            //ownerCode	            货主编码	    否           区分customerID场景下，必传
//            //actualQty	            实际发货数量	是
//            //itemCode	            商品编码	    是
//            JushuitanTaoConfirmDeliveryOrderLineDTO orderLineDTO = new JushuitanTaoConfirmDeliveryOrderLineDTO();
//            orderLineDTO.setActualQty(quantity.intValue());
//            orderLineDTO.setItemCode(sku);
//            orderLines.add(orderLineDTO);
//        }
//
//        JushuitanTaoConfirmDeliveryOrderRequestDTO request = new JushuitanTaoConfirmDeliveryOrderRequestDTO();
//        request.setDeliveryOrder(deliveryOrder);
//        request.setPackages(packages);
//        request.setOrderLines(orderLines);
//
//        JushuitanTaoConfirmDeliveryOrderReqDTO reqDTO = new JushuitanTaoConfirmDeliveryOrderReqDTO();
//        reqDTO.setRequest(request);
//        return reqDTO;
//    }
//}
