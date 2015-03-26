package org.rapidpm.course.java8.basics.inheritence01.v003;


/**
 * Created by sven on 26.03.15.
 */
public class Main {
    public static void main(String[] args) {
        new DemoInterfaceA(){}.doWorkA();
        new DemoInterfaceB(){}.doWorkA();
        new DemoInterfaceB(){}.doWorkB();
        new DemoKlasseA().doWorkA();

        //DemoInterfaceA.huhu = "ups";
    }

    public interface DemoInterfaceA {

        public static final String CONST = "DemoInterfaceA.CONST";
        public static void doStaticWork(){
            System.out.println("DemoInterfaceA.doStaticWork");
        }

        public static String huhu = "";
        default void doWorkA(){ System.out.println("DemoInterfaceA.doWorkA"); }
        default void doWorkB(){ System.out.println("DemoInterfaceA.doWorkB"); }
    }
    public interface DemoInterfaceB extends DemoInterfaceA {
        default void doWorkA(){ System.out.println("DemoInterfaceB.doWorkA"); }

        public static void doStaticWork(){
            DemoInterfaceA.doStaticWork();
            System.out.println("DemoInterfaceA.doStaticWork");
        }
    }
    public interface DemoInterfaceC extends DemoInterfaceA {
        //default void doWorkA(){ System.out.println("DemoInterfaceC.doWorkA"); }

        public static void doStaticWork(){
            DemoInterfaceA.doStaticWork();
            System.out.println("DemoInterfaceC.doStaticWork");
        }
    }


    public class DemoKlasseB implements DemoInterfaceB, DemoInterfaceC {
        //public void doWorkA(){ System.out.println("DemoInterfaceC.doWorkA"); }



        //warum ?
//        public static void doStaticWork(){
//            DemoInterfaceA.doStaticWork();
//            System.out.println("DemoInterfaceC.doStaticWork");
//        }
    }

    public static class DemoKlasseA implements DemoInterfaceA{
        @Override
        public void doWorkA() {
            System.out.println("DemoKlasseA.doWorkA");
        }
    }

}
