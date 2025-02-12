package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductWeigthRange;
import com.eshop.mapper.sds.DhTpProductWeigthRangeMapper;
import com.eshop.service.sds.IDhTpProductWeigthRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 产品阶梯重量 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DhTpProductWeigthRangeServiceImpl extends ServiceImpl<DhTpProductWeigthRangeMapper, DhTpProductWeigthRange> implements IDhTpProductWeigthRangeService {

}
