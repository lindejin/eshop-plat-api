package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.aliexpress;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.service.api.marketplace.supply.call.aliexpress.AeAscpCallService;
import com.eshop.api.modules.service.api.marketplace.supply.domain.aliexpress.AeAscpApiService;
import com.eshop.api.modules.service.sds.ae.ApiAeFullProductCallService;
import com.eshop.api.modules.util.shop.PlatformAppClientUtils;
import com.eshop.db.product.service.main.TbExteriorSkuBindingService;
import com.eshop.modal.constant.ConstantCommon;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.api.marketplace.order.dto.AeProductItemDetailReqDTO;
import com.eshop.modal.entry.api.marketplace.order.vo.AeOrderDetailChildOrderSkuVO;
import com.eshop.modal.entry.api.marketplace.order.vo.AeOrderDetailVO;
import com.eshop.modal.entry.api.marketplace.product.vo.full.SellerRelationInfoVO;
import com.eshop.modal.entry.api.marketplace.product.vo.full.SellerRelationQueryRespVO;
import com.eshop.modal.entry.api.marketplace.product.vo.full.SellerRelationRespVO;
import com.eshop.modal.entry.api.marketplace.supply.dto.AeAscpPoPageQueryReqDTO;
import com.eshop.modal.entry.api.marketplace.supply.vo.AeAscpPoItemDataRespVO;
import com.eshop.modal.entry.api.marketplace.supply.vo.AeAscpPoItemRespVO;
import com.eshop.modal.entry.api.marketplace.supply.vo.AeAscpPoPageQueryDataVO;
import com.eshop.modal.entry.api.marketplace.supply.vo.AeAscpPoPageQueryRespVO;
import com.eshop.modal.entry.api.marketplace.user.vo.AeAddressListDataVO;
import com.eshop.modal.entry.api.marketplace.user.vo.AeAddressListRespVO;
import com.eshop.modal.entry.order.shipment.dto.ShipmentAddressListQueryDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.entry.sds.ae.full.dto.AeProductChoiceQueryReqDTO;
import com.eshop.modal.entry.sds.ae.full.vo.AeChoiceProductDetailVO;
import com.eshop.modal.entry.sds.ae.full.vo.AeChoiceProductSkuVO;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.DateUtil;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.api.service.product.aliexpress.AliexpressFullProductCall;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.utils.order.AeOrderUtils;
import com.eshop.util.platform.utils.status.AeStatusUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
import java.util.stream.Collectors;

/**
 * @author xxs
 * @date 2024/9/05
 * @Description: 速卖通全托管订单Client 实现类
 * @Version 1.0
 */
@StrategyKey(ConstantPlatform.AE)
@Service
@Slf4j
public class AliExpressAscpOrderClientImpl implements AliExpressAscpOrderClient {

    @Resource
    private AeAscpCallService aeAscpCallService;

    @Resource
    private AeStatusUtils aeStatusUtils;

    @Resource
    private AeOrderUtils aeOrderUtils;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private OrderWaybillUtils orderWaybillUtils;

    @Resource
    private TbExteriorSkuBindingService tbExteriorSkuBindingService;
    @Resource
    private AliexpressFullProductCall aliexpressFullProductCall;

    @Resource
    private ApiAeFullProductCallService apiAeFullProductCallService;

