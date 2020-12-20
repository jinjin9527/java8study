package com.sylinx.test.webflux;

import java.text.DecimalFormat;
import java.util.function.Function;

interface IMoneyFormat {
    String formart(int i);
}

class MyMoney{
    private final int money;

    public MyMoney(int money){
        this.money = money;
    }
    public void printMoney(IMoneyFormat iMoneyFormat){
        System.out.println(iMoneyFormat.formart(money));
    }

    public void printMoney1(Function<Integer, String> iMoneyFormat){
        System.out.println(iMoneyFormat.apply(money));
    }
}

public class MoneyDemo {
    public static void main(String []args) {
        MyMoney me = new MyMoney(9999999);
        me.printMoney(i -> new DecimalFormat("#,###").format(i));
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        me.printMoney1(integerStringFunction.andThen(s -> "123" + s));
    }
}
