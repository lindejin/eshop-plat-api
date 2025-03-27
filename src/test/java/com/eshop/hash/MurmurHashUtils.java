package com.eshop.hash;

import org.apache.commons.codec.digest.MurmurHash3;

public class MurmurHashUtils {

    /**
     * 生成与 Guava 完全一致的 64 位哈希（直接返回低位）
     * @param input 输入字符串（无需编码处理）
     * @return 64 位哈希值（低位）
     */
    public static long murmur3_128Low(String input) {
        // 1. 模拟 Guava 的 hashUnencodedChars：将字符串转为 UTF-16 LE 字节数组
        byte[] bytes = getUnencodedBytes(input);

        // 2. 计算 128 位 MurmurHash3
        long[] hash128 = MurmurHash3.hash128x64(bytes, 0, bytes.length, 0);

        // 3. 直接返回低位（Guava 的 asLong() 对应低位）
        return hash128[0];
    }

    /**
     * 将字符串转为 UTF-16 小端序字节数组（模拟 Guava 的 hashUnencodedChars）
     */
    private static byte[] getUnencodedBytes(String input) {
        char[] chars = input.toCharArray();
        byte[] bytes = new byte[chars.length * 2];
        for (int i = 0; i < chars.length; i++) {
            // 小端序编码（低位在前）
            bytes[i * 2] = (byte) (chars[i] & 0xFF);       // 低 8 位
            bytes[i * 2 + 1] = (byte) ((chars[i] >> 8) & 0xFF); // 高 8 位
        }
        return bytes;
    }
}