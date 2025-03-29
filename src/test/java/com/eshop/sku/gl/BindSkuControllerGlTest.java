package com.eshop.sku.gl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eshop.entity.product.TbExteriorSkuBinding;
import com.eshop.entity.sds.ShopeeProduct;
import com.eshop.entity.sds.ShopeeProductSku;
import com.eshop.exception.BusinessException;
import com.eshop.service.product.ITbExteriorSkuBindingService;
import com.eshop.service.sds.IShopeeProductService;
import com.eshop.service.sds.IShopeeProductSkuService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class BindSkuControllerGlTest {

    @Resource
    private ITbExteriorSkuBindingService iTbExteriorSkuBindingService;

    @Resource
    private IShopeeProductService iShopeeProductService;

    @Resource
    private IShopeeProductSkuService iShopeeProductSkuService;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Resource
    private BindSkuControllerGLResultTest bindSkuControllerGLResultTest;

    @Test
    public void generateHash() throws Exception {
        // 循环1w次，每次生成一个hash值，然后存入数据库
        // 生成hash值的方法：MurmurHashUtil.generateUniqueHash()
        List<ShopeeProduct> shopeeProductList = queryDataWithCursor();
        if (shopeeProductList == null || shopeeProductList.size() == 0) {
            log.info("没有数据");
            return;
        }

        Set<Long> productIds = shopeeProductList.stream().map(ShopeeProduct::getId).collect(Collectors.toSet());
        List<ShopeeProductSku> psList = queryDataWithId(productIds);

        if (psList == null || psList.size() == 0) {
            log.info("没有数据");
            return;
        }
        // 使用并行流提高处理速度
        Set<String> skuCodes = psList.parallelStream()
                .map(ShopeeProductSku::getSkuCode)
                .filter(Objects::nonNull) // 可选：过滤null值
                .collect(Collectors.toSet());
        List<TbExteriorSkuBinding> tbExteriorSkuBindings = queryDataBindWithId(skuCodes);
        if (tbExteriorSkuBindings == null || tbExteriorSkuBindings.size() == 0) {
            log.info("没有数据");
            return;
        }
        System.out.println(shopeeProductList.size());
        System.out.println(psList.size());
        System.out.println(tbExteriorSkuBindings.size());

        Map<String, String> stringStringMap = getsSkuBindMapByShopId(tbExteriorSkuBindings);

        bindSkuControllerGLResultTest.generateHash(shopeeProductList,psList,stringStringMap);
    }

    private List<ShopeeProduct> queryDataWithCursor() {
        List<ShopeeProduct> resultList = new ArrayList<>();
        int pageSize = 2000;
        int maxRecords = 2000000; // 最大限制10w条
        Long lastId = null;      // 游标标记

        LambdaQueryWrapper<ShopeeProduct> lqWrapper = Wrappers.<ShopeeProduct>lambdaQuery()
                .isNotNull(ShopeeProduct::getItemGlobalId)
                .eq(ShopeeProduct::getIsPublish, 1)
                .eq(ShopeeProduct::getProductType, 2)
                .orderByAsc(ShopeeProduct::getId);

        // 添加联合索引建议：ALTER TABLE tb_order_resp_log ADD INDEX idx_operate_hash_id (operate_time, hash, id);

        try {
            while (true) {
                LambdaQueryWrapper<ShopeeProduct> wrapper = Wrappers.<ShopeeProduct>lambdaQuery()
                        .select(
                                ShopeeProduct::getId,
                                ShopeeProduct::getShopId,
                                ShopeeProduct::getShopMerchantId,
                                ShopeeProduct::getItemGlobalId,
                                ShopeeProduct::getIsPublish
                                // 只添加需要的字段
                        )
                        .isNotNull(ShopeeProduct::getItemGlobalId)
                        .eq(ShopeeProduct::getSpuCode, "267-44SKHC")
                        .eq(ShopeeProduct::getIsPublish, 1)
                        .eq(ShopeeProduct::getProductType, 2)
                        .orderByAsc(ShopeeProduct::getId);
                // 动态更新查询条件
                if (lastId != null) {
                    wrapper.gt(ShopeeProduct::getId, lastId);
                }

                // 执行分页查询
                Page<ShopeeProduct> page = new Page<>(1, pageSize);
                page.setSearchCount(false); // 关闭自动统计
                IPage<ShopeeProduct> pageResult = iShopeeProductService.page(page, wrapper);

                List<ShopeeProduct> records = pageResult.getRecords();
                if (records.isEmpty()) {
                    break;
                }

                // 合并结果
                resultList.addAll(records);
                // 更新游标
                lastId = records.get(records.size() - 1).getId();
                // 关键修改：判断是否最后一页
                if (records.size() < pageSize) {
                    break;
                }
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


    private List<ShopeeProductSku> queryDataWithId(Set<Long> productIds) {
        // 配置线程池

        // 分批处理ID（每批2000个）
        List<List<Long>> batches = Lists.partition(new ArrayList<>(productIds), 2000);

        // 收集所有异步任务
        List<CompletableFuture<List<ShopeeProductSku>>> futures = batches.stream()
                .map(batch -> CompletableFuture.supplyAsync(() -> {
                    LambdaQueryWrapper<ShopeeProductSku> wrapper = Wrappers.lambdaQuery(ShopeeProductSku.class)
                            .select(
                                    ShopeeProductSku::getId,
                                    ShopeeProductSku::getProductId,
                                    ShopeeProductSku::getSkuCode
                            )
                            .in(ShopeeProductSku::getProductId, batch)
                            .orderByAsc(ShopeeProductSku::getId);

                    // 查询所有匹配记录（不分页）
                    return iShopeeProductSkuService.list(wrapper);
                }, excelTaskPool))
                .collect(Collectors.toList());

        // 合并所有结果
        List<ShopeeProductSku> result = futures.stream()
                .map(CompletableFuture::join)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return result;
    }

//    private List<TbExteriorSkuBinding> queryDataBindWithId(Set<String> skuCodes) {
//        // 配置线程池
//
//        // 分批处理ID（每批500个）
//        List<List<String>> batches = Lists.partition(new ArrayList<>(skuCodes), 500);
//
//        // 收集所有异步任务
//        List<CompletableFuture<List<TbExteriorSkuBinding>>> futures = batches.stream()
//                .map(batch -> CompletableFuture.supplyAsync(() -> {
//                    LambdaQueryWrapper<TbExteriorSkuBinding> wrapper = Wrappers.lambdaQuery(TbExteriorSkuBinding.class)
//                            .in(TbExteriorSkuBinding::getShopSku, batch)
//                            .orderByAsc(TbExteriorSkuBinding::getId);
//
//                    // 查询所有匹配记录（不分页）
//                    return iTbExteriorSkuBindingService.list(wrapper);
//                }, excelTaskPool))
//                .collect(Collectors.toList());
//
//        // 合并所有结果
//        List<TbExteriorSkuBinding> result = futures.stream()
//                .map(CompletableFuture::join)
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//        return result;
//    }

    private List<TbExteriorSkuBinding> queryDataBindWithId(Set<String> skuCodes) {
        // 1. 参数校验
        if (CollectionUtils.isEmpty(skuCodes)) {
            return Collections.emptyList();
        }

        // 2. 分批处理（每批2000个）
        List<List<String>> batches = Lists.partition(new ArrayList<>(skuCodes), 2000);

        // 3. 明确指定泛型类型
        @SuppressWarnings("unchecked")
        CompletableFuture<List<TbExteriorSkuBinding>>[] futuresArray = batches.stream()
                .map(batch -> {
                    if (CollectionUtils.isEmpty(batch)) {
                        return CompletableFuture.completedFuture(Collections.<TbExteriorSkuBinding>emptyList());
                    }

                    return CompletableFuture.supplyAsync(() -> {
                        try {
                            LambdaQueryWrapper<TbExteriorSkuBinding> wrapper = Wrappers.lambdaQuery(TbExteriorSkuBinding.class)
                                    .in(TbExteriorSkuBinding::getShopSku, batch)
                                    .orderByAsc(TbExteriorSkuBinding::getId);

                            List<TbExteriorSkuBinding> result = iTbExteriorSkuBindingService.list(wrapper);
                            return result != null ? result : Collections.<TbExteriorSkuBinding>emptyList();
                        } catch (Exception e) {
                            log.error("查询SKU绑定数据失败，batch size: {}", batch.size(), e);
                            return Collections.<TbExteriorSkuBinding>emptyList();
                        }
                    }, excelTaskPool);
                })
                .toArray(CompletableFuture[]::new);

        // 4. 使用明确类型的数组
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futuresArray);

        try {
            // 5. 配置超时时间
            allFutures.get(30, TimeUnit.SECONDS);

            // 6. 收集结果
            return Arrays.stream(futuresArray)
                    .map(CompletableFuture::join)
                    .flatMap(List::stream)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        } catch (TimeoutException e) {
            log.error("查询SKU绑定数据整体超时", e);
            throw new BusinessException("查询超时，请重试");
        } catch (Exception e) {
            log.error("查询SKU绑定数据发生异常", e);
            throw new BusinessException("查询失败，请稍后重试");
        }
    }

    private List<TbExteriorSkuBinding> queryDataBindWithId2(Set<String> skuCodes) {
        if (CollectionUtils.isEmpty(skuCodes)) {
            return Collections.emptyList();
        }

        List<List<String>> batches = Lists.partition(new ArrayList<>(skuCodes), 2000);

        // 使用明确类型的列表
        // 3. 使用显式类型声明
        @SuppressWarnings("unchecked") // 我们知道这个转换是安全的
        List<CompletableFuture<List<TbExteriorSkuBinding>>> futures = batches.stream()
                .map(batch -> {
                    if (CollectionUtils.isEmpty(batch)) {
                        return CompletableFuture.<List<TbExteriorSkuBinding>>completedFuture(Collections.emptyList());
                    }

                    return CompletableFuture.supplyAsync(() -> {
                        try {
                            LambdaQueryWrapper<TbExteriorSkuBinding> wrapper = Wrappers.lambdaQuery(TbExteriorSkuBinding.class)
                                    .in(TbExteriorSkuBinding::getShopSku, batch);

                            List<TbExteriorSkuBinding> result = iTbExteriorSkuBindingService.list(wrapper);
                            return result != null ? result : Collections.<TbExteriorSkuBinding>emptyList();
                        } catch (Exception e) {
                            log.error("查询失败", e);
                            return Collections.<TbExteriorSkuBinding>emptyList();
                        }
                    }, excelTaskPool);
                })
                .collect(Collectors.toList());

        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                    .get(30, TimeUnit.SECONDS);

            return futures.stream()
                    .map(f -> f.getNow(Collections.<TbExteriorSkuBinding>emptyList()))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("查询异常", e);
            throw new BusinessException("查询失败");
        }
    }


    /**
     * 获取绑定信息映射 shopSku->productSku
     */
    public Map<String, String> getsSkuBindMapByShopId(List<TbExteriorSkuBinding> esbs) {
        if (CollectionUtils.isEmpty(esbs)) {
            return new HashMap<>();
        }

        esbs = esbs.stream().sorted(Comparator.comparing(TbExteriorSkuBinding::getId)).collect(Collectors.toList());
        Map<String, String> skuBindingMap = new HashMap<>();
        for (TbExteriorSkuBinding esb : esbs) {
            Long shopId = esb.getShopId();
            String shopSku = esb.getShopSku();
            String productSku = esb.getProductSku();
            Integer mark = new Integer(esb.getMark());

            String key = "";
            //公共绑定
            if (mark == 1) {
                continue;
            }
            //私自绑定-店铺
            if (mark == 2) {
                key = shopId + "||" + shopSku + "||" + mark;
            }
            key = key.trim().toLowerCase();
            skuBindingMap.put(key, productSku);
        }
        return skuBindingMap;
    }

    /**
     * 获取绑定productSku
     */
    public String getSkuBindByShopId(Map<String, String> skuBindingMap, Long shopId, String shopSku) {
        String privateKey = "";
        String mark = "";
        //私自绑定-店铺 判断
        mark = "2";
        privateKey = shopId + "||" + shopSku + "||" + mark;

        privateKey = privateKey.trim().toLowerCase();
        return skuBindingMap.get(privateKey);
    }

//
//    public Boolean makeTbExteriorSkuBindInfo(List<String> bindSkuCode, Long shopId,List<TbExteriorSkuBinding> skuBindList) throws Exception {
//        if (ObjectUtil.isEmpty(bindSkuCode) || ObjectUtil.isEmpty(shopId)) {
//            return true;
//        }
//        //获取sku绑定映射 key:shopSku->value:productSku
//        Map<String, String> skuBindingMap = getsSkuBindMapByShopId(skuBindList);
//
//        List<TbExteriorSkuBinding> addList = new ArrayList<>();
//        for (String skuCode : bindSkuCode) {
//            // 存在绑定关系 跳过这个sku
//            String productSku = getSkuBindByShopId(skuBindingMap, shopId, skuCode);
//            if (StringUtils.isNotBlank(productSku)) {
//                continue;
//            }
//            TbExteriorSkuBinding tbExteriorSkuBinding = new TbExteriorSkuBinding();
//            tbExteriorSkuBinding.setProductSku(skuCode);
//            tbExteriorSkuBinding.setShopSku(skuCode);
//            tbExteriorSkuBinding.setShopId(shopId);
//            tbExteriorSkuBinding.setMark(2);
//            addList.add(tbExteriorSkuBinding);
//        }
//        if (CollectionUtils.isEmpty(addList)){
//            return true;
//        }
//        int result = tbExteriorSkuBindingService.saveMul(addList);
//        if (result > 0) {
//            return true;
//        }
//        return false;
//    }

    public Boolean makeTbExteriorSkuBindInfo(List<String> bindSkuCode, Long shopId, List<TbExteriorSkuBinding> skuBindList) throws Exception {
        // 参数校验
        if (ObjectUtil.isEmpty(bindSkuCode) || ObjectUtil.isEmpty(shopId)) {
            return true;
        }

        // 获取sku绑定映射 key:shopSku->value:productSku
        Map<String, String> skuBindingMap = getsSkuBindMapByShopId(skuBindList);

        // 使用并行流处理
        List<TbExteriorSkuBinding> addList = bindSkuCode.parallelStream()
                .filter(skuCode -> {
                    // 过滤掉已存在绑定关系的SKU
                    String productSku = getSkuBindByShopId(skuBindingMap, shopId, skuCode);
                    return StringUtils.isBlank(productSku);
                })
                .map(skuCode -> {
                    // 构造新的绑定对象
                    TbExteriorSkuBinding binding = new TbExteriorSkuBinding();
                    binding.setProductSku(skuCode);
                    binding.setShopSku(skuCode);
                    binding.setShopId(shopId);
                    binding.setMark(new Byte("2"));
                    return binding;
                })
                .collect(Collectors.toList());

        // 如果没有需要添加的记录，直接返回
        if (CollectionUtils.isEmpty(addList)) {
            return true;
        }

        // 批量保存
        boolean b = iTbExteriorSkuBindingService.saveBatch(addList, 1000);
        return b;
    }
}
