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
 * 柔性定制item 所需图案列表
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_flexible_customize_material_detail")
public class TbFlexibleCustomizeMaterialDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 柔性定制item列表id
     */
    private Long fcsId;

    /**
     * 批次号
     */
    private Long batchNo;

    /**
     * 小篮子编号
     */
    private Long smallBasketCode;

    /**
     * 素材sku编号
     */
    private String materialSku;

    /**
     * 素材商品条形编码
     */
    private Long materialBarCode;

    /**
     * 定制状态
     */
    private Byte customizeStatus;

    /**
     * 可重复打印的(1.可以2.不行)
     */
    private Byte isReprintable;

    /**
     * 序列号
     */
    private String sequenceNumber;
}
