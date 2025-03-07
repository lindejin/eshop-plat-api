package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbFacilitatorJoin;
import com.eshop.mapper.logistics.TbFacilitatorJoinMapper;
import com.eshop.service.logistics.ITbFacilitatorJoinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流服务商对接信息 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_logistics")
@Service
public class TbFacilitatorJoinServiceImpl extends ServiceImpl<TbFacilitatorJoinMapper, TbFacilitatorJoin> implements ITbFacilitatorJoinService {

}
