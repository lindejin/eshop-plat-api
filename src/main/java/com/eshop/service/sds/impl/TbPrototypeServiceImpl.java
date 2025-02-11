package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototype;
import com.eshop.mapper.sds.TbPrototypeMapper;
import com.eshop.service.sds.ITbPrototypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbPrototypeServiceImpl extends ServiceImpl<TbPrototypeMapper, TbPrototype> implements ITbPrototypeService {

}
