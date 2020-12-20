package com.sylinx.test.streamtest;

import com.sylinx.test.streamtest.data.Gender;
import com.sylinx.test.streamtest.data.Grade;
import com.sylinx.test.streamtest.data.Student;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo8 {
    public static void main(String []args) {

        List<Student> students = Arrays.asList(
                new Student("1", 10, Gender.MALE, Grade.ONE),
                new Student("2", 13, Gender.FEMALE, Grade.TWO),
                new Student("3", 12, Gender.MALE, Grade.THREE),
                new Student("4", 15, Gender.FEMALE, Grade.FOUR),
                new Student("5", 12, Gender.MALE, Grade.ONE),
                new Student("6", 11, Gender.FEMALE, Grade.ONE),
                new Student("7", 10, Gender.MALE, Grade.TWO),
                new Student("8", 19, Gender.FEMALE, Grade.ONE),
                new Student("9", 10, Gender.MALE, Grade.THREE),
                new Student("0", 14, Gender.MALE, Grade.TWO)
        );
        // 获得特定列表
        Set<Integer> ages = students.stream().map(Student::getAge).collect(Collectors.toCollection(TreeSet::new));
        // 统计汇总
        IntSummaryStatistics aaa = students.stream().collect(Collectors.summarizingInt(Student::getAge));

        // 分块 只有两种 所以 传断言函数
        Map<Boolean, List<Student>> genders = students.stream().collect(Collectors.partitioningBy(s -> s.getGender() == Gender.MALE));

        System.out.println(genders);
//        MapUtils.verbosePrint(System.out, "aabb", genders);
        Map<Grade, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getGrade));
//        MapUtils.verbosePrint(System.out, "aabb", collect);

        Map<Grade, Long> collect1 = students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        MapUtils.verbosePrint(System.out, "aabb", collect1);
    }
}
