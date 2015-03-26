package org.rapidpm.course.java8.streams.chap_1_2;

import org.rapidpm.course.java8.streams.Pair;
import org.rapidpm.course.java8.streams.PairListGenerator;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sven on 26.03.15.
 */
public class CHAP_1_2_1_Loesung {
    final static List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();


    public static void main(String[] args) {
        final Set<Pair> pairSet = new HashSet<>();
//        generateDemoValues.forEach((v)->pairSet.add(v));
        generateDemoValues.forEach(pairSet::add);
        pairSet.forEach(System.out::println);

        for (final DemoA demoA : demoAList()) {
            for (final DemoB demoB : demoA.values) {
                for (final DemoC demoC : demoB.values) {
                    System.out.println(demoC);
                }
            }
        }

        demoAList().forEach(a->{
            a.values.forEach(b->{
                b.values.forEach(c->{
                    System.out.println("c = " + c);
                });
            });
        });
        demoAList()
                .forEach(a -> a.values
                        .forEach(b -> b.values
                                .forEach(System.out::println)));


    }

    final static Supplier<DemoC> demoCSupplier = () -> {
        final DemoC demo = new DemoC();
        demo.txt = "DemoC - " + Instant.now();
        return demo;
    };

    final static Supplier<DemoB> demoBSupplier = () -> {
        final DemoB demo = new DemoB();
        final List<DemoC> collect = Stream
                .generate(demoCSupplier)
                .limit(10)
                .collect(Collectors.toList());
        demo.values.addAll(collect);
        return demo;
    };
    public static List<DemoB> createDemoBListe(){
        return Stream
                .generate(demoBSupplier)
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<DemoA> demoAList(){
        final Supplier<DemoA> demoASupplier = () -> {
            final DemoA demo = new DemoA();
            demo.values.addAll(createDemoBListe());
            return demo;
        };

//        final List<DemoA> result = new ArrayList<>();
//        for(int i = 0; i<10; i++){
//            final DemoA a = new DemoA();
//            a.values.addAll(createDemoBListe());
//            result.add(a);
//        }
//        return result;

        return Stream.generate(demoASupplier)
                .limit(10)
                .collect(Collectors.toList());
    }

    public static class DemoA{
        public List<DemoB> values = new ArrayList<>();
    }
    public static class DemoB{
        public List<DemoC> values = new ArrayList<>();
    }
    public static class DemoC{
        public String txt;
    }



}
