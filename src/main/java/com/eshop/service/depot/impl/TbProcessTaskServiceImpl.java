package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessTask;
import com.eshop.mapper.depot.TbProcessTaskMapper;
import com.eshop.service.depot.ITbProcessTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工任务 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_depot")
@Service
public class TbProcessTaskServiceImpl extends ServiceImpl<TbProcessTaskMapper, TbProcessTask> implements ITbProcessTaskService {

}
