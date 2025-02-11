package com.eshop.entity.supply;

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
 * 缺货记录
 * </p>
 *
 * @author supply
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_stockout_commodity")
public class TbStockoutCommodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sku编号
     */
    private String productSku;

    /**
     * 商品中文名称
     */
    private String productCnName;

    /**
     * 商品英文名称
     */
    private String productEnName;

    /**
     * 仓库_id
     */
    private Integer depotId;

    /**
     * 供应商_id
     */
    private Integer supplierId;

    /**
     * 缺货数量
     */
    private Integer stockoutQuantity;

    /**
     * 商品行业_id
     */
    private Integer industryId;

    /**
     * 商品目录_id
     */
    private Integer categoryId;

    /**
     * 商品分类_id
     */
    private Integer classifyId;

    /**
     * 是否已完成(1:是, 2:否)
     */
    private Byte isDone;

    /**
     * 商品状态: (-1: 停止销售, 1: 正常销售, 2:补货中)
     */
    private Byte goodsStatus;

    /**
     * 上一次采购价
     */
    private BigDecimal lastPrice;

    /**
     * 最新一次缺货时间
     */
    private LocalDateTime stockoutTime;
}
