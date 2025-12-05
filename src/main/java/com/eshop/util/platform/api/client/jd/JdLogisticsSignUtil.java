package com.eshop.util.platform.api.client.jd;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Objects;

public class JdLogisticsSignUtil {

    private static final String HEX_CHARACTERS = "0123456789ABCDEF";

    public static String sign(String algorithm, byte[] data, byte[] secret) throws GeneralSecurityException {
        if (Objects.equals(algorithm, "md5-salt")) {
            return bytesToHex(MessageDigest.getInstance("md5").digest(data));
        } else if (Objects.equals(algorithm, "HMacMD5")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } else if (Objects.equals(algorithm, "HMacSHA1")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } else if (Objects.equals(algorithm, "HMacSHA256")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        } else if (Objects.equals(algorithm, "HMacSHA512")) {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secret, algorithm));
            return Base64.getEncoder().encodeToString(mac.doFinal(data));
        }
        throw new GeneralSecurityException("Algorithm " + algorithm + " not supported yet");
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            stringBuilder.append(HEX_CHARACTERS.charAt((b >>> 4) & 0x0F));
            stringBuilder.append(HEX_CHARACTERS.charAt(b & 0x0F));
        }
        return stringBuilder.toString();
    }
}
