package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbMaterialClassify;
import com.eshop.mapper.sds.TbMaterialClassifyMapper;
import com.eshop.service.sds.ITbMaterialClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 素材分类 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_sds")
@Service
public class TbMaterialClassifyServiceImpl extends ServiceImpl<TbMaterialClassifyMapper, TbMaterialClassify> implements ITbMaterialClassifyService {

}
