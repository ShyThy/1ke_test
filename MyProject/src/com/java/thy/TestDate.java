package com.java.thy;

import java.time.*;

/**
 * @auther Administrator TianHangYu
 * @create 2017-08-30
 */
public class TestDate {
    public static final void main(String args[]) throws InterruptedException {
//        test1();
//        test2();
        test3();
    }

    private static void test3(){
        final LocalDateTime from = LocalDateTime.of(2017, Month.FEBRUARY, 10, 23, 59);
        final LocalDateTime to = LocalDateTime.of(2017, 4, 26, 13, 11);
        final Duration duration = Duration.between(from, to);
        System.err.println("Duration in days : " + duration.toDays());
        System.err.println("Duration in hous : " + duration.toHours());
    }

    private static void test1() throws InterruptedException {
//        final Clock clock = Clock.systemDefaultZone();
        final Clock clock = Clock.systemUTC();

        System.err.println(clock.instant());
        System.err.println(clock.millis());
//        Thread.sleep(3000);
//        System.err.println(clock.millis());
    }

    private static void test2() {
        final Clock clock = Clock.systemUTC();
        final LocalDate localDate = LocalDate.now();
        final LocalDate ldFromClock = LocalDate.now(clock);
        System.err.println(localDate);
        System.err.println(ldFromClock);

        final LocalTime localTime = LocalTime.now();
        final LocalTime localTimeFromClock = LocalTime.now(clock);
        System.err.println(localTime);
        System.err.println(localTimeFromClock);

        final LocalDateTime localDateTime = LocalDateTime.now();
        final LocalDateTime localDateTimeFromClock = LocalDateTime.now(clock);
        System.err.println(localDateTime);
        System.err.println(localDateTimeFromClock);

        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.err.println(zonedDateTime);
        System.err.println(zonedDateTimeFromClock);
        System.err.println(zonedDateTimeFromZone);
    }
}
