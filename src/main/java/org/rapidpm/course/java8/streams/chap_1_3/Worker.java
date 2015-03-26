package org.rapidpm.course.java8.streams.chap_1_3;

import java.util.List;

/**
 * Created by Sven Ruppert on 09.11.13.
 */
public interface Worker {

    public static final int ANZAHL_KURVEN = 200;
    public static final int ANZAHL_MESSWERTE = 10;
    public static final int MAX_GENERATED_INT = 100;

    public abstract List<List<Integer>> generateDemoValueMatrix();

    public abstract List<List<Double>> generateInterpolatedValues(List<List<Integer>> baseValues);
}
