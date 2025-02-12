package com.eshop.service.customer.impl;

import com.eshop.entity.customer.MessageRequestBody;
import com.eshop.mapper.customer.MessageRequestBodyMapper;
import com.eshop.service.customer.IMessageRequestBodyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 请求数据存储 服务实现类
 * </p>
 *
 * @author customer
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_customer")
@Service
public class MessageRequestBodyServiceImpl extends ServiceImpl<MessageRequestBodyMapper, MessageRequestBody> implements IMessageRequestBodyService {

}
