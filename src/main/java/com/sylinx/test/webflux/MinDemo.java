package com.sylinx.test.webflux;

import java.util.stream.IntStream;

public class MinDemo {


    public static void main(String []args) {
        int [] num = {1, 3,5 ,2};

        int min = Integer.MAX_VALUE;

        for (int i : num) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);

        int min2 = IntStream.of(num).min().getAsInt();

        System.out.println(min2);
    }
}
