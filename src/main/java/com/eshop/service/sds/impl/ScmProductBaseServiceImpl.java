package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductBase;
import com.eshop.mapper.sds.ScmProductBaseMapper;
import com.eshop.service.sds.IScmProductBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductBaseServiceImpl extends ServiceImpl<ScmProductBaseMapper, ScmProductBase> implements IScmProductBaseService {

}
