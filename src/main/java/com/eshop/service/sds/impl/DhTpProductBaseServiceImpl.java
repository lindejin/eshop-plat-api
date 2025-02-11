package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DhTpProductBase;
import com.eshop.mapper.sds.DhTpProductBaseMapper;
import com.eshop.service.sds.IDhTpProductBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 敦煌商品基本信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class DhTpProductBaseServiceImpl extends ServiceImpl<DhTpProductBaseMapper, DhTpProductBase> implements IDhTpProductBaseService {

}
