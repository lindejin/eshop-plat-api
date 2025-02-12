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
 * AMS商品信息
 * </p>
 *
 * @author depot
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("ams_product")
public class AmsProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品Id
     */
    private String productSpuId;

    /**
     * 货品Id
     */
    private String productSkuId;

    /**
     * sku属性
     */
    private String skuAttr;

    /**
     * 采购单价
     */
    private BigDecimal procureUnitPrice;

    /**
     * 库存数量
     */
    private Long stock;

    /**
     * 公司名称
     */
    private String corporateName;

    /**
     * 商品状态
     */
    private String status;

    /**
     * 销售价
     */
    private BigDecimal salePrice;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 删除人Id
     */
    private Long deleteId;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;
}
