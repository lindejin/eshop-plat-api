package com.eshop.entity.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 有备货时产品sku与备货地址关联信息
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("dh_sku_inven")
public class DhSkuInven implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品sku_id
     */
    private Long skuId;

    /**
     * 产品备货地址编码(必须在itemSkuList[].itemSkuInvenList[].inventoryLocation中。示例值：CN)
     */
    private String inventoryLocation;

    /**
     * skuMD5值
     */
    private String skuMd5;

    /**
     * 有备货时，备货地址下sku的备货数量
     */
    private Long skuInventoryQty;

    /**
     * 是否可销售(0 不可销售1 可销售, 示例值：1)
     */
    private Byte saleStatus;
}
