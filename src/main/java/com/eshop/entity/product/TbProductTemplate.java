package com.eshop.entity.product;

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
 * 主库产品模版关系
 * </p>
 *
 * @author product
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_product_template")
public class TbProductTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id(sds成品)
     */
    private String productId;

    /**
     * 虾皮模版id
     */
    private Long templateId;

    /**
     * 主库(tbProductId)
     */
    private Long spuId;

    /**
     * 主库成品(spuCode)
     */
    private String spuCode;

    /**
     * 虾皮成品id
     */
    private Long shopeeId;

    /**
     * 主库erp-类目
     */
    private Long tbCategoryId;

    /**
     * 创建日期
     */
    private Date createTime;
}
