package org.rapidpm.course.java8.jsr310;

import java.time.*;
import java.time.temporal.*;

import static java.time.DayOfWeek.MONDAY;
import static java.time.LocalDate.of;
import static java.time.Month.APRIL;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class N_TemporalQueries {
    public static void main(String[] args) {
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n",
                LocalDate.now().query(query));
        System.out.printf("LocalDateTime precision is %s%n",
                LocalDateTime.now().query(query));
        System.out.printf("Year precision is %s%n",
                Year.now().query(query));
        System.out.printf("YearMonth precision is %s%n",
                YearMonth.now().query(query));
        System.out.printf("Instant precision is %s%n",
                Instant.now().query(query));

        final TemporalQuery<Boolean> temporalQuery = v -> {
            final int i = v.get(ChronoField.DAY_OF_WEEK);
            if (MONDAY.getValue() == i) return Boolean.TRUE;
            else return Boolean.FALSE;
        };

        final Boolean isApril6Mon = of(2014, APRIL, 6).query(temporalQuery);
        final Boolean isApril7Mon = of(2014, APRIL, 7).query(temporalQuery);
        System.out.println("isApril6Mon = " + isApril6Mon);
        System.out.println("isApril7Mon = " + isApril7Mon);

    }

    public static class MyTemporalQuery implements TemporalQuery<Boolean>{
        @Override
        public Boolean queryFrom(TemporalAccessor temporal) {
            final int i = temporal.get(ChronoField.DAY_OF_WEEK);
            if (MONDAY.getValue() == i) return Boolean.TRUE;
            else return Boolean.FALSE;
        }
    }

}
