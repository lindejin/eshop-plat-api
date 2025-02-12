package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessSkuMaterialSort;
import com.eshop.mapper.depot.TbProcessSkuMaterialSortMapper;
import com.eshop.service.depot.ITbProcessSkuMaterialSortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工sku素材信息排序 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbProcessSkuMaterialSortServiceImpl extends ServiceImpl<TbProcessSkuMaterialSortMapper, TbProcessSkuMaterialSort> implements ITbProcessSkuMaterialSortService {

}
