package com.eshop.entity.collect;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 采集产品图片信息
 * </p>
 *
 * @author collect
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("cl_product_img")
public class ClProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 文件库ID
     */
    private Integer imgId;

    /**
     * 文件类型(1:商品主图)
     */
    private Byte imgType;

    /**
     * 原图片_id
     */
    private Integer rawImgId;

    /**
     * 排序
     */
    private Byte sort;
}
