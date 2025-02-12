package com.eshop.service.finance.impl;

import com.eshop.entity.finance.TbBankAccount;
import com.eshop.mapper.finance.TbBankAccountMapper;
import com.eshop.service.finance.ITbBankAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 账户信息 服务实现类
 * </p>
 *
 * @author finance
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_finance")
@Service
public class TbBankAccountServiceImpl extends ServiceImpl<TbBankAccountMapper, TbBankAccount> implements ITbBankAccountService {

}
