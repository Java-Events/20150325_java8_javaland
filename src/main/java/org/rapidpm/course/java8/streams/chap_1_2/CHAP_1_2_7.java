package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_7 {
    public static void main(String[] args) {

        // example result:
        // [77, 79, 81, 95, 43, 10, 53, 48, 74, 68, 60, 86, 83, 24, 57, 28, 8,
        //  85, 70, 66, 20, 14, 97, 73, 22, 36, 40, 39, 32, 19, 41, 67, 25, 88]
        final Random random = new Random();
        System.out.println(
                Stream.generate(() -> random.nextInt(100))
                        .limit(40)
                        .distinct()
                        .collect(Collectors.toList())
        );


    }
}
