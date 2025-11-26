//package com.eshop.jushuitan;
//
//import bizark.StringUtil;
//import com.alibaba.fastjson.JSONObject;
//import com.bizark.common.exception.AppRuntimeException;
//import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
//import com.eshop.util.platform.api.service.order.jushuitan.JushuitanOrderCall;
//import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanSaleOrderListReqDTO;
//import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanSaleOrderListRespVO;
//import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanSaleOrderVO;
//import com.xxl.conf.core.XxlConfClient;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.Executor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Slf4j
//@Component
//public class JushuitanSaleOrderSyncService {
//
//    private static final Logger logger = LoggerFactory.getLogger(JushuitanSaleOrderSyncService.class);
//    private static final int PAGE_SIZE = 50;
//    private static final int RATE_LIMIT_DELAY = 200; // 200ms 限流延迟
//
//    @Qualifier("jstTaskExecutor")
//    @Autowired
//    private Executor jstTaskExecutor;
//
//    @Autowired
//    private JushuitanOrderCall jushuitanOrderCall;
//
//    /**
//     * 异步分页查询出库单
//     */
//    public void asyncQueryByTime(String startTime, String endTime, AccountEntity account) throws Exception {
//        long startTimeTol = System.currentTimeMillis();
//        String connectStr = account.getConnectStr();
//        if (StringUtil.isEmpty(connectStr)) {
//            logger.warn("#JushuitanSaleOrderSyncService.java# 店铺{}授权信息为空，跳过同步", account.getSellerId());
//            return;
//        }
//        JSONObject connectJson = JSONObject.parseObject(connectStr);
//        String accessToken = connectJson.getString("access_token");
//        if (StringUtil.isEmpty(accessToken)) {
//            accessToken = connectJson.getString("accessToken");
//        }
//        if (StringUtil.isEmpty(accessToken)) {
//            logger.warn("#JushuitanSaleOrderSyncService.java# 店铺{}授权信息中access_token为空，跳过同步", account.getSellerId());
//            return;
//        }
//        logger.info("#JushuitanSaleOrderSyncService.java# 开始同步销售订单，时间范围: {} - {}", startTime, endTime);
//
//        JushuitanAppClientDTO appClient = getAppClient(accessToken);
//        try {
//            // 1. 先获取总条数
//            int totalCount = getTotalCount(startTime, endTime, appClient);
//            if (totalCount == 0) {
//                logger.info("#JushuitanSaleOrderSyncService.java# 无出库单数据需要同步");
//                return;
//            }
//
//            // 2. 计算总页数
//            int totalPages = (totalCount + PAGE_SIZE - 1) / PAGE_SIZE;
//            logger.info("#JushuitanSaleOrderSyncService.java# 总条数: {}, 总页数: {}", totalCount, totalPages);
//
//            // 3. 创建异步任务列表
//            List<CompletableFuture<Void>> futures = new ArrayList<>();
//            // 使用原子类进行线程安全的计数
//            AtomicInteger totalSuccess = new AtomicInteger(0);
//            AtomicInteger completedPages = new AtomicInteger(0);
//
//            // 4. 提交所有异步任务
//            for (int pageIndex = 1; pageIndex <= totalPages; pageIndex++) {
//                final int currentPage = pageIndex;
//
//                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//                    //执行订单同步
//                    processSinglePage(startTime, endTime, currentPage, appClient);
//                    totalSuccess.incrementAndGet();
//                }, jstTaskExecutor).exceptionally(throwable -> {
//                    // 处理页面级异常
//                    log.error("页面处理异常, pageIndex: {}", currentPage, throwable);
//                    completedPages.incrementAndGet();
//                    return null;
//                });
//                futures.add(future);
//            }
//
//            // 5. 等待所有任务完成
//            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
//                    futures.toArray(new CompletableFuture[0])
//            );
//
//            // 获取结果并统计
//            allFutures.get(); // 等待所有任务完成
//            // 输出同步统计
//            long duration = System.currentTimeMillis() - startTimeTol;
//            // 统计结果（这里需要在实际的processSinglePage方法中记录结果）
//            logger.info("#JushuitanSaleOrderSyncService.java# 同步完成 - 成功: {}, 失败: {}, 耗时: {}ms",
//                    totalSuccess.get(), completedPages.get(), duration);
//        } catch (Exception e) {
//            logger.error("#JushuitanSaleOrderSyncService.java# 同步出库单失败", e);
//        }
//    }
//
//    /**
//     * 获取总条数
//     */
//    private int getTotalCount(String startTime, String endTime, JushuitanAppClientDTO appClient) {
//        try {
//            // 限流控制
//            Thread.sleep(RATE_LIMIT_DELAY);
//            JushuitanSaleOrderListReqDTO params = buildBaseParams(startTime, endTime);
//            //设置分页参数
//            params.setPage_index(1);
//            params.setPage_size(1);
//            params.setIs_get_total(true);
//
//            JushuitanSaleOrderListRespVO response = callOutboundApi(params, appClient);
//            if (response != null && response.getData() != null && response.getData().getData_count() != null) {
//                return response.getData().getData_count();
//            }
//        } catch (Exception e) {
//            logger.error("#JushuitanSaleOrderSyncService.java# 获取总条数失败", e);
//        }
//        return 0;
//    }
//
//    /**
//     * 处理单页数据
//     */
//    private void processSinglePage(String startTime, String endTime, int pageIndex,
//                                   JushuitanAppClientDTO appClient) {
//        logger.info("#JushuitanSaleOrderSyncService.java# 开始处理第{}页数据", pageIndex);
//
//        JushuitanSaleOrderListReqDTO params = buildBaseParams(startTime, endTime);
//        params.setPage_index(pageIndex);
//        params.setPage_size(PAGE_SIZE);
//        params.setIs_get_total(false);
//
//        int successCount = 0;
//        int failedCount = 0;
//
//        try {
//            // 限流控制 - 每个请求前延迟
//            Thread.sleep(RATE_LIMIT_DELAY);
//
//            JushuitanSaleOrderListRespVO response = callOutboundApi(params, appClient);
//            List<JushuitanSaleOrderVO> orders = response.getData().getDatas();
//
//            if (orders == null || orders.isEmpty()) {
//                logger.info("#JushuitanSaleOrderSyncService.java# 第{}页无出库单数据", pageIndex);
//                return;
//            }
//
//            // 处理订单数据
//            for (JushuitanSaleOrderVO order : orders) {
//                try {
//                    processSingleOrder(order);
//                    successCount++;
//                } catch (Exception e) {
//                    logger.error("#JushuitanSaleOrderSyncService.java# 第{}页订单处理失败，订单号: {}",
//                            pageIndex, order.getSo_id(), e);
//                    failedCount++;
//                }
//            }
//
//            logger.info("#JushuitanSaleOrderSyncService.java# 第{}页处理完成 - 成功: {}, 失败: {}",
//                    pageIndex, successCount, failedCount);
//
//        } catch (Exception e) {
//            logger.error("#JushuitanSaleOrderSyncService.java# 第{}页同步失败: {}", pageIndex, e.getMessage());
//            throw new AppRuntimeException("JushuitanSaleOrderSyncService.java# 同步失败,页" + pageIndex);
//        }
//    }
//
//    /**
//     * 构建基础参数 - 查询
//     */
//    private JushuitanSaleOrderListReqDTO buildBaseParams(String startTime, String endTime) {
//        //时间条件，内部单号不能同时为空，最大限制20条
//        JushuitanSaleOrderListReqDTO reqDTO = new JushuitanSaleOrderListReqDTO();
//        //modified_begin	string	否	2021-12-02 10:26:25	起始时间，和结束时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空;tips:用时间条件查询由于查询中数据存在变动的可能会由于排序问题引发分页查询漏单的问题，建议使用ts时间戳增量查询的方式
//        reqDTO.setModified_begin(startTime);
//        //modified_end	string	否	2021-12-09 10:26:25	结束时间，和起始时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空
//        reqDTO.setModified_end(endTime);
//        return reqDTO;
//    }
//
//    /**
//     * 处理单个订单
//     */
//    private void processSingleOrder(JushuitanSaleOrderVO order) {
//        // 具体的订单处理逻辑
//        // orderService.saveOrUpdate(order);
//    }
//
//    /**
//     * 调用销售订单API
//     */
//    private JushuitanSaleOrderListRespVO callOutboundApi(JushuitanSaleOrderListReqDTO params, JushuitanAppClientDTO appClient) throws Exception {
//        // 具体的API调用逻辑
//        return jushuitanOrderCall.getSaleOrderList(appClient, params);
//    }
//
//    /**
//     * 鉴权公共参数装配
//     */
//    private JushuitanAppClientDTO getAppClient(String accessToken) throws Exception {
//        //请求地址
//        String apiUrl = XxlConfClient.get("bizark-multichannel.jushuitan.api.url");
//        // 公钥私钥
//        String appKey = XxlConfClient.get("bizark-multichannel.jushuitan.app.key");
//        String appSecret = XxlConfClient.get("bizark-multichannel.jushuitan.app.secret");
//
//        JushuitanAppClientDTO temuAcDTO = new JushuitanAppClientDTO();
//        temuAcDTO.setAppKey(appKey);
//        temuAcDTO.setAppSecret(appSecret);
//        temuAcDTO.setAccessToken(accessToken);
//        temuAcDTO.setApiUrl(apiUrl);
//
//        return temuAcDTO;
//    }
//}
