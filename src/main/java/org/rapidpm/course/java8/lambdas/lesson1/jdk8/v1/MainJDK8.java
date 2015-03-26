package org.rapidpm.course.java8.lambdas.lesson1.jdk8.v1;
import org.rapidpm.course.java8.lambdas.lesson1.Message;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public class MainJDK8 {
    public static void main(String[] args) {
        DemoService service = new DemoService();
        service.addDemoAction(new DemoActionAdapter(){
            @Override
            public void executeAction(Message message) {
                System.out.println("executeAction message A = " + message);
            }
        });
        service.addDemoAction(new DemoActionAdapter(){
            @Override
            public void executeAction(Message message) {
                System.out.println("executeAction message B = " + message);
            }
        });

        final Message msg = new Message("hello JDK 8");
        service.execute(msg);
        service.executeActionTwo(msg);
    }

}
