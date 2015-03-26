package org.rapidpm.course.java8.jsr310;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class K_Parsing_Formatting {
    public static void main(String[] args) {
        final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy  hh:mm a");

        final ZonedDateTime zonedDayTimeNow = ZonedDateTime.now();
        final String out = zonedDayTimeNow.format(format);
        System.out.println("now = " + out);

        final LocalDate localDate = LocalDate.parse(out, format);
        System.out.println("localDate = " + localDate);
    }
}
