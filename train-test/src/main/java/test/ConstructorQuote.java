package test;

import entity.Car;
import org.junit.Test;
import service.CarInterfaceService;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * @Author liuyang
 * @Description : 构造器引用$
 * @Title : 构造器引用$
 * @Date 2020/9/10 10:22
 **/
public class ConstructorQuote {

    /**
     * 构造器的引用
     */
    @Test
    public void test(){
        /**
         * 传统的Lambda表达式实现
         */
        Function<BigDecimal, Car> function = x -> new Car(x);
        Car car = function.apply(new BigDecimal(100));
        System.out.println(car);

        BiFunction<BigDecimal,Integer,Car> biFunction = (x,y) -> new Car(x,y);
        Car car1 = biFunction.apply(new BigDecimal(10000),5);
        System.out.println(car1);

        /**
         * 构造器引用
         */
        Function<BigDecimal,Car> function1 = Car::new;
        Car car2 = function1.apply(new BigDecimal(500));
        System.out.println(car2);

        BiFunction<BigDecimal,Integer,Car> biFunction1 = Car::new;
        Car car3 = biFunction1.apply(new BigDecimal(600),8);
        System.out.println(car3);


        /**
         * 自定义函数式接口并使用
         */
        CarInterfaceService<BigDecimal,Integer,String,Car> carCarInterfaceService = Car::new;
        Car car4 = carCarInterfaceService.carService(new BigDecimal(600),6,"绿色");
        System.out.println(car4);
    }
}
