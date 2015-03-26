package org.rapidpm.course.java8.streams.chap_1_5;


import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 18.11.13.
 */
public class CHAP_1_5_2 {


    /**
     *         final Stream<Long> fibStream = makeFibStream(10);
     fibStream.forEachOrdered(System.out::println);

     System.out.println("isPrime(7) = " + isPrime1(7));
     System.out.println("isPrimeOld(7) = " + isPrime2(7));
     * @param args
     */

    public static void main(String[] args) {
        final Stream<Long> fibStream = makeFibStream(10);
        fibStream.forEachOrdered(System.out::println);
    }


    public static Stream<Long> makeFibStream() {
        return(Stream.generate(new FibonacciSupplier()));
    }
    public static Stream<Long> makeFibStream(int numFibs) {
        return(makeFibStream().limit(numFibs));
    }
    public static List<Long> makeFibList(int numFibs) {
        return(makeFibStream(numFibs).collect(Collectors.toList()));
    }

    public static class FibonacciSupplier implements Supplier<Long> {
        private long previous = 0;
        private long current = 1;
        @Override
        public Long get() {
            long next = current + previous;
            previous = current;
            current = next;
            return(previous);
        }
    }

}