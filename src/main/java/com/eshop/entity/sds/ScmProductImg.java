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
 * 供应链商品图
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("scm_product_img")
public class ScmProductImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应链商品_id
     */
    private Integer scmProductId;

    /**
     * 图片_id
     */
    private Integer fileImgId;

    /**
     * 图片类型(1: 商品图, 2: 尺码图)
     */
    private Byte imgType;

    /**
     * 排序
     */
    private Byte sort;
}
