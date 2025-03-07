package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 库存明细
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_stock_detail")
public class TbStockDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 库存主表_id
     */
    private Long stockId;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 商品条形编码
     */
    private Long barCode;

    /**
     * 供应商_id
     */
    private Long supplierId;

    /**
     * 商品状态(1:还在库存,2:已出库存,3:非常规出库存，-1:冻结)
     */
    private Byte barStatus;

    /**
     * 商品采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 入库人_id
     */
    private Long storagePersonId;

    /**
     * 入库时间
     */
    private Date storageTime;

    /**
     * 出库人_id
     */
    private Long outboundPersonId;

    /**
     * 出库时间
     */
    private Date outboundTime;

    /**
     * 备注
     */
    private String remark;
}
