package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShopDepot;
import com.eshop.mapper.config.TbShopDepotMapper;
import com.eshop.service.config.ITbShopDepotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 店铺发货仓库 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbShopDepotServiceImpl extends ServiceImpl<TbShopDepotMapper, TbShopDepot> implements ITbShopDepotService {

}
