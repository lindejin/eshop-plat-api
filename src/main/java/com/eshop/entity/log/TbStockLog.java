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
 * 库存日志
 * </p>
 *
 * @author log
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_stock_log")
public class TbStockLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品子属性sku
     */
    private String productSku;

    /**
     * 商品条形编码
     */
    private Long barCode;

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
