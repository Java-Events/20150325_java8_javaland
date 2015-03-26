package org.rapidpm.course.java8.lambdas.lesson1.jdk8.v2;

import org.rapidpm.course.java8.lambdas.lesson1.Message;

/**
 * Created by ts40 on 01.04.2014.
 */
public class MainJDK8 {
    public static void main(String[] args) {
        DemoService service = new DemoService();
        service.addDemoActionConsumer((a) -> System.out.println("a = " + a));
        service.addDemoActionConsumer((a) -> System.out.println("b = " + a));
        service.addDemoActionTwoConsumer((a) -> System.out.println("action two = " + a));

        final Message msg = new Message("hello JDK 8");
        service.execute(msg);
        service.executeActionTwo(msg);
    }

}
