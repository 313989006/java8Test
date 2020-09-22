package test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/*
 * @Author liuyang
 * @Description : Java8时间$
 * @Title : Java8时间$
 * @Date 2020/9/13 21:35
 **/
public class JavaEightDate {
    /**
     * LocalDate、LocalTime、LocalDateTime
     */
    @Test
    public void test(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());
        System.out.println(localDateTime.plusDays(2));
        System.out.println(localDateTime.plusYears(1));
        System.out.println(localDateTime.minusYears(1));
    }

    /**
     * Instant
     */
    @Test
    public void test1(){
        Instant instant = Instant.now();
        /**
         * 时差偏移计算加8小时
         */
        OffsetDateTime instant1 = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant);
        System.out.println(instant1);
    }

    /**
     * Duration操作 计算时间范围值
     */
    @Test
    public void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Duration duration = Duration.between(localDateTime,localDateTime1);
        System.out.println(duration.getNano());
    }

    /**
     * Period操作 计算日期范围
     */
    @Test
    public void test3(){
        LocalDate localDate = LocalDate.of(2020,1,1);
        LocalDate localDate1 = LocalDate.of(2020,9,1);
        Period period = Period.between(localDate,localDate1);
        System.out.println(period.getMonths());
    }

    /**
     * 时间校正器-TemporalAdjusters
     */
    @Test
    public void test4(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        // 本年本月最后一天
        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfMonth()));
        // 本年本月第一天
        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
        // 本年下一月第一天
        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));
        // 下一年第一天
        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfNextYear()));
        // 本年最后一天
        System.out.println(localDateTime.with(TemporalAdjusters.lastDayOfYear()));
        // 下一个周五
        System.out.println(localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        // 本月第一个周五
        System.out.println(localDateTime.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));
        // 本月最后一个周五
        System.out.println(localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
        // 下一个周五，如果当前是周五则返回当前时间
        System.out.println(localDateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));
        // 前一个周五
        System.out.println(localDateTime.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
        // 前一个周五，如果当前是周五则返回当前时间
        System.out.println(localDateTime.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY)));
    }

    /**
     * DateTimeFormatter
     * SimpleDateFormat
     */
    @Test
    public void test5(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String strLocalDate = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(strLocalDate);
        String localDate1 = LocalDate.parse("2020-09-14").format(dateTimeFormatter);
        System.out.println(localDate1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = simpleDateFormat.format(new Date());
        System.out.println(str);
    }

}
