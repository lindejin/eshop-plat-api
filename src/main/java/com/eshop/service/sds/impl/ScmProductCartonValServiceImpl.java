package com.eshop.service.sds.impl;

import com.eshop.entity.sds.ScmProductCartonVal;
import com.eshop.mapper.sds.ScmProductCartonValMapper;
import com.eshop.service.sds.IScmProductCartonValService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 供应链商品FBA装箱建议 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class ScmProductCartonValServiceImpl extends ServiceImpl<ScmProductCartonValMapper, ScmProductCartonVal> implements IScmProductCartonValService {

}
