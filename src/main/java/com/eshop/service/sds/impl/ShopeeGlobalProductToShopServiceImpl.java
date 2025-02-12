package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeGlobalProductToShop;
import com.eshop.mapper.sds.ShopeeGlobalProductToShopMapper;
import com.eshop.service.sds.IShopeeGlobalProductToShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeGlobalProductToShopServiceImpl extends ServiceImpl<ShopeeGlobalProductToShopMapper, ShopeeGlobalProductToShop> implements IShopeeGlobalProductToShopService {

}
