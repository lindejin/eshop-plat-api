package com.eshop.service.finance.impl;

import com.eshop.entity.finance.TbAccountFlow;
import com.eshop.mapper.finance.TbAccountFlowMapper;
import com.eshop.service.finance.ITbAccountFlowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 账户收支日志 服务实现类
 * </p>
 *
 * @author finance
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_finance")
@Service
public class TbAccountFlowServiceImpl extends ServiceImpl<TbAccountFlowMapper, TbAccountFlow> implements ITbAccountFlowService {

}
