package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeProductVideo;
import com.eshop.mapper.sds.ShopeeProductVideoMapper;
import com.eshop.service.sds.IShopeeProductVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮产品视频列表 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class ShopeeProductVideoServiceImpl extends ServiceImpl<ShopeeProductVideoMapper, ShopeeProductVideo> implements IShopeeProductVideoService {

}
