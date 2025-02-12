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
 * TK全球商品发布信息
 * </p>
 *
 * @author sds
 * @since 2025-02-12
 */
@Getter
@Setter
@ToString
@TableName("tk_global_product_publish")
public class TkGlobalProductPublish implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * TK主商品Id
     */
    private Long tkProductId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品编码
     */
    private String spuCode;

    /**
     * 商品发布id
     */
    private String productPublishId;

    /**
     * 发布区域(GB:英国,ID:印度尼西亚,MY:马来西亚,TH:泰国,PH:菲律宾,VN:越南,SG:新加坡,US:美国)
     */
    private String region;

    /**
     * TK平台店铺Id
     */
    private String tkShopId;

    /**
     * 用于错误跟踪的 API 请求的标识符
     */
    private String requestId;

    /**
     * 错误信息
     */
    private String printErrMsg;

    /**
     * 发布状态(1:未发布,2:发布成功,3:发布失败)
     */
    private Byte publishStatus;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 发布人
     */
    private Long publishId;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * ERP 店铺Id
     */
    private Long shopId;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 平台产品id
     */
    private Long platformProductId;
}
