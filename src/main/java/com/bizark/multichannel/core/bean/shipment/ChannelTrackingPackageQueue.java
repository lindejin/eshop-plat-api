// 声明这个类所在的包（文件夹路径）
package com.bizark.multichannel.core.bean.shipment;

// 导入需要的工具类
import com.baomidou.mybatisplus.annotation.TableField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 渠道跟踪包裹队列实体类
 * 这个类主要用于：
 * 1. 表示订单中的一个具体包裹信息
 * 2. 作为XML序列化/反序列化的对象（用于与第三方平台数据交互）
 * 功能：存储每个包裹的物流详细信息，一个订单可能对应多个包裹
 */
@XStreamAlias("OrderPackageReturn") // XML序列化时的节点名称
public class ChannelTrackingPackageQueue {

    // === 标识字段 ===
    private Long ID; // 主键ID
    private Long QUEUE_ID; // 外键，关联到主订单表的ID（ChannelTrackingOrderQueue.ID）

    // === 基础信息字段 ===
    private String CHANNEL_ID; // 渠道标识
    private String ORDER_NUM; // 订单编号

    // === 物流核心信息（最重要的字段）===
    @XStreamAlias("tracking_no") // XML节点：物流跟踪号
    private String TRACKING_NO; // 物流单号（如：顺丰123456789）

    @XStreamAlias("carrier") // XML节点：物流承运商
    private String CARRIER; // 物流公司（如：SF-顺丰，ZT-中通）

    @XStreamAlias("carrier_service") // XML节点：物流服务
    private String SHIPPING_METHOD; // 物流方式（如：标准快递、次日达）

    @XStreamAlias("carrier_url") // XML节点：物流公司官网
    private String CARRIER_URL; // 物流公司查询网址

    // === 时间相关字段 ===
    @XStreamAlias("ship_date") // XML节点：发货日期字符串
    private String SHIP_DATE_STR; // 发货时间的字符串格式
    private Date SHIP_DATE; // 发货时间的Date对象格式

    // === 包裹属性字段 ===
    @XStreamAlias("is_master") // XML节点：是否主包裹
    private Integer IS_MASTER; // 标识是否为主包裹（1-是，0-否），一个订单可能有多个包裹

    // === 费用相关字段 ===
    @XStreamAlias("shipping_cost") // XML节点：预估运费
    private BigDecimal ESTIMATE_SHIPPING_COST; // 预估运费金额
    private BigDecimal ACTUAL_SHIPPING_COST; // 实际运费金额

    // === 包裹尺寸重量信息 ===
    @XStreamAlias("package_length") // XML节点：包裹长度
    private BigDecimal PACKAGE_LENGTH; // 包裹长度（单位：厘米）

    @XStreamAlias("package_width") // XML节点：包裹宽度
    private BigDecimal PACKAGE_WIDTH; // 包裹宽度（单位：厘米）

    @XStreamAlias("package_height") // XML节点：包裹高度
    private BigDecimal PACKAGE_HEIGHT; // 包裹高度（单位：厘米）

    @XStreamAlias("package_weight") // XML节点：包裹重量
    private BigDecimal PACKAGE_WEIGHT; // 包裹重量（单位：千克）

    // === 仓库和货币信息 ===
    @XStreamAlias("ship_warehouse") // XML节点：发货仓库
    private String SHIP_WAREHOUSE; // 发货仓库编码
    private String CURRENCY; // 运费币种（如：CNY-人民币，USD-美元）

    // === WMS系统相关字段 ===
    @XStreamAlias("wms_receive_time") // XML节点：WMS接收时间
    private String WMS_RECEIVE_DATE_STR; // WMS接收时间的字符串格式
    private Date WMS_RECEIVE_DATE; // WMS接收时间的Date对象格式

    // === 系统时间戳字段 ===
    private Date LAST_UPDATED_STAMP; // 最后更新时间
    private Date LAST_UPDATED_TX_STAMP; // 最后事务时间
    private Date CREATED_STAMP; // 创建时间
    private Date CREATED_TX_STAMP; // 创建事务时间

    // === 关联数据字段（包裹包含的商品信息）===
    @XStreamAlias("items") // XML节点：商品项数组
    private ChannelTrackingItemQueue[] items; // 包裹中包含的商品数组（XML解析用）

    private List<ChannelTrackingItemQueue> itemQueueList; // 商品项列表（程序内部使用）

    // === Getter和Setter方法 ===

    public Long getQUEUE_ID() {
        return QUEUE_ID;
    }

    public ChannelTrackingPackageQueue setQUEUE_ID(Long QUEUE_ID) {
        this.QUEUE_ID = QUEUE_ID; // 设置关联的主订单ID
        return this; // 支持链式调用
    }

    public Integer getIS_MASTER() {
        return IS_MASTER;
    }

    public void setIS_MASTER(Integer IS_MASTER) {
        this.IS_MASTER = IS_MASTER; // 设置是否为主包裹
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public ChannelTrackingPackageQueue setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
        return this;
    }

