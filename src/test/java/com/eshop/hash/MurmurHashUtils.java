package com.eshop.hash;

import org.apache.commons.codec.digest.MurmurHash3;
import org.apache.commons.lang3.ArrayUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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

    /**
     * 生成与 Guava 完全一致的 128 位 Murmur3 哈希（返回字节数组）
     * @param input 输入字符串（无需编码处理）
     * @return 128 位哈希值（16字节）
     */
    public static byte[] murmur3_128Bytes(String input) {
        // 2. MurmurHash3.hash128x64 (UTF-16, seed=0, Little-Endian)
        byte[] bytes = new byte[input.length() * 2];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            bytes[i * 2] = (byte) (c & 0xFF);
            bytes[i * 2 + 1] = (byte) ((c >> 8) & 0xFF);
        }

        long[] hash128 = MurmurHash3.hash128x64(bytes, 0, bytes.length, 0);
        return longArrayToBytes(hash128);
    }

    /**
     * 将包含两个long值的数组转换为16字节的byte数组（128位）
     * 转换过程采用Little-Endian字节序，与Guava的MurmurHash3实现保持一致
     *
     * @param hash128 包含两个long值的数组，代表128位的哈希值
     *                hash128[0] - 哈希值的低64位
     *                hash128[1] - 哈希值的高64位
     * @return 16字节的byte数组，表示128位的哈希值
     * @throws IllegalArgumentException 如果输入数组长度不为2
     */
    public static byte[] longArrayToBytes(long[] hash128) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.order(ByteOrder.LITTLE_ENDIAN);  // 关键！Little-Endian
        buffer.putLong(hash128[0]);
        buffer.putLong(hash128[1]);
        return buffer.array();
    }

    /**
     * 生成与 Guava 完全一致的 128 位 Murmur3 哈希（返回 Byte[]）
     * @param input 输入字符串（无需编码处理）
     * @return 128 位哈希值（16字节）
     */
    public static Byte[] murmur3_128ByteArray(String input) {
        byte[] primitiveArray = murmur3_128Bytes(input);
        return ArrayUtils.toObject(primitiveArray); // 依赖 Apache Commons Lang
    }

    /**
     * 生成与 Guava 完全一致的 128 位 Murmur3 哈希（返回十六进制字符串）
     *
     * @param input 输入字符串（无需编码处理）
     * @return 128 位哈希值的十六进制表示（32字符小写，与 HashCode.toString() 一致）
     */
    public static String murmur3_128HashString(String input) {
        byte[] hashBytes = murmur3_128Bytes(input);
        return bytesToHex(hashBytes);
    }

    /**
     * 将字节数组转换为十六进制字符串（小写，补零）
     * 例如：0x1A3F -> "1a3f"
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(32);
        for (byte b : bytes) {
            // 每个字节转换为两位十六进制（高位在前）
            String hex = String.format("%02x", b & 0xFF);
            hexString.append(hex);
        }
        return hexString.toString();
    }
}