    @Resource
    private AeAscpApiService aeAscpApiService;

    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize) throws Exception {
        TbShop shopDO = dto.getShop();
        Integer platformShopType = shopDO.getPlatformShopType();
        if (ObjectUtil.isEmpty(platformShopType) || platformShopType != 2) {
            log.error("非速卖通全托管店铺");
            return new PageUtil(pageSize, 0);
        }
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeAscpPoPageQueryReqDTO pageQueryReqDTO = getListReqDTO(osDTO, pageNo, pageSize);
        pageQueryReqDTO.setChannel_user_id(Long.valueOf(sellRelationQuery(acDTO).getChannel_seller_id()));
        AeAscpPoPageQueryRespVO respVO = aeAscpCallService.ascpPoPageQuery(acDTO, pageQueryReqDTO);
        Integer total_item = respVO.getTotal_count();

        if (total_item == null || total_item == 0) {
            total_item = 1;
        }
        return new PageUtil(pageSize, total_item);
    }

    /**
     * 获取商家账号列表
     * @param queryVO
     * @return
     * @throws Exception
     */
    public SellerRelationInfoVO sellRelationQuery(AeAppClientDTO queryVO) throws Exception {
        String respBody = aliexpressFullProductCall.channelSellerld(queryVO);
        SellerRelationQueryRespVO respVO = new SellerRelationQueryRespVO();
        respVO.setRespBody(respBody);
        JSONObject respJson = JSONObject.parseObject(respBody);
        if (ObjectUtil.isNotEmpty(respJson.getString("success"))) {
            respVO.setSuccess("true".equals(respJson.getString("success"))? true : false);
        }
        if (ObjectUtil.isNotEmpty(respJson.getString("global_currency"))) {
            respVO.setGlobal_currency(respJson.getString("global_currency"));
        }
        JSONArray sellerRelationList = respJson.getJSONArray("seller_relation_list");
//        if (ObjectUtil.isNotEmpty(sellerRelationList)) {
//            respVO.setSeller_relation_list(sellerRelationList.toJavaList(SellerRelationRespVO.class));
//        }
        SellerRelationInfoVO sellerRelationInfoVO = new SellerRelationInfoVO();
        if (ObjectUtil.isEmpty(respVO) || !respVO.getSuccess() || ObjectUtil.isEmpty(sellerRelationList)) {
            throw new Exception("获取授权信息异常，请联系管理员");
        } else {
            List<SellerRelationRespVO> sellerRelations = sellerRelationList.toJavaList(SellerRelationRespVO.class);
            SellerRelationRespVO oneStopService = sellerRelations.stream().filter(relation -> (ObjectUtil.isNotEmpty(relation) && ObjectUtil.isNotEmpty(relation.getBusiness_type()) && relation.getBusiness_type().equals("ONE_STOP_SERVICE"))).findFirst().get();
            if (ObjectUtil.isNotEmpty(oneStopService)) {
                sellerRelationInfoVO.setChannel_seller_id(oneStopService.getChannel_seller_id());
                sellerRelationInfoVO.setChannel(oneStopService.getChannel());
                return sellerRelationInfoVO;
            }
            throw new Exception("获取授权信息异常，请联系管理员");
        }
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = dto.getShop();
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeAscpPoPageQueryReqDTO pageQueryReqDTO = getListReqDTO(osDTO, pageNo, pageSize);
        pageQueryReqDTO.setChannel_user_id(Long.valueOf(dto.getShop().getPlatformShopId()));
        AeAscpPoPageQueryRespVO respVO = aeAscpCallService.ascpPoPageQuery(acDTO, pageQueryReqDTO);
        String respBody = respVO.getRespBody();
        List<AeAscpPoPageQueryDataVO> orderListVOS = respVO.getData();
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
        JSONObject jsonObj = po.getJsonObj();
        if (ObjectUtil.isEmpty(jsonObj)) {
            throw new RuntimeException("速卖通订单信息是空！");
        }
        // TODO  AliExpress采购单明细查询API    -先不考虑 塞到订单
        AeAscpPoItemRespVO baseJson = getBaseJson(shopDO, orderNo);
        if (ObjectUtil.isEmpty(baseJson) || ObjectUtil.isEmpty(baseJson.getSuccess()) || baseJson.getSuccess() == false) {
            throw new RuntimeException("速卖通订单信息获取失败，请检查订单号是否正确！");
        }
        ObjectMapper mapper = new ObjectMapper();
        AeAscpPoPageQueryDataVO ascpPoData = mapper.readValue(jsonObj.toString(), AeAscpPoPageQueryDataVO.class);
        List<AeAscpPoItemDataRespVO> dataList = baseJson.getData_list();

        //订单状态
        Integer order_status = 1;

        TbOrderInfo orderInfo = new TbOrderInfo();
        //主表
        order = handleAeOrderDetail(ascpPoData, order, baseJson);
        //买家下单留言
        // String buyerMemo = getBuyerMemo(odVO);
        // if (StringUtils.isNotBlank(buyerMemo)) {
        //     order.setPlatformMessage(buyerMemo);
        // }
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(orderNo, ascpPoData));
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(orderNo, platform.getPlatformName(), operator, "1"));
//        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(orderNo, ascpPoData));
        // TODO 我们的运单信息 需要确认接单 然后创建揽收单 后查询揽收单才能拿得到 -先给个默认值假的也行，后面更新