    public String getORDER_NUM() {
        return ORDER_NUM;
    }

    public ChannelTrackingPackageQueue setORDER_NUM(String ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
        return this;
    }

    // 物流单号的getter/setter - 这是最重要的字段之一
    public String getTRACKING_NO() {
        return TRACKING_NO;
    }

    public ChannelTrackingPackageQueue setTRACKING_NO(String TRACKING_NO) {
        this.TRACKING_NO = TRACKING_NO;
        return this;
    }

    // 物流公司的getter/setter
    public String getCARRIER() {
        return CARRIER;
    }

    public ChannelTrackingPackageQueue setCARRIER(String CARRIER) {
        this.CARRIER = CARRIER;
        return this;
    }

    // 物流方式的getter/setter
    public String getSHIPPING_METHOD() {
        return SHIPPING_METHOD;
    }

    public ChannelTrackingPackageQueue setSHIPPING_METHOD(String SHIPPING_METHOD) {
        this.SHIPPING_METHOD = SHIPPING_METHOD;
        return this;
    }

    // 物流公司网址的getter/setter
    public String getCARRIER_URL() {
        return CARRIER_URL;
    }

    public ChannelTrackingPackageQueue setCARRIER_URL(String CARRIER_URL) {
        this.CARRIER_URL = CARRIER_URL;
        return this;
    }

    // ... 中间省略其他字段的getter/setter方法，结构类似 ...

    public Long getID() {
        return ID;
    }

    public ChannelTrackingPackageQueue setID(Long ID) {
        this.ID = ID;
        return this;
    }

    public String getSHIP_WAREHOUSE() {
        return SHIP_WAREHOUSE;
    }

    public ChannelTrackingPackageQueue setSHIP_WAREHOUSE(String SHIP_WAREHOUSE) {
        this.SHIP_WAREHOUSE = SHIP_WAREHOUSE;
        return this;
    }

    /**
     * 重写toString方法，用于日志打印和调试
     * 注意：这个方法中有个小错误，SHIP_WAREHOUSE被重复输出了两次
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"QUEUE_ID\":")
                .append(QUEUE_ID);
        sb.append(",\"CHANNEL_ID\":\"")
                .append(CHANNEL_ID).append('\"');
        sb.append(",\"ORDER_NUM\":\"")
                .append(ORDER_NUM).append('\"');
        sb.append(",\"TRACKING_NO\":\"")
                .append(TRACKING_NO).append('\"'); // 物流单号 - 关键信息
        sb.append(",\"CARRIER\":\"")
                .append(CARRIER).append('\"'); // 物流公司
        sb.append(",\"SHIPPING_METHOD\":\"")
                .append(SHIPPING_METHOD).append('\"'); // 物流方式
        sb.append(",\"CARRIER_URL\":\"")
                .append(CARRIER_URL).append('\"');
        sb.append(",\"SHIP_DATE_STR\":\"")
                .append(SHIP_DATE_STR).append('\"');
        sb.append(",\"SHIP_DATE\":\"")
                .append(SHIP_DATE).append('\"');
        sb.append(",\"ESTIMATE_SHIPPING_COST\":")
                .append(ESTIMATE_SHIPPING_COST); // 预估运费
        sb.append(",\"ACTUAL_SHIPPING_COST\":")
                .append(ACTUAL_SHIPPING_COST); // 实际运费
        sb.append(",\"PACKAGE_LENGTH\":")
                .append(PACKAGE_LENGTH); // 包裹长度
        sb.append(",\"PACKAGE_WIDTH\":")
                .append(PACKAGE_WIDTH); // 包裹宽度
        sb.append(",\"PACKAGE_HEIGHT\":")
                .append(PACKAGE_HEIGHT); // 包裹高度
        sb.append(",\"PACKAGE_WEIGHT\":")
                .append(PACKAGE_WEIGHT); // 包裹重量
        // 注意：这里有个bug，SHIP_WAREHOUSE被错误地输出为CURRENCY两次
        sb.append(",\"SHIP_WAREHOUSE\":\"")
                .append(CURRENCY).append('\"'); // 这行应该是SHIP_WAREHOUSE
        sb.append(",\"SHIP_WAREHOUSE\":\"")
                .append(CURRENCY).append('\"'); // 这行重复了而且有错误
        sb.append(",\"LAST_UPDATED_STAMP\":\"")
                .append(LAST_UPDATED_STAMP).append('\"');
        sb.append(",\"LAST_UPDATED_TX_STAMP\":\"")
                .append(LAST_UPDATED_TX_STAMP).append('\"');
        sb.append(",\"CREATED_STAMP\":\"")
                .append(CREATED_STAMP).append('\"');
        sb.append(",\"CREATED_TX_STAMP\":\"")
                .append(CREATED_TX_STAMP).append('\"');
        sb.append(",\"items\":")
                .append(Arrays.toString(items)); // 包裹中的商品列表
        sb.append(",\"itemQueueList\":")
                .append(itemQueueList);
        sb.append('}');
        return sb.toString();
    }
}