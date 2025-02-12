package com.eshop.entity.sds;

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
 * 虾皮商品(spu)-最近30统计值
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("shopee_product_extra_info_excel")
public class ShopeeProductExtraInfoExcel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
    private Long productVisitorsVisits;

    /**
     * 商品页面访客
     */
    private Long productPageVisitors;

    /**
     * 跳出商品页面的访客数
     */
    private Long numOfJumpProductPages;

    /**
     * 商品跳出率
     */
    private Long productBounceRate;

    /**
     * 搜索点击数
     */
    private Long searchHits;

    /**
     * 赞
     */
    private Long numOfLikes;

    /**
     * 商品访客（添加至购物车）
     */
    private Long productVisitorsAddCart;

    /**
     * 件数 (加入购物车）
     */
    private Long numOfPiecesAddCart;

    /**
     * 转化率 (加入购物车率)
     */
    private Long conversionRateAddCartRate;

    /**
     * 买家数（已下单）
     */
    private Long numOfBuyersPlaced;

    /**
     * 件数（已下单）
     */
    private Long numOfPieces;

    /**
     * 销售额（已下单） (PHP)
     */
    private Long salesOrderdPhp;

    /**
     * 转化率（已下单）
     */
    private Long conversionRateOrderd;

    /**
     * 买家数（已确认订单）
     */
    private Long numOfBuyersConfirmedOrders;

    /**
     * 件数（已确认订单）
     */
    private Long numOfPiecesConfirmedOrders;

    /**
     * 销售额（已确认订单） (PHP)
     */
    private Long salesConfirmedOrdersPhp;

    /**
     * 转化率（已确认订单）
     */
    private Long conversionReateConfirmedOrders;

    /**
     * 转化率（已确认订单）
     */
    private Long conversionRatetobeDetermined;

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
