package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author ren_chun_hui
 * @since 2025-02-11
 */
@TableName("tb_menufunc")
public class TbMenufunc implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 父目录编号
     */
    private Integer parentid;

    /**
     * 一级目录编号
     */
    private Integer homeid;

    /**
     * 目录名称
     */
    private String menuName;

    /**
     * 目录名称
     */
    private String menuKey;

    /**
     * 父目录名称
     */
    private String parentMenuName;

    /**
     * 父目录名称
     */
    private String parentMenuKey;

    /**
     * 访问连接
     */
    private String pageUrl;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 菜单级别
1级
2级
3级
     */
    private Byte level;

    /**
     * 是否可以作为登陆首页:
1、可以
2、不可以
     */
    private Byte loginPage;

    /**
     * 图标
     */
    private String ico;

    /**
     * 状态：
1、启用
2、停用
     */
    private Byte status;

    /**
     * 是否是特殊流程：
     */
    private Byte type;

    /**
     * 类型：1、单品；2、单品单量；3、单品多量；4、多品
     */
    private Byte taskType;

    /**
     * 展示类型 1.超管类型(默认) 2.商户管理员
     */
    private Byte showType;

    /**
     * 菜单展示类型:1.菜单页面权限 2.按钮操作权限
     */
    private Byte permissionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public String getParentMenuKey() {
        return parentMenuKey;
    }

    public void setParentMenuKey(String parentMenuKey) {
        this.parentMenuKey = parentMenuKey;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(Byte loginPage) {
        this.loginPage = loginPage;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getTaskType() {
        return taskType;
    }

    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }

    public Byte getShowType() {
        return showType;
    }

    public void setShowType(Byte showType) {
        this.showType = showType;
    }

    public Byte getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Byte permissionType) {
        this.permissionType = permissionType;
    }

    @Override
    public String toString() {
        return "TbMenufunc{" +
        ", id = " + id +
        ", parentid = " + parentid +
        ", homeid = " + homeid +
        ", menuName = " + menuName +
        ", menuKey = " + menuKey +
        ", parentMenuName = " + parentMenuName +
        ", parentMenuKey = " + parentMenuKey +
        ", pageUrl = " + pageUrl +
        ", sort = " + sort +
        ", level = " + level +
        ", loginPage = " + loginPage +
        ", ico = " + ico +
        ", status = " + status +
        ", type = " + type +
        ", taskType = " + taskType +
        ", showType = " + showType +
        ", permissionType = " + permissionType +
        "}";
    }
}
