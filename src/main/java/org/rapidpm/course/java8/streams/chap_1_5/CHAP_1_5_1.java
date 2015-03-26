package org.rapidpm.course.java8.streams.chap_1_5;

import java.util.stream.IntStream;

/**
 * User: Sven Ruppert
 * Date: 03.12.13
 * Time: 13:22
 */
public class CHAP_1_5_1 {
    public static void main(String[] args) {
        for(int i = 0; i<1_000_000; i++){
            final boolean b = isPrime1(i) != isPrime2(i);
            if(b) System.out.println("ungleiches Ergebnis =  " + i);
        }
    }
    public static boolean isPrime1(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        return n >= 2 && IntStream
                .rangeClosed(2, (int) (Math.sqrt(n)))  //for(int i=3;i*i<=n;i+=2)
                .allMatch((d) -> n % d != 0);          //if(n%i==0) return false
    }

    public static boolean isPrime2(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
