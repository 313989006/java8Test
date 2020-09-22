package test;

import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
 * @Author liuyang
 * @Description : StreamAPI排序$
 * @Title : StreamAPI排序$
 * @Date 2020/9/11 16:10
 **/
public class StreamApiSort {

    List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色","GOOD"),
            new Car(new BigDecimal(100000),3,"蓝色","BAD"),
            new Car(new BigDecimal(120000),2,"白色","PRACTICAL"),
            new Car(new BigDecimal(100000),3,"蓝色","GOOD"),
            new Car(new BigDecimal(120000),2,"白色","PRACTICAL")
    );

    /**
     * 自然排序
     */
    @Test
    public void test(){
        carList.stream().map(Car::getState).sorted().forEach(System.out::println);
    }

    /**
     * 定制排序
     */
    @Test
    public void test1(){
        carList.stream().sorted((x,y) ->{
            if(x.getYear().equals(y.getYear()))
                return x.getState().compareTo(y.getState());
            else
                return x.getYear().compareTo(y.getYear());
        }).forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        carList.stream().sorted((x,y) ->{
            if(x.getState().equals(y.getState()))
                return x.getYear().compareTo(y.getYear());
            else
                return x.getState().compareTo(y.getState());
        }).forEach(System.out::println);
    }
}
