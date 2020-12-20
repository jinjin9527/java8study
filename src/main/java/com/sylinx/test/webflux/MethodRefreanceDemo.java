package com.sylinx.test.webflux;

import java.util.function.*;


class Dog{
    public String name;

    public int food = 10;
    public Dog(String name) {
        this.name = name;
    }
    public Dog(){}

    public static void bark(Dog dog) {
        System.out.println(dog);
    }

    public int eat(int num) {

        int result = this.food -=num;
        System.out.println(result);
        return result;
    }

    public String toString(){
        return this.name;
    }
}

public class MethodRefreanceDemo {

    public static void main(String []args) {
        Consumer<String> cs = System.out::println;

        cs.accept("12");

        Consumer<Dog> dc = Dog::bark;
        Dog fff = new Dog("fff");
        dc.accept(fff);

        Function<Integer, Integer> fc = fff::eat;
        UnaryOperator<Integer> uic = fff::eat;
        uic.apply(9);


        fc.apply(1);


        IntUnaryOperator iuoc = fff::eat;
        iuoc.applyAsInt(1);

        BiFunction<Dog, Integer, Integer> eee = Dog::eat;
        eee.apply(fff, 11);

        Supplier<Dog> ssd = Dog::new;

        System.out.println(ssd.get().food);

        Function<String ,Dog> fffsd = Dog::new;
        System.out.println(fffsd.apply("ffffaaa").name);
    }
}
