package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商铺授权日志
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_shop_merchant_auth_log")
public class TbShopMerchantAuthLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 店铺商铺id
     */
    private Integer shopMerchantId;

    /**
     * 运行属性/运行描述
     */
    private String operateProperty;

    /**
     * 返回信息
     */
    private String description;

    /**
     * 操作人Id
     */
    private Integer operatorId;

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

    public Integer getShopMerchantId() {
        return shopMerchantId;
    }

    public void setShopMerchantId(Integer shopMerchantId) {
        this.shopMerchantId = shopMerchantId;
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "TbShopMerchantAuthLog{" +
        ", id = " + id +
        ", shopMerchantId = " + shopMerchantId +
        ", operateProperty = " + operateProperty +
        ", description = " + description +
        ", operatorId = " + operatorId +
        ", operateTime = " + operateTime +
        "}";
    }
}
