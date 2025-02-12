package com.eshop.service.config.impl;

import com.eshop.entity.config.TbDataDictionary;
import com.eshop.mapper.config.TbDataDictionaryMapper;
import com.eshop.service.config.ITbDataDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 数据词典 服务实现类
 * </p>
 *
 * @author config
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_config")
@Service
public class TbDataDictionaryServiceImpl extends ServiceImpl<TbDataDictionaryMapper, TbDataDictionary> implements ITbDataDictionaryService {

}
