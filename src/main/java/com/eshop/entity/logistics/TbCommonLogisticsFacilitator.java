package com.eshop.entity.logistics;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 共用_物流服务商
 * </p>
 *
 * @author logistics
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("tb_common_logistics_facilitator")
public class TbCommonLogisticsFacilitator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务商编码(唯一值)
     */
    private String facilitatorCode;

    /**
     * 服务商名
     */
    private String facilitatorName;

    /**
     * 是否允许导入自用,1:允许,2:不允许
     */
    private Byte facilitatorStatus;

    /**
     * api_地址
     */
    private String apiUrl;

    /**
     * 备注
     */
    private String remark;

    /**
     * 帮助文档地址
     */
    private String helpFileUrl;

    /**
     * 调用参数_空值
     */
    private String paramJson;

    /**
     * api接口版本
     */
    private String apiVersions;
}
