package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 柔性定制item
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_flexible_customize_style_detail")
public class TbFlexibleCustomizeStyleDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 小篮子编号
     */
    private Long smallBasketCode;

    /**
     * 成品sku编号
     */
    private String finishedSku;

    /**
     * 合成商品条形编码
     */
    private Long finishedBarCode;

    /**
     * 款式sku编号
     */
    private String styleSku;

    /**
     * 款式商品条形编码
     */
    private Long styleBarCode;

    /**
     * 定制状态
     */
    private Byte customizeStatus;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 包裹类型(1:单品,2:多品)
     */
    private Byte parcelType;
}
