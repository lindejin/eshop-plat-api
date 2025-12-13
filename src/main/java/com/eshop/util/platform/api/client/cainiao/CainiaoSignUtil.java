package com.eshop.util.platform.api.client.cainiao;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class CainiaoSignUtil {


    /**
     * MessageDigest类在rt.jar中
     * Base64类在commons-codec-1.2.jar中
     *
     * 算法说明：根据传入的logistics_interface（报文内容）、charset（编码方式）、keys（SecretKey）三个参数进行加密。
     * 编码方式目前支持GBK与UTF-8两种，签名SecretKey为菜鸟为CP生成，签名体为报文内容+签名Key，
     * 签名算法为：对签名内容进行md5，后将内容转换成base64编码。
     *
     * 例如：content="hello1234"; charset="utf-8"; keys="key123";
     * 签名结果为：ufYU7rvXhHY3IDyZgyt6SA== 即为正确。
     */
    public static String doSign(String content, String charset, String keys) {
        String sign = "";
        content = content + keys;
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes(charset));
            sign = new String(Base64.encodeBase64(md.digest()), charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sign;
    }
}
