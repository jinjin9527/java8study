package com.sylinx.test.webflux;

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

@FunctionalInterface
interface IMath2 {
    int add(int x, int y);
}

public class TypeDemo {

    public static void main(String []args) {
        IMath imm = (x, y) -> x+y;

        IMath [] bbb = {(x, y) -> x+y,(x, y) -> x+y*2};
        Object obj = (IMath) (x, y) -> x+y;

        IMath abb = createLam();
        TypeDemo demo = new TypeDemo();
        demo.test((IMath2)(x, y) -> y+x);
    }

    public static IMath createLam(){
        return (x, y) -> x+y;
    }

    public void test(IMath test) {
        System.out.println(test.add(3,4));
    }

    public void test(IMath2 test) {
        System.out.println(test.add(5,4));
    }
}
