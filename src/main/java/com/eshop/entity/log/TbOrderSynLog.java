package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单（订单号为单位）异常运行日志
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_order_syn_log")
public class TbOrderSynLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号(一对多)
     */
    private String orderNo;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 店长/负责人_id
     */
    private Integer shopownerId;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 描述
     */
    private String description;

    /**
     * 异常
     */
    private String exceptionLog;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopownerId() {
        return shopownerId;
    }

    public void setShopownerId(Integer shopownerId) {
        this.shopownerId = shopownerId;
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

    public String getExceptionLog() {
        return exceptionLog;
    }

    public void setExceptionLog(String exceptionLog) {
        this.exceptionLog = exceptionLog;
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
        return "TbOrderSynLog{" +
        ", id = " + id +
        ", orderNo = " + orderNo +
        ", shopId = " + shopId +
        ", shopownerId = " + shopownerId +
        ", operateProperty = " + operateProperty +
        ", description = " + description +
        ", exceptionLog = " + exceptionLog +
        ", operator = " + operator +
        ", operateTime = " + operateTime +
        "}";
    }
}
