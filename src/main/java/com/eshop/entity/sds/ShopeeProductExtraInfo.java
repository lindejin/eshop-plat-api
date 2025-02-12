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
 * 虾皮商品(spu)-最近30统计值
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("shopee_product_extra_info")
public class ShopeeProductExtraInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * itemId
     */
    private Long itemId;

    /**
     * 销售额
     */
    private Long salesRevenue;

    /**
     * 访客数
     */
    private Long visitorCount;

    /**
     * 订单量
     */
    private Long orderQuantity;

    /**
     * 转化率
     */
    private BigDecimal conversionRate;

    /**
     * 购买用户数
     */
    private Long numOfPurchasingUsers;

    /**
     * 访问用户数
     */
    private Long numOfVisitingUsers;

    /**
     * 页面浏览量
     */
    private Long pageViews;

    /**
     * 加购数
     */
    private Long additionalPurchases;

    /**
     * 加购率
     */
    private BigDecimal purchaseRate;

    /**
     * 买家数
     */
    private Long numberOfBuyers;

    /**
     * 商品评价数
     */
    private Long numOfProductReviews;

    /**
     * 产品点击率
     */
    private BigDecimal productClickThroughRate;

    /**
     * 点击数据
     */
    private Long clickOnData;

    /**
     * 展示次数
     */
    private Long displayFrequency;

    /**
     * 创建时间
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
