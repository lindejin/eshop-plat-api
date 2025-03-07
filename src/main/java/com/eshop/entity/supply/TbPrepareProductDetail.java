package com.eshop.entity.supply;

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
 * 备货单详情 
 * </p>
 *
 * @author supply
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_prepare_product_detail")
public class TbPrepareProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 备货单_id
     */
    private Long prepareId;

    /**
     * sku编码
     */
    private String skuCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 备货数量
     */
    private Long prepareAmount;

    /**
     * 采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 备注
     */
    private String remark;
}
