package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductWholesaleRange;
import com.eshop.mapper.sds.DhTpProductWholesaleRangeMapper;
import com.eshop.service.sds.IDhTpProductWholesaleRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品折扣区间 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DhTpProductWholesaleRangeServiceImpl extends ServiceImpl<DhTpProductWholesaleRangeMapper, DhTpProductWholesaleRange> implements IDhTpProductWholesaleRangeService {

}
