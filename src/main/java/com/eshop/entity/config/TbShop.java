package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 店铺表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_shop")
public class TbShop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户_id
     */
    private Integer merchantId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 平台店铺id
     */
    private String platformShopId;

    /**
     * 店铺商户ID
     */
    private Integer shopMerchantId;

    /**
     * 店铺类型(1: 跨境店, 2: 本土店3.跨境子店铺)
     */
    private Byte shopType;

    /**
     * 平台应用_id
     */
    private Integer appId;

    /**
     * 店铺类型(1.普通/半托管 2.全托管)
     */
    private Byte platformShopType;

    /**
     * 店铺所属国家(本土店国家必选)
     */
    private Integer countryId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 状态: 1:开启,2,停用
     */
    private Byte status;

    /**
     * 授权状态,1:成功 2失败,0:未授权
     */
    private Byte tokenFlag;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 密码(AES加密  CBC模式)
     */
    private String password;

    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;

    /**
     * 调用参数_静态_空值
     */
    private String paramStaticJson;

    /**
     * 调用参数_动态_空值
     */
    private String paramDynamicJson;

    /**
     * 创建人
     */
    private Integer createOperId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateOperId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除字段(1: 删除, 2: 未删除)
     */
    private Byte isDelete;

    /**
     * 删除人
     */
    private Long deleteUserId;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    /**
     * 货币类型
     */
    private String currencyType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getPlatformShopId() {
        return platformShopId;
    }

    public void setPlatformShopId(String platformShopId) {
        this.platformShopId = platformShopId;
    }

    public Integer getShopMerchantId() {
        return shopMerchantId;
    }

    public void setShopMerchantId(Integer shopMerchantId) {
        this.shopMerchantId = shopMerchantId;
    }

    public Byte getShopType() {
        return shopType;
    }

    public void setShopType(Byte shopType) {
        this.shopType = shopType;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Byte getPlatformShopType() {
        return platformShopType;
    }

    public void setPlatformShopType(Byte platformShopType) {
        this.platformShopType = platformShopType;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getTokenFlag() {
        return tokenFlag;
    }

    public void setTokenFlag(Byte tokenFlag) {
        this.tokenFlag = tokenFlag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(LocalDateTime expiresTime) {
        this.expiresTime = expiresTime;
    }

    public String getParamStaticJson() {
        return paramStaticJson;
    }

    public void setParamStaticJson(String paramStaticJson) {
        this.paramStaticJson = paramStaticJson;
    }

    public String getParamDynamicJson() {
        return paramDynamicJson;
    }

    public void setParamDynamicJson(String paramDynamicJson) {
        this.paramDynamicJson = paramDynamicJson;
    }

    public Integer getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Integer createOperId) {
        this.createOperId = createOperId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Integer updateOperId) {
        this.updateOperId = updateOperId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Long getDeleteUserId() {
        return deleteUserId;
    }

    public void setDeleteUserId(Long deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "TbShop{" +
        ", id = " + id +
        ", merchantId = " + merchantId +
        ", platformCode = " + platformCode +
        ", platformShopId = " + platformShopId +
        ", shopMerchantId = " + shopMerchantId +
        ", shopType = " + shopType +
        ", appId = " + appId +
        ", platformShopType = " + platformShopType +
        ", countryId = " + countryId +
        ", name = " + name +
        ", status = " + status +
        ", tokenFlag = " + tokenFlag +
        ", userName = " + userName +
        ", password = " + password +
        ", expiresTime = " + expiresTime +
        ", paramStaticJson = " + paramStaticJson +
        ", paramDynamicJson = " + paramDynamicJson +
        ", createOperId = " + createOperId +
        ", createTime = " + createTime +
        ", updateOperId = " + updateOperId +
        ", updateTime = " + updateTime +
        ", isDelete = " + isDelete +
        ", deleteUserId = " + deleteUserId +
        ", deleteTime = " + deleteTime +
        ", currencyType = " + currencyType +
        "}";
    }
}
