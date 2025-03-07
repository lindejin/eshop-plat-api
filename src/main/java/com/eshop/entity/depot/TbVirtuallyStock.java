package com.eshop.entity.depot;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 虚拟库存
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_virtually_stock")
public class TbVirtuallyStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_编码
     */
    private String skuCode;

    /**
     * 仓库id
     */
    private Long depotId;

    /**
     * 库存数量
     */
    private Long stockAmount;

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
    private Long creatorId;

    /**
     * 创建时间
     */
    private Date createTime;
}
