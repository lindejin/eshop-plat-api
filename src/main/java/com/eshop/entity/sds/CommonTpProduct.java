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
 * 通用库商品模板
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("common_tp_product")
public class CommonTpProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 模版id
     */
    private Integer templateId;

    /**
     * 类目_id
     */
    private Integer categoryId;

    /**
     * 视频_id
     */
    private Integer fileVideoId;

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
    private Integer deliveryTime;

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
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
