package com.eshop.service.log.impl;

import com.eshop.entity.log.TbShopMerchantAuthLog;
import com.eshop.mapper.log.TbShopMerchantAuthLogMapper;
import com.eshop.service.log.ITbShopMerchantAuthLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商铺授权日志 服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbShopMerchantAuthLogServiceImpl extends ServiceImpl<TbShopMerchantAuthLogMapper, TbShopMerchantAuthLog> implements ITbShopMerchantAuthLogService {

}
