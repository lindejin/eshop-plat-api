package com.eshop.util.excel;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eshop.entity.log.TbDownloadFileError;
import com.eshop.entity.order.TbOrderProducts;
import com.eshop.service.log.ITbDownloadFileErrorService;
import com.eshop.service.order.ITbOrderProductsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class QueryTest3 {

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Resource
    private ITbDownloadFileErrorService iTbDownloadFileErrorService;

    public List<TbDownloadFileError> getDownloadList(Set<String> orderNos) {
        if (ObjectUtil.isEmpty(orderNos)) {
            return Collections.emptyList();
        }
        // 将 skuCodes 按照每100个一组分割
        List<List<String>> parcelNoChunks = chunkNoList(new ArrayList<>(orderNos), 5000);

        List<CompletableFuture<List<TbDownloadFileError>>> futures = parcelNoChunks.stream()
                .map(chunk -> CompletableFuture.supplyAsync(() -> {
                    try {
                        LambdaQueryWrapper<TbDownloadFileError> lqWrapper = Wrappers.<TbDownloadFileError>lambdaQuery();
                        lqWrapper.in(TbDownloadFileError::getJoinCode, orderNos);
                        lqWrapper.eq(TbDownloadFileError::getStoragePath,"order-http-syn-record");
                        List<TbDownloadFileError> tempList = iTbDownloadFileErrorService.list(lqWrapper);
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
                .map(future -> future.thenApply(list -> list.stream().map(TbDownloadFileError.class::cast).collect(Collectors.toList())))
                .collect(Collectors.toList());

        List<TbDownloadFileError> results = futures.stream()
                .map(CompletableFuture::join) // 等待所有任务完成
                .filter(p -> ObjectUtil.isNotEmpty(p))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<TbDownloadFileError> ppList = results.stream().filter(p -> ObjectUtil.isNotEmpty(p)).collect(Collectors.toList());
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

}