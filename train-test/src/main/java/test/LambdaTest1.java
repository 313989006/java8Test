package test;

import entity.Car;
import org.junit.Test;
import service.CarsService;

import java.math.BigDecimal;
import java.util.*;

/*
 * @Author liuyang
 * @Description : Lambda表达式$
 * @Title : Lambda表达式$
 * @Date 2020/8/26 15:42
 **/
public class LambdaTest1 {

      List<Car> carList1 = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
      );

    /**
     * 匿名内部类
     */
    @Test
    public void test(){
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    /**
     * Lambda表达式
     */
    @Test
    public void test1(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    /**
     * 类似策略设计模式（在方法体中进行实现）- 匿名内部类
     */
    @Test
    public void test2(){
        List<Car> carList = filterCar(carList1, new CarsService<Car>() {
            @Override
            public boolean operationCar(Car car) {
                return car.getYear() >= 2;
            }
        });

        for (Car car : carList){
            System.out.println(car);
        }
    }

    /**
     * 策略模式Lambda表达式
     */
    @Test
    public void  test3(){
            List<Car> cars = filterCar(carList1,(e) -> e.getYear() >= 2);
            for (Car car : cars){
                System.out.println(car);
            }
            System.out.println("..........................");
            cars.forEach(System.out::println);
    }

    public List<Car> filterCar(List<Car> carList, CarsService<Car> carsService){
        List<Car> cars = new ArrayList<>();
        for (Car car : carList) {
            if (carsService.operationCar(car)){
                cars.add(car);
            }
        }
        return cars;
    }


}
