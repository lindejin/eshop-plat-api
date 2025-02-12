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
 * 供应链商品定位价格
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_clip")
public class ScmProductClip implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品_id
     */
    private Long scmProductId;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 定位名称
     */
    private String clipName;

    /**
     * 定位单价
     */
    private BigDecimal processPrice;

    /**
     * 默认定位宽度(cm)
     */
    private BigDecimal width;

    /**
     * 默认定位高度(cm)
     */
    private BigDecimal height;

    /**
     * 递增属性
     */
    private String rangeAttr;
}
