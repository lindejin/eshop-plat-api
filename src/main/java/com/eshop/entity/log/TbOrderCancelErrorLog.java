package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 取消订单操作错误日志
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_order_cancel_error_log")
public class TbOrderCancelErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 错误原因
     */
    private String errLog;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * TK同意或者拒绝使用此ID
     */
    private String reverseOrderId;

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

    public String getErrLog() {
        return errLog;
    }

    public void setErrLog(String errLog) {
        this.errLog = errLog;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getReverseOrderId() {
        return reverseOrderId;
    }

    public void setReverseOrderId(String reverseOrderId) {
        this.reverseOrderId = reverseOrderId;
    }

    @Override
    public String toString() {
        return "TbOrderCancelErrorLog{" +
        ", id = " + id +
        ", orderNo = " + orderNo +
        ", errLog = " + errLog +
        ", isDelete = " + isDelete +
        ", deleteTime = " + deleteTime +
        ", reverseOrderId = " + reverseOrderId +
        "}";
    }
}
