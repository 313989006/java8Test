package test;

import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * @Author liuyang
 * @Description : StreamApi Reducec操作$
 * @Title : StreamApi Reducec操作$
 * @Date 2020/9/12 10:07
 **/
public class StreamApiReduce {

    List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
    );

    @Test
    public void test(){
        BigDecimal result = carList.stream().map(Car::getMoney).reduce(new BigDecimal(0),(x,y) -> x.add(y));
        System.out.println(result);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Optional<BigDecimal> result1 = carList.stream().map(Car::getMoney).reduce(BigDecimal::add);
        System.out.println(result1.get());
    }
}
