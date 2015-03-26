package org.rapidpm.course.java8.jsr310;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.IsoFields;

import static java.time.temporal.ChronoField.CLOCK_HOUR_OF_DAY;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class L_ChronoField_ISOField {
    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        System.out.println("LocalDate-CLOCK_HOUR_OF_DAY = " + now.isSupported(CLOCK_HOUR_OF_DAY));
        System.out.println("LocalDate-DAY_OF_WEEK = " + now.isSupported(DAY_OF_WEEK));

        final LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime-CLOCK_HOUR_OF_DAY = " + localDateTime.isSupported(CLOCK_HOUR_OF_DAY));
        System.out.println("localDateTime-DAY_OF_WEEK = " + localDateTime.isSupported(DAY_OF_WEEK));

        final int i = now.get(IsoFields.QUARTER_OF_YEAR);
        System.out.println("QUARTER_OF_YEAR = " + i);

    }
}
