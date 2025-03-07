package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.shopee;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.service.api.marketplace.logistics.infrastructure.repository.shopee.ApiShopeeLogisticsSyncService;
import com.eshop.api.modules.service.api.marketplace.order.call.shopee.ShopeeOrderCallService;
import com.eshop.api.modules.util.shop.PlatformAppClientUtils;
import com.eshop.db.logistics.service.LogModeService;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.api.marketplace.order.dto.ShopeeOrderDetailReqDTO;
import com.eshop.modal.entry.api.marketplace.order.dto.ShopeeOrderListReqDTO;
import com.eshop.modal.entry.api.marketplace.order.vo.ShopeeOrderDetailRespVO;
import com.eshop.modal.entry.api.marketplace.order.vo.ShopeeOrderListRespVO;
import com.eshop.modal.entry.platform.config.PlatformOrder3plVO;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.exception.OrderException;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_logistics.TbLogisticsMode;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.WaybillUtils;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.platform.utils.FastJsonUtil;
import com.eshop.util.platform.utils.order.ShopeeOrderUtils;
import com.eshop.util.platform.utils.status.ShopeeStatusUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2024/3/18 14:18
 * @Description: ...
 * @Version 1.0
 */
@StrategyKey(ConstantPlatform.SHOPEE)
@Service
public class ShopeeOrderClientImpl implements ShopeeOrderClient {

    private static final Logger logger = LoggerFactory.getLogger(ShopeeOrderClientImpl.class);

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Autowired
    private ShopeeOrderCallService shopeeOrderCallService;

    @Autowired
    private ShopeeStatusUtils shopeeStatusUtils;

    @Autowired
    private ShopeeOrderUtils shopeeOrderUtils;

    @Autowired
    private OrderWaybillUtils orderWaybillUtils;

    @Autowired
    private LogModeService logModeService;

    @Resource
    private ApiShopeeLogisticsSyncService apiShopeeLogisticsSyncService;

    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize) throws Exception {
        TbShop shop = dto.getShop();
        //api请求
        JSONObject jsonObject = getOrderList(shop, orderSyncDTO, pageSize, null);

        JSONObject response = jsonObject.getJSONObject("response");

        if (response != null) {
            Boolean more = response.getBoolean("more");
            if (more == null) {
                logger.error("店铺:" + shop.getName() + "获取分页信息失败：" + jsonObject.toString());
                throw new RuntimeException("获取分页信息失败" + jsonObject.toString());
            }
        } else {
            String error = jsonObject.getString("error");
            String message = jsonObject.getString("message");

            String msg = "错误类型：" + error + "---错误原因：" + message;
            logger.error("店铺:" + shop.getName() + "获取分页信息失败：" + jsonObject.toString());
            throw new RuntimeException("获取分页信息失败" + jsonObject.toString());
        }

        return new PageUtil(pageSize, 1);
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shop = dto.getShop();
        //api请求
        JSONObject jsonObject = getOrderList(shop, orderSyncDTO, pageSize, cursorDto);
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrders(jsonObject);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);

        //是否有下一页
        Boolean more = Optional.ofNullable(jsonObject)
                .map(p -> p.getJSONObject("response"))
                .map(p -> p.getBoolean("more")).orElse(null);
        result.setMore(more);
        //下一页游标
        String nextCursor = Optional.ofNullable(jsonObject)
                .map(p -> p.getJSONObject("response"))
                .map(p -> p.getString("next_cursor")).orElse(null);
        result.setNextCursor(nextCursor);

        return result;
    }

    @Override
    public TbOrderInfo getAddOrderDetailSync(PlatformSyncDTO dto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbShop shop = dto.getShop();
        TbPlatform platform = dto.getPlatform();
        String operator = dto.getCreator();
        TbOrder order = po.getInfo();

        JSONObject baseJson = getBaseJson(dto, order.getOrderNo());
        String region = baseJson.getString("region");
        TbOrderInfo orderInfo = new TbOrderInfo();
        //主表
        order = getOrder(order, baseJson);
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(baseJson, order));
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(order, platform, operator, "1"));
        //HTTP 获取订单详情 详情包含 费用明细 运单物流方式 运单地址

        //税号
//        assembleOrderBuyerInfos(orderInfo.getOrderBuyer(), order);
        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(baseJson));
        //运单表
//        orderInfo.setWaybills(dhgateOrderUtils.getWaybills(order));
        orderInfo.setWaybills(getWaybills(baseJson, order.getOrderNo(), region));
        //运单地址表
        orderInfo.setWaybillSite(getWaybillSite(baseJson, region, dto, order.getOrderNo()));
        //买家信息装配 买家信息补充
        orderInfo.getOrderBuyer().setCountry(orderInfo.getWaybillSite().getCountry());
