package org.rapidpm.course.java8.streams.chap_1_3;


import org.rapidpm.course.java8.streams.WorkLoadGenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public class WorkerParallelStreams implements Worker{

    @Override
    public List<List<Integer>> generateDemoValueMatrix(){
        return Stream
                .generate(this::generateDemoValuesForY)
                .limit(ANZAHL_KURVEN)
                .collect(Collectors.toList());
    }

    @Override
    public List<List<Double>> generateInterpolatedValues(
            List<List<Integer>> baseValues) {
        return baseValues
                .parallelStream()
                .map(v -> {
                    final WorkLoadGenerator generator = new WorkLoadGenerator();
                    return generator.generate(v);
                })
                .collect(Collectors.toList());
    }

    public List<Integer> generateDemoValuesForY(){
        final Random random = new Random();
        return Stream
                .generate(() -> random.nextInt(MAX_GENERATED_INT))
                .limit(ANZAHL_MESSWERTE)
                .collect(Collectors.toList());
    }
}
