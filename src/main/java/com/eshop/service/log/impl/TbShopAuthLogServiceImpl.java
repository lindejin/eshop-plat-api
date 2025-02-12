package com.eshop.service.log.impl;

import com.eshop.entity.log.TbShopAuthLog;
import com.eshop.mapper.log.TbShopAuthLogMapper;
import com.eshop.service.log.ITbShopAuthLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author log
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_log")
@Service
public class TbShopAuthLogServiceImpl extends ServiceImpl<TbShopAuthLogMapper, TbShopAuthLog> implements ITbShopAuthLogService {

}
