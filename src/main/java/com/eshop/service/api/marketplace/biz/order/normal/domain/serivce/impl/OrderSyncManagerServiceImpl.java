package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;

import com.alibaba.fastjson.JSONObject;
import com.eshop.api.modules.service.api.marketplace.order.domain.order.domain.repository.OrderClient;
import com.eshop.api.modules.service.api.marketplace.order.domain.order.domain.serivce.*;
import com.eshop.api.modules.service.api.marketplace.order.domain.order.infrastructure.temu.TemuPurchaseOrderClientImpl;
import com.eshop.api.modules.service.log.ApiOrderLogService;
import com.eshop.api.modules.task.AutoSyncProduct;
import com.eshop.api.modules.task.order.finance.OrderCostShopeeSyncTask;
import com.eshop.api.modules.util.TikTokApiUtil;
import com.eshop.api.modules.util.service.LogServiceUtils;
import com.eshop.db.config.service.ShopConfigService;
import com.eshop.modal.constant.ConstantRedis;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.config.PlatformSyncInfoResponseVO;
import com.eshop.modal.entry.platform.config.PlatformSyncListResponseVO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.exception.OrderException;
import com.eshop.modal.modal.eshop_config.TbShopConfig;
import com.eshop.modal.modal.eshop_order.TbOrder;
import com.eshop.modal.modal.eshop_order.TbOrderProducts;
import com.eshop.modal.response.PageUtil;
import com.eshop.modal.webutil.order.PlatformPageCursorDto;
import com.eshop.modal.webutil.order.TbOrderInfo;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSyncExecutorService;
import com.eshop.util.DateUtil;
import com.eshop.util.ExceptionUtils;
import com.eshop.util.redis.RedisUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Executor;

/**
 * @author ldj
 * @date 2023/6/26 14:06
 * @Description: ...
 * @Version 1.0
 */
@Service
@Scope("prototype")
public class OrderSyncManagerServiceImpl implements OrderSyncManagerService {

    private static final Logger logger = LoggerFactory.getLogger(OrderSyncManagerServiceImpl.class);

    @Autowired
    private OrderSyncRecordService orderSyncRecordService;

    @Autowired
    private OrderSyncCustomerService orderSyncCustomerService;

    @Autowired
    private OrderSyncFilterService apiOrderSynFilterService;

    @Autowired
    private OrderSyncExecutorService orderSyncExecutorService;

    @Autowired
    private LogServiceUtils logServiceUtils;

    @Autowired
    private AutoSyncProduct autoSyncProduct;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ShopConfigService shopConfigService;

    @Autowired
    @Qualifier(value = "syncProductPool")
    private ThreadPoolTaskExecutor syncProductPool;

    @Autowired
    private ApiOrderLogService orderLogService;

    @Autowired
    private OrderSyncSkuBindService orderSyncSkuBindService;

    @Autowired
    private OrderCostShopeeSyncTask orderCostShopeeSyncTask;
    @Autowired
    private TikTokApiUtil tikTokApiUtil;
    /**
     * 分页数量(增量)
     */
    public final static Integer ORDER_SYN_PAGE_SIZE = 50;

    private final OrderClient orderClient;

    @Autowired
    public OrderSyncManagerServiceImpl(@Qualifier("aliExpressAscpCfOrderClientImpl") OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @Override
    public void orderSyncAdd(PlatformSyncDTO psDto, OrderSyncDTO osDto, boolean isCursor) throws SQLException, Exception {
        //同步订单
        PageUtil page = orderClient.getSyncOrderListCount(psDto, osDto, 1, ORDER_SYN_PAGE_SIZE);

        logger.info("店铺" + psDto.getShop().getId() + "新增" + JSONObject.toJSONString(page));
        //判断是否是走游标方式
        if (isCursor) {
            //游标同步
            synchronizeAddOrderListWithCursor(psDto, osDto, 1, ORDER_SYN_PAGE_SIZE, null);
        } else if (page.getTotalNum() > 0) {
            // 计算总页面数
            int totalPages = (page.getTotalNum() + ORDER_SYN_PAGE_SIZE - 1) / ORDER_SYN_PAGE_SIZE;
            // 遍历每一页
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                //普通同步
                synchronizeAddOrderList(psDto, osDto, currentPage, ORDER_SYN_PAGE_SIZE);
            }
        }
    }

