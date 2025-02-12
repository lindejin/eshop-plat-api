package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ShopeeDimension;
import com.eshop.mapper.sds.ShopeeDimensionMapper;
import com.eshop.service.sds.IShopeeDimensionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虾皮产品包装尺码 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ShopeeDimensionServiceImpl extends ServiceImpl<ShopeeDimensionMapper, ShopeeDimension> implements IShopeeDimensionService {

}
