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
 * 速卖通产品sku属性列表 
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("ae_product_sku_attr")
public class AeProductSkuAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 产品sku主键id
     */
    private Integer skuId;

    /**
     * SkuCode
     */
    private String skuCode;

    /**
     * sku变种属性id(主键id)
     */
    private Long attrId;

    /**
     * sku变种属性值id(主键id)
     */
    private Long attrValId;

    /**
     * sku自定义图片，女装类目色卡图。图片格式只允许jpg、png、jpeg这3种格式
     */
    private String skuImage;

    /**
     * 女装类目sku套图,3:4图片,图片数量限制 : 3到6张图片。女装(200000345)下的叶子类目必传参数。图片格式只允许jpg、png、jpeg这3种格式
     */
    private String imageUrlList;

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
