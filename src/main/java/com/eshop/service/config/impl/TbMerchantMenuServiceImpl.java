package com.eshop.service.config.impl;

import com.eshop.entity.config.TbMerchantMenu;
import com.eshop.mapper.config.TbMerchantMenuMapper;
import com.eshop.service.config.ITbMerchantMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商户菜单信息 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbMerchantMenuServiceImpl extends ServiceImpl<TbMerchantMenuMapper, TbMerchantMenu> implements ITbMerchantMenuService {

}
