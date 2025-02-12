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
 * Temu产品模版详情信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("temu_tp_product_detail")
public class TemuTpProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品模板Id
     */
    private Long productId;

    /**
     * 语言类型
     */
    private String lang;

    /**
     * 组件类型type,图片-image,文本-text
     */
    private String type;

    /**
     * 楼层排序
     */
    private Long priority;

    /**
     * 图片Id
     */
    private Long imgId;

    /**
     * 文本背景颜色 六位值，例#ffffff
     */
    private String backgroundColor;

    /**
     * 字体类型
     */
    private String fontFamily;

    /**
     * 文本字体大小
     */
    private Byte fontSize;

    /**
     * 文本对齐方式
     */
    private String align;

    /**
     * 文本字体颜色 六位值，例#333333
     */
    private String fontColor;

    /**
     * 文本内容
     */
    private String text;
}
