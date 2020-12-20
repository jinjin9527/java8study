package com.sylinx.test.webflux;

public class ThreadDemo {
    public static void main(String[]args){


        Thread ok = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        });
        ok.start();

        Object target2 = (Runnable) () -> System.out.println(1);
        Runnable target3 = () -> System.out.println(1);
//        new Thread(() -> System.out.println("ok")).start();

        System.out.println(target2 == target3);
    }
}
