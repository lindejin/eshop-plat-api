package com.bizark.multichannel.core.bean.shipment;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@XStreamAlias("OrderItemReturn")
public class ChannelTrackingItemQueue {
    private Long QUEUE_ID;

    private String CHANNEL_ID;

    private String ORDER_NUM;

    private String TRACKING_NO;
    @XStreamAlias("linenum")
    private String LINE_NO;
    @XStreamAlias("seller_sku")
    private String SKU;
    @XStreamAlias("shiped_quantity")
    private BigDecimal QUANTITY;
    @XStreamAlias("transparency_codes")
    private String TRANSPARENCY_CODES;

    private Date LAST_UPDATED_STAMP;

    private Date LAST_UPDATED_TX_STAMP;

    private Date CREATED_STAMP;

    private Date CREATED_TX_STAMP;

    private List<ChannelTrackingPackageQueue> packageQueueList;

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
        this.QUEUE_ID = QUEUE_ID;
        return this;
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
        this.TRACKING_NO = TRACKING_NO;
        return this;
    }

    public String getLINE_NO() {
        return LINE_NO;
    }

    public ChannelTrackingItemQueue setLINE_NO(String LINE_NO) {
        this.LINE_NO = LINE_NO;
        return this;
    }

    public String getSKU() {
        return SKU;
    }

    public ChannelTrackingItemQueue setSKU(String SKU) {
        this.SKU = SKU;
        return this;
    }

    public BigDecimal getQUANTITY() {
        return QUANTITY;
    }

    public ChannelTrackingItemQueue setQUANTITY(BigDecimal QUANTITY) {
        this.QUANTITY = QUANTITY;
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

    public String getTRANSPARENCY_CODES() {
        return TRANSPARENCY_CODES;
    }

    public ChannelTrackingItemQueue setTRANSPARENCY_CODES(String TRANSPARENCY_CODES) {
        this.TRANSPARENCY_CODES = TRANSPARENCY_CODES;
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
        sb.append(",\"LINE_NO\":\"")
                .append(LINE_NO).append('\"');
        sb.append(",\"SKU\":\"")
                .append(SKU).append('\"');
        sb.append(",\"QUANTITY\":")
                .append(QUANTITY);
        sb.append(",\"TRANSPARENCY_CODES\":\"")
                .append(TRANSPARENCY_CODES).append('\"');
        sb.append(",\"LAST_UPDATED_STAMP\":\"")
                .append(LAST_UPDATED_STAMP).append('\"');
        sb.append(",\"LAST_UPDATED_TX_STAMP\":\"")
                .append(LAST_UPDATED_TX_STAMP).append('\"');
        sb.append(",\"CREATED_STAMP\":\"")
                .append(CREATED_STAMP).append('\"');
        sb.append(",\"CREATED_TX_STAMP\":\"")
                .append(CREATED_TX_STAMP).append('\"');
        sb.append(",\"packageQueueList\":")
                .append(packageQueueList);
        sb.append('}');
        return sb.toString();
    }
}