package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商户等级
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_merchant_level")
public class TbMerchantLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 等级名称
     */
    private String levelName;

    /**
     * 采购折扣比例
     */
    private Double purchaseDiscount;

    /**
     * 运费折扣比例
     */
    private Double freightDiscount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人	
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除人Id
     */
    private Integer deleteId;

    /**
     * 删除时间
     */
    private LocalDateTime deleteTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Double getPurchaseDiscount() {
        return purchaseDiscount;
    }

    public void setPurchaseDiscount(Double purchaseDiscount) {
        this.purchaseDiscount = purchaseDiscount;
    }

    public Double getFreightDiscount() {
        return freightDiscount;
    }

    public void setFreightDiscount(Double freightDiscount) {
        this.freightDiscount = freightDiscount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Override
    public String toString() {
        return "TbMerchantLevel{" +
        ", id = " + id +
        ", levelName = " + levelName +
        ", purchaseDiscount = " + purchaseDiscount +
        ", freightDiscount = " + freightDiscount +
        ", remark = " + remark +
        ", creatorId = " + creatorId +
        ", createTime = " + createTime +
        ", isDelete = " + isDelete +
        ", deleteId = " + deleteId +
        ", deleteTime = " + deleteTime +
        "}";
    }
}
