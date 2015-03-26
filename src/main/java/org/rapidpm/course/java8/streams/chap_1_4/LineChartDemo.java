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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 04.11.13.
 */
public class LineChartDemo extends Application {

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
        final List<XYChart.Series> chartSeries = getValuesForSeries()
                .parallelStream()
                .map(v -> {
                    final XYChart.Series nextSeries = new XYChart.Series();
                    int i = 0;
                    for (final Double valueForY : v) {
                        final XYChart.Data data = new XYChart.Data(i, valueForY);
                        nextSeries.getData().add(data);
                        i = i + 1;
                    }
                    return nextSeries;
                }).collect(Collectors.toList());

        return chartSeries;
    }


    private List<List<Double>> getValuesForSeries() {
        final List<List<Integer>> demoValueMatrix = generateDemoValueMatrix();
        final List<List<Double>> collect = demoValueMatrix
                .parallelStream()
                .map(v -> {
                    final UnivariateFunction interpolateFunction = createInterpolateFunction(v);
                    //baue Kurve auf
                    final int anzahlValuesInterpolated = (v.size()-1) * STEP_SIZE;
                    final List<Double> result = new ArrayList<>();
                    for (int i = 0; i < anzahlValuesInterpolated-1; i++) {
                        final double valueForY = interpolateFunction.value(i);
                        result.add(valueForY);
                    }
                    return result;
                })
                .collect(Collectors.toList());
        return collect;
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
        return Stream
                .generate(this::generateDemoValuesForY)
                .limit(ANZAHL_KURVEN)              //Anzahl Kurven
                .collect(Collectors.toList());
    }

    public List<Integer> generateDemoValuesForY(){
        final Random random = new Random();
        return Stream
                .generate(() -> random.nextInt(100))
                .limit(10)         //Messwerte in 10er Schritten
                .collect(Collectors.toList());
    }

}
