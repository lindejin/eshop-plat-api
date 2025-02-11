package com.eshop.entity.sds;

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
 * 虾皮商品(spu)-最近30统计值
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("shopee_product_extra_info")
public class ShopeeProductExtraInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * itemId
     */
    private Long itemId;

    /**
     * 销售额
     */
    private Integer salesRevenue;

    /**
     * 访客数
     */
    private Integer visitorCount;

    /**
     * 订单量
     */
    private Integer orderQuantity;

    /**
     * 转化率
     */
    private BigDecimal conversionRate;

    /**
     * 购买用户数
     */
    private Integer numOfPurchasingUsers;

    /**
     * 访问用户数
     */
    private Integer numOfVisitingUsers;

    /**
     * 页面浏览量
     */
    private Integer pageViews;

    /**
     * 加购数
     */
    private Integer additionalPurchases;

    /**
     * 加购率
     */
    private BigDecimal purchaseRate;

    /**
     * 买家数
     */
    private Integer numberOfBuyers;

    /**
     * 商品评价数
     */
    private Integer numOfProductReviews;

    /**
     * 产品点击率
     */
    private BigDecimal productClickThroughRate;

    /**
     * 点击数据
     */
    private Integer clickOnData;

    /**
     * 展示次数
     */
    private Integer displayFrequency;

    /**
     * 创建时间
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
