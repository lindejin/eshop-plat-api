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
 * 供应链商品等级折扣
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_discount")
public class ScmProductDiscount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品id
     */
    private Long scmProductId;

    /**
     * 商户等级id
     */
    private Long merchantLevelId;

    /**
     * 商品折扣比例
     */
    private Double productDiscount;
}
