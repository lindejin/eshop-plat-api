package com.eshop.entity.order;

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
 * 订单商品明细
 * </p>
 *
 * @author order
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_order_products")
public class TbOrderProducts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 平台sku_id
     */
    private Long platformSkuId;

    /**
     * 平台sku_index
     */
    private Long platformSkuIndex;

    /**
     * 店铺sku商品图片
     */
    private Long skuImgId;

    /**
     * 店铺sku编号
     */
    private String shopSku;

    /**
     * 库存sku编号
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
     * 属性
     */
    private String property;

    /**
     * 单品重量
     */
    private Double basisWeight;

    /**
     * 数量
     */
    private Long number;

    /**
     * 订单数量
     */
    private Long orderNumber;

    /**
     * 商品单价
     */
    private BigDecimal unitPrice;

    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    /**
     * 商品类型(1,订单同步下来的、2.赠品、2.补发)
     */
    private Byte productType;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 商品skuid
     */
    private Long productSkuId;

    /**
     * 扩展使用（当业务支持一个PO单多个相同sc_item_id场景使用)
     */
    private Long poLineId;

    /**
     * 是否定制品，0-否，1-是
     */
    private Byte isCustomProduct;
}
