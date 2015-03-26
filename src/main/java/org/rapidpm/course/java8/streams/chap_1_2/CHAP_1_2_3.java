package org.rapidpm.course.java8.streams.chap_1_2;

import org.rapidpm.course.java8.streams.Pair;
import org.rapidpm.course.java8.streams.PairListGenerator;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_3 {

    public static void main(String[] args) {
        final List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();
        //map from Point to DemoElements
        generateDemoValues.forEach(System.out::println);

        System.out.println(" ============ ");
        generateDemoValues.stream()
            .filter(v -> v.getId() % 2 == 0)
            .filter(v->v.getValue().contains("5"))
        .forEach(System.out::println);





    }

}
