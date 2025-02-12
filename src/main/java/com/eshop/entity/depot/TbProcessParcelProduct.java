package com.eshop.entity.depot;

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
 * 加工包裹商品
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_process_parcel_product")
public class TbProcessParcelProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 商品条形编码
     */
    private Long barCode;

    /**
     * sku成本价
     */
    private BigDecimal skuCost;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商品状态(1.待配货 2.已完成 -1.作废)
     */
    private Byte productStatus;

    /**
     * 商品条形编码(重打)
     */
    private Long barCodeReprint;
}
