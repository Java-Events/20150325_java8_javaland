package org.rapidpm.course.java8.jsr310;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class O_Period_Duration {
    public static void main(String[] args) {
        final Instant t1 = Instant.now();
        final Instant t2 = t1.plusSeconds(10);

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        final Duration between = Duration.between(t1, t2);
        final long seconds = between.getSeconds();
        System.out.println("seconds = " + seconds);


        System.out.println(ChronoUnit.SECONDS.between(t2, t1));

        final LocalDate d1 = LocalDate.of(2010, 10, 10);
        final LocalDate d2 = LocalDate.of(2011, 10, 10);

        final Period period = Period.between(d1, d2);
        System.out.println("period = " + period);
        System.out.println("total years " + period.getYears());
        System.out.println("total month " + period.getMonths());
        System.out.println("total days  " + period.getDays());
        System.out.println("total month " + period.toTotalMonths());

    }
}