//        dhgateOrderUtils.assembleWaybillSiteToOrderBuyerInfo(orderInfo.getWaybillSite(), orderInfo.getOrderBuyer());
        //订单轨迹
        orderInfo.setWaybillTracks(getOrderTrackInfoList(baseJson));
        //运单是否妥投
        isDelivered(orderInfo.getWaybills(), orderInfo.getWaybillTracks());
        //HTTP 订单商品信息
        List<TbOrderProducts> orderProductsList = getOrderProductsList(baseJson, order, orderInfo.getWaybills());
        orderInfo.setOrderProducts(orderProductsList);

        //订单详情 respJson
        if (baseJson != null) {
            orderInfo.setOrderDetailRespJson(baseJson.toJSONString());
        }
        //订单产品 respJson
        JSONArray array = baseJson.getJSONArray("item_list");
        if (array != null) {
            orderInfo.setOrderProductRespJson(array.toJSONString());
        }
        //订单号
        String orderSn = baseJson.getString("order_sn");
        orderInfo.setOrderNo(orderSn);


        String orderStatusStr = baseJson.getString("order_status");
        //erp 状态处理转化
        Integer platformOrderStatus = shopeeStatusUtils.getPlatformOrderStatus(orderStatusStr);
        String platformOrderStatusStr = shopeeStatusUtils.getPlatformOrderStatusStr(orderStatusStr);
        String abnormalCause = shopeeStatusUtils.getAbnormalCause(orderStatusStr);
        List<Long> orderTypeMiddles = shopeeStatusUtils.getOrderTypeMiddles(orderStatusStr, orderInfo, true);

        order.setPlatformOrderStatus(platformOrderStatus);
        orderInfo.setAbnormalCause(abnormalCause);
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //是否同步判断
        orderInfo.setIsSync(isSync(baseJson));
        //不同步原因
        if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
            orderInfo.setSyncNotMsg("订单状态+" + platformOrderStatusStr);

        }

        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shop = psDto.getShop();
        //api请求
        JSONObject jsonObject = getOrderList(shop, osDto, pageSize, cursorDto);
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrders(jsonObject);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);

        //是否有下一页
        Boolean more = Optional.ofNullable(jsonObject)
                .map(p -> p.getJSONObject("response"))
                .map(p -> p.getBoolean("more")).orElse(null);
        result.setMore(more);
        //下一页游标
        String nextCursor = Optional.ofNullable(jsonObject)
                .map(p -> p.getJSONObject("response"))
                .map(p -> p.getString("next_cursor")).orElse(null);
        result.setNextCursor(nextCursor);

        return result;
    }

    @Override
    public TbOrderInfo getUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbOrder o = po.getInfo();
        String orderNo = o.getOrderNo();
        //获取订单详情
        JSONObject baseJson = getBaseJson(psDto, orderNo);
        //平台订单状态 原生
        String orderStatusStr = baseJson.getString("order_status");
        return getUpOrderInfoLevel1(psDto, orderNo, orderStatusStr, baseJson);
    }

    private TbOrderInfo getUpOrderInfoLevel1(PlatformSyncDTO psDTO, String orderNo, String orderStatusStr, JSONObject baseJson) {
        TbOrder order = new TbOrder();
        order.setOrderNo(orderNo);
        order.setTransactionNo(orderNo);
        order.setPlatformOrderStatus(shopeeStatusUtils.getPlatformOrderStatus(orderStatusStr));

        TbOrderInfo upOrderInfo = getUpOrderInfoLevel2(psDTO, order, orderStatusStr, baseJson);
        return upOrderInfo;
    }

    private TbOrderInfo getUpOrderInfoLevel2(PlatformSyncDTO psDTO, TbOrder order, String orderStatusStr, JSONObject baseJson) {
        String platformName = psDTO.getPlatform().getPlatformName();
        String operator = psDTO.getCreator();
        String orderNo = order.getOrderNo();
        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(orderNo, platformName, operator, "2"));
        //订单号
        orderInfo.setOrderNo(orderNo);
        //erp 状态处理转化
        Integer platformOrderStatus = shopeeStatusUtils.getPlatformOrderStatus(orderStatusStr);
        String platformOrderStatusStr = shopeeStatusUtils.getPlatformOrderStatusStr(orderStatusStr);
        PlatformOrder3plVO platform3pl = shopeeStatusUtils.getPlatform3pl(orderStatusStr, baseJson);
        String abnormalCause = shopeeStatusUtils.getAbnormalCause(orderStatusStr);
        List<Long> orderTypeMiddles = shopeeStatusUtils.getOrderTypeMiddles(orderStatusStr, null, null, true);

        if (orderInfo.getOrderLogs() != null && StringUtils.isNotBlank(platformOrderStatusStr)) {
            orderInfo.getOrderLogs().setDescription(platformOrderStatusStr);
        }

        orderInfo.setPlatformOrderStatus(platformOrderStatus);
        orderInfo.setAbnormalCause(abnormalCause);
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //订单详情原始数据
        if (baseJson != null) {
            orderInfo.setOrderDetailRespJson(baseJson.toJSONString());
        }
        //订单信息补充
        orderInfo.setOrder(order);
        //3pl揽收情况
        orderInfo.setPlatform3pl(platform3pl);
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shop = psDto.getShop();
        //api请求
        JSONObject jsonObject = getOrderList(shop, osDto, pageSize, cursorDto);
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getOrders(jsonObject);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(jsonObject);
        result.setSyncList(orderList);

        //是否有下一页
        Boolean more = Optional.ofNullable(jsonObject)
                .map(p -> p.getJSONObject("response"))
                .map(p -> p.getBoolean("more")).orElse(null);
        result.setMore(more);
        //下一页游标
        String nextCursor = Optional.ofNullable(jsonObject)
                .map(p -> p.getJSONObject("response"))
                .map(p -> p.getString("next_cursor")).orElse(null);
        result.setNextCursor(nextCursor);

        return result;
    }

    @Override
    public TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDTO, String orderNo) throws Exception {
        //获取订单详情
        JSONObject baseJson = getBaseJson(psDTO, orderNo);
        String buyerCancelReason = baseJson.getString("buyer_cancel_reason");
        String cancel_reason = baseJson.getString("cancel_reason");
        if (StringUtils.isBlank(buyerCancelReason)) {
            buyerCancelReason = cancel_reason;
        }
        String orderStatusStr = baseJson.getString("order_status");
        //创建订单的日期和时间的时间戳 --> 商品总售价
        Long updateTime = baseJson.getLong("update_time");
        Date applyCancelTime = null;
        if (updateTime != null) {
            applyCancelTime = new Date(updateTime * 1000);
        } else {
            applyCancelTime = new Date();
        }
        int sync = -1;
        //买家提交取消申请待处理
        if (StringUtils.isNotBlank(orderStatusStr) && orderStatusStr.equals("IN_CANCEL")) {
            sync = 1;
        }
        TbOrderInfo orderInfo = new TbOrderInfo();
        orderInfo.setOrderNo(orderNo);
        orderInfo.setBuyerCancelReason(buyerCancelReason);
        orderInfo.setApplyCancelTime(applyCancelTime);
        orderInfo.setIsSync(sync);
        return orderInfo;
    }

    private JSONObject getBaseJson(PlatformSyncDTO dto, String orderNo) throws Exception {
        TbShop shop = dto.getShop();
        //api请求
        JSONObject jsonObject = getOrderDetail(shop, orderNo);

        JSONObject reJson = jsonObject;

        JSONArray jsonArray = reJson.getJSONObject("response").getJSONArray("order_list");
        if (CollectionUtils.isNotEmpty(jsonArray)) {
            return jsonArray.getJSONObject(0);
        }
        return null;
    }

    /**
     * 订单列表 初始化访问参数
     *
     * @param posDto
     * @param pageSize
     * @return
     */
    public Map<String, Object> getOrderListDto(OrderSyncDTO posDto, Integer pageSize, PlatformPageCursorDto cursorDto) {
        String cursor = "";

        if (posDto.getStartDate() == null) {
            throw new RuntimeException("时间范围开始时间不能为空!");
        }

        if (posDto.getEndDate() == null) {
            throw new RuntimeException("时间范围结束时间不能为空！");
        }

        if (cursorDto != null && StringUtils.isNotBlank(cursorDto.getNextCursor())) {
            cursor = cursorDto.getNextCursor();
        } else {
            cursor = "0";
        }
        //1指代创建时间 create_time 2.指代更新时间 update_time
        String queryTimeType = posDto.getTimeType().toString();

        //默认时更新时间
        String timeRangeField = "update_time";

        if (StringUtils.isNotBlank(queryTimeType) && "1".equals(queryTimeType)) {
            timeRangeField = "create_time";
        }

        HashMap<String, Object> params = new HashMap<>();
        //时间类型 time_from和time_to。可用值：create_time、update_time。
        //string
        params.put("time_range_field", timeRangeField);
        //搜索时间  字段指定的最大日期范围为 15 天
        //int long类型 精确到秒 1607235072 1676260216
        params.put("time_from", posDto.getStartDate().getTime() / 1000);
        //int long类型 精确到秒 1607235072 1676519473
        params.put("time_to", posDto.getEndDate().getTime() / 1000);

        //每个结果集都作为一页条目返回。使用“page_size”过滤器控制每页（即每次调用）要检索的最大条目数。
        //此整数值用于指定要在单个数据“页”中返回的最大条目数。如果介于 1 和 100 之间，则page_size的限制。
        //int
        params.put("page_size", pageSize);
        //指定要在当前调用中返回的数据的起始条目。默认值为 “”。如果数据超过一页，则偏移量可以是开始下一次调用的某个条目。
        //string
        params.put("cursor", cursor);

        //order_status过滤器用于回收订单，每个订单仅针对每个请求。可用价值：未付款/READY_TO_SHIP/已处理/已发货/已完成/IN_CANCEL/已取消/INVOICE_PENDING
        //UNPAID/READY_TO_SHIP/PROCESSED/SHIPPED/COMPLETED/IN_CANCEL/CANCELLED/INVOICE_PENDING
        //string  READY_TO_SHIP：订单待发货  TO_CONFIRM_RECEIVE


//        //订单状态默认 READY_TO_SHIP：订单待发货 具体情况具体更改
        Integer syncType = posDto.getSyncType();
        if (syncType != null && syncType == 1) {
//            params.put("order_status", "READY_TO_SHIP");
        }
        if (syncType != null && syncType == 3) {
            params.put("order_status", "IN_CANCEL");
        }
//        //响应中的可选字段。可用值：order_status。
//        //string
//        params.put("response_optional_fields", "order_status");
        return params;
    }


    /**
     * 订单列表 初始化访问参数
     *
     * @param posDto
     * @param pageSize
     * @return
     */
    public ShopeeOrderListReqDTO getOrderListDTO(OrderSyncDTO posDto, Integer pageSize, PlatformPageCursorDto cursorDto) {
        String cursor = "";

        if (posDto.getStartDate() == null) {
            throw new RuntimeException("时间范围开始时间不能为空!");
        }

        if (posDto.getEndDate() == null) {
            throw new RuntimeException("时间范围结束时间不能为空！");
        }

        if (cursorDto != null && StringUtils.isNotBlank(cursorDto.getNextCursor())) {
            cursor = cursorDto.getNextCursor();
        } else {
            cursor = "0";
        }
        //1指代创建时间 create_time 2.指代更新时间 update_time
        String queryTimeType = posDto.getTimeType().toString();

        //默认时更新时间
        String timeRangeField = "update_time";

        if (StringUtils.isNotBlank(queryTimeType) && "1".equals(queryTimeType)) {
            timeRangeField = "create_time";
        }

        ShopeeOrderListReqDTO reqDTO = new ShopeeOrderListReqDTO();
        //时间类型 time_from和time_to。可用值：create_time、update_time。
        //string
//        params.put("time_range_field", timeRangeField);
        reqDTO.setTime_range_field(timeRangeField);
        //搜索时间  字段指定的最大日期范围为 15 天
        //int long类型 精确到秒 1607235072 1676260216
//        params.put("time_from", posDto.getStartDate().getTime() / 1000);
        reqDTO.setTime_from(posDto.getStartDate().getTime() / 1000);
        //int long类型 精确到秒 1607235072 1676519473
//        params.put("time_to", posDto.getEndDate().getTime() / 1000);
        reqDTO.setTime_to(posDto.getEndDate().getTime() / 1000);

        //每个结果集都作为一页条目返回。使用“page_size”过滤器控制每页（即每次调用）要检索的最大条目数。
        //此整数值用于指定要在单个数据“页”中返回的最大条目数。如果介于 1 和 100 之间，则page_size的限制。
        //int
//        params.put("page_size", pageSize);
        reqDTO.setPage_size(pageSize);
        //指定要在当前调用中返回的数据的起始条目。默认值为 “”。如果数据超过一页，则偏移量可以是开始下一次调用的某个条目。
        //string
//        params.put("cursor", cursor);
        reqDTO.setCursor(cursor);

        //order_status过滤器用于回收订单，每个订单仅针对每个请求。可用价值：未付款/READY_TO_SHIP/已处理/已发货/已完成/IN_CANCEL/已取消/INVOICE_PENDING
        //UNPAID/READY_TO_SHIP/PROCESSED/SHIPPED/COMPLETED/IN_CANCEL/CANCELLED/INVOICE_PENDING
        //string  READY_TO_SHIP：订单待发货  TO_CONFIRM_RECEIVE


//        //订单状态默认 READY_TO_SHIP：订单待发货 具体情况具体更改
        Integer syncType = posDto.getSyncType();
        if (syncType != null && syncType == 1) {
//            params.put("order_status", "READY_TO_SHIP");
        }
        if (syncType != null && syncType == 3) {
//            params.put("order_status", "IN_CANCEL");
            reqDTO.setOrder_status("IN_CANCEL");
        }
//        //响应中的可选字段。可用值：order_status。
//        //string
//        params.put("response_optional_fields", "order_status");
        return reqDTO;
    }

    /**
     * 订单列表 初始化访问参数
     *
     * @param orderNo
     * @return
     */
    public HashMap<String, Object> getOrderDetailDto(String orderNo) {
        HashMap<String, Object> params = new HashMap<>();
        //order_sn_list order_sn集。如果有多个order_sn，则需要使用英文逗号将它们连接起来。限制 [1，50]
        List<String> longs1 = Arrays.asList(orderNo);
        String orderSnList = longs1.stream()
                .collect(Collectors.joining(","));
        params.put("order_sn_list", orderSnList);

        //添加响应字段
        List<String> longs2 = Arrays.asList(
                "order_sn",
                "region",
                "currency",
                "cod",
                "total_amount",
                "order_status",
                "shipping_carrier",
                "payment_method",
                "estimated_shipping_fee",
                "message_to_seller",
                "create_time",
                "update_time",
                "days_to_ship",
                "ship_by_date",
                "buyer_user_id",
                "buyer_username",
                "recipient_address",
                "actual_shipping_fee",
                "goods_to_declare",
                "note",
                "note_update_time",
                "item_list",
                "pay_time",
                "dropshipper",
                "dropshipper_phone",
                "split_up",
                "buyer_cancel_reason",
                "cancel_by",
                "cancel_reason",
                "actual_shipping_fee_confirmed",
                "buyer_cpf_id",
                "fulfillment_flag",
                "pickup_done_time",
                "package_list",
                "invoice_data",
                "checkout_shipping_carrier",
                "reverse_shipping_fee",
                "order_chargeable_weight_gram",
                "edt_from",
                "edt_to",
                "prescription_images",
                "prescription_check_status"
        );
        String responseOptionalFields = longs2.stream()
                .collect(Collectors.joining(","));
        params.put("response_optional_fields", responseOptionalFields);
        return params;
    }


    public ShopeeOrderDetailReqDTO getOrderDetailDTO(String orderNo) {
        ShopeeOrderDetailReqDTO reqDTO = new ShopeeOrderDetailReqDTO();
        //order_sn_list order_sn集。如果有多个order_sn，则需要使用英文逗号将它们连接起来。限制 [1，50]
        List<String> longs1 = Arrays.asList(orderNo);
        String orderSnList = longs1.stream()
                .collect(Collectors.joining(","));
//        params.put("order_sn_list", orderSnList);
        reqDTO.setOrder_sn_list(orderSnList);
        //添加响应字段
        List<String> longs2 = Arrays.asList(
                "order_sn",
                "region",
                "currency",
                "cod",
                "total_amount",
                "order_status",
                "shipping_carrier",
                "payment_method",
                "estimated_shipping_fee",
                "message_to_seller",
                "create_time",
                "update_time",
                "days_to_ship",
                "ship_by_date",
                "buyer_user_id",
                "buyer_username",
                "recipient_address",
                "actual_shipping_fee",
                "goods_to_declare",
                "note",
                "note_update_time",
                "item_list",
                "pay_time",
                "dropshipper",
                "dropshipper_phone",
                "split_up",
                "buyer_cancel_reason",
                "cancel_by",
                "cancel_reason",
                "actual_shipping_fee_confirmed",
                "buyer_cpf_id",
                "fulfillment_flag",
                "pickup_done_time",
                "package_list",
                "invoice_data",
                "checkout_shipping_carrier",
                "reverse_shipping_fee",
                "order_chargeable_weight_gram",
                "edt_from",
                "edt_to",
                "prescription_images",
                "prescription_check_status"
        );
        String responseOptionalFields = longs2.stream()
                .collect(Collectors.joining(","));
//        params.put("response_optional_fields", responseOptionalFields);
        reqDTO.setResponse_optional_fields(responseOptionalFields);
        return reqDTO;
    }

    /**
     * 获取订单list
     *
     * @param responseJson
     * @return
     */
    private List<PlatformSyncInfoResponseVO<TbOrder>> getOrders(JSONObject responseJson) {
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        JSONArray ordersJosn = Optional.ofNullable(responseJson).map(p -> p.getJSONObject("response")).map(p -> p.getJSONArray("order_list")).orElse(null);

        if (CollectionUtils.isEmpty(ordersJosn)) {
            return orderList;
        }
        for (int i = 0; i < ordersJosn.size(); i++) {
            JSONObject jsonObject = ordersJosn.getJSONObject(i);
            String orderSn = jsonObject.getString("order_sn");
            TbOrder order = new TbOrder();
            order.setOrderNo(orderSn);

            PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
            response.setInfo(order);
            response.setJsonObj(jsonObject);
            orderList.add(response);
        }
        return orderList;
    }

    private TbOrder getOrder(TbOrder order, JSONObject baseJson) {

        //订单号
        String orderSn = baseJson.getString("order_sn");
        //创建订单的日期和时间的时间戳 --> 商品总售价
        Long createTime = baseJson.getLong("create_time");
        /**
         * 发货时间
         * 虾皮没有这个字段
         */
        /**
         * 交货截止时间
         * ship_by_date 默认返回。寄出包裹的截止日期。
         */
        //交货截止时间
        Long shipByDate = baseJson.getLong("ship_by_date");
        if (shipByDate != null && shipByDate == 0) {
            throw new OrderException("交货截止时间为0");
        }
        //平台订单状态 --> 平台订单状态
//        jsonKeyObject.put("order_status", "platformOrderStatus");
        //order_status
        String orderStatus = baseJson.getString("order_status");
        //付款时间
        Long payTime = baseJson.getLong("pay_time");

        if (createTime != null) {

            order.setOrderTime(new Date(createTime * 1000));
        }
        if (shipByDate != null) {
            order.setDeliveryDeadlineTime(new Date(shipByDate * 1000));
        }
        if (payTime != null) {
            order.setPaymentTime(new Date(payTime * 1000));
        }
        //如果付款时间不存在  使用订单创建时间作为付款时间
        if (order.getPaymentTime() == null) {
            order.setPaymentTime(new Date(createTime * 1000));
        }

        order.setOrderDetail(baseJson);

        order.setTransactionNo(orderSn);

        order.setPlatformOrderStatus(0);
        return order;
    }

    private TbOrderBuyerInfo getOrderBuyerInfo(JSONObject baseJson, TbOrder order) {
        TbOrderBuyerInfo orderBuyer = new TbOrderBuyerInfo();

        //buyer_user_id 此订单买家的用户ID
        String buyerId = baseJson.getString("buyer_user_id");
        if (StringUtils.isNotBlank(buyerId)) {
            buyerId = buyerId.trim();
        }
        orderBuyer.setBuyerId(buyerId);
        //buyer_username 买家姓名
        String buyerNickName = baseJson.getString("buyer_username");
        if (StringUtils.isNotBlank(buyerNickName)) {
            buyerNickName = buyerNickName.trim();
        }
        orderBuyer.setBuyerName(buyerNickName);

        orderBuyer.setOrderNo(order.getOrderNo());

        return orderBuyer;
    }

    private TbOrderCostDetail getOrderCostDetail(JSONObject baseJson) {
        return shopeeOrderUtils.getOrderCostDetail(baseJson);
    }

    private List<TbWaybill> getWaybills(JSONObject baseJson, String orderNo, String regionAll) {
        //checkout_shipping_carrier 对于非屏蔽订单，指买家为订单选择的用于配送商品的物流服务提供商。对于屏蔽订单，买方为订单选择的用于交付物料的物流服务类型
        String checkoutShippingCarrier = baseJson.getString("checkout_shipping_carrier");

        JSONArray packageListJson = baseJson.getJSONArray("package_list");

        Long logisticsModeId = null;

        if (StringUtils.isNotBlank(checkoutShippingCarrier)) {
            logisticsModeId = getLogisticsModeId("Shopee", checkoutShippingCarrier);
        }

        List<TbWaybill> waybills = new ArrayList<>();
        for (int i = 0; i < packageListJson.size(); i++) {
            JSONObject jsPackage = packageListJson.getJSONObject(i);
            String packageNumber = jsPackage.getString("package_number");
            String shippingCarrier = jsPackage.getString("shipping_carrier");
            JSONArray itemListJs = jsPackage.getJSONArray("item_list");

            Long logisticsModeIdTemp = getLogisticsModeId("Shopee", shippingCarrier);

            TbWaybill tbWaybill = orderWaybillUtils.generateNewWaybill();

            tbWaybill.setOrderNo(orderNo);
            tbWaybill.setWaybillExternalId(packageNumber);
            //买家自选物流
            tbWaybill.setBuyerOptionalLogistics(shippingCarrier);
            //默认设置为0 正式插入时获取
            tbWaybill.setParcelNo(BigInteger.ZERO);
            //平台 物流服务提供商
            tbWaybill.setCheckoutShippingCarrier(checkoutShippingCarrier);

            if (logisticsModeIdTemp != null) {
                tbWaybill.setLogisticsModeId(logisticsModeIdTemp);
            } else {
                tbWaybill.setLogisticsModeId(logisticsModeId);
            }

            waybills.add(tbWaybill);

            List<TbOrderProducts> orderProductsList = new ArrayList<>();
            for (int j = 0; j < itemListJs.size(); j++) {
                JSONObject jsItem = itemListJs.getJSONObject(j);
                Long itemId = jsItem.getLong("item_id");
                Integer modelQuantity = jsItem.getInteger("model_quantity");
                Long modelId = jsItem.getLong("model_id");

                TbOrderProducts orderProducts = new TbOrderProducts();
                //订单编号
                orderProducts.setOrderNo(orderNo);
                orderProducts.setProductId(itemId);
                orderProducts.setPlatformSkuId(modelId);
                orderProducts.setNumber(modelQuantity);
                //成本价格
                orderProducts.setCostPrice(BigDecimal.ZERO);
                //商品类型
                orderProducts.setProductType(1);
                orderProductsList.add(orderProducts);
            }
            tbWaybill.setProducts(orderProductsList);
        }
        return waybills;
    }

    private TbWaybillSite getWaybillSite(JSONObject baseJson, String regionAll, PlatformSyncDTO psDTO, String orderNo) {
        //recipient_address 此对象包含收件人地址的详细细分。
        JSONObject recipientAddress = baseJson.getJSONObject("recipient_address");

        //地址的收件人姓名。
        //string
        String name = recipientAddress.getString("name");
        //下订单时输入的收件人电话号码。
        //string
        String phone = recipientAddress.getString("phone");
        //收件人地址所在的城镇。是否有城镇将取决于地区和/或国家。
        //string
        String town = recipientAddress.getString("town");
        //收件人地址所在的地区。是否有地区将取决于地区和/或国家。
        //string
        String district = recipientAddress.getString("district");

        //收件人地址所在的城市。是否有城市将取决于地区和/或国家。
        //string
        String city = recipientAddress.getString("city");
        //收件人地址的州/省。是否有州/省将取决于地区和/或国家
        //string
        String state = recipientAddress.getString("state");


        //表示收件人所在区域的两位代码。
        //string
        String region = recipientAddress.getString("region");
        //收件人的邮政编码。
        //string
        String zipcode = recipientAddress.getString("zipcode");
        //收件人的完整地址，包括国家、州、甚至街道等。
        //string
        String fullAddress = recipientAddress.getString("full_address");

        TbWaybillSite waybillSite = new TbWaybillSite();
        if (StringUtils.isNotBlank(name)) {
            waybillSite.setFirstName(name);
        }
        if (StringUtils.isNotBlank(phone)) {
            waybillSite.setPhone(phone);
//            waybillSite.setMobile(phone);
        }
        if (StringUtils.isNotBlank(zipcode)) {
            waybillSite.setPostcode(zipcode);
        }
        if (StringUtils.isNotBlank(region)) {
            waybillSite.setCountry(region);
        }
        waybillSite.setCountry(regionAll);
        if (StringUtils.isNotBlank(state)) {
            waybillSite.setProvinceOrState(state);
        }

        if (StringUtils.isNotBlank(city)) {
            waybillSite.setCity(city);
        }

        if (StringUtils.isNotBlank(fullAddress)) {
            waybillSite.setDetailedAddress(fullAddress);
        }
        waybillSite.setSiteStatus(0);
        //地址二次更新
//        upWaybillSite(psDTO,baseJson,orderNo,waybillSite);
        return waybillSite;
    }

    private List<TbWaybillTrack> getOrderTrackInfoList(JSONObject baseJson) {
        List<TbWaybillTrack> waybillTracks = new ArrayList<>();
        return waybillTracks;
    }

    private List<TbOrderProducts> getOrderProductsList(JSONObject baseJson, TbOrder order, List<TbWaybill> waybills) {
        String orderNo = order.getOrderNo();
        List<TbOrderProducts> opTemps = new ArrayList<>();
        JSONArray array = baseJson.getJSONArray("item_list");
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                //虾皮对商品的唯一标识符。
                //int
                Long itemId = jsonObject.getLong("item_id");
                //项的名称。
                //string
                String itemName = jsonObject.getString("item_name");
                //商品 SKU（库存单位）是由卖家定义的标识符，有时称为父 SKU。商品SKU可以分配给虾皮商品信息中的商品。
                //string
                String itemSku = jsonObject.getString("item_sku");

                //属于同一项目的模型的 ID。
                //int
                Long modelId = jsonObject.getLong("model_id");
                //属于同一项目的模型的名称。卖家可以提供同一商品的型号。
                // 例如，卖家可以为 T 恤设计创建一个固定价格的列表，并提供不同颜色和尺寸的衬衫。
                // 在这种情况下，每种颜色和尺寸组合都是单独的模型。每个型号可以有不同的数量和价格。
                //string
                String modelName = jsonObject.getString("model_name");
                //模型 SKU（库存单位）是由卖家定义的标识符。它仅供卖方使用。
                // 许多卖家将SKU分配给特定类型，尺寸和颜色的商品，这些商品是Shopee列表中一件商品的型号。
                //string
                String modelSku = jsonObject.getString("model_sku");
                //同一买家从一个商品/商品中同时购买的相同商品的数量。
                //int
                Integer modelQuantityPurchased = jsonObject.getInteger("model_quantity_purchased");
                // 商品的原始价格（以发布货币表示）
                //float
                BigDecimal modelOriginalPrice = jsonObject.getBigDecimal("model_original_price");
                //商品的折扣后价格（以列表货币表示）。如果没有折扣，此值将与model_original_price相同。
                // 如果是捆绑促销商品，此值将返回 0，因为根据设计，捆绑商品促销折扣不会细分到商品/型号级别。
                // 由于技术限制，如果我们未将其配置为 0，则该值将返回捆绑交易之前的价格。
                // 如果您想计算捆绑交易商品的商品级折扣价格，请致电 GetEscrowDetails。
                //float
                BigDecimal modelDiscountedPrice = jsonObject.getBigDecimal("model_discounted_price");
                //此值指示买方是否以批发价购买订单物料。
                //boolean
                Boolean wholesale = jsonObject.getBoolean("wholesale");
                //物品的重量
                //float
                Double weight = jsonObject.getDouble("weight");
                //指示此项目是否属于附加交易。
                //boolean
                Boolean add_on_deal = jsonObject.getBoolean("add_on_deal");
                //指示此项是主项还是子项。True 表示主项，False 表示子项。
                //boolean
                Boolean main_item = jsonObject.getBoolean("main_item");
                //用于区分购物车和订单中的商品组的唯一 ID。（例如附加交易）
                //int
                Long add_on_deal_id = jsonObject.getLong("add_on_deal_id");
                //可选类型：product_promotion、flash_sale、group_by、bundle_deal、add_on_deal_main、
                // add_on_deal_sub、add_on_free_gift_main、add_on_free_gift_sub
                //string
                String promotion_type = jsonObject.getString("promotion_type");
                //促销的 ID。
                //int
                Long promotion_id = jsonObject.getLong("promotion_id");
                //订单项的标识。对于同一捆绑促销中的商品，order_item_id应共享相同的 ID，例如 1，2。对于不在捆绑促销中的商品，order_item_id应与item_id相同。
                //int
                Long order_item_id = jsonObject.getLong("order_item_id");
                //产品促销的标识。
                //int
                Long promotion_group_id = jsonObject.getLong("promotion_group_id");
                //商品图片信息。
                //object
                JSONObject imageInfo = jsonObject.getJSONObject("image_info");

                //物料的仓库 ID 列表。
                //string[]
                List<String> product_location_id = jsonObject.getObject("product_location_id", List.class);
                //对于顺序中的每个项目，返回该项目是否为处方项目。
                //boolean
                Boolean is_prescription_item = jsonObject.getBoolean("is_prescription_item");
                //确定项目是否B2C_shop_item。
                //boolean
                Boolean is_b2c_owned_item = jsonObject.getBoolean("is_b2c_owned_item");

                TbOrderProducts orderProducts = new TbOrderProducts();
                //订单编号
                orderProducts.setOrderNo(orderNo);
                orderProducts.setProductId(itemId);
                orderProducts.setShopSku(modelSku);
                orderProducts.setProductEnName(itemName);
                orderProducts.setProperty(modelName);
                orderProducts.setBasisWeight(weight);
                orderProducts.setNumber(modelQuantityPurchased);
                //原价
                orderProducts.setUnitPrice(modelOriginalPrice);
                //成本价格
                orderProducts.setCostPrice(BigDecimal.ZERO);
                //商品类型
                orderProducts.setProductType(1);
                orderProducts.setPlatformSkuId(modelId);
                if (imageInfo != null) {
                    orderProducts.setGoodsImgeUrl(imageInfo.getString("image_url"));
                }
                opTemps.add(orderProducts);
            }

        }
        Map<Long, TbOrderProducts> opMap = opTemps.stream().collect(Collectors.toMap(TbOrderProducts::getPlatformSkuId, o -> o, (oldValue, newValue) -> newValue));
        List<TbOrderProducts> orderProductsList = new ArrayList<>();
        for (TbWaybill waybill : waybills) {
            List<TbOrderProducts> products = waybill.getProducts();
            for (TbOrderProducts product : products) {
                TbOrderProducts opTemp = opMap.get(product.getPlatformSkuId());

                product.setShopSku(opTemp.getShopSku());
                product.setProductEnName(opTemp.getProductEnName());
                product.setProperty(opTemp.getProperty());
                product.setBasisWeight(opTemp.getBasisWeight());
                //原价
                product.setUnitPrice(opTemp.getUnitPrice());
                //成本价格
                product.setCostPrice(BigDecimal.ZERO);
                //商品类型
                product.setProductType(1);
                product.setGoodsImgeUrl(opTemp.getGoodsImgeUrl());
//                product.setNumber();
                orderProductsList.add(product);
            }
        }
        return orderProductsList;
    }

    /**
     * 获取订单同步 运行日志
     *
     * @param order
     * @param tbPlatform
     */
    public TbOrderLog getOrderOperateLog(TbOrder order, TbPlatform tbPlatform, String operator, String type) {
        String operateProperty = "";
        String description = "";
        String logType = "";
        if ("1".equals(type)) {
            logType = "导入订单";
            description = "平台导入信息";
        }
        if ("2".equals(type)) {
            logType = "更新订单";
            description = "平台更新信息";
        }
        TbOrderLog vo = new TbOrderLog();
        vo.setOrderNo(order.getOrderNo());
        if ("sys".equals(operator)) {
            operateProperty = "系统" + logType;
        } else {
            operateProperty = "手动" + logType;
        }
        vo.setOperateProperty(operateProperty);
        vo.setDescription(tbPlatform.getPlatformName() + description);
        vo.setOperator(operator);
        vo.setOperateTime(new Date());

        return vo;
    }

    /**
     * 获取订单同步 运行日志
     */
    public TbOrderLog getOrderOperateLog(String orderNo, String platformName, String operator, String type) {
        String operateProperty = "";
        String description = "";
        String logType = "";
        if ("1".equals(type)) {
            logType = "导入订单";
            description = "平台导入信息";
        }
        if ("2".equals(type)) {
            logType = "更新订单";
            description = "平台更新信息";
        }
        TbOrderLog vo = new TbOrderLog();
        vo.setOrderNo(orderNo);
        if ("sys".equals(operator)) {
            operateProperty = "系统" + logType;
        } else {
            operateProperty = "手动" + logType;
        }
        vo.setOperateProperty(operateProperty);
        vo.setDescription(platformName + description);
        vo.setOperator(operator);
        vo.setOperateTime(new Date());

        return vo;
    }

    /**
     * 判断产品是否妥投
     *
     * @param waybills
     * @param orderTrackInfos
     */
    private void isDelivered(List<TbWaybill> waybills, List<TbWaybillTrack> orderTrackInfos) {
        if (CollectionUtils.isEmpty(waybills)) {
            return;
        }
        if (CollectionUtils.isEmpty(orderTrackInfos)) {
            return;
        }
        Map<String, List<TbWaybillTrack>> orderTrackInfosMap = orderTrackInfos.stream().collect(Collectors.groupingBy(TbWaybillTrack::getWaybillNo));
        for (TbWaybill waybill : waybills) {
            List<TbWaybillTrack> tbWaybillTracks = orderTrackInfosMap.get(waybill.getWaybillNo());
            if (CollectionUtils.isEmpty(tbWaybillTracks)) {
                continue;
            }
            //info信息不为空 并且包含delivered单词  则已经妥投
            boolean isDelivered = tbWaybillTracks.stream().anyMatch(p -> WaybillUtils.isDelivered(p.getInfo()));
            if (isDelivered) {
                waybill.setIsDelivered(1);
            } else {
                waybill.setIsDelivered(2);
            }
        }
    }

    /**
     * 获取物流方式id
     */
    private Long getLogisticsModeId(String facilitatorCode, String channelName) {
        TbLogisticsMode logisticsMode = logModeService.selectLogisticsModeByFacilitatorCodeAndChannelName(facilitatorCode, channelName);
        if (Objects.nonNull(logisticsMode)) {
            return logisticsMode.getId();
        }
        return null;
    }

    /**
     * 订单是否同步判断
     */
    private Integer isSync(JSONObject baseJson) {
        Integer sync = -1;
        //order_status
        //卖家已经操作发货
        String orderStatus = baseJson.getString("order_status");
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("PROCESSED")) {
            sync = 1;
        }
        //订单待发货
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("READY_TO_SHIP")) {
            sync = 1;
        }
        //3pl揽收失败，需要重新重新发货
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("RETRY_SHIP")) {
            sync = 1;
        }
        //买家提交取消申请待处理
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("IN_CANCEL")) {
            sync = 1;
        }
        return sync;
    }


    private JSONObject getOrderList(TbShop shopDO, OrderSyncDTO posDto, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        ShopeeAppClientDTO scDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
        ShopeeOrderListReqDTO reqDTO = getOrderListDTO(posDto, pageSize, cursorDto);
        ShopeeOrderListRespVO respVO = shopeeOrderCallService.getOrderList(scDTO, reqDTO);
        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        return jsonObject;
    }

    private JSONObject getOrderDetail(TbShop shopDO, String orderNo) throws Exception {
        ShopeeAppClientDTO scDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
        ShopeeOrderDetailReqDTO reqDTO = getOrderDetailDTO(orderNo);
        ShopeeOrderDetailRespVO respVO = shopeeOrderCallService.getOrderDetail(scDTO, reqDTO);
        JSONObject jsonObject = FastJsonUtil.parseJson(respVO.getRespBody());
        return jsonObject;
    }
}
