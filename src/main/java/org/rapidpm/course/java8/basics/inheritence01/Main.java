package org.rapidpm.course.java8.basics.inheritence01;


import static org.rapidpm.course.java8.basics.inheritence01.InterfaceA.doSomethingStaticA;
import static org.rapidpm.course.java8.basics.inheritence01.InterfaceA.doSomethingStaticB;

/**
 * Created by Sven Ruppert on 06.08.2014.
 */
public class Main {

  public static void main(String[] args) {
    final AImpl a = new AImpl();
    a.doSomethingA();
    a.doSomethingB();

    doSomethingStaticA();
    doSomethingStaticB();

    a.doStdMethod();


    final BImpl b = new BImpl();
    b.doStdMethod();

  }
}
