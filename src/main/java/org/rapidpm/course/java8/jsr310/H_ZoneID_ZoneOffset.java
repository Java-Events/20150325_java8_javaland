package org.rapidpm.course.java8.jsr310;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class H_ZoneID_ZoneOffset {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("dt = " + dt);

        final ZoneId zoneId = ZoneId.systemDefault();
        final ZonedDateTime zonedDateTimeLocal = dt.atZone(zoneId);
        System.out.println("zonedDateTimeLocal = " + zonedDateTimeLocal);
        //Australia/Darwin     +09:30
        final ZoneId zoneIdAU = ZoneId.of("Australia/Darwin");
        final ZonedDateTime zonedDateTimeAU = dt.atZone(zoneIdAU);
        System.out.println("zonedDateTimeAU    = " + zonedDateTimeAU);
        final ZoneOffset offset = zonedDateTimeAU.getOffset();
        System.out.println("offset = " + offset);
    }
}
