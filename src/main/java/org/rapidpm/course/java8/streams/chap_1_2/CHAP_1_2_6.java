package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_6 {

    public static void main(String[] args) {
        final List<Integer> demoValues
                = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //limit the input
        System.out.println(demoValues
                .stream().limit(4)
                .collect(Collectors.toList()));

        //limit the result
        System.out.println(demoValues
                .stream().filter((v) -> v > 4)
                .limit(4)
                .collect(Collectors.toList()));

        System.out.println(demoValues
                .stream().skip(4)
                .collect(Collectors.toList()));

        System.out.println(demoValues
                .stream().sorted((v1, v2) -> Integer.compare(v2, v1))
                .collect(Collectors.toList()));



    }
}
