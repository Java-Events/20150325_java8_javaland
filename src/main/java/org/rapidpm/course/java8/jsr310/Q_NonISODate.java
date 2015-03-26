package org.rapidpm.course.java8.jsr310;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public class Q_NonISODate {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        JapaneseDate jdate = JapaneseDate.from(date);
        System.out.println("jdate = " + jdate);
        HijrahDate hdate = HijrahDate.from(date);
        System.out.println("hdate = " + hdate);
    }
}
