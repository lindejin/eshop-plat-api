package com.eshop.entity.ai;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * ai sd局部修改基础信息表
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 */
@TableName("sd_compose")
public class SdCompose implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 原图URL
     */
    private String artworkMasterUrl;

    /**
     * 遮罩URL
     */
    private String maskDiagramUrl;

    /**
     * 背景Id
     */
    private Integer paramEmplateId;

    /**
     * 批量次数
     */
    private Byte batchSize;

    /**
     * 状态：1.待处理 2.已添加遮罩 3.已完成
     */
    private Integer status;

    /**
     * 创建者
     */
    private Integer createId;

    /**
     * 更新者
     */
    private Integer updateId;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 1.是 2.否
     */
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtworkMasterUrl() {
        return artworkMasterUrl;
    }

    public void setArtworkMasterUrl(String artworkMasterUrl) {
        this.artworkMasterUrl = artworkMasterUrl;
    }

    public String getMaskDiagramUrl() {
        return maskDiagramUrl;
    }

    public void setMaskDiagramUrl(String maskDiagramUrl) {
        this.maskDiagramUrl = maskDiagramUrl;
    }

    public Integer getParamEmplateId() {
        return paramEmplateId;
    }

    public void setParamEmplateId(Integer paramEmplateId) {
        this.paramEmplateId = paramEmplateId;
    }

    public Byte getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Byte batchSize) {
        this.batchSize = batchSize;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "SdCompose{" +
        ", id = " + id +
        ", artworkMasterUrl = " + artworkMasterUrl +
        ", maskDiagramUrl = " + maskDiagramUrl +
        ", paramEmplateId = " + paramEmplateId +
        ", batchSize = " + batchSize +
        ", status = " + status +
        ", createId = " + createId +
        ", updateId = " + updateId +
        ", createTime = " + createTime +
        ", updateTime = " + updateTime +
        ", isDelete = " + isDelete +
        "}";
    }
}
