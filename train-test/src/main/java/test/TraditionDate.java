package test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*
 * @Author liuyang
 * @Description : 传统时间$
 * @Title : 传统时间$
 * @Date 2020/9/13 21:34
 **/
public class TraditionDate {

    /**
     * Date
     */
    @Test
    public void test(){
        Date date = new Date(2020,9,13,21,47);
        System.out.println(date);
        System.out.println(date.getTime());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Date date1 = new Date();
        System.out.println(date1);
        System.out.println(date1.getTime());
    }


    /**
     * Calendar
     */
    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeZone().getID());

        TimeZone itTimeZone = TimeZone.getTimeZone("Europe/Rome");
        calendar.setTimeZone(itTimeZone);
        System.out.println(calendar.getTimeZone().getID());


        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 手动指定日期时，需注意月份会在指定的月份基础上加一月
         */
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020,9,13,0,0,0);
        System.out.println(calendar1.getTime());
        System.out.println(calendar1.getTime().getTime());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2020,9,13,0,0,0);
        calendar2.set(Calendar.MILLISECOND,0);
        System.out.println(calendar1.getTime());
        System.out.println(calendar1.getTime().getTime());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * Date转Calendar
         */
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(new Date());
        System.out.println(calendar3.getTime());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * Calendar转Date
         */
        Date date = calendar1.getTime();
        System.out.println(date);

        /**
         * SimpleDateFormat转换后的时间差
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = dateFormat.parse("2020-09-14 00:00:00");
            System.out.println("当前时间："+ dateFormat.format(date1.getTime()));

            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTime(date1);
            calendar4.setTimeZone(itTimeZone);
            System.out.println("Calendar指定时间：" + dateFormat.format(calendar4.getTime()));
        } catch (ParseException e) {
        }

    }
}
