package test;

import entity.Car;
import entity.Child;
import entity.Man;
import entity.People;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

/*
 * @Author liuyang
 * @Description : Optional操作$
 * @Title : Optional操作$
 * @Date 2020/9/13 20:27
 **/
public class OptionalHandler {

    /**
     * Optional.of(new Car()) 创建一个Optional实例
     * Optional.empty() 创建一个空的Optional实例
     * Optional.ofNullable(new Car()) 若new Car()不为空，则创建实例，否则创建一个空的Optional实例
     * isPresent() 判断Optional实例是否包含值
     * orElse(new Car())如果有值返回对应的值，没有则返回指定的new Car()
     * orElseGet(() -> new Car()) 如果有值返回对应的值，没有则返回函数式接口Suppiler接口获取的值
     */

    @Test
    public void  test4(){
        Optional<Car> car11 = Optional.empty();
        if(car11.isPresent()) {
            new Car(new BigDecimal(1000),1,"");
        }
    }

    /**
     * Optional-map操作
     */
    @Test
    public void test(){
        Optional<Car> car = Optional.of(new Car(new BigDecimal(1),1,"红色"));
        Optional<String> str = car.map(e -> e.getColor());
        System.out.println(str.get());
    }

    /**
     * Optional-FlatMap操作
     */
    @Test
    public void test1(){
        Optional<Car> car = Optional.of(new Car(new BigDecimal(1),1,"黑色"));
        Optional<String> str = car.flatMap(e -> Optional.of(e.getColor()));
        System.out.println(str.get());
    }

    /**
     * 实例演示-获取小孩的名字
     */
    @Test
    public void test2(){
        Optional<People> people = Optional.empty();
        String name = people.orElse(new People())
              .getMan().orElse(new Man())
              .getChild().orElse(new Child())
              .getName();
        if(name == null){
            name = "张三";
        }
        System.out.println(name);
    }
}
