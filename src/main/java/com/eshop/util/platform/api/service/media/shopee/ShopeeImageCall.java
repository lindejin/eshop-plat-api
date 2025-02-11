package com.eshop.util.platform.api.service.media.shopee;

import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.util.MultiValueMap;

/**
 * @author ldj
 * @date 2023/3/24 14:56
 * @Description: 虾皮图片 调用服务
 * @Version 1.0
 */
public interface ShopeeImageCall {

    /**
     * 虾皮 图片上传(单个)
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String uploadImage(ShopeeAppClientDTO publicDto, MultiValueMap<String, Object> businessDto) throws Exception;
}
