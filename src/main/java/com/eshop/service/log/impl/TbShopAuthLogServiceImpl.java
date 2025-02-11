package com.eshop.service.log.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.eshop.entity.log.TbShopAuthLog;
import com.eshop.mapper.log.TbShopAuthLogMapper;
import com.eshop.service.log.ITbShopAuthLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@DS("eshop_log")
@Service
public class TbShopAuthLogServiceImpl extends ServiceImpl<TbShopAuthLogMapper, TbShopAuthLog> implements ITbShopAuthLogService {

}
