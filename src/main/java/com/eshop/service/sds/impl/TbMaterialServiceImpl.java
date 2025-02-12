package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbMaterial;
import com.eshop.mapper.sds.TbMaterialMapper;
import com.eshop.service.sds.ITbMaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 素材 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbMaterialServiceImpl extends ServiceImpl<TbMaterialMapper, TbMaterial> implements ITbMaterialService {

}
