package test;

import entity.Car;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/*
 * @Author liuyang
 * @Description : StreamAPI collect操作$
 * @Title : StreamAPI collect操作$
 * @Date 2020/9/12 12:42
 **/
public class StreamApiCollect {
    List<Car> carList = Arrays.asList(
            new Car(new BigDecimal(50000),1,"红色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色"),
            new Car(new BigDecimal(100000),3,"蓝色"),
            new Car(new BigDecimal(120000),2,"白色")
    );

    @Test
    public void  test(){
        /**
         * toList
         */
        List<String> carList1 = carList.stream().map(Car::getColor).collect(Collectors.toList());
        carList1.forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * toSet
         */
        Set<Car> carSet = carList.stream().collect(Collectors.toSet());
        Iterator<Car> iterator = carSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 收集到LinkedHashSet
         */
        LinkedHashSet<Car> cars = carList.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        cars.forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * counting总数收集
         */
        long result = carList.stream().collect(Collectors.counting());
        System.out.println(result);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 平均值averagingDouble（有Double、int、Long类型转换）
         */
        Double total = carList.stream().collect(Collectors.averagingDouble(Car::getYear));
        System.out.println(total);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 总和summingLong（有Double、int、Long类型转换）
         */
        Long totalYear = carList.stream().collect(Collectors.summingLong(Car::getYear));
        System.out.println(totalYear);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * maxBy最大值
         */
        Optional<Car> carOptional = carList.stream().collect(Collectors.maxBy(Comparator.comparing(Car::getMoney)));
        System.out.println(carOptional.get());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * minBy最小值
         */
        Optional<BigDecimal> bigDecimal = carList.stream().map(Car::getMoney).collect(Collectors.minBy(BigDecimal::compareTo));
        System.out.println(bigDecimal.get());

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 分组groupingBy
         */
        Map<String,List<Car>> map = carList.stream().collect(Collectors.groupingBy(Car::getColor));
        System.out.println(map);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Map<String,Map<Integer,List<Car>>> map1 = carList.stream().collect(Collectors.groupingBy(Car::getColor,Collectors.groupingBy(Car::getYear)));
        System.out.println(map1);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        int resultYear = carList.stream().collect(Collectors.groupingBy(Car::getYear)).get(1).size();
        int resultYear1 = carList.stream().collect(Collectors.groupingBy(Car::getYear)).get(2).size();
        int resultYear2 = carList.stream().collect(Collectors.groupingBy(Car::getYear)).get(3).size();
        int resultYear3 = carList.stream().collect(Collectors.groupingBy(Car::getColor)).get("白色").size();
        int resultYear4 = carList.stream().collect(Collectors.groupingBy(Car::getColor)).get("红色").size();
        int resultYear5 = carList.stream().collect(Collectors.groupingBy(Car::getColor)).get("蓝色").size();
        System.out.println(resultYear);
        System.out.println(resultYear1);
        System.out.println(resultYear2);
        System.out.println(resultYear3);
        System.out.println(resultYear4);
        System.out.println(resultYear5);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 分片partitioningBy
         */
        Map<Boolean,List<Car>> carMap = carList.stream().collect(Collectors.partitioningBy(x -> x.getYear() > 2));
        System.out.println(carMap);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        int result3 = carList.stream().collect(Collectors.partitioningBy(x -> x.getYear() > 2)).get(false).size();
        System.out.println(result3);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        /**
         * 组合函数summarizingInt（有Double、int、Long类型转换）
         */
        IntSummaryStatistics intSummaryStatistics = carList.stream().collect(Collectors.summarizingInt(Car::getYear));
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());

        /**
         * joining
         */
        String str = carList.stream().map(Car::getColor).collect(Collectors.joining());
        String str1 = carList.stream().map(Car::getColor).collect(Collectors.joining(","));
        String str2 = carList.stream().map(Car::getColor).collect(Collectors.joining(",","@@@","@@@"));
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
