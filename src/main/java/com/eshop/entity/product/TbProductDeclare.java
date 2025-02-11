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
 * 商品申报信息
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_declare")
public class TbProductDeclare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * spu编码
     */
    private String spuCode;

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
     * 海关编码
     */
    private String customsName;

    /**
     * 是否带电池(1:否, 2:是)
     */
    private Byte isHasBattery;

    /**
     * 是否侵权(1:否, 2:是)
     */
    private Byte isTort;

    /**
     * 是否带磁(1:否, 2:是)
     */
    private Byte isHasMagnetic;

    /**
     * 是否液体(1:否, 2:是)
     */
    private Byte isLiquid;

    /**
     * 是否粉末(1:否, 2:是)
     */
    private Byte isPowder;
}
