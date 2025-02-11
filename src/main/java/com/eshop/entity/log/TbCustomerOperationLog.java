package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 客户操作日志表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_customer_operation_log")
public class TbCustomerOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户信息表id
     */
    private Integer customerInfoId;

    /**
     * 平台客户id
     */
    private String platformCustomerId;

    /**
     * 运行属性/运行描述
     */
    private String operationProperty;

    /**
     * 描述
     */
    private String operationDetail;

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

    public Integer getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(Integer customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public String getPlatformCustomerId() {
        return platformCustomerId;
    }

    public void setPlatformCustomerId(String platformCustomerId) {
        this.platformCustomerId = platformCustomerId;
    }

    public String getOperationProperty() {
        return operationProperty;
    }

    public void setOperationProperty(String operationProperty) {
        this.operationProperty = operationProperty;
    }

    public String getOperationDetail() {
        return operationDetail;
    }

    public void setOperationDetail(String operationDetail) {
        this.operationDetail = operationDetail;
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
        return "TbCustomerOperationLog{" +
        ", id = " + id +
        ", customerInfoId = " + customerInfoId +
        ", platformCustomerId = " + platformCustomerId +
        ", operationProperty = " + operationProperty +
        ", operationDetail = " + operationDetail +
        ", operator = " + operator +
        ", operateTime = " + operateTime +
        "}";
    }
}
