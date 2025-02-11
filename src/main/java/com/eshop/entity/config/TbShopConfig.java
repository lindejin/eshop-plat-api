package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 店铺配置表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_shop_config")
public class TbShopConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺_id
     */
    private Integer shopId;

    /**
     * ioss税号（欧盟税号）
     */
    private String iossNo;

    /**
     * vat税号
     */
    private String vatNum;

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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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
        return "TbShopConfig{" +
        ", id = " + id +
        ", shopId = " + shopId +
        ", iossNo = " + iossNo +
        ", vatNum = " + vatNum +
        ", language = " + language +
        ", depotId = " + depotId +
        ", isAutomaticHandle = " + isAutomaticHandle +
        "}";
    }
}
