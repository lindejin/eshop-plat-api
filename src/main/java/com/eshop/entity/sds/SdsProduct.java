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
 * sds-产品(产品 + 图片= 成品)
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("sds_product")
public class SdsProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id-原sds产品id
     */
    private Long productId;

    /**
     * 产品父id
     */
    private Long parentId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编号-对应sku
     */
    private String spuCode;

    /**
     * 当前价格
     */
    private BigDecimal currentPrice;

    /**
     * 产品英文名
     */
    private String englishName;

    /**
     * 产品图片
     */
    private String imgUrl;

    /**
     * 空白设计url
     */
    private String blankDesignUrl;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
