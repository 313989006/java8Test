package test;

import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
 * @Author liuyang
 * @Description : StreamAPI筛选与切片$
 * @Title : StreamAPI筛选与切片$
 * @Date 2020/9/10 14:15
 **/
public class StreamApiScreenSection {

    /**
     * StreamAPI筛选与切片
     *filter - 过滤
     *limit - 条数限制
     *skip - 跳过前条数
     *distinct - 去重
     */

    List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
    );

    /**
     * 过滤filter
     */
    @Test
    public void test(){
        carList.stream().filter(e -> {
            e.setState("测试状态");
            return e.getYear() > 1;
        }).forEach(System.out::println);
    }

    /**
     * 条数限制limit
     */
    @Test
    public void test1(){
        carList.stream().limit(1).forEach(System.out::println);
    }

    /**
     * 跳过前条数skip
     */
    @Test
    public void test2(){
        carList.stream().skip(1).forEach(System.out::println);
    }

    /**
     * 去重distinct
     */
    @Test
    public void test3(){
        carList.stream().filter(e -> e.getYear() > 1)
                .distinct()
                .forEach(System.out::println);
    }

}
