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
 * 供应链商品FBA装箱建议
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_carton_val")
public class ScmProductCartonVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品id
     */
    private Long scmProductId;

    /**
     * 纸箱_id
     */
    private Long cartonId;

    /**
     * 规格名称
     */
    private String specsName;

    /**
     * 预计可装箱数量(件)
     */
    private Long predictPackingNumber;

    /**
     * 预计装箱总体积(cm³)
     */
    private Double predictPackingSize;

    /**
     * 预计装箱总重量(g)
     */
    private Double predictPackingWeight;
}
