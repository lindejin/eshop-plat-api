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
 * 供应链商品FBA装箱
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("scm_product_carton")
public class ScmProductCarton implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应链商品id
     */
    private Integer scmProductId;

    /**
     * 包装/纸箱 名称
     */
    private String cartonName;

    /**
     * 纸箱标准外径尺寸(长 * 宽 * 高cm)
     */
    private String cartonSize;

    /**
     * 纸箱体积(cm³)
     */
    private Double cartonVolume;

    /**
     * 纸箱重量(g)
     */
    private Double cartonWeight;

    /**
     * 纸箱图片展示文件_id
     */
    private Integer fileId;
}
