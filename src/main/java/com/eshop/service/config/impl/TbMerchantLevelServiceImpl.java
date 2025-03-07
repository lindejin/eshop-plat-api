package com.eshop.service.config.impl;

import com.eshop.entity.config.TbMerchantLevel;
import com.eshop.mapper.config.TbMerchantLevelMapper;
import com.eshop.service.config.ITbMerchantLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 商户等级 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_config")
@Service
public class TbMerchantLevelServiceImpl extends ServiceImpl<TbMerchantLevelMapper, TbMerchantLevel> implements ITbMerchantLevelService {

}
