package org.rapidpm.course.java8.jsr310;

import java.time.Month;
import java.time.MonthDay;
import java.util.stream.IntStream;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class E_MonthDay {
    public static void main(String[] args) {
        MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
        boolean validLeapYear = date.isValidYear(2010);
        System.out.println("validLeapYear = " + validLeapYear);
        IntStream
                .rangeClosed(2010, 2015)
                .forEach(v->System.out.println("validLeapYear ("+v+") = " + date.isValidYear(v)));
    }
}
