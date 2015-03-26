package org.rapidpm.course.java8.streams.chap_1_1;

import org.rapidpm.course.java8.streams.Pair;
import org.rapidpm.course.java8.streams.PairListGenerator;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 03.04.2014.
 */
public class CHAP_1_1_Uebung {

    final static List<Pair> generateDemoValues = new PairListGenerator() {
    }.generateDemoValues();

    public static void main(String[] args) {
        //erzeuge 10 Elemente aus einer Liste
        generateDemoValues.stream().forEach((v) -> System.out.println(v));
        generateDemoValues.stream().forEach(System.out::println);


        final Stream.Builder<Pair> builder = Stream.<Pair>builder();
        generateDemoValues.forEach((v) -> {
            builder.add(v);
        });
        final Stream<Pair> build = builder.build();
        build.forEach(System.out::println);

        final Pair[] pairs = nextStream().toArray(Pair[]::new);
        final Set<Pair> collectToSet = nextStream().collect(Collectors.toSet());

        final Function<Pair, String> valueMapper = Pair::getValue;

        nextStream().collect(Collectors.toMap(keyFunct(), valueMapper));
        nextStream().collect(Collectors.groupingBy(keyFunct()));


    }

    public static Function<Pair, Integer> keyFunct(){
//        final Function<Pair, Integer> keyMapper = new Function<Pair, Integer>() {
//            @Override
//            public Integer apply(Pair t) {
//                return t.getId();
//            }
//        };
        return Pair::getId;
    }


    public static Stream<Pair> nextStream() {
        return generateDemoValues.stream();
    }

}
