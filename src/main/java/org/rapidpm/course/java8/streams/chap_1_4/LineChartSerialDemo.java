package org.rapidpm.course.java8.streams.chap_1_4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sven Ruppert on 06.11.13.
 */
public class LineChartSerialDemo extends Application {

    private static final int STEP_SIZE = 100;
    private static final int ANZAHL_KURVEN = 200;

    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample Extended");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Steps");
        final LineChart lineChart = new LineChart(xAxis,yAxis);

        lineChart.setTitle("Demovalues");

        Scene scene  = new Scene(lineChart,800,600);

        for(int i=0; i<10;i++){
            final long start = System.nanoTime();
            final List<XYChart.Series> serieses = generateNextSeries();
            final long stop = System.nanoTime();
            System.out.println("serieses.size() = " + serieses.size());
            System.out.println("dt = " + NumberFormat.getIntegerInstance().format(stop - start));
        }

        final long start = System.nanoTime();
        final List<XYChart.Series> serieses = generateNextSeries();
        final long stop = System.nanoTime();

        System.out.println("dt = " + NumberFormat.getIntegerInstance().format(stop - start));
        final ObservableList<XYChart.Series> data = lineChart.getData();
        data.addAll(serieses);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
    private List<XYChart.Series> generateNextSeries(){
        final List<XYChart.Series> result = new ArrayList<>();
        final List<List<Double>> valuesForSeries = getValuesForSeries();
        for (final List<Double> valuesForSery : valuesForSeries) {
            final XYChart.Series nextSeries = new XYChart.Series();
            int i = 0;
            for (final Double valueForY : valuesForSery) {
                final XYChart.Data data = new XYChart.Data(i, valueForY);
                nextSeries.getData().add(data);
                i = i + 1;
            }
            result.add(nextSeries);
        }
        return result;
    }

    private List<List<Double>> getValuesForSeries() {
        final List<List<Double>> result = new ArrayList<>();
        final List<List<Integer>> demoValueMatrix = generateDemoValueMatrix();
        for (final List<Integer> v : demoValueMatrix) {
            final UnivariateFunction interpolateFunction = createInterpolateFunction(v);
            final int anzahlValuesInterpolated = (v.size()-1) * STEP_SIZE;
            final List<Double> resultStep = new ArrayList<>();
            for (int i = 0; i < anzahlValuesInterpolated-1; i++) {
                final double valueForY = interpolateFunction.value(i);
                resultStep.add(valueForY);
            }
            result.add(resultStep);
        }
        return result;
    }






    private UnivariateFunction createInterpolateFunction(final List<Integer> values){

        final double[] valueArrayX = new double[values.size()];
        for (int i = 0; i < valueArrayX.length; i++) {
            valueArrayX[i] = (double)i* STEP_SIZE;
        }

        final double[] valueArrayY = new double[values.size()];
        int i=0;
        for (final Integer value : values) {
            valueArrayY[i] = (double) value.intValue();
            i= i+1;
        }

        final UnivariateInterpolator interpolator = new SplineInterpolator();
        final UnivariateFunction function = interpolator.interpolate(valueArrayX, valueArrayY);
        return function;
    }


    public List<List<Integer>> generateDemoValueMatrix(){
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< ANZAHL_KURVEN; i++){
            final List<Integer> generatedDemoValuesForY = generateDemoValuesForY();
            result.add(generatedDemoValuesForY);
        }
        return result;
    }

    public List<Integer> generateDemoValuesForY(){
        final Random random = new Random();
        final List<Integer> result = new ArrayList<>();
        for(int i = 0; i<10;i++){
            result.add(random.nextInt(100));
        }
        return result;
    }

}
