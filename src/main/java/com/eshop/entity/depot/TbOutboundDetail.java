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
 * 出库明细
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_outbound_detail")
public class TbOutboundDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出库单号
     */
    private Long outboundNo;

    /**
     * 仓位编码
     */
    private String positionCode;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 商品条形编码
     */
    private Long barCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 出库数量
     */
    private Integer storageQuantity;
}
