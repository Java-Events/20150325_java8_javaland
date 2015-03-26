package org.rapidpm.course.java8.lambdas.lesson1;

/**
 *
 * Legacy Interface - veraendern nicht moeglich
 *
 * Created by Sven Ruppert on 01.04.2014.
 */
public interface DemoServiceInterface {
    public void addDemoAction(DemoAction action);
    public void addDemoActionEndOfList(DemoAction action);
    public void execute(Message msg);
    public void executeActionTwo(Message msg);
}
