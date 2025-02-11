package com.eshop.entity.ai;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * sd 背景属性值
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 */
@TableName("sd_bg_attr_val")
public class SdBgAttrVal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 属性id
     */
    private Integer attrId;

    /**
     * 属性中文名称
     */
    private String attrValZh;

    /**
     * 属性英文名称
     */
    private String attrValEn;

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

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrValZh() {
        return attrValZh;
    }

    public void setAttrValZh(String attrValZh) {
        this.attrValZh = attrValZh;
    }

    public String getAttrValEn() {
        return attrValEn;
    }

    public void setAttrValEn(String attrValEn) {
        this.attrValEn = attrValEn;
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
        return "SdBgAttrVal{" +
        ", id = " + id +
        ", attrId = " + attrId +
        ", attrValZh = " + attrValZh +
        ", attrValEn = " + attrValEn +
        ", createId = " + createId +
        ", updateId = " + updateId +
        ", createTime = " + createTime +
        ", updateTime = " + updateTime +
        ", isDelete = " + isDelete +
        "}";
    }
}
