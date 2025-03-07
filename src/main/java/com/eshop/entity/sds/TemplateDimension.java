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
 * 模版包装尺码
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("template_dimension")
public class TemplateDimension implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模版ID
     */
    private Long templateId;

    /**
     * 包装高度，单位为厘米
     */
    private Long packageHeight;

    /**
     * 包装长度，单位为厘米
     */
    private Long packageLength;

    /**
     * 包装宽度，单位为厘米
     */
    private Long packageWidth;

    /**
     * 重量，单位kg
     */
    private BigDecimal weight;
}
