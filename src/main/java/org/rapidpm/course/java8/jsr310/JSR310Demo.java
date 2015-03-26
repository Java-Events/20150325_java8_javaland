package org.rapidpm.course.java8.jsr310;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ts40 on 21.02.14.
 */
public class JSR310Demo {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("now = " + now);

        final Instant now001 = Instant.now(Clock.systemDefaultZone());

//        final LocalDate localDate001 = LocalDate.now(Clock.systemDefaultZone());
        final LocalDate localDate001 = LocalDate.of(2014, 9, 9);
        final LocalDate localDate002 = LocalDate.of(2014, 10, 10);
        final Period between = Period.between(localDate001, localDate002);
        System.out.println("between = " + between.getYears());
        System.out.println("between = " + between.getMonths());
        System.out.println("between = " + between.getDays());

//        between.getUnits().stream().forEach((v)->{System.out.println(v.getDuration().of);});

    }
}
