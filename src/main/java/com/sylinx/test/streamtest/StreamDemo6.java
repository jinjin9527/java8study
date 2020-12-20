package com.sylinx.test.streamtest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo6 {
    public static void main(String []args) {

        String str = "my name is 000";

//        str.chars().parallel().forEach(i -> System.out.println((char)i));
//        str.chars().parallel().forEachOrdered(i -> System.out.println((char)i));

        List<String> abc = Stream.of(str.split(" ")).collect(Collectors.toList());

//        System.out.println(abc);

        Optional<String> letters = Stream.of(str.split(" ")).reduce( (s1, s2)-> s1 + " | " + s2);

        System.out.println(letters.orElse(""));

        String letters1 = Stream.of(str.split(" ")).reduce("", (s1, s2)-> s1 + " | " + s2);
        System.out.println(letters1);

        Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);

        Optional<String> abcd= Stream.of(str.split(" ")).max((s1,s2) -> s1.length() - s2.length());
        System.out.println(abcd.get());

    }
}
