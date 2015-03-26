package org.rapidpm.course.java8.streams.chap_1_3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.rapidpm.course.java8.streams.TimeCounter;
import org.rapidpm.course.java8.streams.TimeCounterFormatter;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sven Ruppert on 08.11.13.
 */
public class CHAP_1_3 extends Application {
    public static final ExecutorService executorService = Executors.newCachedThreadPool();

    private static final int WARMUP_COUNT = 1000;
    private static final int CROP_COUNT = 10;
    private static final boolean CROP_FIRST = true;

    public static void main(String[] args) {
        launch(args);
    }

    public static List<ChartValue> warmUp(final String prefix, final Worker worker) {
        final List<ChartValue> result = new ArrayList<>();

        for (int i = 0; i < WARMUP_COUNT; i++) {
            System.out.print(prefix);

            final long deltaT = ((TimeCounter) () -> {
                final List<List<Integer>> demoValueMatrix = worker.generateDemoValueMatrix();
                final List<List<Double>> interpolatedValues = worker.generateInterpolatedValues(demoValueMatrix);
                System.out.print(" -> size() = " + interpolatedValues.size() + "  -> ");
            }).execute();

            new TimeCounterFormatter(deltaT).printAsNanoSec();

            //add Value to Chart
            if(CROP_FIRST){
                if(CROP_COUNT >= i){
                    //noop
                } else{
                    final ChartValue chartValue = new ChartValue(i, deltaT );
                    result.add(chartValue);
                }
            } else{
                    final ChartValue chartValue = new ChartValue(i, deltaT );
                    result.add(chartValue);
            }

        }
        return result;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Time used for Worker");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Rounds");
        final LineChart lineChart = new LineChart(xAxis, yAxis);

        lineChart.setTitle("Time used for Worker");

        final Scene scene = new Scene(lineChart, 800, 600);
        final ObservableList<XYChart.Series> data = lineChart.getData();

        data.add(createNextSeries("Serial", warmUp("Serial", new WorkerSerial())));
        data.add(createNextSeries("Threads", warmUp("Threads", new WorkerParallelThreads())));
        data.add(createNextSeries("ExecutorService", warmUp("ExecutorService", new WorkerParallelExecutorService(executorService))));
        data.add(createNextSeries("Streams", warmUp("Streams", new WorkerParallelStreams())));
        data.add(createNextSeries("WorkerJDK8", warmUp("WorkerJDK8", new WorkerJDK8(){})));

        stage.setScene(scene);
        stage.show();
    }

    private XYChart.Series createNextSeries(String prefix, List<ChartValue> serial) {
        final XYChart.Series nextSeries = new XYChart.Series();
        nextSeries.setName(prefix);
        for (final ChartValue chartValue : serial) {
            final XYChart.Data point = new XYChart.Data(chartValue.getX(), chartValue.getY());
            nextSeries.getData().add(point);
        }
        return nextSeries;
    }


    public static class ChartValue {
        public double x;
        public double y;

        public ChartValue(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final ChartValue other = (ChartValue) obj;
            return Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ChartValue{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }


}
