package org.rapidpm.course.java8.lambdas.lesson1.jdk8.v1;

import org.rapidpm.course.java8.lambdas.lesson1.DemoAction;
import org.rapidpm.course.java8.lambdas.lesson1.Message;

/**
* Created by Sven Ruppert on 01.04.2014.
*/
public interface DemoActionAdapter extends DemoAction {
    int i = 0;

    public default void executeAction(Message message){
        System.out.println("DemoActionAdapter - executeAction - message = " + message);
    }
    public default void executeActionTwo(Message message){
        System.out.println("DemoActionAdapter - executeOther - message = " + message);
    }
}
