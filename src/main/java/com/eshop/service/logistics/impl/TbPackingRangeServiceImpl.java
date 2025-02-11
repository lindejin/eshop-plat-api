package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbPackingRange;
import com.eshop.mapper.logistics.TbPackingRangeMapper;
import com.eshop.service.logistics.ITbPackingRangeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包材区间重量及价格 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_logistics")
@Service
public class TbPackingRangeServiceImpl extends ServiceImpl<TbPackingRangeMapper, TbPackingRange> implements ITbPackingRangeService {

}
