package test;

import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * @Author liuyang
 * @Description : StreamAPI-Map操作$
 * @Title : StreamAPI-Map操作$
 * @Date 2020/9/11 11:25
 **/
public class StreamApiMap {

    List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
    );

    /**
     * map操作
     */
    @Test
    public void test(){
        carList.stream().map(x -> x.getYear()).distinct()
                .forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 注意事项： Lambda在同一个方法中多次引用同一个entity，会保留之前entity改变后的结果
         */
        carList.stream().map(z ->{
            z.setYear(z.getYear() * 10);
            return z;
        }).forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        List<Car> cars = new ArrayList<>();
        carList.stream().map(e -> {
            if(e.getYear() == 1)
                e.setColor("RED");
            if(e.getYear() == 2)
                e.setColor("BLUE");
            else e.setColor("BLACK");
            return e;
        }).filter(e -> e.getYear() > 1).forEach(System.out::println);
    }

    /**
     * parallelStream操作MAP
     *
     * parallelStream，其默认线程数是CPU核心数
     *
     * 注意事项：
     * 1.parallelStream线程不安全问题（加锁、使用线程安全的集合或者集合采用collect()或reduce()操作就是满足线程安全的）；
     * 2.parallelStream 适用的场景是CPU密集型的，假如本身电脑CPU的负载很大，那还到处用并行流，那并不能起到作用，切记不要再paralelSreram操作是中使用IO流；
     * 3.不要在多线程中使用parallelStream，原因同上类似，大家都抢着CPU是没有提升效果，反而还会加大线程切换开销；
     */
    @Test
    public void test1(){
        carList.parallelStream().map(Car::getNormalCar).forEach(System.out::println);
    }


    /**
     * flatMap操作
   */
    @Test
    public void test2(){
        carList.stream().flatMap(x -> getStreamCar(x)).forEach(System.out::println);
    }

    public static Stream<Car> getStreamCar(Car car){
        List<Car> cars = new ArrayList<>();
        if(car.getYear() > 1)
            cars.add(car);
        return cars.stream();
    }

}
