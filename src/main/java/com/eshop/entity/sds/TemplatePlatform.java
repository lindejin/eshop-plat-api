package com.eshop.entity.sds;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模版表
 * </p>
 *
 * @author sds
 * @since 2025-02-11
 */
@Getter
@Setter
@ToString
@TableName("template_platform")
public class TemplatePlatform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 平台编码
     */
    private String platformCode;

    /**
     * 类目id
     */
    private String catePubId;

    /**
     * 主库类目
     */
    private Integer tbCategoryId;

    /**
     * 供应链商品id
     */
    private Integer scmProductId;

    /**
     * 背景ids(a,b,c)
     */
    private String backgroupIds;

    /**
     * 素材分类ids(a,b,c)
     */
    private String materialClassifyIds;

    /**
     * 样机ids(a,b,c)
     */
    private String prototypeIds;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 店铺商户id
     */
    private Integer shopMerchantId;

    /**
     * 1.铺货模版 2.精品模版 3.关键词模板 4.标题关键词 5.详情关键词模板 6.三点描述关键词模板 7.五点描述关键词模板 8.采集模板
     */
    private Byte type;

    /**
     * 变种比例
     */
    private Integer proportion;

    /**
     * 标题是否翻译 1.翻译 0.不翻译(默认)
     */
    private Byte titleTranslate;

    /**
     * 最大上刊数量
     */
    private Integer maxPrintCount;

    /**
     * 每天最大刊登量
     */
    private Integer dayMaxPublishNumber;

    /**
     * 每次刊登数量
     */
    private Integer perTimePublishNumber;

    /**
     * 是否支持定制（0:不支持,1:支持）
     */
    private String custom;

    /**
     * 定制图片
     */
    private Integer customImgId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已被删除(1: 是, 2: 否)
     */
    private Byte isDelete;

    /**
     * 创建者
     */
    private Integer createId;

    /**
     * 更新者
     */
    private Integer updateId;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
