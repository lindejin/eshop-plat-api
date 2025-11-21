package com.eshop;

public class DefaultQimenCloudClient {

    private String url;
    private String appkey;
    private String appSecret;
    private String format;

    public DefaultQimenCloudClient(String url, String appkey, String appSecret, String format) {
        this.url = url;
        this.appkey = appkey;
        this.appSecret = appSecret;
        this.format = format;
    }

    public QimenCloudResponse execute(QimenCloudRequest request) {
        return null;
    }
}
