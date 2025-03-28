package com.eshop.hash;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eshop.entity.log.TbOrderRespLog;
import com.eshop.service.log.ITbOrderRespLogService;
import com.eshop.util.MurmurHashUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@SpringBootTest
public class HashControllerTest {

    @Autowired
    private ITbOrderRespLogService iTbOrderRespLogService;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;


    @Test
    public void queryHash_128() {
        QueryWrapper<TbOrderRespLog> wrapper = new QueryWrapper<>();
        // 时间范围（15天）
        wrapper
                .eq("order_no", "250210S3S2K810")
                .isNotNull("hash_128")
                .orderByAsc("id");  // 必须按ID排序

        List<TbOrderRespLog> list = iTbOrderRespLogService.list(wrapper);
        if (CollectionUtils.isNotEmpty(list)) {
            for (TbOrderRespLog respLog : list) {
                System.out.println(toHexString(respLog.getHash128()));
            }
        }
    }

    // 转换为十六进制字符串的方法
    public String toHexString(Byte[] hash128) {
        if (hash128 == null) {
            return null;
        }

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash128) {
            // 将每个字节转换为两位十六进制表示
            String hex = String.format("%02X", b);
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Test
    public void generateHash() {
        // 循环1w次，每次生成一个hash值，然后存入数据库
        // 生成hash值的方法：MurmurHashUtil.generateUniqueHash()
        List<TbOrderRespLog> tbOrderRespLogs = queryDataWithCursor();
        if (tbOrderRespLogs == null || tbOrderRespLogs.size() == 0) {
            log.info("没有数据");
            return;
        }

        List<TbOrderRespLog> upList = new ArrayList<>();
        for (TbOrderRespLog respLog : tbOrderRespLogs) {
            String respBody = respLog.getRespBody();
            String orderNo = respLog.getOrderNo();
            if (StringUtils.isBlank(respLog.getRespBody())) {
                continue;
            }
            TbOrderRespLog upLog = fun01(respLog, respBody, orderNo);
            if (upLog == null) {
                upLog = fun02(respLog, respBody, orderNo);
            }

            if (upLog == null) {
                continue;
            }
            upList.add(upLog);
        }
        if (upList.size() > 0) {
            // 每批处理的数据量
            final int batchSize = 2000;
            // 计算需要多少批次
            int totalBatches = (upList.size() + batchSize - 1) / batchSize;

            // 创建异步任务列表
            List<CompletableFuture<Boolean>> updateFutures = new ArrayList<>();

            // 分批处理数据
            for (int i = 0; i < totalBatches; i++) {
                int start = i * batchSize;
                int end = Math.min(start + batchSize, upList.size());
                List<TbOrderRespLog> batchList = upList.subList(start, end);

                // 创建异步更新任务
                int finalI = i;
                CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        iTbOrderRespLogService.updateBatchById(batchList, batchSize);
                        return true;
                    } catch (Exception e) {
                        log.error("批量更新失败，批次：" + (finalI + 1), e);
                        return false;
                    }
                }, excelTaskPool);

                updateFutures.add(future);
            }

