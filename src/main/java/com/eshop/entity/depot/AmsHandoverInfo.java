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
 * 交接单表，用于ams lbx 交接单的相关信息
 * </p>
 *
 * @author depot
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("ams_handover_info")
public class AmsHandoverInfo implements Serializable {

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
     * 大篮子编号
     */
    private Long bigBasketCode;

    /**
     * 交接单编号
     */
    private Long handoverCode;

    /**
     * 拍照图片
     */
    private Long photoId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Long updater;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除(1删除、2未删除)
     */
    private Byte deleted;

    /**
     * 1.交接进行中 2.交接完成 3.图片上传完成
     */
    private Byte handoverStatus;
}
