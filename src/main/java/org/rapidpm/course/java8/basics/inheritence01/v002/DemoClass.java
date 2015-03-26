package org.rapidpm.course.java8.basics.inheritence01.v002;

import java.time.Instant;

/**
 * Created by sven on 26.03.15.
 */
public interface DemoClass {

    public default String doWork() {
        return Instant.now()+"";
    }
}
