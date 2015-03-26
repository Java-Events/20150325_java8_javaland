package org.rapidpm.course.java8.streams;


import org.rapidpm.course.java8.streams.chap_1_3.Worker;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Sven Ruppert on 12.11.13.
 */
public interface DemoValueGenerator {

    public default List<Integer> generateDemoValuesForY() {
        final Random random = new Random();
        Supplier<Integer> integerSupplier =
                () -> random.nextInt(Worker.MAX_GENERATED_INT);
        return Stream
                .generate(integerSupplier)
                .limit(Worker.ANZAHL_MESSWERTE)
                .collect(toList());

    }
}
