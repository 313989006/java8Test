package test;

import classcode.MethodReference;
import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * @Author liuyang
 * @Description : 方法和构造器引用$
 * @Title : 方法和构造器引用$
 * @Date 2020/8/31 10:39
 **/
public class FunctionQuote {

    /**
     * 若Lambda体中已经有方法实现了，就可以使用方法引用
     * 主要有三种格式
     * 一：对象::实例方法名
     * 二：类::实例方法名
     * 三：类::静态方法名
     */

    /**
     * 对象::实例方法名
     */
    @Test
    public void test(){
        /**
         * 传统Lambda表达式实现
         */
        Car car = new Car(new BigDecimal(1000),3,"红色");
        Function<Car,String> function = x -> x.getColor();
        String color = function.apply(car);
        System.out.println(color);

        /**
         * 对象名::实例方法名实现
         */
        Function<Car,Integer> function1 = Car::getYear;
        Integer year = function1.apply(car);
        System.out.println(year);
    }

    /**
     * 类::实例方法名
     */
    @Test
    public void test1(){
        /**
         * 传统Lambda表达式实现
         */
        MethodReference methodReference = new MethodReference();
        BiFunction<Integer,Integer,Integer> biFunction = (x,y) -> methodReference.calculation(x,y);
        Integer result = biFunction.apply(10,10);
        System.out.println(result);

        /**
         * 类::实例方法名
         */
        BiFunction<Integer,Integer,Integer> biFunction1 = methodReference::calculation;
        Integer total = biFunction.apply(5,5);
        System.out.println(total);
    }

    /**
     * 类::静态方法名
     */
    @Test
    public void test5(){
        /**
         * 传统Lambda表达式实现
         */
        Consumer<String> cs = x -> MethodReference.consumer(x);
        cs.accept("我用Lambda表达式实现该功能");

        Consumer<String> cs1 = MethodReference::consumer;
        cs1.accept("我用方法引用实现该功能");
    }
}
