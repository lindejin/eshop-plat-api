package com.eshop.service.sds.impl;

import com.eshop.entity.sds.CommonProductBase;
import com.eshop.mapper.sds.CommonProductBaseMapper;
import com.eshop.service.sds.ICommonProductBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 通用库商品基础信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class CommonProductBaseServiceImpl extends ServiceImpl<CommonProductBaseMapper, CommonProductBase> implements ICommonProductBaseService {

}
