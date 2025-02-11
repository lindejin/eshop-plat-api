package com.eshop.service.product.impl;

import com.eshop.entity.product.DhProductWholesaleRange;
import com.eshop.mapper.product.DhProductWholesaleRangeMapper;
import com.eshop.service.product.IDhProductWholesaleRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品折扣区间 服务实现类
 * </p>
 *
 * @author product
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_product")
@Service
public class DhProductWholesaleRangeServiceImpl extends ServiceImpl<DhProductWholesaleRangeMapper, DhProductWholesaleRange> implements IDhProductWholesaleRangeService {

}
