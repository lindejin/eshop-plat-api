package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 产品图片列表
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("dh_product_img")
public class DhProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 图片来源(3=Googleshopping推广图片,其他数值=其他来源；示例值：3;)
     */
    private Byte type;

    /**
     * 图片url地址(通过上传图片接口(dh.album.img.upload)获取；上传第一张默认为首图;示例值：/f2/albu/g1/M00/01/02/rBVaIVPxjnCIBEuBAAB1EDXekqMAAAYbgGJ1EkAAHUo678.jpg;	)
     */
    private String imgUrl;

    /**
     * 图片MD5值(通过上传图片接口(dh.album.img.upload)获取；示例值：d9ec536b1792f2562c59e6ad4fd45f9f;)
     */
    private String imgMd5;

    /**
     * 文件库ID
     */
    private Long imgId;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;
}