//        //运单表
         orderInfo.setWaybills(getWaybills(orderNo, ascpPoData));
        //运单地址表
         orderInfo.setWaybillSite(getWaybillSite(orderNo, ascpPoData, shopDO));
        //买家信息装配 买家信息补充
         orderInfo.getOrderBuyer().setCountry(orderInfo.getWaybillSite().getCountry());
        //订单商品信息
        // 获取产品详情信息
        List<AeChoiceProductDetailVO> aeProductInfos = getAeProductInfo(shopDO, dataList);
        List<TbOrderProducts> opDOS = getOrderProductsList(orderNo, baseJson, aeProductInfos);
        orderInfo.setOrderProducts(opDOS);

        if (ascpPoData != null) {
            orderInfo.setOrderDetailRespJson(ascpPoData.toString());
        }
        if (dataList != null) {
            orderInfo.setOrderProductRespJson(JSONUtil.toJsonStr(dataList));
        }
        //订单号
        orderInfo.setOrderNo(orderNo);


//        String orderStatusStr = order_status;
        //erp 状态处理转化
//        Integer platformOrderStatus = aeStatusUtils.getPlatformOrderStatus(orderStatusStr);
        // TODO 先随便写一下，等到调试的时候看到值再说
        Integer platformOrderStatus = ascpPoData.getStatus();

//        String platformOrderStatusStr = aeStatusUtils.getPlatformOrderStatusStr(orderStatusStr);
        String abnormalCause = aeStatusUtils.getAbnormalCause(platformOrderStatus);
//        List<Long> orderTypeMiddles = aeStatusUtils.getOrderTypeMiddles(orderStatusStr, orderInfo, orderEndReason, true);

//        order.setPlatformOrderStatus(aeStatusUtils.getAeAscpPlatformOrderStatus(ascpPoData.getStatus()));
        order.setPlatformOrderStatus(platformOrderStatus);
        if (ObjectUtil.isNotEmpty(abnormalCause)) {
            orderInfo.setAbnormalCause(abnormalCause);
        }
//        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        // TODO 是否同步判断  先随便写一个
//         orderInfo.setIsSync(isSync(odVO, orderStatusStr));
        orderInfo.setIsSync(1);
        // 不同步原因
