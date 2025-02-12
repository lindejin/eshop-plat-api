package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbInventoryTask;
import com.eshop.mapper.depot.TbInventoryTaskMapper;
import com.eshop.service.depot.ITbInventoryTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 盘点计划 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_depot")
@Service
public class TbInventoryTaskServiceImpl extends ServiceImpl<TbInventoryTaskMapper, TbInventoryTask> implements ITbInventoryTaskService {

}
