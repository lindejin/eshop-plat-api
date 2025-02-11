package com.eshop.entity.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_log")
public class TbLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业编号
     */
    private Integer companyId;

    /**
     * 类型:用户登录日志:1,订单:11,采购:12,商品:13,模板:14,主商品:15,平台商品:16,
     */
    private Byte type;

    /**
     * 业务Id
     */
    private Integer sourceId;

    /**
     * 日志格式以json格式保存，并压缩:{"description":"描述","operId":"操作员","timeCreated":"2021-04-01 06:36:28","type":11}
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime timeCreated;

    /**
     * 创建时间Unix格式
     */
    private Integer timeCreatedUnix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Integer getTimeCreatedUnix() {
        return timeCreatedUnix;
    }

    public void setTimeCreatedUnix(Integer timeCreatedUnix) {
        this.timeCreatedUnix = timeCreatedUnix;
    }

    @Override
    public String toString() {
        return "TbLog{" +
        ", id = " + id +
        ", companyId = " + companyId +
        ", type = " + type +
        ", sourceId = " + sourceId +
        ", content = " + content +
        ", timeCreated = " + timeCreated +
        ", timeCreatedUnix = " + timeCreatedUnix +
        "}";
    }
}
