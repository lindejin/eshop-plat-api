package com.eshop.hash;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class MurmurHashComparison {
    public static void main(String[] args) {
        String input = "hello world";

        // 1. Guava's Murmur3_128 (UTF-16)
        byte[] guavaHash = Hashing.murmur3_128()
                .hashUnencodedChars(input)
                .asBytes();
        System.out.println("Guava Hash: " + Arrays.toString(guavaHash));

        // 2. MurmurHash3.hash128x64 (UTF-16, seed=0, Little-Endian)
        byte[] bytes = new byte[input.length() * 2];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            bytes[i * 2] = (byte) (c & 0xFF);
            bytes[i * 2 + 1] = (byte) ((c >> 8) & 0xFF);
        }

        long[] hash128 = MurmurHash3.hash128x64(bytes, 0, bytes.length, 0);
        byte[] convertedHash = longArrayToBytes(hash128);
        System.out.println("Converted Hash: " + Arrays.toString(convertedHash));

        // 3. Compare
        System.out.println("Equal? " + Arrays.equals(guavaHash, convertedHash));
    }

    public static byte[] longArrayToBytes(long[] hash128) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.order(ByteOrder.LITTLE_ENDIAN);  // 关键！Little-Endian
        buffer.putLong(hash128[0]);
        buffer.putLong(hash128[1]);
        return buffer.array();
    }
}
