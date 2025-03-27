package com.eshop.hash;


import com.eshop.util.MurmurHashUtil;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MurmurHash3Test {
    public static void main(String[] args) {
        String input = "Hello, MurmurHash3!";
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);

        // 生成 32 位哈希
//        int hash32 = MurmurHash3.murmurhash3_x86_32(bytes, 0, bytes.length, 0);
        int hash32 = MurmurHash3.hash32x86(bytes, 0, bytes.length, 0);
        System.out.println("32-bit Hash: " + hash32);

        // 生成 128 位哈希（返回两个 long 值）
//        long[] hash128 = MurmurHash3.murmurhash3_x64_128(bytes, 0, bytes.length, 0);
        long[] hash128 = MurmurHash3.hash128x64(bytes, 0, bytes.length, 0);
        System.out.println("128-bit Hash: " + Arrays.toString(hash128));


        long hash64 = MurmurHashUtils.murmur3_128Low(input);
        System.out.println("64-bit Hash: " + hash64);


        Long hash = MurmurHashUtil.generateUniqueHash(input);
        System.out.println("64-bit-2 Hash: " + hash);
    }

    // 生成 64 位哈希值（Long 类型）
    public static long generateUniqueHash(String orderJson) {
        return Hashing.murmur3_128().hashUnencodedChars(orderJson).asLong();
    }
}
