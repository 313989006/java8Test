package test;

import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
 * @Author liuyang
 * @Description : StreamAPI查找与匹配$
 * @Title : StreamAPI查找与匹配$
 * @Date 2020/9/12 8:57
 **/
public class StreamApiSearch {
    List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
    );

    /**
     * 查找
     */
    @Test
    public void test(){
        boolean result = carList.stream().allMatch(e -> e.getYear() > 1);
        System.out.println(result);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        boolean result1 = carList.stream().anyMatch(e -> e.getYear() > 1);
        System.out.println(result1);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        boolean result2 = carList.stream().noneMatch(e -> e.getYear() > 5);
        System.out.println(result2);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Optional<Car> car = carList.stream().findFirst();
        System.out.println(car.get());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Optional<Car> car1 = carList.stream().filter(e -> e.getYear() > 2).findAny();
        System.out.println(car1.get());
    }

    /**
     * 匹配
     */
    @Test
    public void test1(){
        long result = carList.stream().count();
        System.out.println(result);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Optional<Car> year = carList.stream().max(Comparator.comparingInt(Car::getYear));
        System.out.println(year.get());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Optional<Car> year1 = carList.stream().min(Comparator.comparingInt(Car::getYear));
        System.out.println(year1.get());
    }
}
