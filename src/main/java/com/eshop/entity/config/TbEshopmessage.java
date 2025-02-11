package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 平台内部消息
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_eshopmessage")
public class TbEshopmessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String name;

    /**
     * 模块
     */
    private String module;

    /**
     * 内容
     */
    private String detail;

    /**
     * 有效期
     */
    private LocalDateTime expiryTime;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     * 是否开启,1:开启, 2:关闭
     */
    private Byte flag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人Id
     */
    private Integer createOperId;

    /**
     * 是否置顶,1:置顶,2:不置顶
     */
    private Byte top;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Integer createOperId) {
        this.createOperId = createOperId;
    }

    public Byte getTop() {
        return top;
    }

    public void setTop(Byte top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "TbEshopmessage{" +
        ", id = " + id +
        ", name = " + name +
        ", module = " + module +
        ", detail = " + detail +
        ", expiryTime = " + expiryTime +
        ", roleId = " + roleId +
        ", flag = " + flag +
        ", createTime = " + createTime +
        ", createOperId = " + createOperId +
        ", top = " + top +
        "}";
    }
}
