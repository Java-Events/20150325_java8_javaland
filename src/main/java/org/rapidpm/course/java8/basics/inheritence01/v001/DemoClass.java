package org.rapidpm.course.java8.basics.inheritence01.v001;

import java.time.Instant;

/**
 * Created by sven on 26.03.15.
 */
public class DemoClass implements DemoClassInterface{

    public String doWork(){
        return Instant.now()+"";
    }


}
