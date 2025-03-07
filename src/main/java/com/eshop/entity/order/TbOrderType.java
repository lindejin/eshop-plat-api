package com.eshop.entity.order;

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
 * 订单类型
 * </p>
 *
 * @author order
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("tb_order_type")
public class TbOrderType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 是否默认(1:是, 2: 否)
     */
    private Byte isDefault;

    /**
     * 创建人
     */
    private Long createOperId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除字段(1: 删除, 2: 未删除)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;
}
