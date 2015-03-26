package org.rapidpm.course.java8.jsr310;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by ts40 on 31.03.2014.
 */
public class I_OffsetDate_Time {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(2014, Month.APRIL, 20, 19, 30);
        ZoneOffset offset = ZoneOffset.of("-02:00");
        OffsetDateTime dateOffset = OffsetDateTime.of(date, offset);
        OffsetDateTime lastThursday =
                dateOffset.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        System.out.printf("The last Thursday in April 2014 is the %sth.%n",
                lastThursday.getDayOfMonth());
    }
}
