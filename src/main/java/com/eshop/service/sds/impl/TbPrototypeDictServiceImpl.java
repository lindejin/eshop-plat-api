package com.eshop.service.sds.impl;

import com.eshop.entity.sds.TbPrototypeDict;
import com.eshop.mapper.sds.TbPrototypeDictMapper;
import com.eshop.service.sds.ITbPrototypeDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 样机&词典值 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class TbPrototypeDictServiceImpl extends ServiceImpl<TbPrototypeDictMapper, TbPrototypeDict> implements ITbPrototypeDictService {

}
