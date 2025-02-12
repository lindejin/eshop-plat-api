package com.eshop.service.sds.impl;

import com.eshop.entity.sds.AeTpProductSubject;
import com.eshop.mapper.sds.AeTpProductSubjectMapper;
import com.eshop.service.sds.IAeTpProductSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 速卖通商品多语言标题 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class AeTpProductSubjectServiceImpl extends ServiceImpl<AeTpProductSubjectMapper, AeTpProductSubject> implements IAeTpProductSubjectService {

}
