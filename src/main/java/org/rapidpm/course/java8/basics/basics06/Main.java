package org.rapidpm.course.java8.basics.basics06;

/**
 * Created by Sven Ruppert on 24.09.2014.
 */
public class Main {

  public void doSomething() {
    System.out.print("Hello ");
    class Bar {
      Bar() {
        System.out.println("World");
      }
    }
    new Bar();
  }

  public static void main(String[] args) {
    new Main().doSomething();
  }

  class DemoKlasse {

  }
  static class DemoKlasseStatic {

  }

}

