package com.eshop.spu;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 紧凑型SPU生成器（线程安全+高性能）
 */
public class CompactSpuGenerator {
    //==================== 配置常量 ====================
    private static final long EPOCH_BASE = 1609459200000L; // 2021-01-01 UTC
    private static final char[] BASE36_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int MAX_SEQUENCE = 46655; // 36^3-1

    //==================== 核心组件 ====================
    private final AtomicLong sequence = new AtomicLong(0);
    private volatile long lastTimestamp = 0;

    //==================== 公开API ====================
    public String generate(String prefix) {
        return new SpuBuilder(prefix)
                .appendTimestamp()
                .appendSequence()
                .appendChecksum()
                .build();
    }

    //==================== 建造者模式 ====================
    private class SpuBuilder {
        private final StringBuilder buffer;

        SpuBuilder(String prefix) {
            this.buffer = new StringBuilder(prefix).append("-");
        }

        SpuBuilder appendTimestamp() {
            long timeDiff = System.currentTimeMillis() - EPOCH_BASE;
            buffer.append(encodeBase36(timeDiff, 5)).append("-");
            return this;
        }

        SpuBuilder appendSequence() {
            long seq = sequence.updateAndGet(n -> (n >= MAX_SEQUENCE) ? 0 : n + 1);
            buffer.append(encodeBase36(seq, 3)).append("-"); // 3位base36可表示46656个值
            return this;
        }

        SpuBuilder appendChecksum() {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            buffer.append(BASE36_CHARS[random.nextInt(36)])
                    .append(BASE36_CHARS[random.nextInt(36)]);
            return this;
        }

        String build() {
            return buffer.toString();
        }
    }

    //==================== 编码工具 ====================
    private String encodeBase36(long number, int width) {
        char[] buf = new char[width];
        for (int i = width - 1; i >= 0; i--) {
            buf[i] = BASE36_CHARS[(int) (number % 36)];
            number /= 36;
        }
        return new String(buf);
    }
}