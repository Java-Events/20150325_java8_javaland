package org.rapidpm.course.java8.jsr310;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by ts40 on 31.03.2014.
 */
public class C_LocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, Month.APRIL, 3);
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println("nextWed = " + nextWed);

        DayOfWeek dotw = LocalDate.of(2014, Month.APRIL, 3).getDayOfWeek();
        System.out.println("dotw = " + dotw);

    }
}
