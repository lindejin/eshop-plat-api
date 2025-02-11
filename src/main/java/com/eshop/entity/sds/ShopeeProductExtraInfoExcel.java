package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("shopee_product_extra_info_excel")
public class ShopeeProductExtraInfoExcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * itemId
     */
    private Long itemId;

    /**
     * itemId
     */
    private Long productExtraId;

    /**
     * 商品访客（访问）
     */
    private Integer productVisitorsVisits;

    /**
     * 商品页面访客
     */
    private Integer productPageVisitors;

    /**
     * 跳出商品页面的访客数
     */
    private Integer numOfJumpProductPages;

    /**
     * 商品跳出率
     */
    private Integer productBounceRate;

    /**
     * 搜索点击数
     */
    private Integer searchHits;

    /**
     * 赞
     */
    private Integer numOfLikes;

    /**
     * 商品访客（添加至购物车）
     */
    private Integer productVisitorsAddCart;

    /**
     * 件数 (加入购物车）
     */
    private Integer numOfPiecesAddCart;

    /**
     * 转化率 (加入购物车率)
     */
    private Integer conversionRateAddCartRate;

    /**
     * 买家数（已下单）
     */
    private Integer numOfBuyersPlaced;

    /**
     * 件数（已下单）
     */
    private Integer numOfPieces;

    /**
     * 销售额（已下单） (PHP)
     */
    private Integer salesOrderdPhp;

    /**
     * 转化率（已下单）
     */
    private Integer conversionRateOrderd;

    /**
     * 买家数（已确认订单）
     */
    private Integer numOfBuyersConfirmedOrders;

    /**
     * 件数（已确认订单）
     */
    private Integer numOfPiecesConfirmedOrders;

    /**
     * 销售额（已确认订单） (PHP)
     */
    private Integer salesConfirmedOrdersPhp;

    /**
     * 转化率（已确认订单）
     */
    private Integer conversionReateConfirmedOrders;

    /**
     * 转化率（已确认订单）
     */
    private Integer conversionRatetobeDetermined;

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
