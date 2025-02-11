package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 汇率
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_exchange_rate")
public class TbExchangeRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货币类型
     */
    private String currencyType;

    /**
     * 货币名称
     */
    private String currencyName;

    /**
     * 汇率类型(1: 真实汇率, 2:折扣汇率, 3: 固定汇率)
     */
    private Byte exchangeRateType;

    /**
     * 折扣率(如果是折扣汇率_已小数方式存储)
     */
    private Double discountRate;

    /**
     * 创建人id
     */
    private Integer createrId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Integer lastUpdateId;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 货币符号
     */
    private String currencySymbol;

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

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(Integer lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @Override
    public String toString() {
        return "TbExchangeRate{" +
        ", id = " + id +
        ", currencyType = " + currencyType +
        ", currencyName = " + currencyName +
        ", exchangeRateType = " + exchangeRateType +
        ", discountRate = " + discountRate +
        ", createrId = " + createrId +
        ", createTime = " + createTime +
        ", lastUpdateId = " + lastUpdateId +
        ", lastUpdateTime = " + lastUpdateTime +
        ", currencySymbol = " + currencySymbol +
        "}";
    }
}
