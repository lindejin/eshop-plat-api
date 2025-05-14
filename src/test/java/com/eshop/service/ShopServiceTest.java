package com.eshop.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ShopServiceTest {
    @Resource
    private ITbShopService iTbShopService;

    @Test
    void checkAuthorizationExistsByShopee() {
        Boolean onExists = false;
        String shopName = "";
        Long shopId = 1998L;
        String platShopId = "ff808081645a36910164c5cbc1182d82";
        String platformCode = "Dhgate";
        if (shopId != null && StringUtils.isNotBlank(platShopId)) {
            TbShop existsShop = getExistsShop(platformCode, platShopId);
            TbShop existsShopById = getExistsShopById(shopId);

            if (existsShop != null && existsShopById != null) {
                if (!existsShop.getId().equals(existsShopById.getId())) {
                    onExists = true;
                    shopName = existsShop.getName();
                }
            }
        }

        System.out.println(onExists);
        System.out.println(shopName);
    }


    private TbShop getExistsShop(String platformCode, String platShopId) {
        LambdaQueryWrapper<TbShop> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TbShop::getPlatformCode, platformCode);
        lambdaQueryWrapper.eq(TbShop::getPlatformShopId, platShopId);
        lambdaQueryWrapper.eq(TbShop::getIsDelete, 2);
        lambdaQueryWrapper.isNotNull(TbShop::getPlatformShopId);
        lambdaQueryWrapper.orderByAsc(TbShop::getId);
        List<TbShop> shopList = iTbShopService.list(lambdaQueryWrapper);
        if (CollectionUtils.isEmpty(shopList)) {
            return null;
        }
        return shopList.get(0);
    }

    private TbShop getExistsShopById(Long shopId) {
        return iTbShopService.getById(shopId);
    }
}
