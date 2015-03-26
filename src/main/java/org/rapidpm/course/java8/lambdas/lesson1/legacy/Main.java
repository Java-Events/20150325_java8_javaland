package org.rapidpm.course.java8.lambdas.lesson1.legacy;

import org.rapidpm.course.java8.lambdas.lesson1.DemoAction;
import org.rapidpm.course.java8.lambdas.lesson1.DemoServiceInterface;
import org.rapidpm.course.java8.lambdas.lesson1.Message;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public class Main {

    public static void main(String[] args) {

        DemoServiceInterface demoService = new DemoService();

        demoService.addDemoAction(new DemoAction() {
            @Override
            public void executeAction(Message message) {
                System.out.println("001 - message.getMsg() = " + message.getMsg());
            }

            @Override
            public void executeActionTwo(Message message) {

            }

        });
        demoService.addDemoAction(new DemoAction() {
            @Override
            public void executeAction(Message message) {
                System.out.println("002 - message.getMsg() = " + message.getMsg());
            }

            @Override
            public void executeActionTwo(Message message) {

            }

        });
        demoService.addDemoAction(new DemoAction() {
            @Override
            public void executeAction(Message message) {
                System.out.println("003 - message.getMsg() = " + message.getMsg());
            }

            @Override
            public void executeActionTwo(Message message) {

            }

        });

        demoService.execute(new Message("Hello Legacy Service"));
        demoService.executeActionTwo(new Message("Hello Legacy Service"));

    }
}
