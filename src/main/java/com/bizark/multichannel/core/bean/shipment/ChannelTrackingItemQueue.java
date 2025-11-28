// 声明这个类所在的包（文件夹路径）
package com.bizark.multichannel.core.bean.shipment;

// 导入需要的工具类
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 渠道跟踪商品项队列实体类
 * 这个类主要用于：
 * 1. 表示订单中的一个具体商品项（订单行）信息
 * 2. 作为XML序列化/反序列化的对象（用于与第三方平台数据交互）
 * 功能：存储每个商品项的详细信息，包括SKU、发货数量等
 */
@XStreamAlias("OrderItemReturn") // XML序列化时的节点名称
public class ChannelTrackingItemQueue {

    // === 关联标识字段 ===
    private Long QUEUE_ID; // 外键，关联到主订单表的ID（ChannelTrackingOrderQueue.ID）
    private String CHANNEL_ID; // 渠道标识
    private String ORDER_NUM; // 订单编号
    private String TRACKING_NO; // 物流单号（关联到包裹的物流单号）

    // === 商品核心信息 ===
    @XStreamAlias("linenum") // XML节点：订单行号
    private String LINE_NO; // 订单中的行号（如：1, 2, 3），标识这是订单中的第几个商品

    @XStreamAlias("seller_sku") // XML节点：卖家SKU
    private String SKU; // 商品的唯一标识码（库存单位），这是最重要的商品标识

    @XStreamAlias("shiped_quantity") // XML节点：已发货数量
    private BigDecimal QUANTITY; // 本次发货的数量（使用BigDecimal避免精度问题）

    // === 特殊标识信息 ===
    @XStreamAlias("transparency_codes") // XML节点：透明码/溯源码
    private String TRANSPARENCY_CODES; // 用于商品溯源的透明码（如：药品溯源码、奢侈品防伪码等）

    // === 系统时间戳字段 ===
    private Date LAST_UPDATED_STAMP; // 最后更新时间
    private Date LAST_UPDATED_TX_STAMP; // 最后事务时间
    private Date CREATED_STAMP; // 创建时间
    private Date CREATED_TX_STAMP; // 创建事务时间

    // === 关联数据字段 ===
    private List<ChannelTrackingPackageQueue> packageQueueList; // 关联的包裹列表

    // === Getter和Setter方法 ===

    public List<ChannelTrackingPackageQueue> getPackageQueueList() {
        return packageQueueList;
    }

    public ChannelTrackingItemQueue setPackageQueueList(List<ChannelTrackingPackageQueue> packageQueueList) {
        this.packageQueueList = packageQueueList;
        return this;
    }

    public Long getQUEUE_ID() {
        return QUEUE_ID;
    }

    public ChannelTrackingItemQueue setQUEUE_ID(Long QUEUE_ID) {
        this.QUEUE_ID = QUEUE_ID; // 设置关联的主订单ID
        return this; // 支持链式调用
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public ChannelTrackingItemQueue setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
        return this;
    }

    public String getORDER_NUM() {
        return ORDER_NUM;
    }

    public ChannelTrackingItemQueue setORDER_NUM(String ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
        return this;
    }

    public String getTRACKING_NO() {
        return TRACKING_NO;
    }

    public ChannelTrackingItemQueue setTRACKING_NO(String TRACKING_NO) {
        this.TRACKING_NO = TRACKING_NO; // 设置关联的物流单号
        return this;
    }

    // 订单行号的getter/setter
    public String getLINE_NO() {
        return LINE_NO;
    }

    public ChannelTrackingItemQueue setLINE_NO(String LINE_NO) {
        this.LINE_NO = LINE_NO; // 设置订单行号
        return this;
    }

    // 商品SKU的getter/setter - 这是最重要的字段
    public String getSKU() {
        return SKU;
    }

    public ChannelTrackingItemQueue setSKU(String SKU) {
        this.SKU = SKU; // 设置商品SKU
        return this;
    }

    // 发货数量的getter/setter
    public BigDecimal getQUANTITY() {
        return QUANTITY;
    }

    public ChannelTrackingItemQueue setQUANTITY(BigDecimal QUANTITY) {
        this.QUANTITY = QUANTITY; // 设置发货数量（使用BigDecimal保证精度）
        return this;
    }

    public Date getLAST_UPDATED_STAMP() {
        return LAST_UPDATED_STAMP;
    }

    public ChannelTrackingItemQueue setLAST_UPDATED_STAMP(Date LAST_UPDATED_STAMP) {
        this.LAST_UPDATED_STAMP = LAST_UPDATED_STAMP;
        return this;
    }

    public Date getLAST_UPDATED_TX_STAMP() {
        return LAST_UPDATED_TX_STAMP;
    }

    public ChannelTrackingItemQueue setLAST_UPDATED_TX_STAMP(Date LAST_UPDATED_TX_STAMP) {
        this.LAST_UPDATED_TX_STAMP = LAST_UPDATED_TX_STAMP;
        return this;
    }

    public Date getCREATED_STAMP() {
        return CREATED_STAMP;
    }

    public ChannelTrackingItemQueue setCREATED_STAMP(Date CREATED_STAMP) {
        this.CREATED_STAMP = CREATED_STAMP;
        return this;
    }

    public Date getCREATED_TX_STAMP() {
        return CREATED_TX_STAMP;
    }

    public ChannelTrackingItemQueue setCREATED_TX_STAMP(Date CREATED_TX_STAMP) {
        this.CREATED_TX_STAMP = CREATED_TX_STAMP;
        return this;
    }

    // 透明码/溯源码的getter/setter
    public String getTRANSPARENCY_CODES() {
        return TRANSPARENCY_CODES;
    }

    public ChannelTrackingItemQueue setTRANSPARENCY_CODES(String TRANSPARENCY_CODES) {
        this.TRANSPARENCY_CODES = TRANSPARENCY_CODES; // 设置商品溯源码
        return this;
    }

    /**
     * 重写toString方法，用于日志打印和调试
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
                .append(TRACKING_NO).append('\"');
        sb.append(",\"LINE_NO\":\"")
                .append(LINE_NO).append('\"'); // 订单行号
        sb.append(",\"SKU\":\"")
                .append(SKU).append('\"'); // 商品SKU - 关键信息
        sb.append(",\"QUANTITY\":")
                .append(QUANTITY); // 发货数量
        sb.append(",\"TRANSPARENCY_CODES\":\"")
                .append(TRANSPARENCY_CODES).append('\"'); // 透明码
        sb.append(",\"LAST_UPDATED_STAMP\":\"")
                .append(LAST_UPDATED_STAMP).append('\"');
        sb.append(",\"LAST_UPDATED_TX_STAMP\":\"")
                .append(LAST_UPDATED_TX_STAMP).append('\"');
        sb.append(",\"CREATED_STAMP\":\"")
                .append(CREATED_STAMP).append('\"');
        sb.append(",\"CREATED_TX_STAMP\":\"")
                .append(CREATED_TX_STAMP).append('\"');
        sb.append(",\"packageQueueList\":")
                .append(packageQueueList); // 关联的包裹列表
        sb.append('}');
        return sb.toString();
    }
}