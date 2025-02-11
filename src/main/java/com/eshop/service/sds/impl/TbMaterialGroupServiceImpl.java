package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbMaterialGroup;
import com.eshop.mapper.sds.TbMaterialGroupMapper;
import com.eshop.service.sds.ITbMaterialGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 素材组关联关系 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbMaterialGroupServiceImpl extends ServiceImpl<TbMaterialGroupMapper, TbMaterialGroup> implements ITbMaterialGroupService {

}
