package com.sylinx.test.streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class StreamDemo4 {

    public static void main(String[] args){

        //模拟10000条数据 循环打印测试
        List<Integer> list = new ArrayList();
        for (int j = 0; j < 10000; j++) {
            list.add(j);
        }
        // 统计并行执行list的线程
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        // 并行执行
        list.parallelStream().forEach(integer -> {
            Thread thread = Thread.currentThread();
            // 统计并行执行list的线程
            threadSet.add(thread);
        });
        System.out.println(threadSet);
        System.out.println("threadSet一共有" + threadSet.size() + "个线程");//打印结果由此证明parallelStream是多管道线程
        System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");

    }
}
