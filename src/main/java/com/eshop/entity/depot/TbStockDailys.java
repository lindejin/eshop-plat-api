package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 每日SKU入库统计
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_stock_dailys")
public class TbStockDailys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 日期
     */
    private Date date;

    /**
     * 库存主表_id
     */
    private Long stockId;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 入库数量
     */
    private Long stockInCount;
}
