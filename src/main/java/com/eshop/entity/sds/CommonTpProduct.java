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
 * 通用库商品模板
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("common_tp_product")
public class CommonTpProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户_id
     */
    private Long merchantId;

    /**
     * 模版id
     */
    private Long templateId;

    /**
     * 类目_id
     */
    private Long categoryId;

    /**
     * 视频_id
     */
    private Long fileVideoId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 预计发货时效(小时)
     */
    private Long deliveryTime;

    /**
     * 销售单价($) ps: 如果有值认领所有sku取值这里
     */
    private BigDecimal unitPrice;

    /**
     * 商品重量(g) ps: 如果有值认领所有sku取值这里
     */
    private BigDecimal skuWeight;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateId;

    /**
     * 修改时间
     */
    private Date updateTime;
}
