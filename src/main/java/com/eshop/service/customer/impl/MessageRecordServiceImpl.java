package com.eshop.service.customer.impl;

import com.eshop.entity.customer.MessageRecord;
import com.eshop.mapper.customer.MessageRecordMapper;
import com.eshop.service.customer.IMessageRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 消息记录表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-11
 * @since 2025-02-11
 */
@DS("eshop_customer")
@Service
public class MessageRecordServiceImpl extends ServiceImpl<MessageRecordMapper, MessageRecord> implements IMessageRecordService {

}
