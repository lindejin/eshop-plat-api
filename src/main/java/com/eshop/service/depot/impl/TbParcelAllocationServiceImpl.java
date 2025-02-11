package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbParcelAllocation;
import com.eshop.mapper.depot.TbParcelAllocationMapper;
import com.eshop.service.depot.ITbParcelAllocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包裹配货 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbParcelAllocationServiceImpl extends ServiceImpl<TbParcelAllocationMapper, TbParcelAllocation> implements ITbParcelAllocationService {

}
