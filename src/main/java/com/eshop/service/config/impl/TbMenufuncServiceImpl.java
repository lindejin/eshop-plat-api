package com.eshop.service.config.impl;

import com.eshop.entity.config.TbMenufunc;
import com.eshop.mapper.config.TbMenufuncMapper;
import com.eshop.service.config.ITbMenufuncService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbMenufuncServiceImpl extends ServiceImpl<TbMenufuncMapper, TbMenufunc> implements ITbMenufuncService {

}
