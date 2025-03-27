package com.eshop.util;

import com.google.common.hash.Hashing;

public class MurmurHashUtil {

    // 生成 64 位哈希值（Long 类型）
    public static long generateUniqueHash(String orderJson) {
        return Hashing.murmur3_128().hashUnencodedChars(orderJson).asLong();
    }

    /**
     * 生成组合哈希值（MurmurHash + SipHash）
     * @param orderJson 订单 JSON 数据
     * @return 去重用的唯一哈希值
     */
    public static long generateHybridHash(String orderJson) {
        long murmurHash = Hashing.murmur3_128().hashUnencodedChars(orderJson).asLong();
        long sipHash = Hashing.sipHash24().hashUnencodedChars(orderJson).asLong();
        return murmurHash ^ sipHash; // 异或操作合并哈希值
    }

}
