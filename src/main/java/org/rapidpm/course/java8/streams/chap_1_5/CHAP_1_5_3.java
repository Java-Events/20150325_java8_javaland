package org.rapidpm.course.java8.streams.chap_1_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Sven Ruppert
 * Date: 03.12.13
 * Time: 13:23
 */
public class CHAP_1_5_3 {
    public static void main(String[] args) {
        final List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        matrix.add(Arrays.asList(1,2,3,4,5,66,7,8,9)); //hier eine 66
        matrix.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        matrix.forEach(System.out::println);

        final Integer s = matrix.stream()
                .map(l -> l.stream()
                        .filter(v -> v.equals(66))
                        .findFirst().orElse(null))
                .filter(f -> f != null)
                .findFirst().orElse(null);
        System.out.println("s = " + s);

        Integer result = null;
        endPos:
        for (final List<Integer> integers : matrix) {
            for (final Integer integer : integers) {
                if(integer.equals(66)){
                    result = integer;
                    break endPos;
                }
            }
        }
        System.out.println("result " + result);

    }

    //        final String s = matrix.stream()
//                .map((l -> l.stream()
//                        .filter(v -> {
//                            System.out.println("v = " + v);
//                            return v.equals(66);
//                        })
//                        .findFirst()
//                        .map(m -> {
//                            System.out.println("m = " + m);
//                            return m.toString() + "XX";
//                        }).orElse(null)
//
//
//                ))
//                .filter(f->f != null)
//                .findFirst()
//                .orElse("yy");

}
