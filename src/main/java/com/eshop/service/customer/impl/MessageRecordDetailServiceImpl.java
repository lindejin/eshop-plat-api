package com.eshop.service.customer.impl;

import com.eshop.entity.customer.MessageRecordDetail;
import com.eshop.mapper.customer.MessageRecordDetailMapper;
import com.eshop.service.customer.IMessageRecordDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 消息记录详情表 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_customer")
@Service
public class MessageRecordDetailServiceImpl extends ServiceImpl<MessageRecordDetailMapper, MessageRecordDetail> implements IMessageRecordDetailService {

}
