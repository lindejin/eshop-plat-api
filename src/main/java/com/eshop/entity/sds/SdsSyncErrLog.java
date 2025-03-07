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
 * sds数据同步异常日志	
 * </p>
 *
 * @author sds
 * @since 2025-03-07
 */
@Getter
@Setter
@ToString
@TableName("sds_sync_err_log")
public class SdsSyncErrLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 1.sds基础数据 2.sds成品数据
     */
    private Long type;

    /**
     * 分类名称
     */
    private String errMsg;

    /**
     * 创建时间
     */
    private Date createTime;
}
