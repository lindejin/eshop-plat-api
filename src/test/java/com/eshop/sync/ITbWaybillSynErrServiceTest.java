package com.eshop.sync;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.order.TbOrder;
import com.eshop.entity.order.TbWaybillSynErr;
import com.eshop.entity.order.TbWaybillSynRecord;
import com.eshop.service.order.ITbOrderService;
import com.eshop.service.order.ITbWaybillSynErrService;
import com.eshop.service.order.ITbWaybillSynRecordService;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Component
public class ITbWaybillSynErrServiceTest {

    @Resource
    private ITbWaybillSynErrService iTbWaybillSynErrService;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Resource
    private ITbOrderService iTbOrderService;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbWaybillSynRecordService iTbWaybillSynRecordService;

    public List<TbWaybillSynErr> getWaybillSynErrList() {
        LambdaQueryWrapper<TbWaybillSynErr> qw = new LambdaQueryWrapper<>();
        qw.eq(TbWaybillSynErr::getIsDelete, 2);
        //Date synTime 指定时间范围 2025.01.01 - 2025.03.08
        qw.between(TbWaybillSynErr::getSynTime, "2025.01.01", "2025.03.08");
        //根据id正序排序
        qw.orderByAsc(TbWaybillSynErr::getId);

        //获取总记录数
        long total = iTbWaybillSynErrService.count(qw);
        if (total == 0) {
            return Collections.emptyList();
        }

        //计算需要查询的批次数
        int batchSize = 1000;
        int batchCount = (int) Math.ceil((double) total / batchSize);

        //创建异步任务列表
        List<CompletableFuture<List<TbWaybillSynErr>>> futures = new ArrayList<>();

        //分批异步查询
        for (int i = 0; i < batchCount; i++) {
            final int currentBatch = i;
            CompletableFuture<List<TbWaybillSynErr>> future = CompletableFuture.supplyAsync(() -> {
                qw.last("LIMIT " + (currentBatch * batchSize) + "," + batchSize);
                return iTbWaybillSynErrService.list(qw);
            }, excelTaskPool);
            futures.add(future);
        }

        //等待所有异步任务完成并合并结果
        return futures.stream()
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<TbOrder> getOrderList(Set<String> orderNos) {
        if (orderNos == null || orderNos.isEmpty()) {
            return Collections.emptyList();
        }

        // 设置批次大小
        int batchSize = 500;
        // 将Set转为List以支持分批
        List<String> orderNoList = new ArrayList<>(orderNos);
        // 计算需要查询的批次数
        int batchCount = (int) Math.ceil((double) orderNoList.size() / batchSize);

        // 创建异步任务列表
        List<CompletableFuture<List<TbOrder>>> futures = new ArrayList<>();

        // 分批异步查询
        for (int i = 0; i < batchCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = Math.min((i + 1) * batchSize, orderNoList.size());

            // 获取当前批次的订单号
            List<String> batchOrderNos = orderNoList.subList(startIndex, endIndex);

            CompletableFuture<List<TbOrder>> future = CompletableFuture.supplyAsync(() -> {
                LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.in(TbOrder::getOrderNo, batchOrderNos);
                return iTbOrderService.list(queryWrapper);
            }, excelTaskPool);

            futures.add(future);
        }

        // 等待所有异步任务完成并合并结果
        return futures.stream()
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Map<Long, DhAppClientDTO> getAppClientDTOMap(Set<Long> shopIds) {
        Map<Long, DhAppClientDTO> appClientDTOMap = new HashMap<>();
        for (Long shopId : shopIds) {
            try {
                DhAppClientDTO dhAppClientDTO = platformAppClientUtils.getDhAppClientDTO(shopId);
                appClientDTOMap.put(shopId, dhAppClientDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appClientDTOMap;
    }

    public List<TbWaybillSynRecord> getWaybillSynRecordList(Set<String> orderNos) {
        if (orderNos == null || orderNos.isEmpty()) {
            return Collections.emptyList();
        }

        int batchSize = 500;
        List<String> orderNoList = new ArrayList<>(orderNos);
        int batchCount = (int) Math.ceil((double) orderNoList.size() / batchSize);

        List<CompletableFuture<List<TbWaybillSynRecord>>> futures = new ArrayList<>();

        for (int i = 0; i < batchCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = Math.min((i + 1) * batchSize, orderNoList.size());
            List<String> batchOrderNos = orderNoList.subList(startIndex, endIndex);

            CompletableFuture<List<TbWaybillSynRecord>> future = CompletableFuture.supplyAsync(() -> {
                LambdaQueryWrapper<TbWaybillSynRecord> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.in(TbWaybillSynRecord::getOrderNo, batchOrderNos);
                return iTbWaybillSynRecordService.list(queryWrapper);
            }, excelTaskPool);

            futures.add(future);
        }

        return futures.stream()
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