            try {
                // 等待所有更新任务完成
                CompletableFuture.allOf(updateFutures.toArray(new CompletableFuture[0])).join();

                // 检查是否所有批次都更新成功
                boolean allSuccess = updateFutures.stream()
                        .map(CompletableFuture::join)
                        .allMatch(success -> success);

                if (!allSuccess) {
                    log.error("部分批次更新失败");
                }
            } catch (Exception e) {
                log.error("等待更新任务完成时发生错误", e);
            }
        }
        // MurmurHashUtil.generateUniqueHash()
    }

    private static TbOrderRespLog fun01(TbOrderRespLog respLog, String respBody, String orderNo) {
        JSONObject root = JSON.parseObject(respBody);
        JSONObject orderIncomeJson = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("response"))
                .map(r -> r.getJSONObject("order_income")).orElse(null);

        String orderSn = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("response"))
                .map(r -> r.getString("order_sn")).orElse(null);


        if (orderIncomeJson == null) {
            return null;
        }

        if (orderSn == null) {
            return null;
        }

        if (!orderSn.equals(orderNo)) {
            return null;
        }
        // 转回 String 并保留 null 值
        String orderIncomeStr = JSON.toJSONString(
                orderIncomeJson,
                SerializerFeature.WriteMapNullValue // 关键：保留 null 字段
        );

        Byte[] hash128 = MurmurHashUtil.generateUniqueHashByte(orderIncomeStr + orderSn);

        TbOrderRespLog upLog = new TbOrderRespLog();
        upLog.setId(respLog.getId());
        upLog.setHash128(hash128);
        return upLog;
    }

    private static TbOrderRespLog fun02(TbOrderRespLog respLog, String respBody, String orderNo) {
        JSONObject root = JSON.parseObject(respBody);
        JSONObject orderIncomeJson = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("escrow_detail"))
                .map(r -> r.getJSONObject("order_income")).orElse(null);

        String orderSn = Optional.ofNullable(root)
                .map(r -> r.getJSONObject("escrow_detail"))
                .map(r -> r.getString("order_sn")).orElse(null);


        if (orderIncomeJson == null) {
            return null;
        }

        if (orderSn == null) {
            return null;
        }

        if (!orderSn.equals(orderNo)) {
            return null;
        }
        // 转回 String 并保留 null 值
        String orderIncomeStr = JSON.toJSONString(
                orderIncomeJson,
                SerializerFeature.WriteMapNullValue // 关键：保留 null 字段
        );

        Byte[] hash128 = MurmurHashUtil.generateUniqueHashByte(orderIncomeStr + orderSn);

        TbOrderRespLog upLog = new TbOrderRespLog();
        upLog.setId(respLog.getId());
        upLog.setHash128(hash128);
        return upLog;
    }

    // 用iTbOrderRespLogService 分页查询1w数据 完善查询
    private List<TbOrderRespLog> queryData() {
        List<TbOrderRespLog> resultList = new ArrayList<>();
        // 每页大小
        int pageSize = 500;
        // 创建分页查询包装器
        QueryWrapper<TbOrderRespLog> wrapper = new QueryWrapper<>();
        // 添加时间范围限制，只查询最近7天的数据
        wrapper.ge("operate_time", new java.util.Date(System.currentTimeMillis() - 15 * 24 * 60 * 60 * 1000L));
        wrapper.isNull("hash");
        // 先获取符合条件的总记录数
        // 1. 提前查询总数
        long count = iTbOrderRespLogService.count(wrapper);
        // 限制最大查询数量为5000条
        long total = Math.min(count, 40000);
        // 计算总页数
        int totalPages = (int) ((total + pageSize - 1) / pageSize);

//        // 创建线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(
//            Math.min(Runtime.getRuntime().availableProcessors() * 2, totalPages)
//        );

        try {
            // 创建异步任务列表
            List<CompletableFuture<List<TbOrderRespLog>>> futures = new ArrayList<>();

            for (int pageNum = 1; pageNum <= totalPages; pageNum++) {
                final int currentPage = pageNum;
                System.out.println("当前查询第" + currentPage + "页");
                // 创建异步任务
                CompletableFuture<List<TbOrderRespLog>> future = CompletableFuture.supplyAsync(() -> {
                    // 2. 创建分页对象并配置
                    Page<TbOrderRespLog> page = new Page<>(currentPage, pageSize);
                    page.setSearchCount(false); // 禁用自动 COUNT 查询
                    page.setTotal(count);       // 手动注入已计算的总数

                    // 3. 执行分页查询（此时不会触发 COUNT）
                    return iTbOrderRespLogService.list(page, wrapper);
                }, excelTaskPool);

                futures.add(future);
            }

            // 等待所有异步任务完成并收集结果
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            // 合并所有查询结果
            for (CompletableFuture<List<TbOrderRespLog>> future : futures) {
                resultList.addAll(future.get());
                if (resultList.size() >= total) {
                    break;
                }
            }
        } catch (Exception e) {
            log.error("异步查询数据失败", e);
        } finally {
//            excelTaskPool.shutdown();
        }

        return resultList;
    }

    private List<TbOrderRespLog> queryDataWithCursor() {
        List<TbOrderRespLog> resultList = new ArrayList<>();
        int pageSize = 500;
        int maxRecords = 200000; // 最大限制10w条
        Long lastId = null;      // 游标标记

        QueryWrapper<TbOrderRespLog> wrapperInit = new QueryWrapper<>();
        // 时间范围（15天）
        Date startDate = new Date(System.currentTimeMillis() - 20L * 24 * 60 * 60 * 1000);
        wrapperInit
//                .ge("operate_time", startDate)
                .isNull("hash_128")
                .orderByAsc("id");  // 必须按ID排序

        // 添加联合索引建议：ALTER TABLE tb_order_resp_log ADD INDEX idx_operate_hash_id (operate_time, hash, id);

        try {
            while (true) {
                QueryWrapper<TbOrderRespLog> wrapper = new QueryWrapper<>();
                wrapper
//                        .ge("operate_time", startDate)
                        .isNull("hash_128")
                        .orderByAsc("id");  // 必须按ID排序
                // 动态更新查询条件
                if (lastId != null) {
                    wrapper.gt("id", lastId);
                }

                // 执行分页查询
                Page<TbOrderRespLog> page = new Page<>(1, pageSize);
                page.setSearchCount(false); // 关闭自动统计
                IPage<TbOrderRespLog> pageResult = iTbOrderRespLogService.page(page, wrapper);

                List<TbOrderRespLog> records = pageResult.getRecords();
                if (records.isEmpty()) {
                    break;
                }

                // 合并结果
                resultList.addAll(records);
                // 更新游标
                lastId = records.get(records.size() - 1).getId();

                // 达到最大限制
                if (resultList.size() >= maxRecords) {
                    break;
                }
            }
        } catch (Exception e) {
            log.error("游标分页查询失败", e);
        }

        return resultList.size() > maxRecords ?
                resultList.subList(0, maxRecords) :
                resultList;
    }

    @Test
    public void deleteByHashBatch() {
        // 每批处理的数据量
        final int batchSize = 500;

        // 1. 先查询所有重复的hash值
        QueryWrapper<TbOrderRespLog> hashWrapper = new QueryWrapper<>();
        hashWrapper.select("hash, COUNT(*) as count")
                .isNotNull("hash")
                .groupBy("hash")
                .having("COUNT(*) > 1");

        List<Object> duplicateHashes = iTbOrderRespLogService.listObjs(hashWrapper);
        log.info("找到{}组重复hash数据", duplicateHashes.size());

        int totalDeleted = 0;
        // 2. 对每个重复的hash值进行分批删除处理
        for (Object hash : duplicateHashes) {
            // 查询该hash值对应的所有记录ID，按ID升序排序
            QueryWrapper<TbOrderRespLog> recordWrapper = new QueryWrapper<>();
            recordWrapper.eq("hash", hash)
                    .orderByAsc("id");

            // 分页查询该hash值的所有记录
            long page = 1;
            while (true) {
                Page<TbOrderRespLog> pageResult = new Page<>(page, batchSize);
                Page<TbOrderRespLog> records = iTbOrderRespLogService.page(pageResult, recordWrapper);

                if (records.getRecords().isEmpty()) {
                    break;
                }

                // 保留最新的一条记录（ID最大的记录）
                List<Long> idsToDelete = new ArrayList<>();
                for (int i = 0; i < records.getRecords().size() - 1; i++) {
                    idsToDelete.add(records.getRecords().get(i).getId());
                }

                if (!idsToDelete.isEmpty()) {
                    boolean success = iTbOrderRespLogService.removeByIds(idsToDelete);
                    if (success) {
                        totalDeleted += idsToDelete.size();
                        log.info("成功删除hash值{}的{}条重复数据", hash, idsToDelete.size());
                    }
                }

                if (!records.hasNext()) {
                    break;
                }
                page++;
            }
        }

        log.info("批量删除完成，共删除{}条重复数据", totalDeleted);
    }

}
