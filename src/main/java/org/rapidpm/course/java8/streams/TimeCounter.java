package org.rapidpm.course.java8.streams;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public interface TimeCounter {

    public abstract void doIt();

    public default long execute(){
        final long start = System.nanoTime();
        doIt();
        final long stop = System.nanoTime();
        return (stop - start);
    }

}
