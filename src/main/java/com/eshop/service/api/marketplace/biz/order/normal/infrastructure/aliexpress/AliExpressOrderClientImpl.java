package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.aliexpress;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.service.api.marketplace.order.call.aliexpress.AeOrderCallService;
import com.eshop.api.modules.util.shop.PlatformAppClientUtils;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.api.marketplace.order.dto.AeOrderDetailReqDTO;
import com.eshop.modal.entry.api.marketplace.order.dto.AeOrderListReqDTO;
import com.eshop.modal.entry.api.marketplace.order.vo.*;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.DateUtil;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.utils.order.AeOrderUtils;
import com.eshop.util.platform.utils.status.AeStatusUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ldj
 * @date 2024/3/18 14:19
 * @Description: ...
 * @Version 1.0
 */
@StrategyKey(ConstantPlatform.AE)
@Service
public class AliExpressOrderClientImpl implements AliExpressOrderClient {

    @Resource
    private AeOrderCallService aeOrderCallService;

    @Resource
    private AeStatusUtils aeStatusUtils;

    @Resource
    private AeOrderUtils aeOrderUtils;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private OrderWaybillUtils orderWaybillUtils;

    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize) throws Exception {
        TbShop shopDO = dto.getShop();
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeOrderListReqDTO queryReqDTO = getListReqDTO(osDTO, pageNo, pageSize);
        AeOrderListRespVO respVO = aeOrderCallService.getOrderList(acDTO, queryReqDTO);
        Integer total_item = respVO.getTotal_count();

        if (total_item == null || total_item == 0) {
            total_item = 1;
        }
        return new PageUtil(pageSize, total_item);
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = dto.getShop();
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeOrderListReqDTO queryReqDTO = getListReqDTO(osDTO, pageNo, pageSize);
        AeOrderListRespVO respVO = aeOrderCallService.getOrderList(acDTO, queryReqDTO);
        String respBody = respVO.getRespBody();
        List<AeOrderListVO> orderListVOS = respVO.getTarget_list();
        JSONObject respJson = JSONObject.parseObject(respBody);
        if (orderListVOS == null || orderListVOS.size() == 0) {
            return null;
        }
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getAeOrderList(orderListVOS);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(respJson);
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public TbOrderInfo getAddOrderDetailSync(PlatformSyncDTO psDTO, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbShop shopDO = psDTO.getShop();
        TbPlatform platform = psDTO.getPlatform();
        String operator = psDTO.getCreator();
        TbOrder order = po.getInfo();
        String orderNo = order.getOrderNo();

        AeOrderDetailRespVO baseJson = getBaseJson(shopDO, orderNo);
        AeOrderDetailVO odVO = baseJson.getTarget();
        JSONObject odJson = odVO.getOdJson();

        //商品信息 json
        JSONArray opArrJson = odVO.getOpArrJson();
        AeOrderDetailBuyerInfoVO biVO = odVO.getBuyer_info();
        //订单状态
        String order_status = odVO.getOrder_status();
        //订单结束原因
        String orderEndReason = odVO.getOrder_end_reason();

        String region = biVO.getCountry();
        TbOrderInfo orderInfo = new TbOrderInfo();
        //主表
        order = handleAeOrderDetail(orderNo, order, odVO);
        //买家下单留言
        String buyerMemo = getBuyerMemo(odVO);
        if (StringUtils.isNotBlank(buyerMemo)) {
            order.setPlatformMessage(buyerMemo);
        }
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(orderNo, odVO));
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(orderNo, platform.getPlatformName(), operator, "1"));
//        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(orderNo, odVO));
//        //运单表
        orderInfo.setWaybills(getWaybills(orderNo, odVO));
        //运单地址表
        orderInfo.setWaybillSite(getWaybillSite(orderNo, odVO));
        //买家信息装配 买家信息补充
        orderInfo.getOrderBuyer().setCountry(orderInfo.getWaybillSite().getCountry());
        //订单商品信息
        List<TbOrderProducts> opDOS = getOrderProductsList(orderNo, odVO);
        orderInfo.setOrderProducts(opDOS);

        if (odJson != null) {
            orderInfo.setOrderDetailRespJson(odJson.toJSONString());
        }
        if (opArrJson != null) {
            orderInfo.setOrderProductRespJson(opArrJson.toJSONString());
        }
        //订单号
        orderInfo.setOrderNo(orderNo);


        String orderStatusStr = order_status;
        //erp 状态处理转化
        Integer platformOrderStatus = aeStatusUtils.getPlatformOrderStatus(orderStatusStr);
        String platformOrderStatusStr = aeStatusUtils.getPlatformOrderStatusStr(orderStatusStr);
        String abnormalCause = aeStatusUtils.getAbnormalCause(Integer.valueOf(orderStatusStr));
        List<Long> orderTypeMiddles = aeStatusUtils.getOrderTypeMiddles(orderStatusStr, orderInfo, orderEndReason, true);

        order.setPlatformOrderStatus(platformOrderStatus);
        if (ObjectUtil.isNotEmpty(abnormalCause)) {
            orderInfo.setAbnormalCause(abnormalCause);
        }
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //是否同步判断
        orderInfo.setIsSync(isSync(odVO, orderStatusStr));
        //不同步原因
        if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
            orderInfo.setSyncNotMsg("订单状态+" + platformOrderStatusStr);

        }
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDTO, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = psDTO.getShop();
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeOrderListReqDTO queryReqDTO = getListReqDTO(osDTO, pageNo, pageSize);
        AeOrderListRespVO respVO = aeOrderCallService.getOrderList(acDTO, queryReqDTO);
        String respBody = respVO.getRespBody();
        List<AeOrderListVO> orderListVOS = respVO.getTarget_list();
        JSONObject respJson = JSONObject.parseObject(respBody);
        if (orderListVOS == null || orderListVOS.size() == 0) {
            return null;
        }
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = getAeOrderList(orderListVOS);
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(respJson);
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public TbOrderInfo getUpdateOrderDetailSync(PlatformSyncDTO psDTO, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        TbShop shopDO = psDTO.getShop();
        TbOrder o = po.getInfo();
        String orderNo = o.getOrderNo();
        //获取订单详情
        AeOrderDetailRespVO respVO = getBaseJson(shopDO, orderNo);
        AeOrderDetailVO target = respVO.getTarget();
        //平台订单状态 原生
        String orderStatusStr = target.getOrder_status();
        return getUpOrderInfoLevel1(psDTO, orderNo, orderStatusStr, target);
    }

    private TbOrderInfo getUpOrderInfoLevel1(PlatformSyncDTO psDTO, String orderNo, String orderStatusStr, AeOrderDetailVO target) {
        TbOrder order = new TbOrder();
        order.setOrderNo(orderNo);
        order.setTransactionNo(orderNo);
        order.setPlatformOrderStatus(aeStatusUtils.getPlatformOrderStatus(orderStatusStr));

        TbOrderInfo upOrderInfo = getUpOrderInfoLevel2(psDTO, order, orderStatusStr, target);
        return upOrderInfo;
    }

    private TbOrderInfo getUpOrderInfoLevel2(PlatformSyncDTO psDTO, TbOrder order, String orderStatusStr, AeOrderDetailVO target) {
        String platformName = psDTO.getPlatform().getPlatformName();
        String operator = psDTO.getCreator();
        String orderNo = order.getOrderNo();
        JSONObject odJson = target.getOdJson();
        String orderEndReason = target.getOrder_end_reason();
        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(orderNo, platformName, operator, "2"));
        //订单号
        orderInfo.setOrderNo(orderNo);
        //erp 状态处理转化
        Integer platformOrderStatus = aeStatusUtils.getPlatformOrderStatus(orderStatusStr);
        String platformOrderStatusStr = aeStatusUtils.getPlatformOrderStatusStr(orderStatusStr);
        String abnormalCause = aeStatusUtils.getAbnormalCause(platformOrderStatus);
        List<Long> orderTypeMiddles = aeStatusUtils.getOrderTypeMiddles(orderStatusStr, orderInfo, orderEndReason, false);

        if (orderInfo.getOrderLogs() != null && StringUtils.isNotBlank(platformOrderStatusStr)) {
            orderInfo.getOrderLogs().setDescription(platformOrderStatusStr);
        }

        orderInfo.setPlatformOrderStatus(platformOrderStatus);
        if (ObjectUtil.isNotEmpty(abnormalCause)) {
            orderInfo.setAbnormalCause(abnormalCause);
        }
        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //订单详情原始数据
        if (odJson != null) {
            orderInfo.setOrderDetailRespJson(odJson.toJSONString());
        }
        //订单信息补充
        orderInfo.setOrder(order);
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        return null;
    }

    @Override
    public TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo) throws Exception {
        return null;
    }

    private AeOrderListReqDTO getListReqDTO(OrderSyncDTO osDto, Integer pageNo, Integer pageSize) {
        if (osDto.getStartDate() == null) {
            throw new RuntimeException("时间范围开始时间不能为空!");
        }

        if (osDto.getEndDate() == null) {
            throw new RuntimeException("时间范围结束时间不能为空！");
        }
        String startTimeStr = DateUtil.format(osDto.getStartDate());
        String endTimeStr = DateUtil.format(osDto.getEndDate());
        //create_date_end	String	否	订单创建时间结束值，格式: yyyy-MM-dd hh:MM:ss,如2015-07-10 00:00:00 倘若时间维度未精确到时分秒，故该时间条件筛选不许生效。此入参时间为美国太平洋时间。
        String create_date_end = endTimeStr;
        //create_date_start	String	否	订单创建时间起始值，格式: yyyy-MM-dd hh:MM:ss,如2015-07-09 00:00:00 倘若时间维度未精确到时分秒，故该时间条件筛选不许生效。此入参为美国太平洋时间。
        String create_date_start = startTimeStr;
        //current_page	Number	是	当前页码
        Integer current_page = pageNo;
        //page_size	Number	是	每页订单数，最大50
        Integer page_size = pageSize;
        //order_status_list	Object[]	否	查询多个订单状态下的订单信息，具体订单状态见order_status详情。
        List<String> order_status_list = aeStatusUtils.getOrderStatusList();
        //order_status	String	否	订单状态： PLACE_ORDER_SUCCESS:等待买家付款; IN_CANCEL:买家申请取消; WAIT_SELLER_SEND_GOODS:等待您发货; SELLER_PART_SEND_GOODS:部分发货; WAIT_BUYER_ACCEPT_GOODS:等待买家收货; FUND_PROCESSING:买家确认收货后，等待退放款处理的状态; FINISH:已结束的订单; IN_ISSUE:含纠纷的订单; IN_FROZEN:冻结中的订单; WAIT_SELLER_EXAMINE_MONEY:等待您确认金额; RISK_CONTROL:订单处于风控24小时中，从买家在线支付完成后开始，持续24小时。
        String order_status = null;
        //modified_date_end	String	否	订单修改时间结束值，格式: yyyy-mm-dd hh:mm:ss。此时间为美国太平洋时间
        String modified_date_end = endTimeStr;
        //modified_date_start	String	否	订单修改时间起始值 格式: yyyy-mm-dd hh:mm:ss 需要加上createdate控制查询范围。可查询时间范围；默认180天，查询已结束订单为30天。此时间为美国太平洋时间
        String modified_date_start = startTimeStr;

        AeOrderListReqDTO queryReqDTO = new AeOrderListReqDTO();
        //分页
        queryReqDTO.setCurrent_page(current_page);
        queryReqDTO.setPage_size(page_size);
        //时间
        queryReqDTO.setCreate_date_end(create_date_end);
        queryReqDTO.setCreate_date_start(create_date_start);
        queryReqDTO.setModified_date_end(modified_date_end);
        queryReqDTO.setModified_date_start(modified_date_start);
        //订单状态
        queryReqDTO.setOrder_status_list(order_status_list);
        queryReqDTO.setOrder_status(order_status);
        return queryReqDTO;
    }

    private List<PlatformSyncInfoResponseVO<TbOrder>> getAeOrderList(List<AeOrderListVO> orderListVOS) {
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        for (AeOrderListVO orderListVO : orderListVOS) {
            //order订单VO json
            JSONObject orderJson = orderListVO.getOrderJson();
            //order订单id
            String orderNo = orderListVO.getOrderNo();
            TbOrder order = new TbOrder();
            order.setOrderNo(orderNo);

            PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
            response.setInfo(order);
            response.setJsonObj(orderJson);
            orderList.add(response);
        }
        return orderList;
    }

    private AeOrderDetailRespVO getBaseJson(TbShop shopDO, String orderNo) throws Exception {
        Long order_id = null;
        if (ObjectUtil.isNotEmpty(orderNo)) {
            order_id = Long.valueOf(orderNo);
        }
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeOrderDetailReqDTO reqDTO = new AeOrderDetailReqDTO();
        reqDTO.setOrder_id(order_id);
        //api请求
        AeOrderDetailRespVO odRespVO = aeOrderCallService.getOrderDetail(acDTO, reqDTO);
        return odRespVO;
    }

    private TbOrder handleAeOrderDetail(String orderNo, TbOrder orderOld, AeOrderDetailVO odVO) {
        //拷贝orderOld
        TbOrder order = new TbOrder();
        BeanUtils.copyProperties(orderOld, order);
        //订单号
        String orderSn = odVO.getOrderNo();
        //订单状态
        String order_status = odVO.getOrder_status();
        JSONObject odJson = odVO.getOdJson();
        //订单创建时间
        String gmt_create = odVO.getGmt_create();
        //订单修改时间
        String gmt_modified = odVO.getGmt_modified();
        //支付成功时间
        String gmt_pay_success = odVO.getGmt_pay_success();
        //订单结束时间
        String gmt_trade_end = odVO.getGmt_trade_end();
        //当前状态超时日期
        String over_time_left = odVO.getOver_time_left();

        String oaid = odVO.getOaid();
        //订单状态
        String orderStatus = order_status;

        //订单创建时间
        if (ObjectUtil.isNotEmpty(gmt_create)) {
            order.setOrderTime(getTime(gmt_create));
        }
        //当前状态超时日期
        if (ObjectUtil.isNotEmpty(over_time_left)) {
            order.setDeliveryDeadlineTime(getTime(over_time_left));
        }
        //付款时间
        if (ObjectUtil.isNotEmpty(gmt_pay_success)) {
            order.setPaymentTime(getTime(gmt_pay_success));
        }
        //如果付款时间不存在  使用订单创建时间作为付款时间
        if (order.getPaymentTime() == null) {
            order.setPaymentTime(getTime(gmt_create));
        }
        order.setOrderDetail(odJson);
        order.setOrderNo(orderNo);
        order.setTransactionNo(oaid);

        order.setPlatformOrderStatus(0);
        return order;
    }

    private Date getTime(String dateTimeStr) {
        Long utcMillis = convertDateTimeToLong(dateTimeStr, "yyyy-MM-dd HH:mm:ss", "America/Los_Angeles");
        if (utcMillis == null) {
            return null;
        }
        return new Date(utcMillis);
    }

    public static Long convertDateTimeToLong(String dateTimeStr, String format, String timeZone) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        ZonedDateTime dateTime;
        try {
            dateTime = ZonedDateTime.parse(dateTimeStr, formatter.withZone(ZoneId.of(timeZone)));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date time format. Expected format is " + format);
        }

        ZonedDateTime utcTime = dateTime.withZoneSameInstant(ZoneId.of("UTC"));

        return utcTime.toInstant().toEpochMilli();
    }

    private TbOrderBuyerInfo getOrderBuyerInfo(String orderNo, AeOrderDetailVO odVO) {

        AeOrderDetailBuyerInfoVO buyerInfo = odVO.getBuyer_info();
        TbOrderBuyerInfo orderBuyer = new TbOrderBuyerInfo();

        //buyer_user_id 此订单买家的用户ID
        String buyerId = buyerInfo.getLogin_id();
        if (StringUtils.isNotBlank(buyerId)) {
            buyerId = buyerId.trim();
        }
        orderBuyer.setBuyerId(buyerId);
        //buyer_username 买家姓名
        String buyerNickName = buyerInfo.getFirst_name() + buyerInfo.getLast_name();
        if (StringUtils.isNotBlank(buyerNickName)) {
            buyerNickName = buyerNickName.trim();
        }
        orderBuyer.setBuyerName(buyerNickName);

        orderBuyer.setOrderNo(orderNo);

        return orderBuyer;
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

    private TbOrderCostDetail getOrderCostDetail(String orderNo, AeOrderDetailVO odVO) {
        return aeOrderUtils.getOrderCostDetail(orderNo, odVO);
    }

    private List<TbWaybill> getWaybills(String orderNo, AeOrderDetailVO odVO) {
        //获取物流方式
        List<AeOrderDetailChildOrderVO> childOrderList = odVO.getChild_order_list();
        String shippingCarrier = null;
        List<String> shippingCarriers = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(childOrderList)) {
            for (AeOrderDetailChildOrderVO aeOrderDetailChildOrderVO : childOrderList) {
                String logisticsServiceName = aeOrderDetailChildOrderVO.getLogistics_service_name();
                shippingCarriers.add(logisticsServiceName);
            }
            if (ObjectUtil.isNotEmpty(shippingCarriers)) {
                shippingCarrier = shippingCarriers.get(0);
            }
        }
        //收货地址信息
//        AeOrderDetailReceiptAddressVO raVO = odVO.getReceipt_address();
        Long logisticsModeId = null;
//        if (StringUtils.isNotBlank(checkoutShippingCarrier)) {
//            logisticsModeId = getLogisticsModeId("Aliexpress", checkoutShippingCarrier);
//        }

        List<TbWaybill> waybills = new ArrayList<>();
//        Long logisticsModeIdTemp = getLogisticsModeId("Shopee", shippingCarrier);
        Long logisticsModeIdTemp = null;

        TbWaybill tbWaybill = orderWaybillUtils.generateNewWaybill();

        tbWaybill.setOrderNo(orderNo);
        tbWaybill.setWaybillExternalId(null);
        //买家自选物流
        tbWaybill.setBuyerOptionalLogistics(shippingCarrier);
        //默认设置为0 正式插入时获取
        tbWaybill.setParcelNo(BigInteger.ZERO);
        //平台 物流服务提供商
        tbWaybill.setCheckoutShippingCarrier(shippingCarrier);

        if (logisticsModeIdTemp != null) {
            tbWaybill.setLogisticsModeId(logisticsModeIdTemp);
        } else {
            tbWaybill.setLogisticsModeId(logisticsModeId);
        }

        waybills.add(tbWaybill);
        return waybills;
    }

    private TbWaybillSite getWaybillSite(String orderNo, AeOrderDetailVO odVO) {
        //recipient_address 此对象包含收件人地址的详细细分。
        AeOrderDetailReceiptAddressVO raVO = odVO.getReceipt_address();

        //地址的收件人姓名。
        //string
        String name = raVO.getContact_person();
        //传真号
        String fax_number = raVO.getFax_number();
        //电话。
        String phone = raVO.getPhone_number();
        //手机号
        String mobile_no = raVO.getMobile_no();

        //城市
        String city = raVO.getCity();
        //省份
        String state = raVO.getProvince();

        //国家/地区
        String country = raVO.getCountry();
        //邮编
        String zipcode = raVO.getZip();
        //地址1
        String address = raVO.getAddress();
        //地址2
        String address2 = raVO.getAddress2();

        TbWaybillSite waybillSite = new TbWaybillSite();
        if (StringUtils.isNotBlank(name)) {
            waybillSite.setFirstName(name);
        }
        if (StringUtils.isNotBlank(phone)) {
            waybillSite.setPhone(phone);
        }
        if (StringUtils.isNotBlank(mobile_no)) {
            waybillSite.setMobile(mobile_no);
        }
        if (StringUtils.isNotBlank(zipcode)) {
            waybillSite.setPostcode(zipcode);
        }
        if (StringUtils.isNotBlank(country)) {
            waybillSite.setCountry(country);
        }
        if (StringUtils.isNotBlank(state)) {
            waybillSite.setProvinceOrState(state);
        }

        if (StringUtils.isNotBlank(city)) {
            waybillSite.setCity(city);
        }

        if (StringUtils.isNotBlank(address)) {
            waybillSite.setDetailedAddress(address);
        }


        if (StringUtils.isNotBlank(address2)) {
            waybillSite.setReserveAddress(address2);
        }
        waybillSite.setSiteStatus(0);
        return waybillSite;
    }

    private List<TbOrderProducts> getOrderProductsList(String orderNo, AeOrderDetailVO odVO) {
        List<AeOrderDetailChildOrderVO> coVOS = odVO.getChild_order_list();
        List<TbOrderProducts> opTemps = new ArrayList<>();
        if (ObjectUtil.isEmpty(coVOS)) {
            return null;
        }

        for (AeOrderDetailChildOrderVO coVO : coVOS) {
            //product_id	Number	商品ID
            Long product_id = coVO.getProduct_id();
            Long id = coVO.getId();
            //product_name	String	商品名称
            String product_name = coVO.getProduct_name();
            //product_count	Number	商品数量
            Integer product_count = coVO.getProduct_count();
            //sku	String	商品SKU
            String sku = coVO.getSku_code();
            //product_attributes	String	商品扩展属性，skuid等
            List<AeOrderDetailChildOrderSkuVO> skuAttrs = coVO.getSkuAttrs();
            //unit_price	Object	商品单价
            AeOrderDetailProductPriceVO product_price = coVO.getProduct_price();
            BigDecimal unitPrice = null;
            if (product_price != null && product_price.getAmount() != null) {
                unitPrice = new BigDecimal(product_price.getAmount());
            }
            String snapshotSmallPhotoPath = coVO.getSnapshot_small_photo_path();
            Long childOrderId = coVO.getChild_order_id();
            Long orderSortId = coVO.getOrder_sort_id();

            TbOrderProducts orderProducts = new TbOrderProducts();
            //订单编号
            orderProducts.setOrderNo(orderNo);
            orderProducts.setProductId(product_id);
            orderProducts.setShopSku(sku);
            orderProducts.setProductEnName(product_name);
            orderProducts.setProperty(getProperty(skuAttrs));
//                orderProducts.setBasisWeight(weight);
            orderProducts.setNumber(product_count);
            //原价
            orderProducts.setUnitPrice(unitPrice);
            //成本价格
            orderProducts.setCostPrice(BigDecimal.ZERO);
            //商品类型
            orderProducts.setProductType(1);
            orderProducts.setGoodsImgeUrl(snapshotSmallPhotoPath);

            orderProducts.setPlatformSkuId(childOrderId);
            orderProducts.setPlatformSkuIndex(orderSortId);
//                orderProducts.setPlatformSkuId(modelId);
//                if (imageInfo != null) {
//                    orderProducts.setGoodsImgeUrl(imageInfo.getString("image_url"));
//                }
            opTemps.add(orderProducts);
        }

        return opTemps;
    }


    /**
     * 订单是否同步判断
     */
    private Integer isSync(AeOrderDetailVO odVO, String orderStatusStr) {
        Integer sync = -1;
        //order_status
        String orderStatus = orderStatusStr;
        //等待买家付款
//        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("PLACE_ORDER_SUCCESS")) {
//            sync = 1;
//        }
        //等待您发货
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("WAIT_SELLER_SEND_GOODS")) {
            sync = 1;
        }
        //部分发货
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("SELLER_PART_SEND_GOODS")) {
            sync = 1;
        }
        //等待买家收货
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("WAIT_BUYER_ACCEPT_GOODS")) {
            sync = 1;
        }
        //等待您确认金额
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("WAIT_SELLER_EXAMINE_MONEY")) {
            sync = 1;
        }
        //订单处于风控24小时中，从买家在线支付完成后开始，持续24小时。
        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("RISK_CONTROL")) {
            sync = 1;
        }
        //已结束的订单
