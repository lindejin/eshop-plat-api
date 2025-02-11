package com.eshop.service.logistics.impl;

import com.eshop.entity.logistics.TbPlatformFacilitatorMode;
import com.eshop.mapper.logistics.TbPlatformFacilitatorModeMapper;
import com.eshop.service.logistics.ITbPlatformFacilitatorModeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 物流方式&平台中间表 服务实现类
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_logistics")
@Service
public class TbPlatformFacilitatorModeServiceImpl extends ServiceImpl<TbPlatformFacilitatorModeMapper, TbPlatformFacilitatorMode> implements ITbPlatformFacilitatorModeService {

}