//        if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
//            orderInfo.setSyncNotMsg("订单状态+" + platformOrderStatusStr);
//
//        }
        return orderInfo;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDTO, OrderSyncDTO osDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = psDTO.getShop();
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeAscpPoPageQueryReqDTO pageQueryReqDTO = getListReqDTO(osDTO, pageNo, pageSize);
        pageQueryReqDTO.setChannel_user_id(Long.valueOf(sellRelationQuery(acDTO).getChannel_seller_id()));
        AeAscpPoPageQueryRespVO respVO = aeAscpCallService.ascpPoPageQuery(acDTO, pageQueryReqDTO);
        String respBody = respVO.getRespBody();
        List<AeAscpPoPageQueryDataVO> orderListVOS = respVO.getData();
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
        AeAscpPoItemRespVO respVO = getBaseJson(shopDO, orderNo);
        List<AeAscpPoItemDataRespVO> target = respVO.getData_list();

        JSONObject jsonObj = po.getJsonObj();
        if (ObjectUtil.isEmpty(jsonObj)) {
            throw new RuntimeException("速卖通订单信息是空！");
        }
        ObjectMapper mapper = new ObjectMapper();
        AeAscpPoPageQueryDataVO ascpPoData = mapper.readValue(jsonObj.toString(), AeAscpPoPageQueryDataVO.class);
        //平台订单状态 原生
        Integer orderStatusStr = ascpPoData.getStatus();
        return getUpOrderInfoLevel1(psDTO, orderNo, orderStatusStr, target);
    }

    private TbOrderInfo getUpOrderInfoLevel1(PlatformSyncDTO psDTO, String orderNo, Integer orderStatusStr, List<AeAscpPoItemDataRespVO> target) {
        TbOrder order = new TbOrder();
        order.setOrderNo(orderNo);
        order.setTransactionNo(orderNo);
        // order.setPlatformOrderStatus(aeStatusUtils.getAeAscpPlatformOrderStatus(orderStatusStr));
        order.setPlatformOrderStatus(orderStatusStr);

        TbOrderInfo upOrderInfo = getUpOrderInfoLevel2(psDTO, order, orderStatusStr, target);
        return upOrderInfo;
    }

    private TbOrderInfo getUpOrderInfoLevel2(PlatformSyncDTO psDTO, TbOrder order, Integer orderStatus, List<AeAscpPoItemDataRespVO> target) {
        String platformName = psDTO.getPlatform().getPlatformName();
        String operator = psDTO.getCreator();
        String orderNo = order.getOrderNo();
//        String orderEndReason = target.getOrder_end_reason();
        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(orderNo, platformName, operator, "2"));
        //订单号
        orderInfo.setOrderNo(orderNo);
        //erp 状态处理转化
        Integer platformOrderStatus = orderStatus;
//        Integer platformOrderStatus = aeStatusUtils.getAeAscpPlatformOrderStatus(orderStatus);
        String platformOrderStatusStr = aeStatusUtils.getAeAscpPlatformOrderStatusStr(orderStatus);
//        String abnormalCause = aeStatusUtils.getAeAscpAbnormalCause(orderStatus);
//        List<Long> orderTypeMiddles = aeStatusUtils.getOrderTypeMiddles(orderStatus, orderInfo, orderEndReason, false);

        if (orderInfo.getOrderLogs() != null && StringUtils.isNotBlank(platformOrderStatusStr)) {
            orderInfo.getOrderLogs().setDescription(platformOrderStatusStr);
        }

        orderInfo.setPlatformOrderStatus(platformOrderStatus);
