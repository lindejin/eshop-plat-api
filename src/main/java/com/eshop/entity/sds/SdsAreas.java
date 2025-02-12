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
 * sds地址基础数据
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("sds_areas")
public class SdsAreas implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sds-地址id
     */
    private Long areaId;

    /**
     * 地址名称
     */
    private String name;

    /**
     * 上级id
     */
    private Long parentId;

    /**
     * 省份code 或 城市code
     */
    private String areaCode;

    /**
     * 是否还有子级（0没有 1有）
     */
    private String children;

    /**
     * 同步时间
     */
    private Date synTime;
}
