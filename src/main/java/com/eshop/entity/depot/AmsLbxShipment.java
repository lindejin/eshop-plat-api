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
 * ams的lbx货运信息表，用于存储货物的相关信息
 * </p>
 *
 * @author depot
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("ams_lbx_shipment")
public class AmsLbxShipment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增的主键列，用于唯一标识每个记录
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属商户的ID
     */
    private Long merchantId;

    /**
     * 仓库ID
     */
    private Long depotId;

    /**
     * 仓位号
     */
    private String depotLocation;

    /**
     * 运单号
     */
    private String waybillNo;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * LBX编号
     */
    private String lbxCode;

    /**
     * lbx箱子数量
     */
    private Integer boxQuantity;

    /**
     * 货物状态 1.待签收 2.待配送 3.完成配送    4.部分签收 5 部分配送 6.配送退回
     */
    private Byte shipmentStatus;

    /**
     * 大篮子编号
     */
    private Long bigBasketCode;

    /**
     * 交接单编号
     */
    private Long handoverCode;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private Long updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除(1删除、2未删除)
     */
    private Byte deleted;

    /**
     * 签收箱数
     */
    private Integer signBoxs;
}
