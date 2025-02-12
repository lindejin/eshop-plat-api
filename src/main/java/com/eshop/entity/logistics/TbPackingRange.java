package com.eshop.entity.logistics;

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
 * 包材区间重量及价格
 * </p>
 *
 * @author logistics
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_packing_range")
public class TbPackingRange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包材id
     */
    private Long packingId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 包材自重(KG)
     */
    private Double weight;

    /**
     * 长(cm)
     */
    private Double length;

    /**
     * 宽(cm)
     */
    private Double width;

    /**
     * 高(cm)
     */
    private Double height;

    /**
     * 包裹区间重量(KG)
     */
    private Double rangeWeight;
}
