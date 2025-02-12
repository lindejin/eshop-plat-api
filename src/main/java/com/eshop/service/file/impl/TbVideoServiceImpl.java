package com.eshop.service.file.impl;

import com.eshop.entity.file.TbVideo;
import com.eshop.mapper.file.TbVideoMapper;
import com.eshop.service.file.ITbVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 视频 服务实现类
 * </p>
 *
 * @author file
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_file")
@Service
public class TbVideoServiceImpl extends ServiceImpl<TbVideoMapper, TbVideo> implements ITbVideoService {

}
