package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 供应链商品基础信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("scm_product_base")
public class ScmProductBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 供应链商品id
     */
    private Long scmProductId;

    /**
     * 商品中文名称
     */
    private String productNameCn;

    /**
     * 商品英文名称
     */
    private String productNameEn;

    /**
     * 商品简称
     */
    private String productAbbreviation;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 视频_id
     */
    private Long fileVideoId;

    /**
     * 预计发货时效(小时)
     */
    private Long deliveryTime;
}
