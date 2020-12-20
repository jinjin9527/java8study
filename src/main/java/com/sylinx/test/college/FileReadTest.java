package com.sylinx.test.college;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FileReadTest {
    private static final String PATH = "src/com/sylinx/test/4.txt";

    public static void main(String []args) {
        try {
            Path path = Paths.get(PATH);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);


            int totalcount = 5;
            int step = 300;
            List<List<Integer>> resultList = new ArrayList<>();
            int count = 0;
            for(int i= 0;i<totalcount;i++) {
                count = i * step;
                List<Integer> everycount = new ArrayList<>();
                while(count < (i + 1) * step){
                    everycount.add(Integer.parseInt(lines.get(count)));
                    count+=3;
                }
                resultList.add(everycount);

            }

            for (List<Integer> index : resultList) {
                System.out.println(index.stream().collect(Collectors.summarizingLong(it -> it)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
