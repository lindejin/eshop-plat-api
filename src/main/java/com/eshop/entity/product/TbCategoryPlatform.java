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
 * 主类目与平台类目中间表
 * </p>
 *
 * @author product
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_category_platform")
public class TbCategoryPlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台类目id
     */
    private String platformCategoryId;

    /**
     * 平台佣金比例(0.05 = 5%)
     */
    private Double brokerageProportion;

    /**
     * 操作人id
     */
    private Integer operId;

    /**
     * 操作时间
     */
    private LocalDateTime operTime;
}
