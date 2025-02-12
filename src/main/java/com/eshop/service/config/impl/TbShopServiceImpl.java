package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShop;
import com.eshop.mapper.config.TbShopMapper;
import com.eshop.service.config.ITbShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 店铺表 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbShopServiceImpl extends ServiceImpl<TbShopMapper, TbShop> implements ITbShopService {

}
