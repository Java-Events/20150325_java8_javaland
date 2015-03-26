package org.rapidpm.course.java8.basics.functionalinterfaces;

/**
 * Created by sven on 26.03.15.
 */
public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker() {
            @Override
            public void doWorkB() { }
            @Override
            public void doWorkC() {}
        };

        Worker worker1 = () -> {};

        worker.doWorkA();
        worker.doWorkB();
        worker.doWorkC();

        new AbstractWorker() {
            @Override
            public void hups() {

            }
        };
        //AbstractWorker abstractWorker = () -> {};
    }

    public static abstract class AbstractWorker {
        public abstract void hups();
    }


    @FunctionalInterface
    public static interface Worker{
        public default void doWorkA(){System.out.println("Worker.doWorkA");}
        public default void doWorkB(){System.out.println("Worker.doWorkB");}
        public  void doWorkC();
    }

}