//        orderInfo.setAbnormalCause(abnormalCause);
//        orderInfo.setOrderTypeMiddles(orderTypeMiddles);
        //订单详情原始数据
        if (target != null) {
            orderInfo.setOrderDetailRespJson(JSONUtil.toJsonStr(target));
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

    private AeAscpPoPageQueryReqDTO getListReqDTO(OrderSyncDTO osDto, Integer pageNo, Integer pageSize) {
        if (osDto.getStartDate() == null) {
            throw new RuntimeException("时间范围开始时间不能为空!");
        }

        if (osDto.getEndDate() == null) {
            throw new RuntimeException("时间范围结束时间不能为空！");
        }
        String startTimeStr = DateUtil.format(osDto.getStartDate());
        String endTimeStr = DateUtil.format(osDto.getEndDate());

        AeAscpPoPageQueryReqDTO queryReqDTO = new AeAscpPoPageQueryReqDTO();
        // 采购单号
        queryReqDTO.setPurchase_order_no(null);
        // 单据类型 10:普通仓发 50:JIT                                              ---必填
        queryReqDTO.setOrder_type(50);
        // 行业账套 AER 221000，AEG(choice2.0) 288000 aechoice 5110000             ---必填
        queryReqDTO.setBiz_type(5110000);
        // 单据状态 10:待确认 15:已确认 17:待发货 20:待收货 21:已到仓 30:部分收货 40:收货完成 -99:已取消,不传则返回所有状态的采购单
//        queryReqDTO.setStatus();
        // 渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id, choice2.0(当bizType=288000时)场景下可以不传该参数)
//        queryReqDTO.setChannel_user_id();
        // 交易主单号
//        queryReqDTO.setTrade_order_id();
        // 该字段仅支持POP仓发，半托管、全托管不生效，勿传
//        queryReqDTO.setData_range();

        // 开始时间  "yyyy-MM-dd HH:mm:ss"
        queryReqDTO.setCreate_time_begin(startTimeStr);
        // 结束时间  "yyyy-MM-dd HH:mm:ss"
        queryReqDTO.setCreate_time_end(endTimeStr);
        // 当前页
        queryReqDTO.setPage_index(pageNo);
        // 分页大小
        queryReqDTO.setPage_size(pageSize);
        return queryReqDTO;
    }

    private List<PlatformSyncInfoResponseVO<TbOrder>> getAeOrderList(List<AeAscpPoPageQueryDataVO> orderListVOS) {
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        for (AeAscpPoPageQueryDataVO orderListVO : orderListVOS) {
            //order订单VO json
            JSONObject orderJson = (JSONObject) JSONObject.toJSON(orderListVO);
            //order订单id
            String orderNo = orderListVO.getPurchase_order_no();
            TbOrder order = new TbOrder();
            order.setOrderNo(orderNo);

            PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
            response.setInfo(order);
            response.setJsonObj(orderJson);
            orderList.add(response);
        }
        return orderList;
    }

    private AeAscpPoItemRespVO getBaseJson(TbShop shopDO, String orderNo) throws Exception {
        String order_id = null;
        if (ObjectUtil.isNotEmpty(orderNo)) {
            order_id = orderNo;
        }
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        AeProductItemDetailReqDTO reqDTO = new AeProductItemDetailReqDTO();
        reqDTO.setPurchase_order_no(order_id);
        reqDTO.setPage_size(5000);
        reqDTO.setPage_index(1);
        reqDTO.setBiz_type(5110000);
        reqDTO.setChannel_user_id(Long.valueOf(sellRelationQuery(acDTO).getChannel_seller_id()));
        //api请求
        AeAscpPoItemRespVO odRespVO = aeAscpCallService.ascpPoItemQuery(acDTO, reqDTO);
        return odRespVO;
    }

    /**
     *
     * @param ascpPageDataVO 采购单分页查询单个信息
     * @param orderOld       订单信息
     * @param odVO           采购单分页查询单个信息对应的订单详情信息
     * @return
     */
    private TbOrder handleAeOrderDetail(AeAscpPoPageQueryDataVO ascpPageDataVO, TbOrder orderOld, AeAscpPoItemRespVO odVO) {
        //拷贝orderOld
        TbOrder order = new TbOrder();
        BeanUtils.copyProperties(orderOld, order);
        //订单号
        String orderNo = ascpPageDataVO.getPurchase_order_no();
        // TODO 订单状态
        String orderStatus = "";

        Long gmtCreate = ascpPageDataVO.getGmt_create();
        Long gmtExpiration = ascpPageDataVO.getGmt_expiration();
        String tradeOrderId = ascpPageDataVO.getTrade_order_id();

        //订单创建时间
        if (ObjectUtil.isNotEmpty(gmtCreate)) {
            order.setOrderTime(cn.hutool.core.date.DateUtil.date(gmtCreate));
        }
        //当前状态超时日期
        if (ObjectUtil.isNotEmpty(gmtExpiration)) {
            order.setDeliveryDeadlineTime(cn.hutool.core.date.DateUtil.date(gmtExpiration));
        }
        //如果付款时间不存在  使用订单创建时间作为付款时间
        if (order.getPaymentTime() == null) {
            order.setPaymentTime(cn.hutool.core.date.DateUtil.date(gmtCreate));
        }
        // 交易主单号
        if (ObjectUtil.isNotEmpty(tradeOrderId)) {
            order.setTransactionNo(tradeOrderId);
        }

        order.setOrderDetail((JSONObject) JSONObject.toJSON(odVO));
        order.setOrderNo(orderNo);
        order.setPlatformOrderStatus(ascpPageDataVO.getStatus());
        order.setOrderType(4);
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

    private TbOrderBuyerInfo getOrderBuyerInfo(String orderNo, AeAscpPoPageQueryDataVO ascpPoData) {

        TbOrderBuyerInfo orderBuyer = new TbOrderBuyerInfo();
        //buyer_user_id 此订单买家的用户ID  交易主单号先作为买家id
        String tradeOrderId = ascpPoData.getTrade_order_id();
        if (StringUtils.isNotBlank(tradeOrderId)) {
            tradeOrderId = tradeOrderId.trim();
        }
        orderBuyer.setEmail(tradeOrderId);
        // 国际物流单号作为  卖家手机号
        orderBuyer.setContactPhone(ascpPoData.getLp());
        // 仓库code 作为买家id
        orderBuyer.setBuyerId(ascpPoData.getStore_code());
        //buyer_username 买家姓名        仓库名称作为买家姓名
        String buyerNickName = ascpPoData.getStore_name();
        if (StringUtils.isNotBlank(buyerNickName)) {
            buyerNickName = buyerNickName.trim();
        }
        orderBuyer.setBuyerName(buyerNickName);
        orderBuyer.setCountry(ascpPoData.getReceiver_country());

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

    private TbOrderCostDetail getOrderCostDetail(String orderNo, AeAscpPoPageQueryDataVO ascpPoData) {
        return aeOrderUtils.getOrderCostDetail(orderNo, ascpPoData);
    }

    private List<TbWaybill> getWaybills(String orderNo, AeAscpPoPageQueryDataVO odVO) {
        //获取物流方式
//        List<AeOrderDetailChildOrderVO> childOrderList = odVO.getChild_order_list();
//        String shippingCarrier = null;
//        List<String> shippingCarriers = new ArrayList<>();
//        if (ObjectUtil.isNotEmpty(childOrderList)) {
//            for (AeOrderDetailChildOrderVO aeOrderDetailChildOrderVO : childOrderList) {
//                String logisticsServiceName = aeOrderDetailChildOrderVO.getLogistics_service_name();
//                shippingCarriers.add(logisticsServiceName);
//            }
//            if (ObjectUtil.isNotEmpty(shippingCarriers)) {
//                shippingCarrier = shippingCarriers.get(0);
//            }
//        }
        List<String> whcOrderNoList = odVO.getWhc_order_no_list();
        String whcOrderNo = null;
        if (ObjectUtil.isNotEmpty(whcOrderNoList)) {
            whcOrderNo = whcOrderNoList.get(0);
        }
        //收货地址信息
//        AeOrderDetailReceiptAddressVO raVO = odVO.getReceipt_address();
        Long logisticsModeId = null;
//        if (StringUtils.isNotBlank(checkoutShippingCarrier)) {
//            logisticsModeId = getLogisticsModeId("Aliexpress", checkoutShippingCarrier);
//        }

        List<TbWaybill> waybills = new ArrayList<>();
////        Long logisticsModeIdTemp = getLogisticsModeId("Shopee", shippingCarrier);
//        Long logisticsModeIdTemp = null;

        TbWaybill tbWaybill = orderWaybillUtils.generateNewWaybill();
        if (ObjectUtil.isNotEmpty(whcOrderNo)) {
            tbWaybill.setWaybillNo(whcOrderNo);
        }
        tbWaybill.setOrderNo(orderNo);
        tbWaybill.setWaybillExternalId(null);
        //买家自选物流
        tbWaybill.setBuyerOptionalLogistics("买家自选物流-无");
        //默认设置为0 正式插入时获取
        tbWaybill.setParcelNo(BigInteger.ZERO);
        //平台 物流服务提供商
        tbWaybill.setCheckoutShippingCarrier("物流服务提供商-无");

//        if (logisticsModeIdTemp != null) {
//            tbWaybill.setLogisticsModeId(logisticsModeIdTemp);
//        } else {
//            tbWaybill.setLogisticsModeId(logisticsModeId);
//        }
        tbWaybill.setLogisticsModeId(ConstantCommon.AE_DEFAULT_MODE_ID);
        waybills.add(tbWaybill);
        return waybills;
    }

    private TbWaybillSite getWaybillSite(String orderNo, AeAscpPoPageQueryDataVO odVO, TbShop shopDO) {

        ShipmentAddressListQueryDTO queryDTO = new ShipmentAddressListQueryDTO();
        queryDTO.setShopId(shopDO.getId());
        queryDTO.setPlatChannelId(Long.valueOf(shopDO.getPlatformShopId()));
        //城市
        String city = null;
        //省份
        String state = null;
        //国家/地区
        String country = null;
        //邮编
        String zipcode = null;

        try {
            AeAddressListRespVO addressList = aeAscpApiService.getAddressList(shopDO, queryDTO);
            if (ObjectUtil.isEmpty(addressList) || ObjectUtil.isEmpty(addressList.getAddress_list())) {
                log.error("获取店铺默认发货地址异常!");
            }
            AeAddressListDataVO aeAddressListDataVO = addressList.getAddress_list().stream().filter(data -> "WAREHOUSE".equals(data.getAddress_type()) && data.getDefault_address()).findFirst().get();
            if (ObjectUtil.isEmpty(aeAddressListDataVO)) {
                log.error("获取店铺默认发货地址异常!");
            } else {
                //城市
                city = aeAddressListDataVO.getCity();
                //省份
                state = aeAddressListDataVO.getProv();
                //国家/地区
                country = aeAddressListDataVO.getCountry();
                //邮编
                zipcode = aeAddressListDataVO.getPostcode();
            }

        } catch (Exception exception) {
            log.error("获取店铺默认发货地址异常!");
        }

        //地址的收件人姓名。
        //string
        String name = odVO.getStore_contact_name();
//        //传真号
//        String fax_number = odVO.getFax_number();
        //电话。
        String phone = odVO.getStore_contact_phone();
        //手机号
        String mobile_no = odVO.getStore_contact_phone();


        //地址1
        String address = odVO.getStore_address_detail();
        //地址2
//        String address2 = raVO.getAddress2();

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


//        if (StringUtils.isNotBlank(address2)) {
//            waybillSite.setReserveAddress(address2);
//        }
        waybillSite.setLastName(name);
        waybillSite.setFirstName(name);
        waybillSite.setSiteStatus(0);
        return waybillSite;
    }


    private List<AeChoiceProductDetailVO> getAeProductInfo(TbShop shopDO, List<AeAscpPoItemDataRespVO> dataList) throws Exception {
        List<AeChoiceProductDetailVO> aeChoiceProductDetailVOS = new ArrayList<>();
        AeProductChoiceQueryReqDTO aeProductChoiceQueryReqDTO = new AeProductChoiceQueryReqDTO();
        AeAppClientDTO acDTO = platformAppClientUtils.getAeAppClientDTO(shopDO);
        SellerRelationInfoVO sellerRelationInfoVO = sellRelationQuery(acDTO);
        aeProductChoiceQueryReqDTO.setChannel_seller_id(sellerRelationInfoVO.getChannel_seller_id());
        aeProductChoiceQueryReqDTO.setChannel(sellerRelationInfoVO.getChannel());

        for (AeAscpPoItemDataRespVO aeAscpPoItemDataRespVO : dataList) {
            aeProductChoiceQueryReqDTO.setProduct_id(Long.valueOf(aeAscpPoItemDataRespVO.getItem_id()));
            AeChoiceProductDetailVO aeChoiceProductDetailVO = apiAeFullProductCallService.choiceProductQuery(acDTO, aeProductChoiceQueryReqDTO);
            aeChoiceProductDetailVOS.add(aeChoiceProductDetailVO);
        }
        return aeChoiceProductDetailVOS;
    }

    private List<TbOrderProducts> getOrderProductsList(String orderNo, AeAscpPoItemRespVO odVO, List<AeChoiceProductDetailVO> aeChoiceProductDetailVOS) throws Exception {
        List<AeAscpPoItemDataRespVO> coVOS = odVO.getData_list();
        List<TbOrderProducts> opTemps = new ArrayList<>();
        if (ObjectUtil.isEmpty(coVOS)) {
            return null;
        }

        if (ObjectUtil.isEmpty(aeChoiceProductDetailVOS)) {
            throw new Exception("获取速卖通订单里商品详情信息失败");
        }
        for (AeAscpPoItemDataRespVO coVO : coVOS) {
            //product_id	Number	商品ID
            Long product_id = Long.valueOf(coVO.getItem_id());
            //product_name	String	商品名称
            String product_name = coVO.getTitle();
            //product_count	Number	商品数量
            Integer product_count = coVO.getQuantity();
            //条形码
            String scItemCode = coVO.getBarcode();
            //sku	String	商品SKU  TODO 根据第三方供应链信息里的skuid 查询绑定关系 找到我们平台的sku信息，完善sku相关信息 这里先不管，订单没有返回skuCode
            // String sku = coVO.getSku_code();
            // 未税采购单价，单位元 -原价
            String noTaxPurchasePriceDec = coVO.getNo_tax_purchase_price_dec();
            // 三方平台图片url
            String skuImg = coVO.getSku_img();
            String skuId = coVO.getSku_id();

            TbOrderProducts orderProducts = new TbOrderProducts();
            //订单编号
            orderProducts.setOrderNo(orderNo);
            orderProducts.setProductId(product_id);
            List<AeChoiceProductSkuVO> skuVOS = aeChoiceProductDetailVOS.stream().flatMap(aeChoiceProductDetailVO -> aeChoiceProductDetailVO.getOne_stop_service_product_dto().getProduct_sku_list().stream()).collect(Collectors.toList());
            List<AeChoiceProductSkuVO> aeChoiceProductSkuVO = skuVOS.stream().filter(sku -> (ObjectUtil.isNotEmpty(sku.getSku_id()) && sku.getSku_id().equals(Long.valueOf(coVO.getSku_id())))).collect(Collectors.toList());
            if (ObjectUtil.isNotEmpty(aeChoiceProductSkuVO)) {
                orderProducts.setShopSku(aeChoiceProductSkuVO.get(0).getSku_code());
            }
            orderProducts.setProductEnName(product_name);
//            orderProducts.setProperty(getProperty(skuAttrs));
//                orderProducts.setBasisWeight(weight);
            orderProducts.setNumber(product_count);
            //原价
            if (ObjectUtil.isNotEmpty(noTaxPurchasePriceDec)){
                orderProducts.setUnitPrice(new BigDecimal(noTaxPurchasePriceDec));
            } else {
                orderProducts.setUnitPrice(new BigDecimal(0));
            }
            //成本价格
            orderProducts.setCostPrice(BigDecimal.ZERO);
            //商品类型
            orderProducts.setProductType(1);
            orderProducts.setGoodsImgeUrl(skuImg);

            orderProducts.setPlatformSkuId(Long.valueOf(skuId));
            orderProducts.setPlatformSkuIndex(Long.valueOf(scItemCode));
//            orderProducts.setPlatformSkuIndex(orderSortId);
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

//    private String getBuyerMemo(AeOrderDetailVO odVO) {
//        //多线程String
//        StringBuffer sb = new StringBuffer();
//        String memo = odVO.getMemo();
//        if (StringUtils.isNotBlank(memo)) {
//            sb.append("order_memo:");
//            sb.append(memo);
//            sb.append(";");
//        }
//        List<AeOrderDetailChildOrderVO> childOrderList = odVO.getChild_order_list();
//        if (ObjectUtil.isNotEmpty(childOrderList)) {
//            for (AeOrderDetailChildOrderVO childOrder : childOrderList) {
//                String buyerMemo = childOrder.getBuyer_memo();
//                if (StringUtils.isNotBlank(buyerMemo)) {
//                    sb.append("buyerMemo:");
//                    sb.append(buyerMemo);
//                    sb.append(";");
//                }
//            }
//        }
//        return sb.toString();
//    }

}
