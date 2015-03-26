package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_8 {
    public static void main(String[] args) {
        final List<Integer> demoValues
                = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //find the maximum
        System.out.println(demoValues
                .stream().max(Integer::compareTo)
        );
        //find the BUG ;-)
        System.out.println(demoValues
                .stream().min((v1, v2) -> Integer.compare(v2, v1))
        );

    }
}
