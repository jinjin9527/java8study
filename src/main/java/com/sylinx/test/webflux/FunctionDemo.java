package com.sylinx.test.webflux;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionDemo {

    public static void main(String []args) {
        IntPredicate p = i -> i> 0;
        System.out.println(p.test(1));

        IntConsumer c = s -> System.out.println(";;" + s);
        c.accept(333);
    }

}
