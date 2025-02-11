package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件下载失败记录
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_download_file_error")
public class TbDownloadFileError implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关联编码
     */
    private String joinCode;

    /**
     * 关联类型(1: 主商品主图, 2: 主商品附图, 3: sku图片)
     */
    private Byte joinType;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 存储路径(绝对路径)
     */
    private String storagePath;

    /**
     * 下载失败次数
     */
    private Integer gamesLost;

    /**
     * 失败时间(上一次)
     */
    private LocalDateTime loseTime;

    /**
     * 是否已下载(1: 是, 2: 否)
     */
    private Byte isDownload;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoinCode() {
        return joinCode;
    }

    public void setJoinCode(String joinCode) {
        this.joinCode = joinCode;
    }

    public Byte getJoinType() {
        return joinType;
    }

    public void setJoinType(Byte joinType) {
        this.joinType = joinType;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public Integer getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(Integer gamesLost) {
        this.gamesLost = gamesLost;
    }

    public LocalDateTime getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(LocalDateTime loseTime) {
        this.loseTime = loseTime;
    }

    public Byte getIsDownload() {
        return isDownload;
    }

    public void setIsDownload(Byte isDownload) {
        this.isDownload = isDownload;
    }

    @Override
    public String toString() {
        return "TbDownloadFileError{" +
        ", id = " + id +
        ", joinCode = " + joinCode +
        ", joinType = " + joinType +
        ", downloadUrl = " + downloadUrl +
        ", storagePath = " + storagePath +
        ", gamesLost = " + gamesLost +
        ", loseTime = " + loseTime +
        ", isDownload = " + isDownload +
        "}";
    }
}