//        if (StringUtils.isNotBlank(orderStatus) && orderStatus.equals("FINISH")) {
//            sync = 1;
//        }
        return sync;
    }

    private String getProperty(List<AeOrderDetailChildOrderSkuVO> skuAttrs) {
        if (ObjectUtil.isEmpty(skuAttrs)) {
            return "";
        }
        String property = "";
        for (AeOrderDetailChildOrderSkuVO skuAttr : skuAttrs) {
            String pName = skuAttr.getPName();
            String pValue = skuAttr.getPValue();
            String selfDefineValue = skuAttr.getSelfDefineValue();
            if (StringUtils.isNotBlank(selfDefineValue)) {
                pValue = selfDefineValue;
            }
            if (StringUtils.isNotBlank(pName) && StringUtils.isNotBlank(pValue)) {
                property += pName + ":" + pValue + ";";
            }
        }
        //去除最厚一个字符
        if (StringUtils.isNotBlank(property)) {
            return property.substring(0, property.length() - 1);
        }
        //判空  返回null
        return property;
    }

    private String getBuyerMemo(AeOrderDetailVO odVO) {
        //多线程String
        StringBuffer sb = new StringBuffer();
        String memo = odVO.getMemo();
        if (StringUtils.isNotBlank(memo)) {
            sb.append("order_memo:");
            sb.append(memo);
            sb.append(";");
        }
        List<AeOrderDetailChildOrderVO> childOrderList = odVO.getChild_order_list();
        if (ObjectUtil.isNotEmpty(childOrderList)) {
            for (AeOrderDetailChildOrderVO childOrder : childOrderList) {
                String buyerMemo = childOrder.getBuyer_memo();
                if (StringUtils.isNotBlank(buyerMemo)) {
                    sb.append("buyerMemo:");
                    sb.append(buyerMemo);
                    sb.append(";");
                }
            }
        }
        return sb.toString();
    }

}
