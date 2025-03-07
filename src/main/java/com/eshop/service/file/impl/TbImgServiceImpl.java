package com.eshop.service.file.impl;

import com.eshop.entity.file.TbImg;
import com.eshop.mapper.file.TbImgMapper;
import com.eshop.service.file.ITbImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 图片空间 服务实现类
 * </p>
 *
 * @author file
 * @since 2025-03-07
 * @since 2025-03-07
 */
@DS("eshop_file")
@Service
public class TbImgServiceImpl extends ServiceImpl<TbImgMapper, TbImg> implements ITbImgService {

}
