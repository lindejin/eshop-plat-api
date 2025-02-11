package com.eshop.entity.depot;

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
 * 篮子
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_depot_basket")
public class TbDepotBasket implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库id
     */
    private Integer depotId;

    /**
     * 篮子名称
     */
    private String basketName;

    /**
     * 篮子编号
     */
    private Long basketCode;

    /**
     * 篮子序号
     */
    private Integer serialNumber;

    /**
     * 篮子类型(1:大篮子,2:小篮子)
     */
    private Byte basketType;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * 篮子状态(1.空闲 2.占用)
     */
    private Byte basketStatus;

    /**
     * 篮子用途(101:普通大篮子,201:普通小篮子,202:柔性定制加工小篮子)
     */
    private Integer useType;
}
