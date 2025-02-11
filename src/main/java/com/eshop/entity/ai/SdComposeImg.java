package com.eshop.entity.ai;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * ai  sd局部修改生成图片信息表
 * </p>
 *
 * @author ai
 * @since 2025-02-11
 */
@TableName("sd_compose_img")
public class SdComposeImg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 合成图片信息ID
     */
    private Integer composeId;

    /**
     * 合成图URL
     */
    private String imgUrl;

    /**
     * 缩略图URL
     */
    private String thumbnailImgUrl;

    /**
     * 高品质图URL
     */
    private String highQualityImgUrl;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComposeId() {
        return composeId;
    }

    public void setComposeId(Integer composeId) {
        this.composeId = composeId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getThumbnailImgUrl() {
        return thumbnailImgUrl;
    }

    public void setThumbnailImgUrl(String thumbnailImgUrl) {
        this.thumbnailImgUrl = thumbnailImgUrl;
    }

    public String getHighQualityImgUrl() {
        return highQualityImgUrl;
    }

    public void setHighQualityImgUrl(String highQualityImgUrl) {
        this.highQualityImgUrl = highQualityImgUrl;
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

    @Override
    public String toString() {
        return "SdComposeImg{" +
        ", id = " + id +
        ", composeId = " + composeId +
        ", imgUrl = " + imgUrl +
        ", thumbnailImgUrl = " + thumbnailImgUrl +
        ", highQualityImgUrl = " + highQualityImgUrl +
        ", createId = " + createId +
        ", updateId = " + updateId +
        ", createTime = " + createTime +
        ", updateTime = " + updateTime +
        "}";
    }
}
