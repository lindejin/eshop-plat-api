package com.eshop.entity.log;

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
 * 第三方商品同步日志
 * </p>
 *
 * @author log
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_product_syn_log")
public class TbProductSynLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 平台商品spu	商品spu
     */
    private String spuCode;

    /**
     * 第三方平台商品Id
     */
    private String productId;

    /**
     * 原spu
     */
    private String rawSpu;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 运行时间
     */
    private Date operateTime;
}
