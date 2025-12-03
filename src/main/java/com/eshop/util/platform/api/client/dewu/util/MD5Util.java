package com.eshop.util.platform.api.client.dewu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String getMD5Str(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            byte[] byteResult = digest.digest();
            String result = convertbyte2String(byteResult);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String convertbyte2String(byte[] byteResult) {
        char[] hexDigits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        char[] result = new char[byteResult.length * 2];
        int index = 0;
        for (byte b : byteResult) {
            result[index++] = hexDigits[b >>> 4 & 0xF];
            result[index++] = hexDigits[b & 0xF];
        }
        return new String(result);
    }
}
