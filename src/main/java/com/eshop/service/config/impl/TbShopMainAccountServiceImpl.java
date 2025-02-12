package com.eshop.service.config.impl;

import com.eshop.entity.config.TbShopMainAccount;
import com.eshop.mapper.config.TbShopMainAccountMapper;
import com.eshop.service.config.ITbShopMainAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 店铺主账户 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbShopMainAccountServiceImpl extends ServiceImpl<TbShopMainAccountMapper, TbShopMainAccount> implements ITbShopMainAccountService {

}
