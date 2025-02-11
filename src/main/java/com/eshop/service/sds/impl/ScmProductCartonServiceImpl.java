package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductCarton;
import com.eshop.mapper.sds.ScmProductCartonMapper;
import com.eshop.service.sds.IScmProductCartonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品FBA装箱 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class ScmProductCartonServiceImpl extends ServiceImpl<ScmProductCartonMapper, ScmProductCarton> implements IScmProductCartonService {

}
