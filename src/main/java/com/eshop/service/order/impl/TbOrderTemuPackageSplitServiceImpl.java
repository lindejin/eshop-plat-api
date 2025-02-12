package com.eshop.service.order.impl;

import com.eshop.entity.order.TbOrderTemuPackageSplit;
import com.eshop.mapper.order.TbOrderTemuPackageSplitMapper;
import com.eshop.service.order.ITbOrderTemuPackageSplitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * temu备货单 拆包信息 服务实现类
 * </p>
 *
 * @author order
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_order")
@Service
public class TbOrderTemuPackageSplitServiceImpl extends ServiceImpl<TbOrderTemuPackageSplitMapper, TbOrderTemuPackageSplit> implements ITbOrderTemuPackageSplitService {

}
