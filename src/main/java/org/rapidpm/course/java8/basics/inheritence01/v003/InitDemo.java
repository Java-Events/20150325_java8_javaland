package org.rapidpm.course.java8.basics.inheritence01.v003;

/**
 * Created by sven on 26.03.15.
 */
public class InitDemo {


    {
        System.out.println("InitDemo.non-static A ");
    }

    {
        System.out.println("InitDemo.non-static B ");
    }
    static {
        System.out.println("InitDemo.static A ");
    }

    static {
        System.out.println("InitDemo.static B ");
    }



    public InitDemo() {
        System.out.println("InitDemo.constructor ");
    }

    public static void main(String[] args) {
        new InitDemo();
    }
}
