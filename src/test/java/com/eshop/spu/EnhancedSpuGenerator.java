//package com.eshop.spu;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.ThreadLocalRandom;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class EnhancedSpuGenerator {
//    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
//    private static final char[] CHECKSUM_CHARS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".toCharArray();
//
//    @Autowired
//    private SequenceGenerator sequenceGenerator;
//
//    // 线程安全的SPU生成入口
//    public synchronized String createSpuCode(Long prefix) {
//        return new SpuBuilder(prefix)
//                .appendTimestamp()
//                .appendSequence()
//                .appendRandomChecksum()
//                .build();
//    }
//
//    // 建造者模式封装
//    private class SpuBuilder {
//        private final StringBuilder code = new StringBuilder(24);
//
//        SpuBuilder(Long prefix) {
//            code.append(String.format("%03d", prefix)).append("-");
//        }
//
//        SpuBuilder appendTimestamp() {
//            code.append(System.currentTimeMillis()).append("-");
//            return this;
//        }
//
//        SpuBuilder appendSequence() {
//            code.append(sequenceGenerator.getNextSegment()).append("-");
//            return this;
//        }
//
//        SpuBuilder appendRandomChecksum() {
//            code.append(CHECKSUM_CHARS[RANDOM.nextInt(CHECKSUM_CHARS.length)]);
//            code.append(CHECKSUM_CHARS[RANDOM.nextInt(CHECKSUM_CHARS.length)]);
//            return this;
//        }
//        SpuBuilder appendTimestamp() {
//            long current = System.currentTimeMillis();
//            while (current <= lastTimestamp) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(1);
//                    current = System.currentTimeMillis();
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//            lastTimestamp = current;
//            code.append(current).append("-");
//            return this;
//        }
//        String build() {
//            return code.toString();
//        }
//    }
//}
