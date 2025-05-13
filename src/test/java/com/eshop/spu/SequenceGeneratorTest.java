package com.eshop.spu;

import java.util.stream.IntStream;

public class SequenceGeneratorTest {

    public static void main(String[] args) {
//        // 创建生成器实例
//        SequenceGenerator generator = SequenceGenerator.createDefault();
//
//        // 并发测试
//        IntStream.range(0, 1000).parallel().forEach(i -> {
//            String spu = generator.generateSpuCode(1L);
//            System.out.println("Generated SPU: " + spu);
//        });

        CompactSpuGenerator generator = new CompactSpuGenerator();

        // 百万次并发测试
        IntStream.range(0, 1_000_000).parallel().forEach(i -> {
            String spu = generator.generate("P");
            if (spu.length() != 10) { // P + 5+3+2 = 11字符？需要验证
                System.out.println("Invalid length: " + spu);
            }
        });
    }
}
