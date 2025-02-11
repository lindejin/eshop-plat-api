package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 虚拟库存
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_virtually_stock")
public class TbVirtuallyStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * sku_编码
     */
    private String skuCode;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 库存数量
     */
    private Integer stockAmount;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
