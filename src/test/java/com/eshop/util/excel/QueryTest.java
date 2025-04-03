package com.eshop.util.excel;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eshop.entity.order.TbOrderProducts;
import com.eshop.entity.order.TbOrderRequestBody;
import com.eshop.service.order.ITbOrderProductsService;
import com.eshop.service.order.ITbOrderRequestBodyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class QueryTest {

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Resource
    private ITbOrderRequestBodyService iTbOrderRequestBodyService;

    @Resource
    private ITbOrderProductsService iTbOrderProductsService;

    public List<TbOrderRequestBody> getBodyList(Set<String> orderNos) {
        if (ObjectUtil.isEmpty(orderNos)) {
            return Collections.emptyList();
        }
        // 将 skuCodes 按照每100个一组分割
        List<List<String>> parcelNoChunks = chunkNoList(new ArrayList<>(orderNos), 500);

        List<CompletableFuture<List<TbOrderRequestBody>>> futures = parcelNoChunks.stream()
                .map(chunk -> CompletableFuture.supplyAsync(() -> {
                    try {
                        LambdaQueryWrapper<TbOrderRequestBody> lqWrapper = Wrappers.<TbOrderRequestBody>lambdaQuery();
                        lqWrapper.in(TbOrderRequestBody::getOrderNo, orderNos);
                        lqWrapper.eq(TbOrderRequestBody::getRequestType, 3);
                        List<TbOrderRequestBody> tempList = iTbOrderRequestBodyService.list(lqWrapper);
                        if (ObjectUtil.isEmpty(tempList)) {
                            return Collections.emptyList();
                        }
                        return tempList;
                    } catch (Exception e) {
                        // 处理异常
                        e.printStackTrace();
                        return Collections.emptyList();
                    }
                }, excelTaskPool))
                .map(future -> future.thenApply(list -> list.stream().map(TbOrderRequestBody.class::cast).collect(Collectors.toList())))
                .collect(Collectors.toList());

        List<TbOrderRequestBody> results = futures.stream()
                .map(CompletableFuture::join) // 等待所有任务完成
                .filter(p -> ObjectUtil.isNotEmpty(p))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<TbOrderRequestBody> ppList = results.stream().filter(p -> ObjectUtil.isNotEmpty(p)).collect(Collectors.toList());
        return ppList;
    }

    private List<List<Long>> chunkList(List<Long> list, int chunkSize) {
        List<List<Long>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }

    private List<List<String>> chunkNoList(List<String> list, int chunkSize) {
        List<List<String>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            chunks.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return chunks;
    }



    public List<TbOrderProducts> getOpListConcurrently() {
        // 1. 先获取总记录数
        long total = iTbOrderProductsService.count(Wrappers.<TbOrderProducts>lambdaQuery()
//                .isNull(TbOrderProducts::getProductSku)
                .isNull(TbOrderProducts::getSkuImgId));

        System.out.println("Total records: " + total);

        // 2. 设置分页大小（根据实际情况调整）
        int pageSize = 5000;
        int totalPages = (int) Math.ceil((double) total / pageSize);

        // 3. 创建线程池（根据服务器CPU核心数调整）

        // 4. 创建并行查询任务
        List<CompletableFuture<List<TbOrderProducts>>> futures = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            final int pageNum = i + 1;
            futures.add(CompletableFuture.supplyAsync(() -> {
                return queryByPage(pageNum, pageSize);
            }, excelTaskPool));
        }

        // 5. 合并所有分页结果
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));

        CompletableFuture<List<TbOrderProducts>> resultFuture = allFutures.thenApply(v -> {
            return futures.stream()
                    .map(CompletableFuture::join)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        });

        // 6. 获取最终结果
        try {
            List<TbOrderProducts> result = resultFuture.get(5, TimeUnit.MINUTES); // 设置超时时间
            System.out.println("Final result size: " + result.size());
            return result;
        } catch (Exception e) {
            throw new RuntimeException("并发查询失败", e);
        } finally {
        }
    }

    private List<TbOrderProducts> queryByPage(int pageNum, int pageSize) {
        Page<TbOrderProducts> page = new Page<>(pageNum, pageSize);
        page.setSearchCount(false); // 关闭自动统计
        IPage<TbOrderProducts> result = iTbOrderProductsService.page(page, Wrappers.<TbOrderProducts>lambdaQuery()
//                .isNull(TbOrderProducts::getProductSku)
                .isNull(TbOrderProducts::getSkuImgId));

        System.out.printf("Page %d completed, size: %d%n", pageNum, result.getRecords().size());
        return result.getRecords();
    }
}