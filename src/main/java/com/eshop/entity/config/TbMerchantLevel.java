package com.eshop.entity.config;

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
 * 商户等级
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_merchant_level")
public class TbMerchantLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 等级名称
     */
    private String levelName;

    /**
     * 采购折扣比例
     */
    private Double purchaseDiscount;

    /**
     * 运费折扣比例
     */
    private Double freightDiscount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人	
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除人Id
     */
    private Integer deleteId;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;
}
