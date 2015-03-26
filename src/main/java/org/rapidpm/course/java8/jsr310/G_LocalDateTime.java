package org.rapidpm.course.java8.jsr310;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * Created by ts40 on 31.03.2014.
 */
public class G_LocalDateTime {
    public static void main(String[] args) {
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));
    }
}
