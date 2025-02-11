package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 汇率记录
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_exchange_rate_record")
public class TbExchangeRateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货币类型
     */
    private String currencyType;

    /**
     * 同步日期(yyyy-MM-dd)
     */
    private LocalDateTime syncDate;

    /**
     * 执行汇率(7位小数)
     */
    private BigDecimal executeExchangeRate;

    /**
     * 实际汇率(7位小数)
     */
    private BigDecimal actualExchangeRate;

    /**
     * 汇率类型(1: 真实汇率, 2:折扣汇率, 3: 固定汇率)
     */
    private Byte exchangeRateType;

    /**
     * 折扣率(如果是折扣汇率_已小数方式存储)
     */
    private Double discountRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public LocalDateTime getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(LocalDateTime syncDate) {
        this.syncDate = syncDate;
    }

    public BigDecimal getExecuteExchangeRate() {
        return executeExchangeRate;
    }

    public void setExecuteExchangeRate(BigDecimal executeExchangeRate) {
        this.executeExchangeRate = executeExchangeRate;
    }

    public BigDecimal getActualExchangeRate() {
        return actualExchangeRate;
    }

    public void setActualExchangeRate(BigDecimal actualExchangeRate) {
        this.actualExchangeRate = actualExchangeRate;
    }

    public Byte getExchangeRateType() {
        return exchangeRateType;
    }

    public void setExchangeRateType(Byte exchangeRateType) {
        this.exchangeRateType = exchangeRateType;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "TbExchangeRateRecord{" +
        ", id = " + id +
        ", currencyType = " + currencyType +
        ", syncDate = " + syncDate +
        ", executeExchangeRate = " + executeExchangeRate +
        ", actualExchangeRate = " + actualExchangeRate +
        ", exchangeRateType = " + exchangeRateType +
        ", discountRate = " + discountRate +
        "}";
    }
}
