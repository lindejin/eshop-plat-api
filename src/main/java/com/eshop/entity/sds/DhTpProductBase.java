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
 * 敦煌商品基本信息
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("dh_tp_product_base")
public class DhTpProductBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 产品名称
     */
    private String itemName;

    /**
     * 产品搜索关键字1
     */
    private String keyWord1;

    /**
     * 产品搜索关键字2
     */
    private String keyWord2;

    /**
     * 产品搜索关键字3
     */
    private String keyWord3;

    /**
     * 产品简短描述
     */
    private String shortDesc;

    /**
     * 产品详细描述文件名称
     */
    private String contentName;

    /**
     * 产品视频地址
     */
    private String videoUrl;

    /**
     * 卖点&特性1
     */
    private String shortDesc1;

    /**
     * 卖点&特性2
     */
    private String shortDesc2;

    /**
     * 卖点&特性3
     */
    private String shortDesc3;

    /**
     * 卖点&特性4
     */
    private String shortDesc4;

    /**
     * 卖点&特性5
     */
    private String shortDesc5;

    /**
     * 产品区间价格最小值
     */
    private BigDecimal originalPriceMin;

    /**
     * 产品价格价格最大值
     */
    private BigDecimal originalPriceMax;
}
