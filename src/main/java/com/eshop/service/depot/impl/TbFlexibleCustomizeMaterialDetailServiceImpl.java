package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbFlexibleCustomizeMaterialDetail;
import com.eshop.mapper.depot.TbFlexibleCustomizeMaterialDetailMapper;
import com.eshop.service.depot.ITbFlexibleCustomizeMaterialDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 柔性定制item 所需图案列表 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbFlexibleCustomizeMaterialDetailServiceImpl extends ServiceImpl<TbFlexibleCustomizeMaterialDetailMapper, TbFlexibleCustomizeMaterialDetail> implements ITbFlexibleCustomizeMaterialDetailService {

}
