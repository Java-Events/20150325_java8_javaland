package org.rapidpm.course.java8.lambdas.lesson1.jdk8.v2;

import org.rapidpm.course.java8.lambdas.lesson1.DemoAction;
import org.rapidpm.course.java8.lambdas.lesson1.Message;

import java.util.function.Consumer;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public interface DemoServiceMixin {

    public default void addDemoActionConsumer(Consumer<Message> c){
        addDemoAction(new DemoActionAdapter() {
            public void executeAction(Message m) {
                c.accept(m);
            }
        });
    }

    public default void addDemoActionTwoConsumer(Consumer<Message> c){
        addDemoActionEndOfList(new DemoActionAdapter() {
            public void executeActionTwo(Message m) {
                c.accept(m);
            }
        });
    }

    //baugleich zum original interface ohne Vererbung
    public void addDemoAction(DemoAction action);
    public void addDemoActionEndOfList(DemoAction action);

    public interface DemoActionAdapter extends DemoAction {
        public default void executeAction(Message message){
            System.out.println("DemoActionAdapter - executeAction - message = " + message);
        }
        public default void executeActionTwo(Message message){
            System.out.println("DemoActionAdapter - executeOther - message = " + message);
        }
    }
}
