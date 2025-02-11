package com.eshop.service.ai.impl;

import com.eshop.entity.ai.GptCallRecord;
import com.eshop.mapper.ai.GptCallRecordMapper;
import com.eshop.service.ai.IGptCallRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * gpt调用记录 服务实现类
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_ai")
@Service
public class GptCallRecordServiceImpl extends ServiceImpl<GptCallRecordMapper, GptCallRecord> implements IGptCallRecordService {

}
