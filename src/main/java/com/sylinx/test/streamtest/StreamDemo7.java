package com.sylinx.test.streamtest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamDemo7 {

    public static void main(String []args) {
        //IntStream.range(1, 100).parallel().peek(StreamDemo7::debug).count();

        // 可以用这个属性修改线程数
        // 默认线程数 是 当前机器的cpu数
        // 并行流使用线程池ForkJoinPool.commonPool
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
//        IntStream.range(1, 100).parallel().peek(StreamDemo7::debug).count();

        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(() -> IntStream.range(1, 100).parallel().peek(StreamDemo7::debug).count());
        pool.shutdown();
        synchronized (pool){
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + " " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void debug2(int i) {
        System.err.println(i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
