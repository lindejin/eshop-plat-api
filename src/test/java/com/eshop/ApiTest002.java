//package com.eshop;
//
//import cn.hutool.core.lang.hash.Hash;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ApiTest002 {
//
//
//    //初始方法
//    public void Setup() {
//        String appkey = "";//奇门的appkey
//        String secret = "";//奇门的密钥
//        String session = "";//非必填参数 可以不传
//        Map<String, String> params = new HashMap<String, String>();
//        //业务参数传参
//        params.put("page_index", "1");
//        params.put("page_size", "10");
//        params.put("o_ids", "5459022");
//
//        //Util.Post 集成了 系统参数 和 计算 sign的方法
//        System.out.println("返回结果：" + Post("http://a1q40taq0j.api.taobao.com/router/qm", appkey, secret, "jushuitan.order.list.query", session, params));
//    }
//
//
//        ///
//
//        /// 给TOP请求签名 API v2.0
//        ///
//
//        /// 所有字符型的TOP请求参数
//        /// 签名密钥
//        /// 签名
//        public  String CreateSign(Map<String, String>  parameters, String secret) {
//            parameters.remove("sign");
//            Map<String, String> sortedParams = new HashMap(parameters);
//            IEnumerator > dem = sortedParams.GetEnumerator();
//            StringBuilder query = new StringBuilder(secret);
//            while (dem.MoveNext()) {
//                string key = dem.Current.Key;
//                string value = dem.Current.Value;
//                if (!string.IsNullOrEmpty(key) && !string.IsNullOrEmpty(value)) {
//                    query.Append(key).Append(value);
//                }
//            }
//            query.Append(secret);
//            MD5 md5 = MD5.Create();
//            byte[] bytes = md5.ComputeHash(Encoding.UTF8.GetBytes(query.ToString()));
//            StringBuilder result = new StringBuilder();
//            for (int i = 0; i < bytes.Length; i++) {
//                string hex = bytes[i].ToString("X");
//                if (hex.Length == 1) {
//                    result.Append("0");
//                }
//                result.Append(hex);
//            }
//            return result.ToString();
//        }
//
//
//        ///
//
//        /// 组装普通文本请求参数。
//        ///
//
//        /// Key-Value形式请求参数字典
//        /// URL编码后的请求数据
//        protected static string PostData(IDictionary parameters) {
//            StringBuilder postData = new StringBuilder();
//            bool hasParam = false;
//            IEnumerator > dem = parameters.GetEnumerator();
//            while (dem.MoveNext()) {
//                string name = dem.Current.Key;
//                string value = dem.Current.Value;
//                // 忽略参数名或参数值为空的参数
//                if (!string.IsNullOrEmpty(name) && !string.IsNullOrEmpty(value)) {
//                    if (hasParam) {
//                        postData.Append("&");
//                    }
//                    postData.Append(name);
//                    postData.Append("=");
//                    postData.Append(Uri.EscapeDataString(value));
//                    hasParam = true;
//                }
//            }
//            return postData.ToString();
//        }
//
//
//        ///
//
//        /// TOP API POST 请求
//        ///
//
//        /// 请求容器URL
//        /// AppKey
//        /// AppSecret
//        /// API接口方法名
//        /// 调用私有的sessionkey
//        /// 请求参数
//        /// 返回字符串
//        public static string Post(string url, string appkey, string appSecret, string method, string session, IDictionary param) {
//                #region---- - API系统参数----
//            param.Add("customer_id", "");//申请奇门自定义场景的customer_id
//            param.Add("target_app_key", "23060081");//申请奇门自定义场景的target_app_key
//            param.Add("app_key", appkey);
//            param.Add("method", method);
//            param.Add("session", session);//非必填
//            param.Add("timestamp", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
//            param.Add("format", "json");
//            param.Add("v", "2.0");
//            param.Add("sign_method", "md5");
//            param.Add("sign", CreateSign(param, appSecret));
//                #endregion
//            string result = string.Empty;
//                #region---- 完成 HTTP POST 请求 ----
//                    HttpWebRequest req = (HttpWebRequest) WebRequest.Create(url);
//            req.Method = "POST";
//            req.KeepAlive = true;
//            req.Timeout = 300000;
//            req.ContentType = "application/x-www-form-urlencoded;charset=utf-8";
//            byte[] postData = Encoding.UTF8.GetBytes(PostData(param));
//            Stream reqStream = req.GetRequestStream();
//            reqStream.Write(postData, 0, postData.Length);
//            reqStream.Close();
//            HttpWebResponse rsp = (HttpWebResponse) req.GetResponse();
//            Encoding encoding = Encoding.GetEncoding(rsp.CharacterSet);
//            Stream stream = null;
//            StreamReader reader = null;
//            stream = rsp.GetResponseStream();
//            reader = new StreamReader(stream, encoding);
//            result = reader.ReadToEnd();
//            if (reader != null) reader.Close();
//            if (stream != null) stream.Close();
//            if (rsp != null) rsp.Close();
//                #endregion
//            return Regex.Replace(result, @ "[\x00-\x08\x0b-\x0c\x0e-\x1f]", "");
//        }
//    }