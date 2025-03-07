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
 * 主库产品模版关系
 * </p>
 *
 * @author sds
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
     * 主库产品id(sds成品)
     */
    private Long productId;

    /**
     * 虾皮模版id
     */
    private Long templateId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 主库skuId
     */
    private Long skuId;
}
