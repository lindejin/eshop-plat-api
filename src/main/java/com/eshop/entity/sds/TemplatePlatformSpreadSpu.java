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
 * 模板-铺货拓展信息-样机合并认领spu信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("template_platform_spread_spu")
public class TemplatePlatformSpreadSpu implements Serializable {

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
     * spu索引
     */
    private Byte spuIndex;

    /**
     * 是否是主spu 1.是 0.否
     */
    private Byte mainSpu;

    /**
     * 图片索引
     */
    private Byte imgIndex;

    /**
     * 图片排序
     */
    private Byte sort;
}
