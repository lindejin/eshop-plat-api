package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 成品图片
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_prototype_img")
public class TbPrototypeImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 样机id
     */
    private Long prototypeId;

    /**
     * 文件库_id
     */
    private Long imgId;

    /**
     * 是否合成背景(1: 是, 否)
     */
    private Byte isSynthesisBackground;

    /**
     * 背景图_id
     */
    private Long maskImgId;

    /**
     * 文件名称
     */
    private String imgName;

    /**
     * 图片类型(1: 属性图, 2: 常规图)
     */
    private Byte imgType;

    /**
     * 图片宽度px
     */
    private BigDecimal imgWidth;

    /**
     * 图片高度px
     */
    private BigDecimal imgHeight;

    /**
     * 排序
     */
    private Byte sort;
}
