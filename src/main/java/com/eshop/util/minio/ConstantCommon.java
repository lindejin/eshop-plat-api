package com.eshop.util.minio;

/**
 * @author ldj
 * 一些使用的公共参数
 */
public class ConstantCommon {
    /**
     * 标识符号
     */
    public final static String REGEX = "@@@";

    /** 虾皮平台Code */
    public final static String SHOPEE_PLATFORM_CODE = "Shopee";

    public final static String TIKTIK_PLATFORM_CODE = "TikTok";

    public final static String ALIEXPRESS_PLATFORM_CODE = "AliExpress";

    public final static String DHGATE_PLATFORM_CODE = "Dhgate";
    //Temu平台
    public final static String TEMU_PLATFORM_CODE = "Temu";
    // 通用子库
    public final static String COMMON_PLATFORM_CODE = "Common";

    /** 虾皮最大SKU数量 */
    public final static Integer SHOPEE_MAX_SKU_COUNT = 50;

    public final static Integer TK_MAX_SKU_COUNT = 50;

    /** 虾皮主库取值规则属性color */
    public final static String SHOPEE_SPACES_COLOR = "Color";
    /** 虾皮主库取值规则属性low_color */
    public final static String SHOPEE_SPACES_LOW_COLOR = "color";

    /** 虾皮主库取值规则属性size */
    public final static String SHOPEE_SPACES_SIZE = "Size";
    /** 虾皮主库取值规则属性low_size */
    public final static String SHOPEE_SPACES_LOW_SIZE = "size";

    /** 虾皮主库取值规则属性layer */
    public final static String SHOPEE_SPACES_LAYER = "Material";


    /** 虾皮主库取值规则属性layer */
    public final static String MATERIAL_SPACES_LAYER = "Material";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";


    /**
     * 速卖通默认的物流方式
     */
    public static final Long AE_DEFAULT_MODE_ID = 21988L;
    /**
     * 速卖通默认的物流方式
     */
    public static final Long TEMU_DEFAULT_MODE_ID = 19265L;

    /**
     * 关键词常量
     */
    public static final String MATERIAL_DESCRIPTION = "素材描述";
    public static final String BACKGROUND_DESCRIPTION ="背景描述";
    public static final String MODEL_DESCRIPTION = "模特描述";
    public static final String MATERIAL_TAGS = "素材标签";
    public static final String BACKGROUND_LABEL = "背景标签";
    public static final String MODEL_TAGS = "模特标签";


    public static final String SDS_DEPOT_NAME = "SDS仓库";


    public static final String REQUEST_ID_KEY = "lingtu:requests:";

    public static final String COLLECT_SOURCE_URL_KEY = "collect:source:url:";

    public static final Long COLLECT_SOURCE_URL_TIMEOUT = 60L;

    public static final String AI_MATERIAL_CLASSIFY_SUFFIX = "-AI";
}