    /**
     * 游标方式
     */
    public void synchronizeAddOrderListWithCursor(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws SQLException, Exception {
        try {
            //游标方式 新增 请求订单列表数据
            PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = orderClient.getAddSyncOrderList(psDto, osDto, pageNo, pageSize, cursorDto);
            if (orderListSync == null) {
                return;
            }
            //订单同步 新增 订单列表处理
            processAddOrderList(psDto, osDto, orderListSync);
            //判断是否需要下一页 递归同步订单
            if (Boolean.TRUE.equals(orderListSync.getMore())) {
                PlatformPageCursorDto newCursorDto = new PlatformPageCursorDto();
                newCursorDto.setNextCursor(orderListSync.getNextCursor());
                newCursorDto.setMore(true);
                synchronizeAddOrderListWithCursor(psDto, osDto, pageNo + 1, pageSize, newCursorDto);
            }
        } catch (Exception e) {
            logServiceUtils.saveOrderErrLog(psDto, osDto, e);
            logger.error("新增 定时订单失败！线程外部部异常：" + ExceptionUtils.exToString(e));
            logger.error("新增 定时订单失败！请求参数：" + JSONObject.toJSON(psDto));
            logger.error("新增 定时订单失败！搜索参数：" + JSONObject.toJSON(osDto));
            e.printStackTrace();
        }
    }

    /**
     * 分页方式
     */
    public void synchronizeAddOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize) throws SQLException, Exception {
        try {
            //分页方式 新增 请求订单列表数据
            PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = orderClient.getAddSyncOrderList(psDto, osDto, pageNo, pageSize, null);
            if (orderListSync == null) {
                return;
            }
            //订单同步 新增 订单列表处理
            processAddOrderList(psDto, osDto, orderListSync);
        } catch (Exception e) {
            logServiceUtils.saveOrderErrLog(psDto, osDto, e);
            logger.error("新增 定时订单失败！线程外部部异常：" + ExceptionUtils.exToString(e));
            logger.error("新增 定时订单失败！请求参数：" + JSONObject.toJSON(psDto));
            logger.error("新增 定时订单失败！搜索参数：" + JSONObject.toJSON(osDto));
            e.printStackTrace();
        }
    }

