package org.rapidpm.course.java8.jsr310;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sven Ruppert on 01.04.2014.
 */
public class R_LegacyCode {
    public static void main(String[] args) {
        Instant inst = new Date().toInstant();
        Date newDate = Date.from(inst);

        final Instant now = Calendar.getInstance().toInstant();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
    }
}
