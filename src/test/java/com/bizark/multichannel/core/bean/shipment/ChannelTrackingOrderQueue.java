package com.bizark.multichannel.core.bean.shipment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@XStreamAlias("OrderHeaderReturn")
@TableName("CHANNEL_TRACKING_ORDER_QUEUE")
public class ChannelTrackingOrderQueue {
    @TableField("ID")
    private Long ID;
    @XStreamAlias("channel")
    @TableField("CHANNEL_ID")
    private String CHANNEL_ID;
    @XStreamAlias("ordernum")
    @TableField("ORDER_NUM")
    private String ORDER_NUM;

    @XStreamAlias("ship_warehouse")
    @TableField("SHIP_WAREHOUSE")
    private String SHIP_WAREHOUSE;

    @XStreamAlias("warehouse_country_code")
    @TableField("SHIP_FROM_COUNTRY")
    private String SHIP_FROM_COUNTRY;

    @XStreamAlias("advanced")
    @TableField("ADVANCED")
    private Integer ADVANCED;

    @XStreamAlias("ship_date")
    @TableField(exist = false)
    private String SHIP_DATE_STR;
    @TableField(exist = false)
    private Date SHIP_DATE;
    @TableField("STATUS")
    private Integer STATUS;
    @TableField("LAST_UPDATED_STAMP")
    private Date LAST_UPDATED_STAMP;
    @TableField("LAST_UPDATED_TX_STAMP")
    private Date LAST_UPDATED_TX_STAMP;
    @TableField("CREATED_STAMP")
    private Date CREATED_STAMP;
    @TableField("CREATED_TX_STAMP")
    private Date CREATED_TX_STAMP;
    @TableField("FEED_ID")
    private String FEED_ID;
    @TableField("MESSAGE")
    private String MESSAGE;
    @TableField("INVOICE_STATUS")
    private Integer INVOICE_STATUS;

    @TableField("RETRY_COUNT")
    private Integer RETRY_COUNT;

    @XStreamAlias("wms_receive_time")
    @TableField(exist = false)
    private String WMS_RECEIVE_TIME_STR;

    @XStreamAlias("packages")
    @TableField(exist = false)
    private ChannelTrackingPackageQueue[] packages;
    @TableField(exist = false)
    private List<ChannelTrackingPackageQueue> packageQueueList;
    @TableField(exist = false)
    private List<ChannelTrackingItemQueue> itemQueueList;

    public Long getID() {
        return ID;
    }

    public List<String> shipWarehouses;

    public ChannelTrackingOrderQueue setID(Long ID) {
        this.ID = ID;
        return this;
    }

    public String getCHANNEL_ID() {
        return CHANNEL_ID;
    }

    public ChannelTrackingOrderQueue setCHANNEL_ID(String CHANNEL_ID) {
        this.CHANNEL_ID = CHANNEL_ID;
        return this;
    }

    public String getORDER_NUM() {
        return ORDER_NUM;
    }

    public ChannelTrackingOrderQueue setORDER_NUM(String ORDER_NUM) {
        this.ORDER_NUM = ORDER_NUM;
        return this;
    }

    public String getSHIP_WAREHOUSE() {
        return SHIP_WAREHOUSE;
    }

    public ChannelTrackingOrderQueue setSHIP_WAREHOUSE(String SHIP_WAREHOUSE) {
        this.SHIP_WAREHOUSE = SHIP_WAREHOUSE;
        return this;
    }

    public String getSHIP_FROM_COUNTRY() {
        return SHIP_FROM_COUNTRY;
    }

    public ChannelTrackingOrderQueue setSHIP_FROM_COUNTRY(String SHIP_FROM_COUNTRY) {
        this.SHIP_FROM_COUNTRY = SHIP_FROM_COUNTRY;
        return this;
    }

    public Integer getADVANCED() {
        return ADVANCED;
    }

    public ChannelTrackingOrderQueue setADVANCED(Integer ADVANCED) {
        this.ADVANCED = ADVANCED;
        return this;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public ChannelTrackingOrderQueue setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
        return this;
    }

    public Date getLAST_UPDATED_STAMP() {
        return LAST_UPDATED_STAMP;
    }

    public ChannelTrackingOrderQueue setLAST_UPDATED_STAMP(Date LAST_UPDATED_STAMP) {
        this.LAST_UPDATED_STAMP = LAST_UPDATED_STAMP;
        return this;
    }

    public Date getLAST_UPDATED_TX_STAMP() {
        return LAST_UPDATED_TX_STAMP;
    }

    public ChannelTrackingOrderQueue setLAST_UPDATED_TX_STAMP(Date LAST_UPDATED_TX_STAMP) {
        this.LAST_UPDATED_TX_STAMP = LAST_UPDATED_TX_STAMP;
        return this;
    }

    public Date getCREATED_STAMP() {
        return CREATED_STAMP;
    }

