package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbSynthesisTask;
import com.eshop.mapper.sds.TbSynthesisTaskMapper;
import com.eshop.service.sds.ITbSynthesisTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 模特合成任务配置 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_sds")
@Service
public class TbSynthesisTaskServiceImpl extends ServiceImpl<TbSynthesisTaskMapper, TbSynthesisTask> implements ITbSynthesisTaskService {

}
