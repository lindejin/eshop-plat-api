package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbQualityControlError;
import com.eshop.mapper.depot.TbQualityControlErrorMapper;
import com.eshop.service.depot.ITbQualityControlErrorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 质检异常原因 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbQualityControlErrorServiceImpl extends ServiceImpl<TbQualityControlErrorMapper, TbQualityControlError> implements ITbQualityControlErrorService {

}
