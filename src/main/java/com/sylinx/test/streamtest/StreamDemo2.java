package com.sylinx.test.streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String []args) {
        List<String > list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        long  aaa = list.stream().map(x -> x + "1").count();
        System.out.println(aaa);
        list.parallelStream();

        int [] nums = {1, 2, 3};
        Arrays.stream(nums);

        IntStream.of(nums);
        IntStream.rangeClosed(1, 5);
        IntStream a = new Random().ints().limit(5);
        Random rrr = new Random();
        Stream.generate((() -> rrr.nextInt())).limit(20);
    }
}
