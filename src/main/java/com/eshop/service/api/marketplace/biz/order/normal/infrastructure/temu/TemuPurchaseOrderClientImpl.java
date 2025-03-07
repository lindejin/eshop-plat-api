package com.eshop.service.api.marketplace.biz.order.normal.infrastructure.temu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.api.annotation.StrategyKey;
import com.eshop.api.modules.service.api.marketplace.order.call.temu.TemuOrderPoCallService;
import com.eshop.api.modules.util.shop.PlatformAppClientUtils;
import com.eshop.api.modules.util.shop.app.TemuAppClientUtils;
import com.eshop.api.modules.util.temuapi.prepareorder.TemuPurchaseOrderUtils;
import com.eshop.modal.constant.ConstantCommon;
import com.eshop.modal.constant.ConstantPlatform;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.entry.temu.TemuCommonParams;
import com.eshop.modal.entry.temu.dto.purchase.PurchaseOrderDTO;
import com.eshop.modal.entry.temu.vo.purchase.*;
import com.eshop.modal.enumerate.temuplatform.TemuPurchaseOrderStatusEnum;
import com.eshop.modal.exception.OrderException;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.util.file.utils.StringUtils;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.utils.order.TemuOrderPoOrderUtils;
import com.eshop.util.platform.utils.status.TemuOrderPoStatusUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Temu备货单相关API
 *
 * @author sheng
 * @date 2025-01-09 10:21
 */
@StrategyKey(ConstantPlatform.TEMU)
@Slf4j
@Service
public class TemuPurchaseOrderClientImpl implements TemuPurchaseOrderClient {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private TemuOrderPoCallService temuOrderPoCallService;

    @Resource
    private OrderWaybillUtils orderWaybillUtils;

    @Resource
    private TemuOrderPoStatusUtils temuOrderPoStatusUtils;

    @Resource
    private TemuOrderPoOrderUtils temuOrderPoOrderUtils;


    @Autowired
    private TemuAppClientUtils temuAppClientUtils;
    @Autowired
    private TemuPurchaseOrderUtils purchaseOrderUtils;

