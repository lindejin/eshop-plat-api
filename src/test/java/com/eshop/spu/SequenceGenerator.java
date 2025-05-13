package com.eshop.spu;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * SPU生成器核心模块（线程安全版）
 */
public class SequenceGenerator {

    // ==================== 模块配置 ====================
    private static final int TIMESTAMP_LENGTH = 13;
    private static final int SEQUENCE_LENGTH = 4;
    private static final int CHECKSUM_LENGTH = 2;
    private static final char[] SAFE_CHARS = "2346789ABCDEFGHJKMNPQRSTUVWXYZ".toCharArray();

    // ==================== 依赖组件 ====================
    private final TimestampProvider timestampProvider;
    private final SequenceManager sequenceManager;
    private final ChecksumGenerator checksumGenerator;

    // ==================== 初始化 ====================
    public SequenceGenerator(TimestampProvider timestampProvider,
                             SequenceManager sequenceManager,
                             ChecksumGenerator checksumGenerator) {
        this.timestampProvider = timestampProvider;
        this.sequenceManager = sequenceManager;
        this.checksumGenerator = checksumGenerator;
    }

    // ==================== 核心生成逻辑 ====================
    public String generateSpuCode(long prefix) {
        return new SpuBuilder()
                .appendPrefix(prefix)
                .appendTimestamp()
                .appendSequence()
                .appendChecksum()
                .build();
    }

    // ==================== 建造者封装 ====================
    private class SpuBuilder {
        private final StringBuilder buffer = new StringBuilder(24);

        SpuBuilder appendPrefix(long prefix) {
            buffer.append(String.format("%03d", prefix)).append("-");
            return this;
        }

        SpuBuilder appendTimestamp() {
            buffer.append(timestampProvider.getTimestamp()).append("-");
            return this;
        }

        SpuBuilder appendSequence() {
            buffer.append(String.format("%0" + SEQUENCE_LENGTH + "d",
                    sequenceManager.nextValue())).append("-");
            return this;
        }

        SpuBuilder appendChecksum() {
            buffer.append(checksumGenerator.generate(CHECKSUM_LENGTH));
            return this;
        }

        String build() {
            return buffer.toString();
        }
    }

    // ==================== 时间戳提供器 ====================
    public interface TimestampProvider {
        String getTimestamp();
    }

    // ==================== 序列号管理器 ====================
    public interface SequenceManager {
        long nextValue();
    }

    // ==================== 校验码生成器 ====================
    public interface ChecksumGenerator {
        String generate(int length);
    }

    // ==================== 默认实现 ====================

    /**
     * 毫秒级时间戳提供器（带熔断保护）
     */
    public static class DefaultTimestampProvider implements TimestampProvider {
        private long lastTimestamp = 0;

        @Override
        public synchronized String getTimestamp() {
            long current = System.currentTimeMillis();
            while (current <= lastTimestamp) {
                current = System.currentTimeMillis();
            }
            lastTimestamp = current;
            return String.valueOf(current);
        }
    }

    /**
     * 原子序列管理器（带周期重置）
     */
    public static class ResetableSequenceManager implements SequenceManager {
        private static final int MAX_SEQUENCE = 9999;
        private final AtomicLong counter = new AtomicLong(0);

        @Override
        public long nextValue() {
            return counter.updateAndGet(val -> val >= MAX_SEQUENCE ? 0 : val + 1);
        }
    }

    /**
     * 安全字符校验码生成器
     */
    public static class SafeChecksumGenerator implements ChecksumGenerator {
        private final ThreadLocalRandom random = ThreadLocalRandom.current();

        @Override
        public String generate(int length) {
            char[] result = new char[length];
            for (int i = 0; i < length; i++) {
                result[i] = SAFE_CHARS[random.nextInt(SAFE_CHARS.length)];
            }
            return new String(result);
        }
    }

    // ==================== 工厂方法 ====================
    public static SequenceGenerator createDefault() {
        return new SequenceGenerator(
                new DefaultTimestampProvider(),
                new ResetableSequenceManager(),
                new SafeChecksumGenerator()
        );
    }
}