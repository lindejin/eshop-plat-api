package com.eshop.service.sds.impl;

import com.eshop.entity.sds.DiyImg;
import com.eshop.mapper.sds.DiyImgMapper;
import com.eshop.service.sds.IDiyImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 定位图库 服务实现类
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 * @since 2025-02-12
 */
@DS("eshop_sds")
@Service
public class DiyImgServiceImpl extends ServiceImpl<DiyImgMapper, DiyImg> implements IDiyImgService {

}
