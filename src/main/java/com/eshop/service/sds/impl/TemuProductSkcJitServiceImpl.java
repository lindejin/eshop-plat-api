package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductSkcJit;
import com.eshop.mapper.sds.TemuProductSkcJitMapper;
import com.eshop.service.sds.ITemuProductSkcJitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * temu 全托JIT模式 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TemuProductSkcJitServiceImpl extends ServiceImpl<TemuProductSkcJitMapper, TemuProductSkcJit> implements ITemuProductSkcJitService {

}
