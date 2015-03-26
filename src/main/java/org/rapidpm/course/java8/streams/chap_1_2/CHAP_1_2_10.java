package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_10 {
    public static void main(String[] args) {
        final List<Integer> demoValues
                = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(demoValues.stream()  //seriell
                .map((m1) -> m1)
                .parallel()
                .map((m2) -> m2)
                .sequential() //seriell
                .collect(Collectors.toList()));


    }
}
