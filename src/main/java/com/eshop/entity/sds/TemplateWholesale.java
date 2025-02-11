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
 * 模版批发
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("template_wholesale")
public class TemplateWholesale implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模版_id
     */
    private Integer templateId;

    /**
     * 此层的最小计数
     */
    private Integer minCount;

    /**
     * 此层的最大计数
     */
    private Integer maxCount;

    /**
     * 价格
     */
    private BigDecimal unitPrice;
}
