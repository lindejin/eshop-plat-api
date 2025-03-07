package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbPacking;
import com.eshop.mapper.logistics.TbPackingMapper;
import com.eshop.service.logistics.ITbPackingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 包材 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_logistics")
@Service
public class TbPackingServiceImpl extends ServiceImpl<TbPackingMapper, TbPacking> implements ITbPackingService {

}
