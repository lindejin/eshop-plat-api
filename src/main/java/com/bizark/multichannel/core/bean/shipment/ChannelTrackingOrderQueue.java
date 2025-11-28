// 声明这个类所在的包（文件夹路径）
package com.bizark.multichannel.core.bean.shipment;

// 导入需要的工具类
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 渠道跟踪订单队列实体类
 * 这个类主要用于：
 * 1. 映射数据库中的渠道跟踪订单表（CHANNEL_TRACKING_ORDER_QUEUE）
 * 2. 作为XML序列化/反序列化的对象（用于与第三方平台数据交互）
 * 功能：存储从第三方平台同步过来的订单信息，特别是发货相关的跟踪信息
 */
@XStreamAlias("OrderHeaderReturn") // XML序列化时的根节点名称
@TableName("CHANNEL_TRACKING_ORDER_QUEUE") // 对应的数据库表名
public class ChannelTrackingOrderQueue {

    // === 数据库字段映射（核心业务字段）===

    @TableField("ID") // 标记这个字段对应数据库表中的ID列
    private Long ID; // 主键ID

    @XStreamAlias("channel") // XML中对应的节点名称为"channel"
    @TableField("CHANNEL_ID") // 数据库字段：渠道ID
    private String CHANNEL_ID; // 渠道标识（如：淘宝、京东等）

    @XStreamAlias("ordernum") // XML中对应的节点名称为"ordernum"
    @TableField("ORDER_NUM") // 数据库字段：订单编号
    private String ORDER_NUM; // 第三方平台的订单号

    @XStreamAlias("ship_warehouse") // XML节点：发货仓库
    @TableField("SHIP_WAREHOUSE") // 数据库字段：发货仓库
    private String SHIP_WAREHOUSE; // 订单发货的仓库编码或名称

    @XStreamAlias("warehouse_country_code") // XML节点：仓库国家代码
    @TableField("SHIP_FROM_COUNTRY") // 数据库字段：发货国家
    private String SHIP_FROM_COUNTRY; // 发货地国家代码

    @XStreamAlias("advanced") // XML节点：高级标识
    @TableField("ADVANCED") // 数据库字段：高级标识
    private Integer ADVANCED; // 可能是特殊订单标识（如：加急、VIP订单等）

    // === 非数据库字段（临时字段，用于数据处理）===

    @XStreamAlias("ship_date") // XML节点：发货日期字符串
    @TableField(exist = false) // 表示这个字段不在数据库表中
    private String SHIP_DATE_STR; // 发货日期的字符串格式（从XML解析用）

    @TableField(exist = false) // 不在数据库表中
    private Date SHIP_DATE; // 发货日期的Date对象格式（程序内部使用）

    // === 状态和时间戳字段 ===

    @TableField("STATUS") // 数据库字段：状态
    private Integer STATUS; // 订单状态（如：0-待处理，1-已发货，2-发货失败等）

    @TableField("LAST_UPDATED_STAMP") // 最后更新时间戳
    private Date LAST_UPDATED_STAMP; // 记录最后修改时间

    @TableField("LAST_UPDATED_TX_STAMP") // 最后事务时间戳
    private Date LAST_UPDATED_TX_STAMP; // 事务相关的时间戳

    @TableField("CREATED_STAMP") // 创建时间戳
    private Date CREATED_STAMP; // 记录创建时间

    @TableField("CREATED_TX_STAMP") // 创建事务时间戳
    private Date CREATED_TX_STAMP; // 创建时的事务时间戳

    @TableField("FEED_ID") // 数据库字段：数据馈送ID
    private String FEED_ID; // 可能用于标识数据同步批次或来源

    @TableField("MESSAGE") // 数据库字段：消息或错误信息
    private String MESSAGE; // 存储处理结果消息或错误信息

    @TableField("INVOICE_STATUS") // 数据库字段：发票状态
    private Integer INVOICE_STATUS; // 发票处理状态

    @TableField("RETRY_COUNT") // 数据库字段：重试次数
    private Integer RETRY_COUNT; // 操作失败后的重试次数统计

    // === 其他临时字段 ===

    @XStreamAlias("wms_receive_time") // XML节点：WMS接收时间
    @TableField(exist = false) // 不在数据库表中
    private String WMS_RECEIVE_TIME_STR; // WMS系统接收时间的字符串格式

    // === 关联数据字段（订单包含的包裹和商品信息）===

    @XStreamAlias("packages") // XML节点：包裹列表
    @TableField(exist = false) // 不在数据库表中，是关联数据
    private ChannelTrackingPackageQueue[] packages; // 订单对应的包裹数组（XML解析用）

    @TableField(exist = false) // 不在数据库表中
    private List<ChannelTrackingPackageQueue> packageQueueList; // 包裹列表（程序内部使用）

    @TableField(exist = false) // 不在数据库表中
    private List<ChannelTrackingItemQueue> itemQueueList; // 商品项列表

    // === Getter和Setter方法（每个字段的读写方法）===
    // 这些方法遵循JavaBean规范，用于读取和设置字段值

    public Long getID() {
        return ID;
    }

    // 额外的业务字段
    public List<String> shipWarehouses; // 可用的发货仓库列表

    public ChannelTrackingOrderQueue setID(Long ID) {
        this.ID = ID;
        return this; // 返回this支持链式调用，如obj.setA().setB()
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public ChannelTrackingOrderQueue setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
        return this;
    }

    // ... 中间省略了其他字段的getter/setter方法，结构类似 ...

    public String getWMS_RECEIVE_TIME_STR() {
        return WMS_RECEIVE_TIME_STR;
    }

    public void setWMS_RECEIVE_TIME_STR(String WMS_RECEIVE_TIME_STR) {
        this.WMS_RECEIVE_TIME_STR = WMS_RECEIVE_TIME_STR;
    }

    /**
     * 重写toString方法，用于日志打印和调试
     * 返回对象的JSON格式字符串表示
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{"); // 使用StringBuilder提高字符串拼接效率
        sb.append("\"ID\":")
                .append(ID);
        sb.append(",\"CHANNEL_ID\":\"")
                .append(CHANNEL_ID).append('\"');
        sb.append(",\"ORDER_NUM\":\"")
                .append(ORDER_NUM).append('\"');
        // ... 拼接其他重要字段 ...
        sb.append(",\"packages\":")
                .append(Arrays.toString(packages)); // 将包裹数组转为字符串
        sb.append('}');
        return sb.toString();
    }
}