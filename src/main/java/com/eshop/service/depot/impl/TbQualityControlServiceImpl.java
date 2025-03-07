package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbQualityControl;
import com.eshop.mapper.depot.TbQualityControlMapper;
import com.eshop.service.depot.ITbQualityControlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 质检单 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbQualityControlServiceImpl extends ServiceImpl<TbQualityControlMapper, TbQualityControl> implements ITbQualityControlService {

}
