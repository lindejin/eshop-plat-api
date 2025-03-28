package com.eshop.hash;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eshop.entity.log.TbOrderRespLog;
import com.eshop.entity.order.TbOrder;
import com.eshop.service.log.ITbOrderRespLogService;
import com.eshop.service.order.ITbOrderService;
import com.eshop.util.MurmurHashUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class HashControllerDelTest {

    @Autowired
    private ITbOrderService iTbOrderService;

    @Autowired
    private ITbOrderRespLogService iTbOrderRespLogService;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Test
    public void generateHash() {
        // 循环1w次，每次生成一个hash值，然后存入数据库
        // 生成hash值的方法：MurmurHashUtil.generateUniqueHash()
        List<TbOrderRespLog> tbOrderRespLogs = queryData();
        if (tbOrderRespLogs == null || tbOrderRespLogs.size() == 0) {
            log.info("没有数据");
            return; 
        }
    }

    // 用iTbOrderRespLogService 分页查询1w数据 完善查询
    private List<TbOrderRespLog> queryData() {
        List<TbOrderRespLog> resultList = new ArrayList<>();
        // 每页大小
        int pageSize = 500;
        // 创建分页查询包装器
        QueryWrapper<TbOrderRespLog> wrapper = new QueryWrapper<>();
        // 添加时间范围限制，只查询最近7天的数据
        wrapper.eq("order_no","250208MKA8ET4D");
        // 先获取符合条件的总记录数
        // 1. 提前查询总数
        long count = iTbOrderRespLogService.count(wrapper);
        // 限制最大查询数量为5000条
        long total = Math.min(count, 40000);
        // 计算总页数
        int totalPages = (int)((total + pageSize - 1) / pageSize);

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
        int maxRecords = 100000; // 最大限制1w条
        Long lastId = null;      // 游标标记

        QueryWrapper<TbOrderRespLog> wrapperInit = new QueryWrapper<>();
        // 时间范围（15天）
        Date startDate = new Date(System.currentTimeMillis() - 40L * 24 * 60 * 60 * 1000);
        wrapperInit
//                .ge("operate_time", startDate)
                .isNull("hash")
                .orderByAsc("id");  // 必须按ID排序

        // 添加联合索引建议：ALTER TABLE tb_order_resp_log ADD INDEX idx_operate_hash_id (operate_time, hash, id);

        try {
            while (true) {
                QueryWrapper<TbOrderRespLog> wrapper = new QueryWrapper<>();
                wrapper
//                        .ge("operate_time", startDate)
                        .isNull("hash")
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

    private Set<String> getOrderNos(){
        // 1. 先查询所有重复的hash值和订单号组合
        QueryWrapper<TbOrder> hashWrapper = new QueryWrapper<>();
        hashWrapper.eq("order_no","250208MKA8ET4D");
        hashWrapper.eq("platform_id",5);
        List<TbOrder> list = iTbOrderService.list(hashWrapper);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.stream().map(TbOrder::getOrderNo).collect(Collectors.toSet());
    }

    @Test
    public void deleteByHashBatch() {
        Set<String> orderNos = getOrderNos();
        if (orderNos == null || orderNos.isEmpty()) {
            log.info("没有需要处理的订单号");
            return;
        }

        // 将订单号转换为List以便分批处理
        List<String> orderNoList = new ArrayList<>(orderNos);
        // 每批处理的订单号数量
        final int orderBatchSize = 200;
        // 每批处理的数据量
        final int batchSize = 500;
        int totalDeleted = 0;

        // 分批处理订单号
        for (int i = 0; i < orderNoList.size(); i += orderBatchSize) {
            int endIndex = Math.min(i + orderBatchSize, orderNoList.size());
            List<String> batchOrderNos = orderNoList.subList(i, endIndex);
            log.info("开始处理第{}批订单号，共{}个", (i / orderBatchSize) + 1, batchOrderNos.size());

            // 1. 查询这批订单号中的重复hash值
            QueryWrapper<TbOrderRespLog> hashWrapper = new QueryWrapper<>();
            hashWrapper.select("order_no, hash, COUNT(*) as count")
                    .isNotNull("hash")
                    .in("order_no", batchOrderNos)
                    .groupBy("order_no, hash")
                    .having("COUNT(*) > 1");

            List<Map<String, Object>> duplicateGroups = iTbOrderRespLogService.listMaps(hashWrapper);
            log.info("本批次找到{}组重复hash数据", duplicateGroups.size());

            // 2. 对每个重复的订单号和hash值组合进行分批删除处理
            for (Map<String, Object> group : duplicateGroups) {
                String orderNo = (String) group.get("order_no");
                Object hash = group.get("hash");

                // 查询该订单号和hash值对应的所有记录ID，按ID升序排序
                QueryWrapper<TbOrderRespLog> recordWrapper = new QueryWrapper<>();
                recordWrapper.eq("order_no", orderNo)
                        .eq("hash", hash)
                        .orderByAsc("id");

                // 分页查询该组合的所有记录
                long page = 1;
                while (true) {
                    Page<TbOrderRespLog> pageResult = new Page<>(page, batchSize);
                    Page<TbOrderRespLog> records = iTbOrderRespLogService.page(pageResult, recordWrapper);

                    if (records.getRecords().isEmpty()) {
                        break;
                    }

                    // 保留最新的一条记录（ID最大的记录）
                    List<Long> idsToDelete = new ArrayList<>();
                    for (int j = 0; j < records.getRecords().size() - 1; j++) {
                        idsToDelete.add(records.getRecords().get(j).getId());
                    }

                    if (!idsToDelete.isEmpty()) {
                        boolean success = iTbOrderRespLogService.removeByIds(idsToDelete);
                        if (success) {
                            totalDeleted += idsToDelete.size();
                            log.info("成功删除订单号{}的hash值{}的{}条重复数据", orderNo, hash, idsToDelete.size());
                        }
                    }

                    if (!records.hasNext()) {
                        break;
                    }
                    page++;
                }
            }
        }
        
        log.info("批量删除完成，共删除{}条重复数据", totalDeleted);
    }

    @Test
    public void deleteByHashBatchWithOrderNo() {
        // 每批处理的数据量
        final int batchSize = 500;
        
        // 1. 查询所有重复的hash值
        QueryWrapper<TbOrderRespLog> hashWrapper = new QueryWrapper<>();
        hashWrapper.select("hash, COUNT(*) as count")
                .eq("order_no", "250208MKA8ET4D")
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
                    .eq("order_no", "250208MKA8ET4D")
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
