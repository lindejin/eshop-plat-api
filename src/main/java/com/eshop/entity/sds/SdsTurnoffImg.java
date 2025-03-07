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
 * sds-成品图片信息
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("sds_turnoff_img")
public class SdsTurnoffImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 成品编码
     */
    private String skuCode;

    /**
     * 成品iD
     */
    private Long turnoffId;

    /**
     * 文件类型1:成品图片
     */
    private Byte imgType;

    /**
     * 文件库ID
     */
    private String path;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
