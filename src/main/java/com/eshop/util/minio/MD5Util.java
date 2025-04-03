package com.eshop.util.minio;

/**
 * <p>
 *  MD5工具类
 * </p>
 *
 * @author: rch
 * @since: 2020-12-03
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /** * 生成16位小写md5加密字符串 * @param sourceStr * @return */
    public static String MD5ToLow16(String sourceStr) {
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            StringBuffer buf = getMD5StringBuffer(sourceStr);
            return buf.toString().substring(8, 24).toLowerCase();// 16位加密
            // return buf.toString();// 32位加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /** * 生成16位大写md5加密字符串 * @param sourceStr * @return */
    public static String MD5ToUpp16(String sourceStr) {
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            StringBuffer buf = getMD5StringBuffer(sourceStr);
            return buf.toString().substring(8, 24).toUpperCase();// 16位加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /** * 生成32位小写md5加密字符串 * @param sourceStr * @return */
    public static String MD5ToLow32(String sourceStr) {
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            StringBuffer buf = getMD5StringBuffer(sourceStr);
            return buf.toString().toLowerCase();// 32位加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /** * 生成32位大写md5加密字符串 * @param sourceStr * @return */
    public static String MD5ToUpp32(String sourceStr) {
        try {
            StringBuffer buf = getMD5StringBuffer(sourceStr);

            return buf.toString().toUpperCase();// 32位加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /** * 将字符串MD5加密 * @param sourceStr * @return * @throws NoSuchAlgorithmException */
    private static StringBuffer getMD5StringBuffer(String sourceStr) throws NoSuchAlgorithmException {
        // 获得MD5摘要算法的 MessageDigest对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 使用指定的字节更新摘要
        mdInst.update(sourceStr.getBytes());
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < md.length; i++) {
            int tmp = md[i];
            if (tmp < 0){
                tmp += 256;
            }
            if (tmp < 16){
                buf.append("0");
            }
            buf.append(Integer.toHexString(tmp));
        }
        return buf;
    }

    public static String md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update((str).getBytes("UTF-8"));
            byte b[] = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer("");

            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        String str = "1";
//        System.out.println(str);
//        System.out.println(MD5ToLow16(str));
//        System.out.println(MD5ToLow32(str));
//        System.out.println(MD5ToUpp16(str));
//        System.out.println(MD5ToUpp32(str));
        String ttt = "sportsCe7vS3j1ziPHwfDDffJ3ivX34Z1cb2S1133687017471620710415600000004www.sportstatus.comzhU33255";
        System.out.println(md5(ttt));
    }
}
