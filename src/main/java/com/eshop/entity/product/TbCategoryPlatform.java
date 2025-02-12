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
 * 主类目与平台类目中间表
 * </p>
 *
 * @author product
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tb_category_platform")
public class TbCategoryPlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类目id
     */
    private Long categoryId;

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
    private Long operId;

    /**
     * 操作时间
     */
    private Date operTime;
}
