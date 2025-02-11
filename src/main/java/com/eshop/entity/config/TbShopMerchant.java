package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 平台商户信息表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_shop_merchant")
public class TbShopMerchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户Id
     */
    private Integer merchantId;

    /**
     * 主账号Id
     */
    private Integer mainAccountId;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 商户名称
     */
    private String name;

    /**
     * 授权状态,1:成功 2失败,-1:未授权
     */
    private Byte tokenFlag;

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
     * 平台商户Id
     */
    private String platformShopMerchantId;

    /**
     * 平台应用_id
     */
    private Integer appId;

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

    public Integer getMainAccountId() {
        return mainAccountId;
    }

    public void setMainAccountId(Integer mainAccountId) {
        this.mainAccountId = mainAccountId;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getTokenFlag() {
        return tokenFlag;
    }

    public void setTokenFlag(Byte tokenFlag) {
        this.tokenFlag = tokenFlag;
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

    public String getPlatformShopMerchantId() {
        return platformShopMerchantId;
    }

    public void setPlatformShopMerchantId(String platformShopMerchantId) {
        this.platformShopMerchantId = platformShopMerchantId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "TbShopMerchant{" +
        ", id = " + id +
        ", merchantId = " + merchantId +
        ", mainAccountId = " + mainAccountId +
        ", platformCode = " + platformCode +
        ", name = " + name +
        ", tokenFlag = " + tokenFlag +
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
        ", platformShopMerchantId = " + platformShopMerchantId +
        ", appId = " + appId +
        "}";
    }
}
