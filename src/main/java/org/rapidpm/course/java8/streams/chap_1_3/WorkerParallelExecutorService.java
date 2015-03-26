package org.rapidpm.course.java8.streams.chap_1_3;


import org.rapidpm.course.java8.streams.DemoValueGenerator;
import org.rapidpm.course.java8.streams.WorkLoadGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public class WorkerParallelExecutorService implements Worker {

    private final ExecutorService executorService;

    public WorkerParallelExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public List<List<Integer>> generateDemoValueMatrix() {
        final List<Task> taskList = new ArrayList<>();
        for(int i = 0; i< ANZAHL_KURVEN; i++){
            taskList.add(new Task());
        }

        final List<List<Integer>> result = new ArrayList<>();
        try {
            final List<Future<List<Integer>>> futureList = executorService.invokeAll(taskList);
            for (final Future<List<Integer>> future : futureList) {
                final List<Integer> valueList = future.get();
                result.add(valueList);
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<List<Double>> generateInterpolatedValues(List<List<Integer>> baseValues) {
        final List<TaskInterpolate> taskList = new ArrayList<>();
        for (final List<Integer> baseValue : baseValues) {
            final TaskInterpolate taskInterpolate = new TaskInterpolate();
            taskInterpolate.values.addAll(baseValue);
            taskList.add(taskInterpolate);
        }

        final List<List<Double>> result = new ArrayList<>();
        try {
            final List<Future<List<Double>>> futureList = executorService.invokeAll(taskList);
            for (final Future<List<Double>> future : futureList) {
                final List<Double> valueList = future.get();
                result.add(valueList);
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static class Task implements Callable<List<Integer>> {
        private DemoValueGenerator valueGenerator = new DemoValueGenerator(){};

        @Override
        public List<Integer> call() {
            final List<Integer> result = new ArrayList<>();
            result.addAll(valueGenerator.generateDemoValuesForY());
            return result;
        }
    }


    public static class TaskInterpolate implements Callable<List<Double>>  {
        public final List<Integer> values = new ArrayList<>();
        public final List<Double> result = new ArrayList<>();

        private final WorkLoadGenerator generator = new WorkLoadGenerator();

        @Override
        public List<Double> call() {
            result.addAll(generator.generate(values));
            return result;
        }
    }
}
