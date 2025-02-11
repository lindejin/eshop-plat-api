package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbFlexibleCustomizeTask;
import com.eshop.mapper.depot.TbFlexibleCustomizeTaskMapper;
import com.eshop.service.depot.ITbFlexibleCustomizeTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 柔性定制任务 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbFlexibleCustomizeTaskServiceImpl extends ServiceImpl<TbFlexibleCustomizeTaskMapper, TbFlexibleCustomizeTask> implements ITbFlexibleCustomizeTaskService {

}
