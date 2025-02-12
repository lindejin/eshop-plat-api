package com.eshop.service.customer.impl;

import com.eshop.entity.customer.MessageRecordReply;
import com.eshop.mapper.customer.MessageRecordReplyMapper;
import com.eshop.service.customer.IMessageRecordReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 消息回复记录表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_customer")
@Service
public class MessageRecordReplyServiceImpl extends ServiceImpl<MessageRecordReplyMapper, MessageRecordReply> implements IMessageRecordReplyService {

}
