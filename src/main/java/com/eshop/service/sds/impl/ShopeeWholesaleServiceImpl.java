package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeWholesale;
import com.eshop.mapper.sds.ShopeeWholesaleMapper;
import com.eshop.service.sds.IShopeeWholesaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮spu批发 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class ShopeeWholesaleServiceImpl extends ServiceImpl<ShopeeWholesaleMapper, ShopeeWholesale> implements IShopeeWholesaleService {

}
