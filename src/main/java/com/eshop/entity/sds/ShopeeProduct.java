package com.eshop.entity.sds;

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
 * 虾皮商品
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("shopee_product")
public class ShopeeProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 模版Id
     */
    private Long templateId;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 产品id
     */
    private Long itemId;

    /**
     * 产品名称
     */
    private String itemName;

    /**
     * 产品状态(UNLIST:下架状态； NORMAL:上架状态)
     */
    private String itemStatus;

    /**
     * 品牌id(类目属性冗余过来，这个必填)
     */
    private Long brandId;

    /**
     * 尺码ID
     */
    private Long sizeId;

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
     * 刊登时间
     */
    private Date publishTime;

    /**
     * 刊登失败原因
     */
    private String publishErrInfo;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 虾皮折扣活动ID
     */
    private Long discountId;

    /**
     * 是否已刊登到店铺1: 是, 2: 否 3.手动刊登
     */
    private Byte isPublish;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;
}
