package org.rapidpm.course.java8.basics.inheritence01;

/**
 * Created by Sven Ruppert on 06.08.2014.
 */
public interface InterfaceC extends  InterfaceA {
  public default void doStdMethod(){
    System.out.println("doStdMethod - InterfaceC");
  }
}
