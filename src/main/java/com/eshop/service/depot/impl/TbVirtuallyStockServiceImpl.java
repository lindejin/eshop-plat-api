package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbVirtuallyStock;
import com.eshop.mapper.depot.TbVirtuallyStockMapper;
import com.eshop.service.depot.ITbVirtuallyStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 虚拟库存 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbVirtuallyStockServiceImpl extends ServiceImpl<TbVirtuallyStockMapper, TbVirtuallyStock> implements ITbVirtuallyStockService {

}
