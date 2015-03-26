package org.rapidpm.course.java8.lambdas.lesson0.b_lamdastart;

import java.util.Date;
import java.util.function.Function;

/**
 * Created by Sven Ruppert on 02.04.2014.
 */
public class Main {
    public static void doMore(DemoInterface d) {
        d.doSomething();
    }

    public static void printMe(){
        System.out.println("printMe");
    }

    public static void main(String[] args) {
        doMore(() -> {
                    System.out.println("new Date() = " + new Date());
                });

        doMore(() -> System.out.println("new Date() = " + new Date()));

        doMore(new DemoInterface() {
            @Override
            public void doSomething() {
                printMe();
            }
        });
        doMore(() -> {
            printMe();
        });
        doMore(() -> printMe());
        doMore(Main::printMe);

        doMore(new DemoInterface() {
            @Override
            public void doSomething() {
                System.out.println("+ new Date() = " + new Date());
            }
        });
    }
}
