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
 * 供应链商品包装规格
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_package")
public class ScmProductPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品id
     */
    private Long scmProductId;

    /**
     * 规格名称
     */
    private String specsName;

    /**
     * 包装尺寸(长 * 宽 * 高)(cm)
     */
    private String packageSizeCm;

    /**
     * 包装尺寸(长 * 宽 * 高)(in)
     */
    private String packageSizeIn;

    /**
     * 包装体积(cm³)
     */
    private Double packageVolumeCm;

    /**
     * 包装体积(in³)
     */
    private Double packageVolumeIn;

    /**
     * 含包装重量(g)
     */
    private Double packageWeightG;

    /**
     * 含包装重量(lb)
     */
    private Double packageWeightLb;
}
