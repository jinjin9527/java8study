package com.sylinx.test.streamtest;

import java.util.stream.IntStream;

public class StreamDemo {

    public static void main(String []args) {

        // 外部迭代
        int [] nums = {1, 2, 3};
        int sum=0;
        for(int i:nums) {
            sum+=i;
        }
        System.out.println(sum);

        // 内部迭代
        // map 中间操作 返回stream的操作
        // sum 终止操作 出力值
        // 惰性求值 终止没有调用的情况下 中间操作不会执行
        int sum2 = IntStream.of(nums).map(StreamDemo::doubleNum).sum();
        System.out.println(sum2);

        System.out.println("---------------");
        IntStream.of(nums).map(StreamDemo::doubleNum);
    }

    public static int doubleNum(int i) {
        System.out.println(" **** 2");

        return i * 2;
    }
}
