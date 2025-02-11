package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 包裹运费相关日志
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_parcel_freight_log")
public class TbParcelFreightLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 包裹号
     */
    private Long parcelNo;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作人
     */
    private Integer operator;

    /**
     * 运行时间
     */
    private LocalDateTime operateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getParcelNo() {
        return parcelNo;
    }

    public void setParcelNo(Long parcelNo) {
        this.parcelNo = parcelNo;
    }

    public String getOperateProperty() {
        return operateProperty;
    }

    public void setOperateProperty(String operateProperty) {
        this.operateProperty = operateProperty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "TbParcelFreightLog{" +
        ", id = " + id +
        ", parcelNo = " + parcelNo +
        ", operateProperty = " + operateProperty +
        ", description = " + description +
        ", operator = " + operator +
        ", operateTime = " + operateTime +
        "}";
    }
}
