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
 * 模版图片列表
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("template_img")
public class TemplateImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模版ID
     */
    private Integer productId;

    /**
     * 文件库ID
     */
    private Integer imgId;

    /**
     * 排序(序号为一的为主图)
     */
    private Byte sort;

    /**
     * 类型 1.固定图
     */
    private Byte type;
}
