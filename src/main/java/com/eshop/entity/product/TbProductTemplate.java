package com.eshop.entity.product;

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
 * 主库产品模版关系
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_product_template")
public class TbProductTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id(sds成品)
     */
    private String productId;

    /**
     * 产品类型1.柔性定制产品 2.普通产品 3.采集产品
     */
    private Byte productType;

    /**
     * 虾皮模版id
     */
    private Integer templateId;

    /**
     * 主库(tbProductId)
     */
    private Integer spuId;

    /**
     * 主库成品(spuCode)
     */
    private String spuCode;

    /**
     * 虾皮成品id
     */
    private Integer shopeeId;

    /**
     * 主库erp-类目
     */
    private Integer tbCategoryId;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;
}
