package com.eshop.entity.sds;

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
 * 模版基础信息
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("template_product")
public class TemplateProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模版id
     */
    private Long templateId;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 产品名称
     */
    private String itemName;

    /**
     * 产品状态
     */
    private String itemStatus;

    /**
     * 产品价格
     */
    private BigDecimal originalPrice;

    /**
     * 单价折扣
     */
    private BigDecimal priceDiscount;

    /**
     * 产品备货数量
     */
    private Long inventory;

    /**
     * 此字段仅适用于印度尼西亚和马来西亚的本地卖家。使用此字段可确定产品是否为危险产品。0 表示非危险品，1 表示危险品。有关更多信息，请访问市场相应的卖家教育中心。)
     */
    private Byte itemDangerous;

    /**
     * description_type（正常，扩展）--- 不要了，白名单卖家字段关联，那个先不管
     */
    private String descriptionType;

    /**
     * (仅适用于 BR 本地卖家）全球贸易项目代码。如果已上传，请通过get_item_base_info api 检查项目的gtin_code
     */
    private String gtinCode;

    /**
     * 项目状况，可以是新的或二手的
     */
    private String conditionVal;

    /**
     * 描述-需要确认大小
     */
    private String description;

    /**
     * 商品是否为预购商品(0.否  1.是)
     */
    private Long isPreOrder;

    /**
     * 保证发货订单的天数
     */
    private Long daysToShip;

    /**
     * 尺码ID
     */
    private Long sizeId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String brandName;
}
