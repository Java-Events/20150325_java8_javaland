package org.rapidpm.course.java8.jsr310;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public class P_Clock {
    public static void main(String[] args) {
        final Clock clock = Clock.systemDefaultZone();
        final ZoneId zone = clock.getZone();
        System.out.println("zone = " + zone);
        final Instant instant = clock.instant();
        System.out.println("instant = " + instant);

        final Clock fixed = Clock.fixed(instant, zone);
        System.out.println("fixed.instant() = " + fixed.instant());
        System.out.println("fixed.instant() = " + fixed.instant());
        System.out.println("fixed.instant() = " + fixed.instant());
    }
}