    @Override
    public PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize) throws Exception {
        TbShop shopDO = dto.getShop();
        //非CN应用不能拉取备货单
        if (!"CN".equalsIgnoreCase(dto.getShopLocation())) {
            return new PageUtil(pageSize, 0);
        }
        PurchaseOrderPageVO purchaseOrder = getOrderList(shopDO, dto.getShopLocation(), orderSyncDTO, pageNo, pageSize);
        Integer count = purchaseOrder.getTotal();
        if (Objects.isNull(purchaseOrder.getTotal()) || purchaseOrder.getTotal() == 0) {
            count = 1;
        }
        return new PageUtil(pageSize, count);
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = dto.getShop();
        PurchaseOrderPageVO respVO = getOrderList(shopDO, dto.getShopLocation(), orderSyncDTO, pageNo, pageSize);
        JSONArray subOrderForSupplierList = respVO.getSubOrderForSupplierList();
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(subOrderForSupplierList)) {
            int size = subOrderForSupplierList.size();
            for (int i = 0; i < size; i++) {
                JSONObject orderObj = subOrderForSupplierList.getJSONObject(i);
                orderObj.put("request_id", respVO.getRequestId());
                TbOrder order = new TbOrder();
                order.setOrderNo(orderObj.getString("subPurchaseOrderSn"));
                PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
                response.setInfo(order);
                response.setJsonObj(orderObj);
                orderList.add(response);
            }
        }
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(respVO.getReturnJson());
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        TbShop shopDO = psDto.getShop();
        PurchaseOrderPageVO respVO = getOrderList(shopDO, psDto.getShopLocation(), osDto, pageNo, pageSize);
        JSONArray subOrderForSupplierList = respVO.getSubOrderForSupplierList();
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(subOrderForSupplierList)) {
            int size = subOrderForSupplierList.size();
            for (int i = 0; i < size; i++) {
                JSONObject orderObj = subOrderForSupplierList.getJSONObject(i);
                orderObj.put("request_id", respVO.getRequestId());
                TbOrder order = new TbOrder();
                order.setOrderNo(orderObj.getString("subPurchaseOrderSn"));
                PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
                response.setInfo(order);
                response.setJsonObj(orderObj);
                orderList.add(response);
            }
        }
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        result.setJsonObj(respVO.getReturnJson());
        result.setSyncList(orderList);
        return result;
    }

    @Override
    public TbOrderInfo getAddOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        //数据转换
        TbShop shop = psDto.getShop();
        TbPlatform platform = psDto.getPlatform();
        String operator = psDto.getCreator();
        TbOrder order = po.getInfo();
        JSONObject orderJSON = po.getJsonObj();
        PurchaseOrderDataVO orderInfoVO = orderJSON.toJavaObject(PurchaseOrderDataVO.class);
        orderInfoVO.setReturnJson(orderJSON);
        Integer status = orderInfoVO.getStatus();

        //过滤,没有付款信息的订单
        if (status == 0) {
            throw new OrderException("待接单订单不同步,当前订单状态: " + status);
        }
        TemuCommonParams params = temuAppClientUtils.getParams(shop.getId(), psDto.getShopLocation());
        //不同步原因
        //if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
        //    orderInfo.setSyncNotMsg("订单状态+" + platformOrderStatusStr);
        //}


        //获取详细数据
        getOrder(order, orderInfoVO);
        String orderNo = order.getOrderNo();
        //参数转换
        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单主信息
        orderInfo.setOrder(order);
        //买家信息表
        orderInfo.setOrderBuyer(getOrderBuyerInfo(orderInfoVO, orderNo));
        //订单日志
        orderInfo.setOrderLogs(getOrderOperateLog(order, platform, operator, "1"));
        //订单费用明细
        orderInfo.setOrderCostDetail(getOrderCostDetail(orderNo, orderInfoVO));
        //运单表
        orderInfo.setWaybills(getWaybills(orderNo));
        //运单地址表
        orderInfo.setWaybillSite(getWaybillSite(orderInfoVO, params));
        //订单商品信息
        List<TbOrderProducts> opDOS = getOrderProductsList(orderNo, orderInfoVO);
        orderInfo.setOrderProducts(opDOS);
        orderInfo.setOrderDetailRespJson(orderJSON.toJSONString());
        orderInfo.setOrderNo(orderNo);
        orderInfo.setAbnormalCause(TemuPurchaseOrderStatusEnum.getErrTextByCode(status));
        //是否同步判断
        orderInfo.setIsSync(1);
        if (status == 0) {
            orderInfo.setIsSync(-1);
            orderInfo.setSyncNotMsg("待接单订单不同步,当前订单状态: " + status + "( " + TemuPurchaseOrderStatusEnum.getTextByCode(status) + " )");
        }
        return orderInfo;
    }

    private TbWaybillSite getWaybillSite(PurchaseOrderDataVO orderInfoVO, TemuCommonParams params) {
        List<MallAddressVO> mallAddress = purchaseOrderUtils.getMallAddress(params);
        TbWaybillSite tbWaybillSite = new TbWaybillSite();
        tbWaybillSite.setCountry("中国");
        if (CollectionUtils.isNotEmpty(mallAddress)) {
            MallAddressVO mallAddressVO = mallAddress.get(0);
            tbWaybillSite.setLastName(mallAddressVO.getAddressLabel());
            tbWaybillSite.setProvinceOrState(mallAddressVO.getProvinceName());
            tbWaybillSite.setCity(mallAddressVO.getCityName());
            String detailedAddress = Optional.ofNullable(mallAddressVO.getDistrictName()).orElse("");
            detailedAddress += Optional.ofNullable(mallAddressVO.getAddressDetail()).orElse("");
            tbWaybillSite.setDetailedAddress(detailedAddress);
            tbWaybillSite.setSiteStatus(0);
        } else {
            tbWaybillSite.setFirstName(orderInfoVO.getSupplierName());
            tbWaybillSite.setProvinceOrState("福建省");
            tbWaybillSite.setCity("厦门市");
            tbWaybillSite.setDetailedAddress("集美区******");
            tbWaybillSite.setSiteStatus(1);
        }
        return tbWaybillSite;
    }

    /**
     * 商品信息
     *
     * @param orderNo
     * @param orderInfoVO
     * @return java.util.List<com.eshop.modal.modal.eshop_order.TbOrderProducts>
     * @author sheng
     * @date 2025-01-10 15:22
     */
    private List<TbOrderProducts> getOrderProductsList(String orderNo, PurchaseOrderDataVO orderInfoVO) {
        List<PurchaseOrderSkuVO> skuList = orderInfoVO.getSkuQuantityDetailList();
        if (CollectionUtils.isEmpty(skuList)) {
            return Collections.emptyList();
        }
        List<TbOrderProducts> opDOS = new ArrayList<>();
        String productName = orderInfoVO.getProductName();
        for (PurchaseOrderSkuVO skuVO : skuList) {
            TbOrderProducts opDO = new TbOrderProducts();
            opDO.setOrderNo(orderNo);
            //平台商品Id
            String productId = orderInfoVO.getProductId();
            if (StringUtils.isNotBlank(productId)) {
                opDO.setProductId(Long.valueOf(productId));
            }

            String productSkuId = Optional.ofNullable(skuVO.getProductSkuId()).orElse(skuVO.getFulfilmentProductSkuId());
            if (StringUtils.isNotBlank(productSkuId)) {
                opDO.setPlatformSkuId(Long.parseLong(productSkuId));
            } else {
                opDO.setPlatformSkuId(0L);
            }
            //opDO.setPoLineId();
            //opDO.setPlatformSkuIndex();
            opDO.setShopSku(skuVO.getExtCode());
            opDO.setProductCnName(productName);
            opDO.setProductEnName(productName);
            opDO.setProperty(skuVO.getClassName());
            //opDO.setBasisWeight();
            opDO.setNumber(skuVO.getPurchaseQuantity());
            opDO.setOrderNumber(skuVO.getPurchaseQuantity());
            opDO.setUnitPrice(BigDecimal.ZERO);
            opDO.setCostPrice(BigDecimal.ZERO);
            if (Objects.isNull(orderInfoVO.getIsCustomProduct()) || orderInfoVO.getIsCustomProduct()) {
                opDO.setIsCustomProduct(0);
            } else {
                opDO.setIsCustomProduct(1);
            }
            opDO.setProductType(1);
            //图片
            List<String> thumbUrlList = skuVO.getThumbUrlList();
            if (CollectionUtils.isNotEmpty(thumbUrlList)) {
                opDO.setGoodsImgeUrl(thumbUrlList.get(0));
            }

            opDOS.add(opDO);
        }
        return opDOS;
    }

    /**
     * 构建运单信息
     *
     * @param orderNo
     * @return java.util.List<com.eshop.modal.modal.eshop_order.TbWaybill>
     * @author sheng
     * @date 2025-01-10 14:58
     */
    private List<TbWaybill> getWaybills(String orderNo) {
        List<TbWaybill> waybills = new ArrayList<>();
        TbWaybill tbWaybill = orderWaybillUtils.generateNewWaybill();

        tbWaybill.setOrderNo(orderNo);
        tbWaybill.setWaybillExternalId(null);
        //买家自选物流
        tbWaybill.setBuyerOptionalLogistics("买家自选物流-无");
        //默认设置为0 正式插入时获取
        tbWaybill.setParcelNo(BigInteger.ZERO);
        //平台 物流服务提供商
        tbWaybill.setCheckoutShippingCarrier("物流服务提供商-无");
        tbWaybill.setLogisticsModeId(ConstantCommon.TEMU_DEFAULT_MODE_ID);
        waybills.add(tbWaybill);
        return waybills;
    }

    /**
     * 订单费用明细
     *
     * @param orderNo
     * @param orderInfoVO
     * @return com.eshop.modal.modal.eshop_order.TbOrderCostDetail
     * @author sheng
     * @date 2025-01-10 14:27
     */
    private TbOrderCostDetail getOrderCostDetail(String orderNo, PurchaseOrderDataVO orderInfoVO) {
        TbOrderCostDetail ocdVO = new TbOrderCostDetail();
        String currencyCode = "USD";
        List<PurchaseOrderSkuVO> detailList = orderInfoVO.getSkuQuantityDetailList();
        if (CollectionUtils.isNotEmpty(detailList)) {
            currencyCode = detailList.get(0).getCurrencyType();
        }
        ocdVO.setCurrency(currencyCode);
        //订单编号
        ocdVO.setOrderNo(orderNo);
        //商品总售价
        ocdVO.setProductTotalPrice(new BigDecimal("0"));
        //应收运费
        if (ocdVO.getReceivablePostage() == null) {
            ocdVO.setReceivablePostage(new BigDecimal("0"));
        }
        //其他收入
        if (ocdVO.getOtherRevenue() == null) {
            ocdVO.setOtherRevenue(new BigDecimal("0"));
        }
        //商品成本价
        if (ocdVO.getProductCostPrice() == null) {
            ocdVO.setProductCostPrice(new BigDecimal("0"));
        }
        //物流支出
        if (ocdVO.getLogisticsCosts() == null) {
            ocdVO.setLogisticsCosts(new BigDecimal("0"));
        }
        //包材费
        if (ocdVO.getPackingFee() == null) {
            ocdVO.setPackingFee(new BigDecimal("0"));
        }
        //平台佣金费
        if (ocdVO.getPlatformCost() == null) {
            ocdVO.setPlatformCost(new BigDecimal("0"));
        }
        //转账费用
        if (ocdVO.getTransferCost() == null) {
            ocdVO.setTransferCost(new BigDecimal("0"));
        }
        //广告费用
        ocdVO.setAdvertisingRate(new BigDecimal("0"));
        //推广费/测评费(刷单费)   -->

        //店铺优惠劵
        if (ocdVO.getShopCoupon() == null) {
            ocdVO.setShopCoupon(new BigDecimal("0"));
        }
        //其他支出
        ocdVO.setOtherExpenses(new BigDecimal("0"));
        //退款金额
        if (ocdVO.getRefundMoney() == null) {
            ocdVO.setRefundMoney(new BigDecimal("0"));
        }
        return ocdVO;
    }

    /**
     * 买家信息表
     *
     * @param orderInfoVO
     * @param orderNo
     * @return com.eshop.modal.modal.eshop_order.TbOrderBuyerInfo
     * @author sheng
     * @date 2025-01-09 16:20
     */
    private TbOrderBuyerInfo getOrderBuyerInfo(PurchaseOrderDataVO orderInfoVO, String orderNo) {
        TbOrderBuyerInfo orderBuyer = new TbOrderBuyerInfo();
        orderBuyer.setBuyerId(orderInfoVO.getDeliveryOrderSn());
        orderBuyer.setBuyerName(orderInfoVO.getSupplierName());
        orderBuyer.setOrderNo(orderNo);
        orderBuyer.setCountry("中国");
        orderBuyer.setBuyerId(orderInfoVO.getSupplierId());
        return orderBuyer;
    }

    /**
     * 订单主表信息
     *
     * @param order
     * @param orderInfoVO
     * @author sheng
     * @date 2025-01-09 16:02
     */
    private void getOrder(TbOrder order, PurchaseOrderDataVO orderInfoVO) {
        //订单号
        String orderSn = orderInfoVO.getSubPurchaseOrderSn();
        //创建订单的日期和时间的时间戳 --> 商品总售价
        Long createTime = orderInfoVO.getPurchaseTime();
        if (Objects.nonNull(createTime)) {
            order.setOrderTime(new Date(createTime));
            //没有付款时间 使用创建时间
            order.setPaymentTime(new Date(createTime));
        }
        //时间使用最晚收集时间
        //Long shipByDate = vo.getTtsSla();
        PurchaseOrderDeliverInfoVO deliverInfo = orderInfoVO.getDeliverInfo();
        if (Objects.nonNull(deliverInfo) && Objects.nonNull(deliverInfo.getExpectLatestDeliverTimeOrDefault())) {
            order.setDeliveryDeadlineTime(new Date(deliverInfo.getExpectLatestDeliverTimeOrDefault()));
        }
        order.setOrderDetail(orderInfoVO.getReturnJson());
        //order.setPlatformMessage(vo.getBuyerMessage());
        order.setTransactionNo(orderSn);
        order.setOrderType(5);
        order.setOrderNo(orderSn);
        order.setPlatformOrderStatus(orderInfoVO.getStatus());
    }

    @Override
    public TbOrderInfo getUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) throws Exception {
        //数据转换
        //TbShop shop = psDto.getShop();
        TbPlatform platform = psDto.getPlatform();
        String operator = psDto.getCreator();
        TbOrder order = po.getInfo();
        JSONObject orderJSON = po.getJsonObj();
        if (Objects.isNull(orderJSON) || orderJSON.isEmpty()) {
            throw new OrderException("未获取到订单详细信息");
        }
        PurchaseOrderDataVO orderInfoVO = orderJSON.toJavaObject(PurchaseOrderDataVO.class);
        orderInfoVO.setReturnJson(orderJSON);
        Integer status = orderInfoVO.getStatus();
        //过滤,没有付款信息的订单
        //if (status == 0) {
        //    throw new OrderException("待接单订单不同步,当前订单状态: " + status);
        //}
        //获取详细数据
        getOrder(order, orderInfoVO);
        String orderNo = order.getOrderNo();
        //参数转换
        TbOrderInfo orderInfo = new TbOrderInfo();
        //订单主信息
        orderInfo.setOrder(order);
        //订单日志
        TbOrderLog orderOperateLog = getOrderOperateLog(order, platform, operator, "2");
        orderOperateLog.setDescription(TemuPurchaseOrderStatusEnum.getTextByCode(status));
        orderInfo.setOrderLogs(getOrderOperateLog(order, platform, operator, "2"));
        //运单表
        orderInfo.setWaybills(getWaybills(orderNo));
        //订单商品信息
        List<TbOrderProducts> opDOS = getOrderProductsList(orderNo, orderInfoVO);
        orderInfo.setOrderProducts(opDOS);
        orderInfo.setOrderDetailRespJson(orderJSON.toJSONString());
        orderInfo.setOrderNo(orderNo);
        orderInfo.setAbnormalCause(TemuPurchaseOrderStatusEnum.getErrTextByCode(status));
        //是否同步判断
        orderInfo.setIsSync(1);
        return orderInfo;

    }

    @Override
    public PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws Exception {
        //TbShop shopDO = psDto.getShop();
        //PurchaseOrderPageVO respVO = getOrderList(shopDO, psDto.getShopLocation(), osDto, pageNo, pageSize);
        //JSONArray subOrderForSupplierList = respVO.getSubOrderForSupplierList();
        //List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();
        //if (CollectionUtils.isNotEmpty(subOrderForSupplierList)) {
        //    int size = subOrderForSupplierList.size();
        //    for (int i = 0; i < size; i++) {
        //        JSONObject orderObj = subOrderForSupplierList.getJSONObject(i);
        //        orderObj.put("request_id", respVO.getRequestId());
        //        TbOrder order = new TbOrder();
        //        order.setOrderNo(orderObj.getString("subPurchaseOrderSn"));
        //        PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
        //        response.setInfo(order);
        //        response.setJsonObj(orderObj);
        //        orderList.add(response);
        //    }
        //}
        //PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> result = new PlatformSyncListResponseVO<>();
        //result.setJsonObj(respVO.getReturnJson());
        //result.setSyncList(orderList);
        //return result;
        //TODO 该功能未实现
        return null;
    }

    @Override
    public TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo) throws Exception {
        return null;
    }

    /**
     * 获取订单同步 运行日志
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
     * 获取订单列表
     *
     * @param shopDO
     * @param shopLocation
     * @param posDto
     * @param pageNo
     * @param pageSize
     * @return com.eshop.modal.entry.temu.vo.purchase.PurchaseOrderPageVO
     * @author sheng
     * @date 2025-01-09 14:59
     */
    private PurchaseOrderPageVO getOrderList(TbShop shopDO, String shopLocation, OrderSyncDTO posDto, Integer pageNo, Integer pageSize) throws Exception {
        PurchaseOrderDTO orderDTO = new PurchaseOrderDTO();
        orderDTO.setPageSize(pageSize);
        orderDTO.setPageNo(pageNo);
        if (Objects.nonNull(posDto.getEndDate())) {
            orderDTO.setPurchaseTimeTo(posDto.getEndDate().getTime());
        }
        if (Objects.nonNull(posDto.getStartDate())) {
            orderDTO.setPurchaseTimeFrom(posDto.getStartDate().getTime());
        }
        TemuCommonParams params = temuAppClientUtils.getParams(shopDO.getId(), shopLocation);
        return purchaseOrderUtils.getPurchaseOrder(params, orderDTO);
    }

}
