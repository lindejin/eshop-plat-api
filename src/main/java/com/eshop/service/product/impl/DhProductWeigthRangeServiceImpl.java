package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductWeigthRange;
import com.eshop.mapper.product.DhProductWeigthRangeMapper;
import com.eshop.service.product.IDhProductWeigthRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品阶梯重量 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_product")
@Service
public class DhProductWeigthRangeServiceImpl extends ServiceImpl<DhProductWeigthRangeMapper, DhProductWeigthRange> implements IDhProductWeigthRangeService {

}
