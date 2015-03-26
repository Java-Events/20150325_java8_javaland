package org.rapidpm.course.java8.jsr310;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class A_DayOfWeek {
    public static void main(String[] args) {
        DayOfWeek dow = DayOfWeek.MONDAY;
        final DayOfWeek minus = dow.minus(2);
        System.out.println("minus = " + minus);

        Locale locale = Locale.getDefault();
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
    }
}
