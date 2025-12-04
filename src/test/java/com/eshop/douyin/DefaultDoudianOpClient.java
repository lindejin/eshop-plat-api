//package com.eshop.douyin;
//
//import com.eshop.util.platform.api.client.douyin.util.SignUtil;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.Future;
//
//public class DefaultDoudianOpClient implements DoudianOpClient {
//    private static final Logger LOG = Logger.getLogger(DefaultDoudianOpClient.class);
//
//    private static final DefaultDoudianOpClient DEFAULT_DOUDIAN_OP_CLIENT = new DefaultDoudianOpClient();
//
//    private HttpClient httpClient = DefaultHttpClient.getDefaultClient();
//
//    public <T, R> DoudianOpResponseWrapper<T> request(DoudianOpRequest<R> request, AccessToken accessToken) {
//        return doRequest(request, accessToken);
//    }
//
//    private <T, R> DoudianOpResponseWrapper<T> doRequest(DoudianOpRequest<R> request, AccessToken accessToken) {
//        String appKey = request.getConfig().getAppKey();
//        String appSecret = request.getConfig().getAppSecret();
//        String paramJson = JsonUtil.toJson(request.getParam());
//        String requestUrlPath = getRequestUrlPath(request.getUrlPath());
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        String requestUrlPattern = "%s/%s?app_key=%s&method=%s&v=2&sign=%s&timestamp=%s&access_token=%s";
//        String method = requestUrlPath.replaceAll("/", ".");
//        String sign = SignUtil.sign(appKey, appSecret, method, timestamp, paramJson, "2");
//        String accessTokenStr = "";
//        if (accessToken != null)
//            accessTokenStr = accessToken.getAccessToken();
//        if (request.getConfig().getFieldCheck())
//            ParameterChecker.check(request.getParam());
//        String requestUrl = null;
//        requestUrl = String.format(requestUrlPattern, new Object[] { request.getConfig().getOpenRequestUrl(), requestUrlPath, appKey, method, sign, timestamp, accessTokenStr });
//        HttpRequest httpRequest = HttpRequest.build(requestUrl, paramJson);
//        LOG.info("http request url: %s, body: %s", new Object[] { requestUrl, paramJson });
//        String logId = LogUtils.getLogId();
//        if (logId != null)
//            httpRequest.addHeader("x-tt-logid", logId);
//        httpRequest.addHeader("from", "sdk");
//        httpRequest.addHeader("sdk-version", "doudian-sdk-java-1.1.0");
//        httpRequest.addHeader("sdk-type", "java");
//        httpRequest.addHeader("x-open-no-old-err-code", "1");
//        if (request.isPerf())
//            httpRequest.addHeader("X-Perf-Env", "dop_isv_mock");
//        if (request.getConfig().getHttpClientConnectTimeout() != null)
//            httpRequest.setConnectTimeout(request.getConfig().getHttpClientConnectTimeout().intValue());
//        if (request.getConfig().getHttpClientReadTimeout() != null)
//            httpRequest.setReadTimeout(request.getConfig().getHttpClientReadTimeout().intValue());
//        if (request.getConfig().getHttpRequestHeader() != null && request.getConfig().getHttpRequestHeader().size() > 0)
//            httpRequest.addHeader(request.getConfig().getHttpRequestHeader());
//        HttpResponse httpResponse = this.httpClient.post(httpRequest);
//        if (httpResponse.getStatusCode() != 200)
//            throw new DoudianOpException(DoudianOpException.Code.HTTP_RESPONSE_STATUS_CODE_NOT_2XX);
//        String httpBody = httpResponse.getBody();
//        LOG.info("http response: %s", new Object[] { httpBody });
//        if (httpBody == null || "".equals(httpBody))
//            httpBody = "{}";
//        try {
//            DoudianOpResponse<?> response = (DoudianOpResponse)JsonUtil.fromJson(httpBody, request.getResponseClass());
//            response.setOriginResponse(httpBody);
//            DoudianOpResponseWrapper<T> responseWrapper = new DoudianOpResponseWrapper<>();
//            responseWrapper.setResponse((T)response);
//            responseWrapper.setHttpRequest(httpRequest);
//            responseWrapper.setHttpResponse(httpResponse);
//            return responseWrapper;
//        } catch (Exception e) {
//            throw new DoudianOpException(DoudianOpException.Code.JSON_ERROR, e);
//        }
//    }
//
//    public <T, R> Future<DoudianOpResponseWrapper<T>> asyncRequest(final DoudianOpRequest<R> request, final AccessToken accessToken) {
//        return DoudianOpThreadPool.getInstance(request.getConfig()).submit(new Callable<DoudianOpResponseWrapper<T>>() {
//            public DoudianOpResponseWrapper<T> call() throws Exception {
//                return DefaultDoudianOpClient.this.request(request, accessToken);
//            }
//        });
//    }
//
//    private String getRequestUrlPath(String originUrl) {
//        if (originUrl == null || originUrl.length() == 0)
//            return originUrl;
//        if (originUrl.startsWith("/"))
//            return originUrl.substring(1);
//        return originUrl;
//    }
//
//    public static DefaultDoudianOpClient getDefaultClient() {
//        return DEFAULT_DOUDIAN_OP_CLIENT;
//    }
//
//    public void setHttpClient(HttpClient httpClient) {
//        this.httpClient = httpClient;
//    }
//}
