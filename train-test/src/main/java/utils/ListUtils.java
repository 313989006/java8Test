package utils;

import entity.Car;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
 * @Author liuyang
 * @Description : List集合操作$
 * @Title : List集合操作$
 * @Date 2020/9/11 16:18
 **/
public abstract class ListUtils {
      List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
    );
}
