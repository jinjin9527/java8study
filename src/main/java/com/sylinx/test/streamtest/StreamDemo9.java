package com.sylinx.test.streamtest;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * stream 运行机制
 * 1.所有操作是链式调用，一个元素只迭代一次
 * 2.每一个中间操作返回一个新的流。
 * 流里面有一个属性sourceStage 指向同一个地方 就是head
 * head -> nextStage -> nextStage ->...->null
 * 3.有状态操作会把无状态操作阶段截断，
 * 4.并行环境下，有状态的中间操作不一定能并行操作
 * 5.parallel/sequetial 这两个操作也是中间操作(也是返回stream)
 * 但是他们不创建流，他们只修改head的并行标志[boolean 变量]
 */
public class StreamDemo9 {

    public static void main(String []args) {
        Random random = new Random();
        Stream stream = Stream.generate(
                () -> random.nextInt()
        ).limit(500)
         .peek(s -> print("peek : " + s))
         .filter(s -> {
            print("filter : " + s);
            return s<100000;})
         .sorted((i1, i2) -> {
             print("sorted : " + i1 + ", " + i2);
             return i1.compareTo(i2);
         })
         .peek(s -> {print("peek2 : " + s);}).parallel()
                ;

        stream.count();

    }

    public static void print(String a) {
//        System.out.println(a);
        System.out.println(Thread.currentThread().getName() + " > " + a);
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
