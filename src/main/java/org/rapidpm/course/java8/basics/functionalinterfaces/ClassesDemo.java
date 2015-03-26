package org.rapidpm.course.java8.basics.functionalinterfaces;

/**
 * Created by sven on 26.03.15.
 */
public class ClassesDemo {





    public class InnerClassNonStatic{
        public void printMe(){
            System.out.println("InnerClassNonStatic.printMe");
        }
    }
    public static class InnerClass{
        public void printMe(){
            System.out.println("InnerClass.printMe");
        }
    }

    public static void main(String[] args) {
        new InnerClass().printMe();
    }
}
