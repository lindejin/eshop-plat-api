package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPlatformAccount;
import com.eshop.mapper.supply.TbPlatformAccountMapper;
import com.eshop.service.supply.ITbPlatformAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采购平台账号授权 服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_supply")
@Service
public class TbPlatformAccountServiceImpl extends ServiceImpl<TbPlatformAccountMapper, TbPlatformAccount> implements ITbPlatformAccountService {

}
