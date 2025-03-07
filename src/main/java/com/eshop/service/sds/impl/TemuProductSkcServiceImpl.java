package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuProductSkc;
import com.eshop.mapper.sds.TemuProductSkcMapper;
import com.eshop.service.sds.ITemuProductSkcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品skc信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuProductSkcServiceImpl extends ServiceImpl<TemuProductSkcMapper, TemuProductSkc> implements ITemuProductSkcService {

}
