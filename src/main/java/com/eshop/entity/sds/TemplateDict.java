package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模板-数据字典
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("template_dict")
public class TemplateDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 1.shopee模版详情 2.shopee背景词 3.shopee爆款词 4.shopee背景属性 5.tk模版详情 6.tk背景词 7.tk爆款词
     */
    private Byte type;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建者
     */
    private Long createId;

    /**
     * 更新者
     */
    private Long updateId;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
