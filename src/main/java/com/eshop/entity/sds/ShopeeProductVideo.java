package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 虾皮产品视频列表
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("shopee_product_video")
public class ShopeeProductVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 图片url地址(通过上传图片接口(dh.album.img.upload)获取；上传第一张默认为首图;示例值：/f2/albu/g1/M00/01/02/rBVaIVPxjnCIBEuBAAB1EDXekqMAAAYbgGJ1EkAAHUo678.jpg;	)
     */
    private String videoUrl;

    /**
     * 平台视屏ID
     */
    private String uploadId;

    /**
     * 文件库ID
     */
    private Long videoId;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;
}
