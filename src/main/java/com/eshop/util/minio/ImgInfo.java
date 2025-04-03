package com.eshop.util.minio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xxs
 * @date 2023/12/6
 * @desc 图片信息
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImgInfo {
    /**
     * 图片url
     */
    private String url;

    /**
     * 缩略图url
     */
    private String thumbnailUrl;
}
