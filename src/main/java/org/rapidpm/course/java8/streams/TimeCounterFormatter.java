package org.rapidpm.course.java8.streams;

import java.text.NumberFormat;

/**
 * Created by Sven Ruppert on 11.11.13.
 */
public class TimeCounterFormatter {

    private final long deltaT;

    public TimeCounterFormatter(long deltaT) {
        this.deltaT = deltaT;
    }


    public long asNanoSec(){
        return deltaT;
    }

    public long asMucroSec(){
        return deltaT/1000;
    }

    public long asMilliSec(){
        return deltaT/1000/1000;
    }

    public void printAsMilliSec(){
        System.out.println("time = " + NumberFormat.getIntegerInstance().format(asMilliSec()) + " [ms]");
    }
    public void printAsMucroSec(){
        System.out.println("time = " + NumberFormat.getIntegerInstance().format(asMucroSec()) + " [us]");
    }
    public void printAsNanoSec(){
        System.out.println("time = " + NumberFormat.getIntegerInstance().format(asNanoSec()) + " [ns]");
    }


}
