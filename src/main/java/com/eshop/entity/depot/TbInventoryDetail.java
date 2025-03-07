package com.eshop.entity.depot;

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
 * 盘点详情
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_inventory_detail")
public class TbInventoryDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 盘点编号
     */
    private Long inventoryNo;

    /**
     * 仓位编码
     */
    private String positionCode;

    /**
     * 库存sku编号
     */
    private String productSku;

    /**
     * 商品条形编码
     */
    private Long barCode;

    /**
     * 盘点明细状态(0.待盘点，1.正常盘点，2.盘亏，3.盘盈)
     */
    private Byte inventoryDetailStatus;

    /**
     * 盘点明细扫描人
     */
    private Long scanningId;

    /**
     * 盘点明细扫描时间
     */
    private Date scanningTime;

    /**
     * 备注
     */
    private String remark;
}
