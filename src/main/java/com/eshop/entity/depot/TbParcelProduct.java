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
 * 包裹商品
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_parcel_product")
public class TbParcelProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 商品条形编码
     */
    private Long barCode;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 商户_成本价
     */
    private BigDecimal merchantCostPrice;

    /**
     * 出仓状态  -1:退货成本已返还商户, 1:待配货,2:待复核,3:待打包,4:待出库,5:已出库,6包裹换单,99包裹退单
     */
    private Byte status;
}
