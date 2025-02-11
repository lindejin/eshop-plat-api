package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 店铺商户配置表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_shop_merchant_config")
public class TbShopMerchantConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺商户_id
     */
    private Integer shopMerchantId;

    /**
     * ioss税号（欧盟税号）
     */
    private String iossNo;

    /**
     * vat税号
     */
    private String vatNum;

    /**
     * 每天最大刊登量
     */
    private Integer dayMaxPublishNumber;

    /**
     * 语言
     */
    private String language;

    /**
     * 发货仓库
     */
    private Integer depotId;

    /**
     * 是否自动审核订单(1: 是, 2: 否)
     */
    private Byte isAutomaticHandle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopMerchantId() {
        return shopMerchantId;
    }

    public void setShopMerchantId(Integer shopMerchantId) {
        this.shopMerchantId = shopMerchantId;
    }

    public String getIossNo() {
        return iossNo;
    }

    public void setIossNo(String iossNo) {
        this.iossNo = iossNo;
    }

    public String getVatNum() {
        return vatNum;
    }

    public void setVatNum(String vatNum) {
        this.vatNum = vatNum;
    }

    public Integer getDayMaxPublishNumber() {
        return dayMaxPublishNumber;
    }

    public void setDayMaxPublishNumber(Integer dayMaxPublishNumber) {
        this.dayMaxPublishNumber = dayMaxPublishNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public Byte getIsAutomaticHandle() {
        return isAutomaticHandle;
    }

    public void setIsAutomaticHandle(Byte isAutomaticHandle) {
        this.isAutomaticHandle = isAutomaticHandle;
    }

    @Override
    public String toString() {
        return "TbShopMerchantConfig{" +
        ", id = " + id +
        ", shopMerchantId = " + shopMerchantId +
        ", iossNo = " + iossNo +
        ", vatNum = " + vatNum +
        ", dayMaxPublishNumber = " + dayMaxPublishNumber +
        ", language = " + language +
        ", depotId = " + depotId +
        ", isAutomaticHandle = " + isAutomaticHandle +
        "}";
    }
}
