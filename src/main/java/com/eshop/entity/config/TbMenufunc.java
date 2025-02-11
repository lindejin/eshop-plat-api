package com.eshop.entity.config;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author config
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
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
}
