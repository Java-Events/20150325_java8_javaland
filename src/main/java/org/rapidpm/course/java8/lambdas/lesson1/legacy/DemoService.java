package org.rapidpm.course.java8.lambdas.lesson1.legacy;

import org.rapidpm.course.java8.lambdas.lesson1.DemoAction;
import org.rapidpm.course.java8.lambdas.lesson1.DemoServiceInterface;
import org.rapidpm.course.java8.lambdas.lesson1.Message;

import java.util.LinkedList;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public class DemoService implements DemoServiceInterface {

    private LinkedList<DemoAction> actionList = new LinkedList<>();

    @Override
    public void addDemoAction(DemoAction action) {
        actionList.addFirst(action);
    }
    @Override
    public void addDemoActionEndOfList(DemoAction action) {
        actionList.addLast(action);
    }


    @Override
    public void execute(Message msg) {
        for (DemoAction demoAction : actionList) {
            demoAction.executeAction(msg);
        }
    }

    @Override
    public void executeActionTwo(Message msg) {
        for (DemoAction demoAction : actionList) {
            demoAction.executeActionTwo (msg);
        }
    }

}
