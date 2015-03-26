package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_9 {

    public static final List<Integer> demoValues
            = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    private static Stream<Integer> getStream() {
        return demoValues.stream();
    }

    static final Function<Integer, Integer> f = (e) -> {
        System.out.println("e = " + e);
        return e;
    };

    public static void main(String[] args) {
        // true, some are matching
        System.out.println("anyMatch " + getStream().map(f).anyMatch((v) -> v % 2 == 0));

        //false, not all are matching
        System.out.println("allMatch " + getStream().map(f)
                .allMatch((v) -> v % 2 == 0));

        //false, not all are NOT matching
        System.out.println("noneMatch " + getStream().map(f)
                .noneMatch((v) -> v % 2 == 0));

        //5 matching the filter, 2,4,6,8,10
        System.out.println("count " + getStream().map(f)
                .filter((v) -> v % 2 == 0).count());
    }
}
