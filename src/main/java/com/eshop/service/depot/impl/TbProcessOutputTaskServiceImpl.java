package com.eshop.service.depot.impl;

import com.eshop.entity.depot.TbProcessOutputTask;
import com.eshop.mapper.depot.TbProcessOutputTaskMapper;
import com.eshop.service.depot.ITbProcessOutputTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 加工任务 服务实现类
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_depot")
@Service
public class TbProcessOutputTaskServiceImpl extends ServiceImpl<TbProcessOutputTaskMapper, TbProcessOutputTask> implements ITbProcessOutputTaskService {

}
