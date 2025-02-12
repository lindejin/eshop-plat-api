package com.eshop.service.collect.impl;

import com.eshop.entity.collect.ClProductBase;
import com.eshop.mapper.collect.ClProductBaseMapper;
import com.eshop.service.collect.IClProductBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 采集商品基础信息 服务实现类
 * </p>
 *
 * @author collect
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_collect")
@Service
public class ClProductBaseServiceImpl extends ServiceImpl<ClProductBaseMapper, ClProductBase> implements IClProductBaseService {

}
