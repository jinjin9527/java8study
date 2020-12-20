package com.sylinx.test.webflux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VarDemo {

    public static void main(String []args) {
        String abc = "abc";
        List<String> list = new ArrayList<>();
        list.add("1");

//        abc= "11";
        Consumer<String> sc = s -> System.out.println(s + list);

        sc.accept("1222");
    }
}
