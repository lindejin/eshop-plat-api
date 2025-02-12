package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbProductMaterial;
import com.eshop.mapper.sds.TbProductMaterialMapper;
import com.eshop.service.sds.ITbProductMaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 款式商品_素材 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbProductMaterialServiceImpl extends ServiceImpl<TbProductMaterialMapper, TbProductMaterial> implements ITbProductMaterialService {

}
