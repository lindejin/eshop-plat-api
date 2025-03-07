package com.eshop.service.supply.impl;

import com.eshop.entity.supply.TbPrepareProduct;
import com.eshop.mapper.supply.TbPrepareProductMapper;
import com.eshop.service.supply.ITbPrepareProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 备货单  服务实现类
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_supply")
@Service
public class TbPrepareProductServiceImpl extends ServiceImpl<TbPrepareProductMapper, TbPrepareProduct> implements ITbPrepareProductService {

}
