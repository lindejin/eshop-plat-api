package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TemuTpProductSkc;
import com.eshop.mapper.sds.TemuTpProductSkcMapper;
import com.eshop.service.sds.ITemuTpProductSkcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * Temu产品模版skc信息 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TemuTpProductSkcServiceImpl extends ServiceImpl<TemuTpProductSkcMapper, TemuTpProductSkc> implements ITemuTpProductSkcService {

}
