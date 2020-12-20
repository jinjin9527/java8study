package com.sylinx.test.streamtest;

import java.util.Random;
import java.util.stream.Stream;

public class StreamDemo5 {

    public static void main(String []args) {

        // map filter foreach
        String str = "my name is 000";
        Stream.of(str.split(" ")).filter(s -> s.length() >2).map(s -> s.length()).forEach(System.out::println);

        //flatmap A.B(集合)　
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(i -> System.out.println((char) i.intValue()));

        // peek用于debug 是中间操作  foreach是终止操作
        System.out.println("-------------");
        Stream.of(str.split(" ")).peek(s -> System.out.println(s.length())).forEach(System.out::println);

        // limit 使用 限制无限流
        new Random().ints().filter(i -> i>100 && i<120).limit(5).forEach(System.out::println);
    }
}
