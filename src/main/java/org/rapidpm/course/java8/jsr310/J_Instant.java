package org.rapidpm.course.java8.jsr310;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class J_Instant {

    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("timestamp = " + timestamp);
        Instant oneHourLater = Instant.now().plusSeconds(60*60);

        LocalDateTime ldt = LocalDateTime.ofInstant(oneHourLater, ZoneId.systemDefault());
        System.out.println("ldt = " + ldt);

    }
}
