package org.rapidpm.course.java8.streams.chap_1_2;

import org.rapidpm.course.java8.streams.Pair;
import org.rapidpm.course.java8.streams.PairListGenerator;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_2 {
    public static void main(String[] args) {
        final List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();
        final Stream<DemoElement> demoElementStream = getDemoElementStream(generateDemoValues);


        final Stream<String> stringStream = getDemoElementStream(generateDemoValues)
                .map(v -> v.getValue());
        final Stream<String> stringStreamShort = getDemoElementStream(generateDemoValues)
                .map(DemoElement::getValue);

        //map from Point to DemoElements to Strings
        final List<String> stringList = generateDemoValues.stream().map(v -> {
            final String value = v.getValue();
            final DemoElement d = new DemoElement();
            d.setDatum(new Date());
            d.setValue(Base64.getEncoder().encodeToString(value.getBytes()));
            return d;
        })
                .map(DemoElement::getValue).collect(Collectors.toList());

        final Stream<Pair> filteredPairStream = generateDemoValues
                .stream().filter(v -> v.getId() % 2 == 0);

    }

    private static Stream<DemoElement> getDemoElementStream(List<Pair> generateDemoValues) {
        //map from Point to DemoElements
        return generateDemoValues.stream().map(v -> {
            final String value = v.getValue();
            final DemoElement d = new DemoElement();
            d.setDatum(new Date());
            d.setValue(Base64.getEncoder().encodeToString(value.getBytes()));
            return d;
        });
    }
}
