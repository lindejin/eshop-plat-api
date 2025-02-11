package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 采购单日志
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_purchases_log")
public class TbPurchasesLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购单号
     */
    private Long purchaseNo;

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
    private String operator;

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

    public Long getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(Long purchaseNo) {
        this.purchaseNo = purchaseNo;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
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
        return "TbPurchasesLog{" +
        ", id = " + id +
        ", purchaseNo = " + purchaseNo +
        ", operateProperty = " + operateProperty +
        ", description = " + description +
        ", operator = " + operator +
        ", operateTime = " + operateTime +
        "}";
    }
}
