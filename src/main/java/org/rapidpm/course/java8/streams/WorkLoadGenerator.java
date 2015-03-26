package org.rapidpm.course.java8.streams;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven Ruppert on 12.11.13.
 */
public class WorkLoadGenerator {


    public static final int STEP_SIZE = 100;

    private UnivariateFunction createInterpolateFunction(final List<Integer> values) {
        final double[] valueArrayX = new double[values.size()];
        for (int i = 0; i < valueArrayX.length; i++) {
            valueArrayX[i] = (double) i * STEP_SIZE;
        }

        final double[] valueArrayY = new double[values.size()];
        int i = 0;
        for (final Integer value : values) {
            valueArrayY[i] = (double) value.intValue();
            i = i + 1;
        }

        final UnivariateInterpolator interpolator = new SplineInterpolator();
        final UnivariateFunction function = interpolator.interpolate(valueArrayX, valueArrayY);
        return function;
    }

    public List<Double> generate(final List<Integer> v) {
        final UnivariateFunction interpolateFunction = createInterpolateFunction(v);
        //baue Kurve auf
        final int anzahlValuesInterpolated = (v.size() - 1) * STEP_SIZE;
        final List<Double> result = new ArrayList<>();
        for (int i = 0; i < anzahlValuesInterpolated - 1; i++) {
            final double valueForY = interpolateFunction.value(i);
            result.add(valueForY);
        }
        return result;
    }

}
