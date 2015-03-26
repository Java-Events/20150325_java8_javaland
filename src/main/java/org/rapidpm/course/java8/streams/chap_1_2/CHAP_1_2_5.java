package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_5 {

    public static void main(String[] args) {
        final List<String> demoValues = Arrays.asList("A", "B", "C", "D", "E");

        System.out.println(demoValues.stream()
                .reduce(String::concat)); //Optional[ABCDE]

        System.out.println(demoValues.parallelStream()
                .reduce(String::concat)); //Optional[ABCDE]

        //result is ABCDE
        System.out.println(demoValues.stream()
                .reduce("", String::concat));

        //result is ABCDE
        System.out.println(demoValues.parallelStream()
                .reduce("", String::concat));

        //result is X_ABCDE
        System.out.println(demoValues.stream()
                .reduce("X_", String::concat));

        //result is X_AX_BX_CX_DX_E
        System.out.println(demoValues.parallelStream()
                .reduce("X_", String::concat));

        System.out.println(demoValues.stream()
                .reduce("X_", (v1,v2)->{
                    System.out.println("v1 -> " + v1);
                    System.out.println("v2 -> " + v2);
                    return v1.concat(v2)+"_";
                }));

        System.out.println(demoValues.parallelStream()
                .reduce("X_", (v1,v2)->{
//                    System.out.println("v1 -> " + v1);
//                    System.out.println("v2 -> " + v2);
                    final String result = v1.concat(v2) + "#";
                    System.out.println("v1 " + v1 + " plus v2_ " + v2 + "_ => " + result);
                    return result;
                }));

        final List<Integer> demoIntValues = Arrays.asList(1, 2, 3, 4, 5);

        final Integer maxInteger = demoIntValues.parallelStream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("maxInteger = " + maxInteger);


//        final Integer maxInteger = demoIntValues.stream().reduce(Integer.MIN_VALUE, Integer::max);
//        System.out.println("maxInteger = " + maxInteger);

    }
}
