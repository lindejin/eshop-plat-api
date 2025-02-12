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
 * 模板-铺货拓展信息-模特图片信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("template_platform_spread_prototype_img")
public class TemplatePlatformSpreadPrototypeImg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模板id
     */
    private Long templateId;

    /**
     * 样机id
     */
    private Long prototypeId;

    /**
     * 图片id
     */
    private Long imgId;

    /**
     * 图片排序
     */
    private Byte sort;
}
