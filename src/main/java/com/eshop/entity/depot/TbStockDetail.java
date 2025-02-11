package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 库存明细
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_stock_detail")
public class TbStockDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 库存主表_id
     */
    private Integer stockId;

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
    private Integer supplierId;

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
    private Integer storagePersonId;

    /**
     * 入库时间
     */
    private LocalDateTime storageTime;

    /**
     * 出库人_id
     */
    private Integer outboundPersonId;

    /**
     * 出库时间
     */
    private LocalDateTime outboundTime;

    /**
     * 备注
     */
    private String remark;
}
