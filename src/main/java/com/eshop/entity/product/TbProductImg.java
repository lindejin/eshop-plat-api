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
 * 产品图片信息
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_img")
public class TbProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 文件库ID
     */
    private Integer imgId;

    /**
     * 文件类型(1:商品主图,2:商品附图,3:尺码图片)
     */
    private Byte imgType;

    /**
     * 原图片_id
     */
    private Integer rawImgId;
}
