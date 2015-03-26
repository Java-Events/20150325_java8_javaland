package org.rapidpm.course.java8.basics.inheritence01;

/**
 * Created by Sven Ruppert on 06.08.2014.
 */
public interface InterfaceA {

  public static void doSomethingStaticA(){
    System.out.println("doSomethingStaticA");
  }

  public static void doSomethingStaticB(){
    System.out.println("doSomethingStaticB");
  }

  public void doSomethingA();  //existiert eine Std Implementierung
  public void doSomethingB();

  public default void doStdMethod(){
    System.out.println("doStdMethod");
  }


}
