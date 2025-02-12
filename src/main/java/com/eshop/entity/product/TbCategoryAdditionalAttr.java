package com.eshop.entity.product;

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
 * 类目附加属性
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_category_additional_attr")
public class TbCategoryAdditionalAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long categoryId;

    /**
     * 海关编码
     */
    private String customsName;

    /**
     * 申报名称
     */
    private String declareName;

    /**
     * 申报名称_英文
     */
    private String declareNameEn;

    /**
     * 申报价格
     */
    private BigDecimal declarePrice;

    /**
     * 申报重量
     */
    private Double declareWeight;

    /**
     * 是否上传尺码表(1:是, 2:否)
     */
    private Byte isSizeTable;

    /**
     * 包材id
     */
    private Long packingId;
}
