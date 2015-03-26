package org.rapidpm.course.java8.jsr310;

import java.time.Month;
import java.time.YearMonth;

/**
 * Created by Sven Ruppert on 31.03.2014.
 */
public class D_YearMonth {
    public static void main(String[] args) {
        YearMonth date = YearMonth.now();
        //2014-03: 31
        System.out.printf("%s: %d%n", date, date.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
        //2010-02: 28
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        //2012-02: 29
        YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());
    }
}