    /**
     * 订单同步 新增 订单列表处理
     */
    private void processAddOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync) throws Exception {
        //订单同步 新增 执行订单号过滤
        List<PlatformSyncInfoResponseVO<TbOrder>> poList = apiOrderSynFilterService.orderAddFilter(orderListSync.getSyncList(), psDto);
        if (CollectionUtils.isEmpty(poList)) {
//            logger.error("新增 订单过滤后为空！");
            String errMsg = "新增 订单过滤后为空！";
            logServiceUtils.saveOrderErrLog(psDto, osDto, errMsg);
            return;
        }
        //客户类型先行验证
        orderSyncCustomerService.customerProcess(psDto, poList);
        //启动多线程调度 同步订单列表的订单详情
        poList.forEach(po -> {
            Executor orderSynPool = getSyncPool(psDto.getPlatform().getPlatformCode());
            orderSynPool.execute(() -> {
                //处理新增订单详情同步
                processAddOrderDetailSync(psDto, po);
            });
        });
    }


    /**
     * 处理新增订单详情同步
     */
    private void processAddOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) {
        try {
            TbOrderInfo orderInfo = orderClient.getAddOrderDetailSync(psDto, po);
            if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
                logServiceUtils.saveOrderSynLog2(psDto, po.getInfo().getOrderNo(), orderInfo.getSyncNotMsg(), 1);
//                logger.error("新增 定时订单失败,判定订单状态无法同步！" + orderInfo.getSyncNotMsg());
                return;
            }
            orderInfo.setPlatformCode(psDto.getPlatform().getPlatformCode());
            orderInfo.setCreator(psDto.getCreator());
            orderInfo.setCreatorId(psDto.getCreatorId());
            //去除产品shopSku前后空格
            trimShopSku(orderInfo);
            orderSyncRecordService.addOrderDetailSyn(orderInfo);
            //同步虾皮订单费用
            boolean isAdd = true;
            addOrUpdateWithOrderCost(orderInfo, psDto, isAdd);
            //syncProduct(orderInfo);
        } catch (OrderException e) {
            logServiceUtils.saveOrderSynLog2(psDto, po.getInfo().getOrderNo(), e.getMsg(), 1);
        } catch (Exception e) {
            logServiceUtils.saveOrderSynLog(psDto, po.getInfo().getOrderNo(), e, 1);
            logger.error("新增 定时订单失败！线程内部异常：" + ExceptionUtils.exToString(e));
            logger.error("新增 定时订单失败！请求参数：{}", JSONObject.toJSON(psDto));
            logger.error("新增 定时订单失败！请求订单号：{}", JSONObject.toJSON(po.getInfo()));
        }
    }

    //_____________________ 订单更新 _____________________//
    //_____________________ 订单更新 _____________________//
    //_____________________ 订单更新 _____________________//

    @Override
    public void orderSyncUpdate(PlatformSyncDTO psDto, OrderSyncDTO osDto, boolean isCursor) throws SQLException, Exception {
        //Temu备货单查询没有修改时间,把下单时间拉长前20天
        if (orderClient instanceof TemuPurchaseOrderClientImpl) {
            Date date = osDto.getStartDate();
            if (Objects.isNull(date)) {
                date = new Date();
            }
            osDto.setStartDate(DateUtil.addDay(date, -20));
        }
        PageUtil page = orderClient.getSyncOrderListCount(psDto, osDto, 1, ORDER_SYN_PAGE_SIZE);
        //判断是否是走游标方式
        if (isCursor) {
            //游标同步
            synchronizeUpdateOrderListWithCursor(psDto, osDto, 1, ORDER_SYN_PAGE_SIZE, null);
        } else if (page.getTotalNum() > 0) {
            // 计算总页面数
            int totalPages = (page.getTotalNum() + ORDER_SYN_PAGE_SIZE - 1) / ORDER_SYN_PAGE_SIZE;
            // 遍历每一页
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                //普通同步
                synchronizeUpdateOrderList(psDto, osDto, currentPage, ORDER_SYN_PAGE_SIZE);
            }
        }
    }


    /**
     * 游标方式
     */
    public void synchronizeUpdateOrderListWithCursor(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws SQLException, Exception {
        try {
            //游标方式 更新 请求订单列表数据
            PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = orderClient.getUpdateSyncOrderList(psDto, osDto, pageNo, pageSize, cursorDto);
            if (orderListSync == null) {
                return;
            }
            // 订单同步 更新 订单列表处理
            processUpdateOrderList(psDto, orderListSync);
            //判断是否需要下一页 递归同步订单
            if (Boolean.TRUE.equals(orderListSync.getMore())) {
                PlatformPageCursorDto newCursorDto = new PlatformPageCursorDto();
                newCursorDto.setNextCursor(orderListSync.getNextCursor());
                newCursorDto.setMore(true);
                synchronizeUpdateOrderListWithCursor(psDto, osDto, pageNo + 1, pageSize, newCursorDto);
            }
        } catch (Exception e) {
            logServiceUtils.saveOrderErrLog(psDto, osDto, e);
            logger.error("更新 定时订单失败！线程外部部异常：" + ExceptionUtils.exToString(e));
            logger.error("更新 定时订单失败！请求参数：" + JSONObject.toJSON(psDto));
            logger.error("更新 定时订单失败！搜索参数：" + JSONObject.toJSON(osDto));
            e.printStackTrace();
        }
    }

    /**
     * 分页方式
     */
    public void synchronizeUpdateOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize) throws SQLException, Exception {
        try {
            //分页方式 更新 请求订单列表数据
            PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = orderClient.getUpdateSyncOrderList(psDto, osDto, pageNo, pageSize, null);
            if (orderListSync == null) {
                return;
            }
            // 订单同步 更新 订单列表处理
            processUpdateOrderList(psDto, orderListSync);
        } catch (Exception e) {
            logServiceUtils.saveOrderErrLog(psDto, osDto, e);
            logger.error("更新 定时订单失败！线程外部部异常：" + ExceptionUtils.exToString(e));
            logger.error("更新 定时订单失败！请求参数：" + JSONObject.toJSON(psDto));
            logger.error("更新 定时订单失败！搜索参数：" + JSONObject.toJSON(osDto));
            e.printStackTrace();
        }
    }

    /**
     * 订单同步 更新 订单列表处理
     */
    private void processUpdateOrderList(PlatformSyncDTO psDto, PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync) throws Exception {
        List<PlatformSyncInfoResponseVO<TbOrder>> poList = apiOrderSynFilterService.orderUpdateFilter(orderListSync.getSyncList(), psDto);
        //没有订单 不处理
        if (CollectionUtils.isEmpty(poList)) {
//            logger.error("更新 订单过滤后为空！");
            String errMsg = "更新 订单过滤后为空！";
            logServiceUtils.saveOrderErrLog(psDto, null, errMsg);
            return;
        }
        //启动多线程调度 同步订单详情 更新
        for (PlatformSyncInfoResponseVO<TbOrder> po : poList) {
            Executor orderSynPool = getSyncPool(psDto.getPlatform().getPlatformCode());
            orderSynPool.execute(() -> {
                //处理更新订单详情同步
                processUpdateOrderDetailSync(psDto, po);
            });
        }
    }

    /**
     * 更新 处理订单详情同步
     */
    private void processUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po) {
        try {
            TbOrderInfo orderInfo = orderClient.getUpdateOrderDetailSync(psDto, po);
            updateOrderDetailSync(psDto, orderInfo);
        } catch (Exception e) {
            logServiceUtils.saveOrderSynLog(psDto, po.getInfo().getOrderNo(), e, 2);
            logger.error("新增 定时订单失败！线程内部异常：" + ExceptionUtils.exToString(e));
            logger.error("新增 定时订单失败！请求参数：{}", JSONObject.toJSON(psDto));
            logger.error("新增 定时订单失败！请求订单号：{}", JSONObject.toJSON(po.getInfo()));
        }
    }

    /**
     * 更新 处理订单详情同步
     */
    @Override
    public void updateOrderDetailSync(PlatformSyncDTO psDTO, TbOrderInfo orderInfo) {
        try {
            orderInfo.setCreator(psDTO.getCreator());
            orderInfo.setCreatorId(psDTO.getCreatorId());
            orderInfo.setPlatformCode(psDTO.getPlatform().getPlatformCode());

            //设置商户id
            orderInfo.setMerchantId(psDTO.getShop().getMerchantId());
            orderSyncRecordService.updateOrderDetailSyn(orderInfo);
            //更新虾皮订单费用
            boolean isAdd = false;
            addOrUpdateWithOrderCost(orderInfo, psDTO, isAdd);
        } catch (Exception e) {
            logServiceUtils.saveOrderSynLog(psDTO, orderInfo.getOrderNo(), e, 2);
            logger.error("新增 定时订单失败！线程内部异常：" + ExceptionUtils.exToString(e));
            logger.error("新增 定时订单失败！请求参数：{}", JSONObject.toJSON(psDTO));
            logger.error("新增 定时订单失败！请求订单号：{}", JSONObject.toJSON(orderInfo));
        }
    }


    //_____________________ 订单申请取消 _____________________//
    //_____________________ 订单申请取消 _____________________//
    //_____________________ 订单申请取消 _____________________//
    @Override
    public void orderSyncInCancel(PlatformSyncDTO psDto, OrderSyncDTO osDto, boolean isCursor) throws SQLException, Exception {
        PageUtil page = orderClient.getSyncOrderListCount(psDto, osDto, 1, ORDER_SYN_PAGE_SIZE);
        //判断是否是走游标方式
        if (isCursor) {
            //游标同步
            synchronizeInCancelOrderListWithCursor(psDto, osDto, 1, ORDER_SYN_PAGE_SIZE, null);
        } else if (page.getTotalNum() > 0) {
            // 计算总页面数
            int totalPages = (page.getTotalNum() + ORDER_SYN_PAGE_SIZE - 1) / ORDER_SYN_PAGE_SIZE;
            // 遍历每一页
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                //普通同步
                synchronizeInCancelOrderList(psDto, osDto, currentPage, ORDER_SYN_PAGE_SIZE);
            }
        }
    }

    /**
     * 游标方式
     */
    public void synchronizeInCancelOrderListWithCursor(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto) throws SQLException, Exception {
        try {
            //游标方式 更新 请求订单列表数据
            PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = orderClient.getInCancelSyncOrderList(psDto, osDto, pageNo, pageSize, cursorDto);
            if (orderListSync == null) {
                return;
            }
            // 订单同步 更新 订单列表处理
            processInCancelOrderList(psDto, orderListSync);
            //判断是否需要下一页 递归同步订单
            if (Boolean.TRUE.equals(orderListSync.getMore())) {
                PlatformPageCursorDto newCursorDto = new PlatformPageCursorDto();
                newCursorDto.setNextCursor(orderListSync.getNextCursor());
                newCursorDto.setMore(true);
                synchronizeInCancelOrderListWithCursor(psDto, osDto, pageNo + 1, pageSize, newCursorDto);
            }
        } catch (Exception e) {
            logServiceUtils.saveOrderErrLog(psDto, osDto, e);
            logger.error("申请取消 定时订单失败！线程外部部异常：" + ExceptionUtils.exToString(e));
            logger.error("申请取消 定时订单失败！请求参数：" + JSONObject.toJSON(psDto));
            logger.error("申请取消 定时订单失败！搜索参数：" + JSONObject.toJSON(osDto));
            e.printStackTrace();
        }
    }

    /**
     * 分页方式
     */
    public void synchronizeInCancelOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize) throws SQLException, Exception {
        try {
            //分页方式 更新 请求订单列表数据
            PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = orderClient.getInCancelSyncOrderList(psDto, osDto, pageNo, pageSize, null);
            if (orderListSync == null) {
                return;
            }
            // 订单同步 更新 订单列表处理
            processInCancelOrderList(psDto, orderListSync);
        } catch (Exception e) {
            logServiceUtils.saveOrderErrLog(psDto, osDto, e);
            logger.error("申请取消 定时订单失败！线程外部部异常：" + ExceptionUtils.exToString(e));
            logger.error("申请取消 定时订单失败！请求参数：" + JSONObject.toJSON(psDto));
            logger.error("申请取消 定时订单失败！搜索参数：" + JSONObject.toJSON(osDto));
            e.printStackTrace();
        }
    }

    /**
     * 订单同步 取消申请 订单列表处理
     */
    private void processInCancelOrderList(PlatformSyncDTO psDto, PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync) throws Exception {
        List<PlatformSyncInfoResponseVO<TbOrder>> poList = apiOrderSynFilterService.orderInCancelFilter(orderListSync.getSyncList(), psDto);
        //没有订单 不处理
        if (CollectionUtils.isEmpty(poList)) {
            logger.error("申请取消 订单过滤后为空！");
            return;
        }
        //启动多线程调度 同步订单详情 更新
        for (PlatformSyncInfoResponseVO<TbOrder> po : poList) {
            Executor orderSynPool = getSyncPool(psDto.getPlatform().getPlatformCode());
            orderSynPool.execute(() -> {
                //处理更新订单详情同步
                String orderNo = po.getInfo().getOrderNo();
                processInCancelOrderDetailSync(psDto, orderNo);
            });
        }
    }

    /**
     * 取消申请 处理订单详情同步
     */
    private void processInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo) {
        try {
            TbOrderInfo orderInfo = orderClient.getInCancelOrderDetailSync(psDto, orderNo);
            if (orderInfo.getIsSync() != null && orderInfo.getIsSync() == -1) {
                logServiceUtils.saveOrderSynLog2(psDto, orderNo, orderInfo.getSyncNotMsg(), 1);
                return;
            }
            orderInfo.setPlatformCode(psDto.getPlatform().getPlatformCode());
            orderInfo.setCreator(psDto.getCreator());
            orderInfo.setCreatorId(psDto.getCreatorId());
            inCancelOrderDetailSync(psDto, orderInfo);
        } catch (Exception e) {
            logServiceUtils.saveOrderSynLog(psDto, orderNo, e, 2);
            logger.error("申请取消 定时订单失败！线程内部异常：" + ExceptionUtils.exToString(e));
            logger.error("申请取消 定时订单失败！请求参数：{}", JSONObject.toJSON(psDto));
            logger.error("申请取消 定时订单失败！请求订单号：{}", JSONObject.toJSON(orderNo));
        }
    }

    /**
     * 取消申请 处理订单详情同步
     */
    public void inCancelOrderDetailSync(PlatformSyncDTO psDTO, TbOrderInfo orderInfo) {
        try {
            orderInfo.setCreator(psDTO.getCreator());
            orderInfo.setCreatorId(psDTO.getCreatorId());
            orderInfo.setPlatformCode(psDTO.getPlatform().getPlatformCode());
            orderSyncRecordService.inCancelOrderDetailSyn(psDTO, orderInfo);
        } catch (Exception e) {
            logServiceUtils.saveOrderSynLog(psDTO, orderInfo.getOrderNo(), e, 2);
            logger.error("申请取消 定时订单失败！线程内部异常：" + ExceptionUtils.exToString(e));
            logger.error("申请取消 定时订单失败！请求参数：{}", JSONObject.toJSON(psDTO));
            logger.error("申请取消 定时订单失败！请求订单号：{}", JSONObject.toJSON(orderInfo));
        }
    }

    @Override
    public void orderSyncCallback(PlatformSyncDTO psDto, String orderNo, JSONObject payload) throws SQLException, Exception {
        List<PlatformSyncInfoResponseVO<TbOrder>> orderRespList = getOrderRespList(orderNo, payload);
        if (CollectionUtils.isEmpty(orderRespList)) {
            return;
        }
        PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> orderListSync = new PlatformSyncListResponseVO<>();
        orderListSync.setJsonObj(payload);
        orderListSync.setSyncList(orderRespList);
        //是否有下一页
        orderListSync.setMore(null);
        //下一页游标
        orderListSync.setNextCursor(null);
        // 订单同步 更新 订单列表处理
        processUpdateOrderList(psDto, orderListSync);
    }

    /**
     * 获取订单信息
     */
    private List<PlatformSyncInfoResponseVO<TbOrder>> getOrderRespList(String orderNo, JSONObject payload) {
        List<PlatformSyncInfoResponseVO<TbOrder>> orderList = new ArrayList<>();

        if (StringUtils.isBlank(orderNo)) {
            return orderList;
        }
        String orderSn = orderNo;
        TbOrder order = new TbOrder();
        order.setOrderNo(orderSn);

        PlatformSyncInfoResponseVO<TbOrder> response = new PlatformSyncInfoResponseVO();
        response.setInfo(order);
        response.setJsonObj(payload);
        orderList.add(response);

        return orderList;
    }

    /**
     * 同步商品
     *
     * @author sheng
     * @date 2024-02-01 11:10
     */
    private void syncProduct(TbOrderInfo orderInfo) {
        try {
            String platformCode = orderInfo.getPlatformCode();
            TbOrder order = orderInfo.getOrder();
            Long shopId = order.getShopId();
            List<TbOrderProducts> orderProducts = orderInfo.getOrderProducts();
            //判断是是否绑定,自动同步商品
            if ("TikTok".equals(platformCode) || "Shopee".equals(platformCode)) {
                TbShopConfig shopConfig = shopConfigService.selectOneByProperty(TbShopConfig::getShopId, shopId);
                if (Objects.isNull(shopConfig)) {
                    orderLogService.saveInfo(order.getOrderNo(), "自动同步商品失败", "未获取到店铺配置信息!!!", "sys");
                }
                Long depotId = shopConfig.getDepotId();
                if (Objects.isNull(depotId) || depotId.longValue() == 0L) {
                    orderLogService.saveInfo(order.getOrderNo(), "自动同步商品失败", "该店铺未绑定仓库,请先绑定!!!", "sys");
                }
                //自动绑定
                Map<String, List<TbOrderProducts>> unboundSpuMap = orderSyncSkuBindService.autoBindingFinishProduct(orderProducts, depotId);
                if (!CollectionUtils.sizeIsEmpty(unboundSpuMap)) {
                    //保存需要缓存的商品,后面校验是否缓存过
                    for (Map.Entry<String, List<TbOrderProducts>> entry : unboundSpuMap.entrySet()) {
                        String rawSpu = entry.getKey();
                        rawSpu = rawSpu.trim();
                        String reidsKey = ConstantRedis.ORDER_SYNC_PRODUCT + depotId + ":" + rawSpu;
                        String value = redisUtils.getData(reidsKey, String.class);
                        if (StringUtils.isBlank(value)) {
                            String finalRawSpu = rawSpu;
                            redisUtils.set(reidsKey, DateUtil.format(new Date()), 60 * 60 * 1);
                            syncProductPool.execute(() -> {
                                // 执行业务逻辑
                                autoSyncProduct.syncProductAndBinding(finalRawSpu, entry.getValue(), orderInfo.getAuthInfoDTO(), shopId, platformCode, depotId);
                            });
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("订单自动同步商品" + e.toString());
        }
    }

    /**
     * 去除产品shopSku前后空格
     *
     * @param orderInfo
     */
    private void trimShopSku(TbOrderInfo orderInfo) {
        //订单商品信息
        List<TbOrderProducts> orderProducts = orderInfo.getOrderProducts();
        if (CollectionUtils.isNotEmpty(orderProducts)) {
            for (TbOrderProducts orderProduct : orderProducts) {
                if (StringUtils.isNotBlank(orderProduct.getShopSku())) {
                    orderProduct.setShopSku(orderProduct.getShopSku().trim());
                }
            }
        }
    }

    /**
     * 实时新增/更新 虾皮订单费用
     */
    private void addOrUpdateWithOrderCost(TbOrderInfo orderInfo, PlatformSyncDTO psDto, boolean isAdd) {
        try {
            if (psDto.getPlatform().getPlatformCode().equals("Shopee")) {
                orderCostShopeeSyncTask.addOrUpdateWithOrderCost(orderInfo, psDto);
            } else if ("TikTok".equals(psDto.getPlatform().getPlatformCode())) {
                //TK保存订单费用明细
                tikTokApiUtil.saveTkOrderCostDetail(orderInfo);
            }
        } catch (Exception e) {
            logger.error("订单费用同步异常", e);
        }
    }

    private Executor getSyncPool(String platformCode) {
        return orderSyncExecutorService.getOrderSyncPool(platformCode);
    }
}
