package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 供应链包材费区间范围
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("scm_product_package_range")
public class ScmProductPackageRange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应链商品id
     */
    private Integer scmProductId;

    /**
     * 仓库_id
     */
    private Integer depotId;

    /**
     * 阶梯数量
     */
    private Integer startQt;

    /**
     * 包材阶梯费用
     */
    private BigDecimal packageCost;
}
