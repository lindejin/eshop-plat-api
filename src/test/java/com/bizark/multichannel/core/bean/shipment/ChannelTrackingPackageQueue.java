package com.bizark.multichannel.core.bean.shipment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@XStreamAlias("OrderPackageReturn")
public class ChannelTrackingPackageQueue {
    private Long ID;

    private Long QUEUE_ID;

    private String CHANNEL_ID;

    private String ORDER_NUM;
    @XStreamAlias("tracking_no")
    private String TRACKING_NO;
    @XStreamAlias("carrier")
    private String CARRIER;
    @XStreamAlias("carrier_service")
    private String SHIPPING_METHOD;
    @XStreamAlias("carrier_url")
    private String CARRIER_URL;

    @XStreamAlias("ship_date")
    private String SHIP_DATE_STR;


    @XStreamAlias("is_master")
    private Integer IS_MASTER;

    private Date SHIP_DATE;
    @XStreamAlias("shipping_cost")
    private BigDecimal ESTIMATE_SHIPPING_COST;

    private BigDecimal ACTUAL_SHIPPING_COST;

    @XStreamAlias("package_length")
    private BigDecimal PACKAGE_LENGTH;

    @XStreamAlias("package_width")
    private BigDecimal PACKAGE_WIDTH;

    @XStreamAlias("package_height")
    private BigDecimal PACKAGE_HEIGHT;

    @XStreamAlias("package_weight")
    private BigDecimal PACKAGE_WEIGHT;

    @XStreamAlias("ship_warehouse")
    private String SHIP_WAREHOUSE;

    private String CURRENCY;

    @XStreamAlias("wms_receive_time")
    private String WMS_RECEIVE_DATE_STR;

    private Date WMS_RECEIVE_DATE;

    private Date LAST_UPDATED_STAMP;

    private Date LAST_UPDATED_TX_STAMP;

    private Date CREATED_STAMP;

    private Date CREATED_TX_STAMP;

    @XStreamAlias("items")
    private ChannelTrackingItemQueue[] items;

    private List<ChannelTrackingItemQueue> itemQueueList;

    public Long getQUEUE_ID() {
        return QUEUE_ID;
    }

    public ChannelTrackingPackageQueue setQUEUE_ID(Long QUEUE_ID) {
        this.QUEUE_ID = QUEUE_ID;
        return this;
    }

    public Integer getIS_MASTER() {
        return IS_MASTER;
    }

