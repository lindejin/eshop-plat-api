package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;

import cn.hutool.core.util.ObjectUtil;
import com.eshop.api.modules.service.api.marketplace.order.domain.order.domain.serivce.*;
import com.eshop.api.modules.service.order.ApiOrderRollbackService;
import com.eshop.api.modules.task.ImageDownloadTask;
import com.eshop.api.modules.util.TikTokApiUtil;
import com.eshop.api.modules.util.service.IncrServiceUtils;
import com.eshop.api.modules.util.service.LogServiceUtils;
import com.eshop.api.modules.util.service.WaybillServiceUtils;
import com.eshop.db.log.service.OrderLogService;
import com.eshop.db.order.service.*;
import com.eshop.modal.entry.config.dto.OperatorDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.exception.OrderException;
import com.eshop.modal.modal.eshop_config.TbPlatform;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.modal.modal.eshop_config.TbShopEmployee;
import com.eshop.modal.modal.eshop_log.TbOrderLog;
import com.eshop.modal.modal.eshop_order.*;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSync3plService;
import com.eshop.util.ExceptionUtils;
import com.eshop.util.platform.OrderUtils;
import com.eshop.util.platform.OrderWaybillUtils;
import com.eshop.util.platform.utils.order.DhgateOrderUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ldj
 * @date 2023/6/26 14:04
 * @Description: ...
 * @Version 1.0
 */
@Service
public class OrderSyncRecordServiceImpl implements OrderSyncRecordService {

    private static final Logger logger = LoggerFactory.getLogger(OrderSyncRecordServiceImpl.class);

    @Autowired
    private IncrServiceUtils incrServiceUtils;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderBuyerInfoService orderBuyerInfoService;

    @Autowired
    private OrderCostDetailService orderCostDetailService;

    @Autowired
    private OrderLogService orderOperateLogService;

    @Autowired
    private OrderProductsService orderProductsService;

    @Autowired
    private OrderWaybillService orderWaybillService;

    @Autowired
    private WaybillServiceUtils waybillServiceUtils;

    @Autowired
    private WaybillSiteService waybillSiteService;

    @Autowired
    private OrderRequestBodyService orderRequestBodyService;

    @Autowired
    private ImageDownloadTask imageDownloadTask;

    @Autowired
    private OrderUtils orderUtils;

    @Autowired
    private ApiOrderRollbackService apiOrderRollbackService;

    @Autowired
    private OrderTypeMiddleService orderTypeMiddleService;

    @Autowired
    private DhgateOrderUtils dhgateOrderUtils;

    @Autowired
    private OrderWaybillUtils orderWaybillUtils;

    @Autowired
    private LogServiceUtils logServiceUtils;

    @Resource
    private OrderSyncSkuBindService orderSyncSkuBindService;

    @Resource
    private OrderSyncSkuDeclareService orderSyncSkuDeclareService;

    @Resource
    private OrderSyncPromotionOrderService orderSyncPromotionOrderService;

    @Resource
    private OrderCancelService orderCancelService;

    @Resource
    private OrderSync3plService orderSync3PlService;

    @Autowired
    private TikTokApiUtil tikTokApiUtil;

    private final Lock lockCustomer = new ReentrantLock();

