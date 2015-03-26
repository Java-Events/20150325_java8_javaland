package org.rapidpm.course.java8.streams.chap_1_3;


import org.rapidpm.course.java8.streams.DemoValueGenerator;
import org.rapidpm.course.java8.streams.WorkLoadGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public class WorkerParallelThreads implements Worker {

    @Override
    public List<List<Integer>> generateDemoValueMatrix() {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Task> taskList = new ArrayList<>();
        for(int i = 0; i< ANZAHL_KURVEN; i++){
            taskList.add(new Task());
        }
        for (final Task task : taskList) {
            task.run();
        }
        for (final Task task : taskList) {
            try {
                task.join();
                result.add(task.result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<List<Double>> generateInterpolatedValues(List<List<Integer>> baseValues) {
        final List<List<Double>> result = new ArrayList<>();
        final List<TaskInterpolate> taskList = new ArrayList<>();
        for (final List<Integer> baseValue : baseValues) {
            final TaskInterpolate taskInterpolate = new TaskInterpolate();
            taskInterpolate.values.addAll(baseValue);
            taskList.add(taskInterpolate);
        }
        for (final TaskInterpolate task : taskList) {
            task.run();
        }
        for (final TaskInterpolate task : taskList) {
            try {
                task.join();
                result.add(task.result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static class Task extends Thread {
        public List<Integer> result = new ArrayList<>();
        private DemoValueGenerator valueGenerator = new DemoValueGenerator(){};

        @Override
        public void run() {
            result.addAll(valueGenerator.generateDemoValuesForY());
        }
    }
    public static class TaskInterpolate extends Thread {
        public final List<Integer> values = new ArrayList<>();
        public final List<Double> result = new ArrayList<>();

        private final WorkLoadGenerator generator = new WorkLoadGenerator();

        @Override
        public void run() {
            result.addAll(generator.generate(values));
        }
    }
}