    public ChannelTrackingOrderQueue setCREATED_STAMP(Date CREATED_STAMP) {
        this.CREATED_STAMP = CREATED_STAMP;
        return this;
    }

    public Date getCREATED_TX_STAMP() {
        return CREATED_TX_STAMP;
    }

    public ChannelTrackingOrderQueue setCREATED_TX_STAMP(Date CREATED_TX_STAMP) {
        this.CREATED_TX_STAMP = CREATED_TX_STAMP;
        return this;
    }

    public String getFEED_ID() {
        return FEED_ID;
    }

    public ChannelTrackingOrderQueue setFEED_ID(String FEED_ID) {
        this.FEED_ID = FEED_ID;
        return this;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public ChannelTrackingOrderQueue setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
        return this;
    }

    public Integer getINVOICE_STATUS() {
        return INVOICE_STATUS;
    }

    public ChannelTrackingOrderQueue setINVOICE_STATUS(Integer INVOICE_STATUS) {
        this.INVOICE_STATUS = INVOICE_STATUS;
        return this;
    }

    public Integer getRETRY_COUNT() {
        return RETRY_COUNT;
    }

    public void setRETRY_COUNT(Integer RETRY_COUNT) {
        this.RETRY_COUNT = RETRY_COUNT;
    }

    public ChannelTrackingPackageQueue[] getPackages() {
        return packages;
    }

    public ChannelTrackingOrderQueue setPackages(ChannelTrackingPackageQueue[] packages) {
        this.packages = packages;
        return this;
    }

    public Date getSHIP_DATE() {
        return SHIP_DATE;
    }

    public ChannelTrackingOrderQueue setSHIP_DATE(Date SHIP_DATE) {
        this.SHIP_DATE = SHIP_DATE;
        return this;
    }

    public String getSHIP_DATE_STR() {
        return SHIP_DATE_STR;
    }

    public ChannelTrackingOrderQueue setSHIP_DATE_STR(String SHIP_DATE_STR) {
        this.SHIP_DATE_STR = SHIP_DATE_STR;
        return this;
    }

    public List<ChannelTrackingPackageQueue> getPackageQueueList() {
        return packageQueueList;
    }

    public ChannelTrackingOrderQueue setPackageQueueList(List<ChannelTrackingPackageQueue> packageQueueList) {
        this.packageQueueList = packageQueueList;
        return this;
    }

    public List<ChannelTrackingItemQueue> getItemQueueList() {
        return itemQueueList;
    }

    public ChannelTrackingOrderQueue setItemQueueList(List<ChannelTrackingItemQueue> itemQueueList) {
        this.itemQueueList = itemQueueList;
        return this;
    }

    public List<String> getShipWarehouses() {
        return shipWarehouses;
    }

    public void setShipWarehouses(List<String> shipWarehouses) {
        this.shipWarehouses = shipWarehouses;
    }

    public String getWMS_RECEIVE_TIME_STR() {
        return WMS_RECEIVE_TIME_STR;
    }

    public void setWMS_RECEIVE_TIME_STR(String WMS_RECEIVE_TIME_STR) {
        this.WMS_RECEIVE_TIME_STR = WMS_RECEIVE_TIME_STR;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"ID\":")
                .append(ID);
        sb.append(",\"CHANNEL_ID\":\"")
                .append(CHANNEL_ID).append('\"');
        sb.append(",\"ORDER_NUM\":\"")
                .append(ORDER_NUM).append('\"');
        sb.append(",\"SHIP_WAREHOUSE\":\"")
                .append(SHIP_WAREHOUSE).append('\"');
        sb.append(",\"STATUS\":\"")
                .append(STATUS).append('\"');
        sb.append(",\"LAST_UPDATED_STAMP\":\"")
                .append(LAST_UPDATED_STAMP).append('\"');
        sb.append(",\"LAST_UPDATED_TX_STAMP\":\"")
                .append(LAST_UPDATED_TX_STAMP).append('\"');
        sb.append(",\"CREATED_STAMP\":\"")
                .append(CREATED_STAMP).append('\"');
        sb.append(",\"CREATED_TX_STAMP\":\"")
                .append(CREATED_TX_STAMP).append('\"');
        sb.append(",\"FEED_ID\":\"")
                .append(FEED_ID).append('\"');
        sb.append(",\"MESSAGE\":\"")
                .append(MESSAGE).append('\"');
        sb.append(",\"INVOICE_STATUS\":\"")
                .append(INVOICE_STATUS).append('\"');
        sb.append(",\"RETRY_COUNT\":\"")
                .append(RETRY_COUNT).append('\"');
        sb.append(",\"ADVANCED\":\"")
                .append(ADVANCED).append('\"');
        sb.append(",\"SHIP_FROM_COUNTRY\":\"")
                .append(SHIP_FROM_COUNTRY).append('\"');
        sb.append(",\"packages\":")
                .append(Arrays.toString(packages));
        sb.append('}');
        return sb.toString();
    }
}