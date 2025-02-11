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
 * Temu产品 模版敏感属性
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("temu_product_sku_sensitive")
public class TemuProductSkuSensitive implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * skuId
     */
    private Integer productSkuId;

    /**
     * 敏感类型(多个逗号,隔开): 110001:纯电, 120001:内电, 130001:磁性, 140001:液体, 150001:粉末, 160001:膏体, 170001:刀具 
     */
    private String sensitiveList;

    /**
     * 最大电池容量 (Wh)
     */
    private String maxBatteryCapacity;

    /**
     * 最大电池容量(mWh)
     */
    private String maxBatteryCapacityHp;

    /**
     * 最大液体容量(ml)
     */
    private String maxLiquidCapacity;

    /**
     * 最大液体容量 (μL)
     */
    private String maxLiquidCapacityHp;

    /**
     * 最大刀具长度 (mm)
     */
    private String maxKnifeLength;

    /**
     * 最大刀具长度 (μm)
     */
    private String maxKnifeLengthHp;

    /**
     * 刀尖角度
     */
    private String degrees;
}
