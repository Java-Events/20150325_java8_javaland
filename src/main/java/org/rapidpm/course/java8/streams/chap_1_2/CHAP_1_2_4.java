package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_4 {
    public static void main(String[] args) {

        final List<String> demoValues = Arrays.asList("AB", "AAB", "AAAB", "AAAAB", "AAAAAB");

        final Optional<String> first = demoValues.stream().findFirst();

        //intro Optional
        final boolean present = first.isPresent();
        System.out.println("present = " + present);

        //how to create an Optional
        final Optional<String> optionalA = Optional.of("A");
        final Optional<String> optionalB1 = Optional.ofNullable("B");
        final Optional<String> optionalB2 = Optional.ofNullable(null);
        System.out.println("optionalB2.isPresent() = " + optionalB2.isPresent());

        optionalA.ifPresent(System.out::println); // result = 'A'

        //lambda is not activated
        optionalB2.ifPresent(System.out::println);// result = ''

        optionalA.filter(v->v.contains("A")).ifPresent(System.out::println);

        demoValues.stream()
                .forEach(v -> {
                    Optional.ofNullable(v)
                            .filter(o -> o.contains("AAA"))
                            .ifPresent(System.out::println);
                });

        final Optional<String> aa = demoValues.stream()
                .filter(v -> v.contains("AA"))
                .findFirst();
        System.out.println("aa = " + aa);

        demoValues.stream()
                .forEach(v -> {
                    Optional.ofNullable(v)
                            .map(o->o.concat("_X"))
                            .filter(f->f.contains("AAA"))
                            .ifPresent(System.out::println);
                });

        final Optional<Optional<String>> map = optionalA.map(CHAP_1_2_4::addX);
        final Optional<String> flatMap = optionalA.flatMap(CHAP_1_2_4::addX);

        demoValues.stream()
                .forEach(v -> {
                    Optional.ofNullable(v)
                            .flatMap(CHAP_1_2_4::addX)
                            .filter(f -> f.contains("AAA"))
                            .ifPresent(System.out::println);
                });


        System.out.println(optionalB2.orElse("noop"));

        try {
            optionalB2.orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        //back to Streams
        final String value = demoValues
                .stream()
                .filter(o -> o.contains("AAA"))
                .findFirst().orElse("noop ");
        System.out.println("value = " + value);

        for(int i=0; i<10;i++){
            final String valueParallel = demoValues
                    .parallelStream()
                    .filter(o -> o.contains("A"))
                    .findFirst().orElse("noop ");
            System.out.println("value ("+i+") = " + valueParallel);
        }

    }

    public static Optional<String> addX(final String value) {
        final Optional<String> optional = Optional.ofNullable(value);
        final boolean present = optional.isPresent();
        if(present){
            return optional.map(v -> v + "_X");
        } else{
            return optional;
        }
    }
}