    /**
     * addOrderSynMap 订单同步相关信息入库
     * 多线程操作
     *
     * @param orderInfo
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOrderDetailSyn(TbOrderInfo orderInfo) throws Exception {
        try {
            addOrderToTransaction(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 订单同步  增量
     *
     * @param orderInfo
     * @throws Exception
     */
    private void addOrderToTransaction(TbOrderInfo orderInfo) throws Exception {
        try {
            //订单数据 -> 数据库
            addOrderToDb(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 订单数据入库
     *
     * @param orderInfo
     * @throws Exception
     */
    private void addOrderToDb(TbOrderInfo orderInfo) throws Exception {
        BigInteger parcelNo = null;
        //保存请求信息
        savePostJson(orderInfo);
        //订单商品信息
        List<TbOrderProducts> orderProducts = orderInfo.getOrderProducts();
        //订单
        TbOrder order = orderInfo.getOrder();
        //店铺id
        Long shopId = order.getShopId();
        //买家信息表
        TbOrderBuyerInfo orderBuyer = orderInfo.getOrderBuyer();
        //是否耍单
        isBrushBill(order, orderBuyer, orderInfo.getWaybillSite(), orderInfo.getCreatorId());
        if (Objects.nonNull(order)) {
            try {
                orderService.insertData(order);
            } catch (DuplicateKeyException e) {
                throw new OrderException("订单唯一键重复异常，请检查同步数据(插入重复数据,并发操作冲突)；" + order.getOrderNo());
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new OrderException("订单获取异常，请检查同步数据！");
        }


        //订单日志
        TbOrderLog orderLogs = orderInfo.getOrderLogs();
        if (Objects.nonNull(orderLogs)) {
            orderOperateLogService.insertData(orderLogs);
        }

        //订单费用明细
        TbOrderCostDetail orderCostDetail = orderInfo.getOrderCostDetail();
        assembleOrderCostDetail(orderCostDetail, orderProducts);
        if (Objects.nonNull(orderCostDetail)) {
            orderCostDetailService.insertData(orderCostDetail);
        } else {
            throw new OrderException("订单费用明细获取异常，请检查同步数据！");
        }

        //是否需要保存订单类型中间表信息
        isSaveOrderTypeMiddle(orderInfo);

        //运单表
        List<TbWaybill> waybills = orderInfo.getWaybills();
        if (CollectionUtils.isNotEmpty(waybills)) {
            parcelNo = updateParcelNo(waybills, orderProducts);
            waybillServiceUtils.saveMul(waybills);
        } else {
            throw new OrderException("运单获取异常，请检查同步数据！");
        }
        //装配运单中间表
        List<TbOrderWaybill> orderWaybills = getOrderWaybills(order, waybills);
        //运单中间表
        if (CollectionUtils.isNotEmpty(orderWaybills)) {
            orderWaybillService.saveMul(orderWaybills);
        }
        //运单地址表
//        TbWaybillSite waybillSite = orderInfo.getWaybillSite();
        //运单地址装配 关联运单id
        List<TbWaybillSite> waybillSites = assembleWaybillSites(waybills, orderInfo.getWaybillSite());
        if (CollectionUtils.isNotEmpty(waybillSites)) {
            //去除前后空格
            dhgateOrderUtils.waybillSitesTrim(waybillSites);
            waybillSiteService.saveMul(waybillSites);
        } else {
            throw new OrderException("运单地址获取异常，请检查同步数据！");
        }
        //荷兰邮箱装配
        orderUtils.isNetherlands(orderInfo.getWaybillSite(), orderBuyer);
        //买家信息装配 买家信息补充
//        assembleOrderBuyerInfos(orderInfo.getWaybillSite(), orderBuyer);
        if (Objects.nonNull(orderBuyer)) {
            orderBuyerInfoService.insertData(orderBuyer);
        } else {
            throw new OrderException("买家信息获取异常，请检查同步数据！");
        }

        if (CollectionUtils.isEmpty(orderProducts)) {
            throw new OrderException("订单商品获取异常，请检查同步数据！");
        }
        //商品信息装配 商品信息补充
        orderSyncSkuBindService.orderSkuAndProductSkuBind(orderProducts, shopId);
        if (CollectionUtils.isNotEmpty(orderProducts)) {
            //更新包裹号到订单商品
            updateParcelNoToOrderProduct(parcelNo, orderProducts);
            orderProducts.stream().filter(product -> ObjectUtil.isEmpty(product.getOrderNumber())).forEach(product -> product.setOrderNumber(product.getNumber()));
            orderProductsService.saveMul(orderProducts);
        }

        //商品申报信息处理
        orderSyncSkuDeclareService.orderSkuAndProductSkuToDeclare(orderProducts);
        //启动多线程下载图片 TODO
        imageDownloadTask.downloadImgJobByOrderProduct(orderProducts);
    }

    /**
     * 保存请求信息
     *
     * @param orderInfo
     * @throws Exception
     */
    private void savePostJson(TbOrderInfo orderInfo) throws Exception {
        TbOrder order = orderInfo.getOrder();
        String orderNo = order.getOrderNo();
        List<TbOrderRequestBody> orderRespBodyList = new ArrayList<>();

        String orderDetailRespJson = orderInfo.getOrderDetailRespJson();
        String orderProductRespJson = orderInfo.getOrderProductRespJson();
        String logisticTrackRespJson = orderInfo.getLogisticTrackRespJson();

        //订单详情
        if (orderDetailRespJson != null) {
            TbOrderRequestBody requestBody = new TbOrderRequestBody();
            requestBody.setOrderNo(orderNo);
            requestBody.setRequestType(1);
            requestBody.setOrderDetail(orderDetailRespJson);
            requestBody.setSynTime(new Date());
            orderRespBodyList.add(requestBody);
        }

        //订单产品信息
        if (orderProductRespJson != null) {
            TbOrderRequestBody requestBody = new TbOrderRequestBody();
            requestBody.setOrderNo(orderNo);
            requestBody.setRequestType(3);
            requestBody.setOrderDetail(orderProductRespJson);
            requestBody.setSynTime(new Date());
            orderRespBodyList.add(requestBody);
        }

        //订单物流轨迹
        if (logisticTrackRespJson != null) {
            TbOrderRequestBody requestBody = new TbOrderRequestBody();
            requestBody.setOrderNo(orderNo);
            requestBody.setRequestType(5);
            requestBody.setOrderDetail(logisticTrackRespJson);
            requestBody.setSynTime(new Date());
            orderRespBodyList.add(requestBody);
        }
        if (ObjectUtil.isNotEmpty(orderRespBodyList)) {
            orderRequestBodyService.saveMul(orderRespBodyList);
        }
    }

    /**
     * 订单-物流 中间表获取
     *
     * @param waybills
     * @return
     */
    private List<TbOrderWaybill> getOrderWaybills(TbOrder order, List<TbWaybill> waybills) {
        List<TbOrderWaybill> result = new ArrayList<>();
        for (TbWaybill waybill : waybills) {
            if (Objects.isNull(order)) {
                return null;
            }
            if (Objects.isNull(waybill)) {
                continue;
            }
            Long orderId = order.getId();
            Long waybillId = waybill.getId();
            TbOrderWaybill orderWaybill = new TbOrderWaybill();
            orderWaybill.setOrderId(orderId);
            orderWaybill.setWaybillId(waybillId);
            result.add(orderWaybill);
        }

        return result;
    }

    /**
     * 应收货款
     *
     * @param orderCostDetail
     * @param orderProducts
     */
    private void assembleOrderCostDetail(TbOrderCostDetail orderCostDetail, List<TbOrderProducts> orderProducts) {
//        BigDecimal receivableLoans = orderCostDetail.getReceivableLoans();
//        if (receivableLoans == null || receivableLoans.intValue() <= 0) {
//            BigDecimal fxPrice = orderProducts.stream().map(o -> o.getUnitPrice().multiply(new BigDecimal(o.getNumber())).setScale(4, BigDecimal.ROUND_HALF_UP)).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
//            orderCostDetail.setReceivableLoans(fxPrice);
//        }
    }

    /**
     * 物流更新包裹号
     *
     * @param waybills
     */
    private BigInteger updateParcelNo(List<TbWaybill> waybills, List<TbOrderProducts> orderProductsList) {
        for (TbWaybill waybill : waybills) {
            List<TbOrderProducts> products = waybill.getProducts();
            //获取包裹号自增
            BigInteger parcelNo = incrServiceUtils.generateParcelNo();
            //设置包裹号
            waybill.setParcelNo(parcelNo);
            //设置包裹类型(1: 初始包裹,2:拆包包裹
            waybill.setParcelType(1);
            //设置默认值
            orderWaybillUtils.setDefault(waybill);
            if (CollectionUtils.isNotEmpty(products)) {
                for (TbOrderProducts product : products) {
                    product.setParcelNo(parcelNo);
                }
            }
        }
        TbWaybill waybill = waybills.get(0);
        String orderNo = waybill.getOrderNo();
        Double fxWeight = orderProductsList.stream().filter(v -> orderNo.equals(v.getOrderNo())).filter(e -> Objects.nonNull(e.getBasisWeight())).mapToDouble(TbOrderProducts::getBasisWeight).filter(Objects::nonNull).summaryStatistics().getSum();
        //设置重量
        waybill.setFreightWeight(fxWeight);

        return waybill.getParcelNo();
    }

    /**
     * 运单地址装配
     *
     * @param waybills
     * @param waybillSite
     */
    private List<TbWaybillSite> assembleWaybillSites(List<TbWaybill> waybills, TbWaybillSite waybillSite) {
        List<TbWaybillSite> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(waybills)) {
            return null;
        }
        if (Objects.isNull(waybillSite)) {
            return null;
        }
        for (TbWaybill waybill : waybills) {
            TbWaybillSite newVo = new TbWaybillSite();
            BeanUtils.copyProperties(waybillSite, newVo);
            newVo.setWaybillId(waybill.getId());
            result.add(newVo);
        }
        return result;
    }

    /**
     * 更新包裹号到订单商品
     *
     * @param parcelNo
     * @param orderProductsList
     */
    private void updateParcelNoToOrderProduct(BigInteger parcelNo, List<TbOrderProducts> orderProductsList) {
        orderProductsList.forEach(orderProduct -> {
            if (orderProduct.getParcelNo() == null) {
                orderProduct.setParcelNo(parcelNo);
            }
        });
    }

    /**
     * updateOrderSynMap 订单同步相关信息入库 更新
     * 自动
     *
     * @param orderInfo
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateOrderDetailSyn(TbOrderInfo orderInfo) throws Exception {
        try {
            updateOrderToTransaction(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void inCancelOrderDetailSyn(PlatformSyncDTO psDTO, TbOrderInfo orderInfo) throws Exception {
        TbOrderCancel orderCancel = getTbOrderCancel(psDTO, orderInfo);
        orderCancelService.insertData(orderCancel);
    }

    /**
     * 申请取消订单 数据保存
     */
    @NotNull
    private TbOrderCancel getTbOrderCancel(PlatformSyncDTO psDTO, TbOrderInfo orderInfo) {
        TbPlatform platform = psDTO.getPlatform();
        Long platformId = platform.getId();
        String platformName = platform.getPlatformName();
        Long merchantId = psDTO.getMerchantId();
        TbShop shop = psDTO.getShop();
        Long shopId = shop.getId();
        String shopName = shop.getName();
        TbShopEmployee shopEmployee = psDTO.getShopEmployee();
        Long shopownerId = shopEmployee.getEmployeeId();

        String orderNo = orderInfo.getOrderNo();
        String buyerCancelReason = orderInfo.getBuyerCancelReason();
        Date applyCancelTime = orderInfo.getApplyCancelTime();
        Long creatorId = psDTO.getCreatorId();
        Long updateId = psDTO.getCreatorId();

        TbOrderCancel orderCancel = new TbOrderCancel();
        orderCancel.setOrderNo(orderNo);
        orderCancel.setPlatformCode(platform.getPlatformCode());
        orderCancel.setPlatformName(platformName);
        orderCancel.setMerchantId(merchantId);
        orderCancel.setShopId(shopId);
        orderCancel.setShopName(shopName);
        orderCancel.setShopownerId(shopownerId);
        orderCancel.setCancelStatus(1);
        orderCancel.setApplyCancelTime(applyCancelTime);
        orderCancel.setBuyerCancelReason(buyerCancelReason);
        orderCancel.setCreateId(creatorId);
        orderCancel.setCreateTime(new Date());
        orderCancel.setUpdateId(updateId);
        orderCancel.setUpdateTime(new Date());
        return orderCancel;
    }

    /**
     * 订单同步  存量
     *
     * @param orderInfo
     * @throws Exception
     */
    private void updateOrderToTransaction(TbOrderInfo orderInfo) throws Exception {
        try {
            //订单数据 -> 数据库
            updateOrderToDb(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 订单数据入库
     *
     * @param orderInfo
     * @throws Exception
     */
    private void updateOrderToDb(TbOrderInfo orderInfo) throws Exception {
        //订单
        TbOrder order = orderInfo.getOrder();
        String platformCode = orderInfo.getPlatformCode();
        Integer platformOrderStatus = order.getPlatformOrderStatus();
        TbOrder query = orderService.selectOneByProperty(TbOrder::getOrderNo, order.getOrderNo());
        if (platformOrderStatus.compareTo(query.getPlatformOrderStatus()) == 0) {
            return;
        }
        //保存请求信息
        saveUpdatePostJson(orderInfo);
        //未发货订单，申请退款、订单取消、高风险订单、拒付订单 判断
        isAbnormalPlatformOrderStatus(orderInfo);
        if (Objects.nonNull(order)) {
            order.setPlatformCode(platformCode);
            orderService.updatePlatformOrderStatusByOrderNo(order);
        }
        //是否需要保存订单类型中间表信息
        isSaveOrderTypeMiddle(orderInfo);
        //订单日志
        TbOrderLog orderLogs = orderInfo.getOrderLogs();
        if (Objects.nonNull(orderLogs)) {
            orderOperateLogService.insertData(orderLogs);
        }
        //更新3pl揽收情况
        if (orderInfo.getPlatform3pl() != null) {
            orderSync3PlService.update3plPackageRecord(query.getId(), orderInfo.getPlatform3pl());
        }
    }

    /**
     * 保存请求信息
     *
     * @param orderInfo
     * @throws Exception
     */
    private void saveUpdatePostJson(TbOrderInfo orderInfo) throws Exception {
        TbOrder order = orderInfo.getOrder();
        String orderNo = order.getOrderNo();
        List<TbOrderRequestBody> requestBodies = new ArrayList<>();

        String orderDetailRespJson = orderInfo.getOrderDetailRespJson();

        //订单详情
        if (orderDetailRespJson != null) {
            TbOrderRequestBody requestBody = new TbOrderRequestBody();
            requestBody.setOrderNo(orderNo);
            requestBody.setRequestType(11);
            requestBody.setOrderDetail(orderDetailRespJson);
            requestBody.setSynTime(new Date());
            requestBodies.add(requestBody);
        }
        orderRequestBodyService.saveMul(requestBodies);
    }

    /**
     * 111000,订单取消;
     * 101003,等待买家付款;
     * 102001,买家已付款，等待平台确认;
     * 103001,等待发货;
     * 105001,买家申请退款，等待协商结果;
     * 105002,退款协议已达成;
     * 105003,部分退款后，等待发货;
     * 105004,买家取消退款申请;
     * 103002,已部分发货;
     * 101009,等待买家确认收货;
     * 106001,退款/退货协商中，等待协议达成;
     * 106002,买家投诉到平台;
     * 106003,协议已达成，执行中;
     * 102006,人工确认收货;
     * 102007,超过预定期限，自动确认收货;
     * 102111,交易成功;
     * 111111,交易关闭
     */
    //未发货订单，申请退款、订单取消、高风险订单、拒付订单
    private void isAbnormalPlatformOrderStatus(TbOrderInfo orderInfo) {
        String abnormalCause = orderInfo.getAbnormalCause();
        TbOrder order = orderInfo.getOrder();
        Long merchantId = orderInfo.getMerchantId();
        try {
            if (StringUtils.isNotBlank(abnormalCause)) {
                OperatorDTO oDto = new OperatorDTO();
                oDto.setOperatorName(orderInfo.getCreator());
                oDto.setOperatorId(orderInfo.getCreatorId());
                apiOrderRollbackService.orderRollbackStatus(order.getOrderNo(), abnormalCause, oDto);
            }
        } catch (Exception e) {
            logger.error("订单状态变更失败！：" + ExceptionUtils.exToString(e));
            try {
                logServiceUtils.saveOrderSynLog(orderInfo, order, e, 2,merchantId);
            } catch (Exception ce) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 是否需要保存订单类型中间表信息
     *
     * @param orderInfo
     * @throws Exception
     */
    private void isSaveOrderTypeMiddle(TbOrderInfo orderInfo) throws Exception {
        TbOrder order = orderInfo.getOrder();
        List<Long> orderTypeMiddles = orderInfo.getOrderTypeMiddles();

        String orderNo = order.getOrderNo();
        Long orderId = order.getId();
        if (orderId == null || orderId <= 0) {
            TbOrder query = orderService.selectOneByProperty(TbOrder::getOrderNo, orderNo);
            orderId = query.getId();
        }

        if (CollectionUtils.isNotEmpty(orderTypeMiddles)) {
            //订单类型保存
            List<TbOrderTypeMiddle> otms = new ArrayList<>();
            for (Long typeId : orderTypeMiddles) {
                TbOrderTypeMiddle middle = new TbOrderTypeMiddle();
                middle.setOrderId(orderId);
                middle.setTypeId(typeId);
                otms.add(middle);
            }
            orderTypeMiddleService.saveMul(otms);
        }

    }

    /**
     * 是否耍单订单
     *
     * @param order
     * @throws Exception
     */
    public void isBrushBill(TbOrder order, TbOrderBuyerInfo obDO, TbWaybillSite wsDO, Long creatorId) throws Exception {
        if (order.getCustomerBase() != null && order.getCustomerBase().getCustomerType() == -1) {
            //设置订单类型 耍单订单
            order.setOrderType(2);
        }
        //客户信息处置
        //加锁
        lockCustomer.lock();
        try {
            orderSyncPromotionOrderService.promotionOrderProcessor(order, obDO, wsDO, creatorId);
        } finally {
            lockCustomer.unlock();
        }
    }
}
