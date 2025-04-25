package com.eshop.sku;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.eshop.entity.depot.TbStock;
import com.eshop.entity.product.TbProductSku;
import com.eshop.service.depot.ITbStockService;
import com.eshop.service.product.ITbProductSkuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
public class SkuTest {

    @Resource
    private ITbProductSkuService iTbProductSkuService;

    @Resource
    private ITbStockService iTbStockService;


    @Test
    public void upload() {
        String skuCode = "626514";
        TbProductSku psVO = getProductSku(skuCode);
        TbStock stock = getStock(skuCode);


        System.out.println(psVO.getSkuCode());
        System.out.println(stock.getProductSku());

        System.out.println(psVO.getSkuCode().length());
        System.out.println(stock.getProductSku().length());


        System.out.println(stock.getProductSku().equals(psVO.getSkuCode()));

        List<TbProductSku> productSkuRaw = getProductSkuRaw(skuCode);
        if (CollectionUtils.isNotEmpty(productSkuRaw)) {
            for (TbProductSku tbProductSku : productSkuRaw) {
                System.out.println(tbProductSku.getSkuCode());
                System.out.println(tbProductSku.getRawSku());
                System.out.println(stock.getProductSku());
                System.out.println(stock.getProductSku().equals(tbProductSku.getRawSku()));
            }
        }
    }

    @Test
    public void upload2() {
        String skuCode = "626514";

        List<TbProductSku> productSkuRaw = getProductSkuRaw(skuCode);
        if (CollectionUtils.isNotEmpty(productSkuRaw)) {
            for (TbProductSku tbProductSku : productSkuRaw) {
                System.out.println(tbProductSku.getSkuCode());
                System.out.println(tbProductSku.getRawSku());
                System.out.println(skuCode);
                System.out.println(skuCode.equals(tbProductSku.getRawSku()));
            }
        }
    }

    private TbProductSku getProductSku(String skuCode) {
        LambdaQueryWrapper<TbProductSku> lqWrapper = Wrappers.<TbProductSku>lambdaQuery();
        lqWrapper.eq(TbProductSku::getSkuCode,skuCode);
        return iTbProductSkuService.getOne(lqWrapper);
    }

    private List<TbProductSku> getProductSkuRaw(String skuCode) {
        LambdaQueryWrapper<TbProductSku> lqWrapper = Wrappers.<TbProductSku>lambdaQuery();
        lqWrapper.eq(TbProductSku::getRawSku,skuCode);
        return iTbProductSkuService.list(lqWrapper);
    }

    private TbStock getStock(String skuCode) {
        LambdaQueryWrapper<TbStock> lqWrapper = Wrappers.<TbStock>lambdaQuery();
        lqWrapper.eq(TbStock::getProductSku,skuCode);
        return iTbStockService.getOne(lqWrapper);
    }
}
