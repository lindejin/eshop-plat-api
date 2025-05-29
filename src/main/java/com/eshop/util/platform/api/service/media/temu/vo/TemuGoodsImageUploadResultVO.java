package com.eshop.util.platform.api.service.media.temu.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class TemuGoodsImageUploadResultVO {
    /**
     * 原图链接
     */
    private String imageUrl;
    /**
     * 单张AI裁图链接
     */
    private String url;
    /**
     * 多张AI裁图链接
     */
    private List<String> urls;
}
