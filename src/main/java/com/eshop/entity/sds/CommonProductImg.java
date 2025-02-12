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
 * 通用库商品图片
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("common_product_img")
public class CommonProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 主表_id
     */
    private Long productId;

    /**
     * 图片_id
     */
    private Long fileImgId;

    /**
     * 图片类型(1: 商品图, 2: 尺码图)
     */
    private Byte imgType;

    /**
     * 排序
     */
    private Byte sort;
}