    public void setIS_MASTER(Integer IS_MASTER) {
        this.IS_MASTER = IS_MASTER;
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

    public String getTRACKING_NO() {
        return TRACKING_NO;
    }

    public ChannelTrackingPackageQueue setTRACKING_NO(String TRACKING_NO) {
        this.TRACKING_NO = TRACKING_NO;
        return this;
    }

    public String getCARRIER() {
        return CARRIER;
    }

    public ChannelTrackingPackageQueue setCARRIER(String CARRIER) {
        this.CARRIER = CARRIER;
        return this;
    }

    public String getSHIPPING_METHOD() {
        return SHIPPING_METHOD;
    }

    public ChannelTrackingPackageQueue setSHIPPING_METHOD(String SHIPPING_METHOD) {
        this.SHIPPING_METHOD = SHIPPING_METHOD;
        return this;
    }

    public String getCARRIER_URL() {
        return CARRIER_URL;
    }

    public ChannelTrackingPackageQueue setCARRIER_URL(String CARRIER_URL) {
        this.CARRIER_URL = CARRIER_URL;
        return this;
    }

    public Date getSHIP_DATE() {
        return SHIP_DATE;
    }

    public ChannelTrackingPackageQueue setSHIP_DATE(Date SHIP_DATE) {
        this.SHIP_DATE = SHIP_DATE;
        return this;
    }

    public BigDecimal getESTIMATE_SHIPPING_COST() {
        return ESTIMATE_SHIPPING_COST;
    }

    public ChannelTrackingPackageQueue setESTIMATE_SHIPPING_COST(BigDecimal ESTIMATE_SHIPPING_COST) {
        this.ESTIMATE_SHIPPING_COST = ESTIMATE_SHIPPING_COST;
        return this;
    }

    public BigDecimal getACTUAL_SHIPPING_COST() {
        return ACTUAL_SHIPPING_COST;
    }

    public ChannelTrackingPackageQueue setACTUAL_SHIPPING_COST(BigDecimal ACTUAL_SHIPPING_COST) {
        this.ACTUAL_SHIPPING_COST = ACTUAL_SHIPPING_COST;
        return this;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public ChannelTrackingPackageQueue setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
        return this;
    }

    public String getWMS_RECEIVE_DATE_STR() {
        return WMS_RECEIVE_DATE_STR;
    }

    public ChannelTrackingPackageQueue setWMS_RECEIVE_DATE_STR(String WMS_RECEIVE_DATE_STR) {
        this.WMS_RECEIVE_DATE_STR = WMS_RECEIVE_DATE_STR;
        return this;
    }

    public Date getWMS_RECEIVE_DATE() {
        return WMS_RECEIVE_DATE;
    }

    public ChannelTrackingPackageQueue setWMS_RECEIVE_DATE(Date WMS_RECEIVE_DATE) {
        this.WMS_RECEIVE_DATE = WMS_RECEIVE_DATE;
        return this;
    }

    public Date getLAST_UPDATED_STAMP() {
        return LAST_UPDATED_STAMP;
    }

    public ChannelTrackingPackageQueue setLAST_UPDATED_STAMP(Date LAST_UPDATED_STAMP) {
        this.LAST_UPDATED_STAMP = LAST_UPDATED_STAMP;
        return this;
    }

    public Date getLAST_UPDATED_TX_STAMP() {
        return LAST_UPDATED_TX_STAMP;
    }

    public ChannelTrackingPackageQueue setLAST_UPDATED_TX_STAMP(Date LAST_UPDATED_TX_STAMP) {
        this.LAST_UPDATED_TX_STAMP = LAST_UPDATED_TX_STAMP;
        return this;
    }

    public Date getCREATED_STAMP() {
        return CREATED_STAMP;
    }

    public ChannelTrackingPackageQueue setCREATED_STAMP(Date CREATED_STAMP) {
        this.CREATED_STAMP = CREATED_STAMP;
        return this;
    }

    public Date getCREATED_TX_STAMP() {
        return CREATED_TX_STAMP;
    }

    public ChannelTrackingPackageQueue setCREATED_TX_STAMP(Date CREATED_TX_STAMP) {
        this.CREATED_TX_STAMP = CREATED_TX_STAMP;
        return this;
    }

    public ChannelTrackingItemQueue[] getItems() {
        return items;
    }

    public ChannelTrackingPackageQueue setItems(ChannelTrackingItemQueue[] items) {
        this.items = items;
        return this;
    }

    public String getSHIP_DATE_STR() {
        return SHIP_DATE_STR;
    }

    public ChannelTrackingPackageQueue setSHIP_DATE_STR(String SHIP_DATE_STR) {
        this.SHIP_DATE_STR = SHIP_DATE_STR;
        return this;
    }

    public List<ChannelTrackingItemQueue> getItemQueueList() {
        return itemQueueList;
    }

    public ChannelTrackingPackageQueue setItemQueueList(List<ChannelTrackingItemQueue> itemQueueList) {
        this.itemQueueList = itemQueueList;
        return this;
    }

    public BigDecimal getPACKAGE_LENGTH() {
        return PACKAGE_LENGTH;
    }

    public ChannelTrackingPackageQueue setPACKAGE_LENGTH(BigDecimal PACKAGE_LENGTH) {
        this.PACKAGE_LENGTH = PACKAGE_LENGTH;
        return this;
    }

    public BigDecimal getPACKAGE_WIDTH() {
        return PACKAGE_WIDTH;
    }

    public ChannelTrackingPackageQueue setPACKAGE_WIDTH(BigDecimal PACKAGE_WIDTH) {
        this.PACKAGE_WIDTH = PACKAGE_WIDTH;
        return this;
    }

    public BigDecimal getPACKAGE_HEIGHT() {
        return PACKAGE_HEIGHT;
    }

    public ChannelTrackingPackageQueue setPACKAGE_HEIGHT(BigDecimal PACKAGE_HEIGHT) {
        this.PACKAGE_HEIGHT = PACKAGE_HEIGHT;
        return this;
    }

    public BigDecimal getPACKAGE_WEIGHT() {
        return PACKAGE_WEIGHT;
    }

    public ChannelTrackingPackageQueue setPACKAGE_WEIGHT(BigDecimal PACKAGE_WEIGHT) {
        this.PACKAGE_WEIGHT = PACKAGE_WEIGHT;
        return this;
    }

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
        sb.append(",\"CARRIER\":\"")
                .append(CARRIER).append('\"');
        sb.append(",\"SHIPPING_METHOD\":\"")
                .append(SHIPPING_METHOD).append('\"');
        sb.append(",\"CARRIER_URL\":\"")
                .append(CARRIER_URL).append('\"');
        sb.append(",\"SHIP_DATE_STR\":\"")
                .append(SHIP_DATE_STR).append('\"');
        sb.append(",\"SHIP_DATE\":\"")
                .append(SHIP_DATE).append('\"');
        sb.append(",\"ESTIMATE_SHIPPING_COST\":")
                .append(ESTIMATE_SHIPPING_COST);
        sb.append(",\"ACTUAL_SHIPPING_COST\":")
                .append(ACTUAL_SHIPPING_COST);
        sb.append(",\"PACKAGE_LENGTH\":")
                .append(PACKAGE_LENGTH);
        sb.append(",\"PACKAGE_WIDTH\":")
                .append(PACKAGE_WIDTH);
        sb.append(",\"PACKAGE_HEIGHT\":")
                .append(PACKAGE_HEIGHT);
        sb.append(",\"PACKAGE_WEIGHT\":")
                .append(PACKAGE_WEIGHT);
        sb.append(",\"SHIP_WAREHOUSE\":\"")
                .append(CURRENCY).append('\"');
        sb.append(",\"SHIP_WAREHOUSE\":\"")
                .append(CURRENCY).append('\"');
        sb.append(",\"LAST_UPDATED_STAMP\":\"")
                .append(LAST_UPDATED_STAMP).append('\"');
        sb.append(",\"LAST_UPDATED_TX_STAMP\":\"")
                .append(LAST_UPDATED_TX_STAMP).append('\"');
        sb.append(",\"CREATED_STAMP\":\"")
                .append(CREATED_STAMP).append('\"');
        sb.append(",\"CREATED_TX_STAMP\":\"")
                .append(CREATED_TX_STAMP).append('\"');
        sb.append(",\"items\":")
                .append(Arrays.toString(items));
        sb.append(",\"itemQueueList\":")
                .append(itemQueueList);
        sb.append('}');
        return sb.toString();
    }
}