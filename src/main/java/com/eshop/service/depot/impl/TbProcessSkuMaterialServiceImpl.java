package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessSkuMaterial;
import com.eshop.mapper.depot.TbProcessSkuMaterialMapper;
import com.eshop.service.depot.ITbProcessSkuMaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工sku素材信息 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbProcessSkuMaterialServiceImpl extends ServiceImpl<TbProcessSkuMaterialMapper, TbProcessSkuMaterial> implements ITbProcessSkuMaterialService {

}
