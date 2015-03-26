package org.rapidpm.course.java8.jsr310;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class F_LocalTime {
    public static void main(String[] args) {
        LocalTime thisSec = LocalTime.now();
        final LocalDateTime localDateTime = thisSec
                .atDate(LocalDate.of(1999, Month.JANUARY, 4));

        System.out.println("thisSec.getHour() = " + thisSec.getHour());
        System.out.println("thisSec.getMinute() = " + thisSec.getMinute());
    }
}
