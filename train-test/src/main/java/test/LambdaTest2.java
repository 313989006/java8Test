package test;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/*
 * @Author liuyang
 *
 * @Description : Lambda测试二$
 *
 * @Title : Lambda测试二$
 *
 * @Date 2020/8/27 15:03
 **/
public class LambdaTest2 {
    /**
     * 四大内置函数式接口（@FunctionalInterface）
     * 一：Consumer<T> :消费型接口 -accept(T t)
     * 二：Supplier<T> :供给型接口 -get()
     * 三：Function<T,R> :函数式接口 -apply(T,R)
     * 四：Predicate<T> :断言型接口 -test(T t)
     */

    /**
     * BiFunction<T,U,R> 传T、U,返回R
     * UnaryOperator<T>  传T，返回T
     * BinaryOperator<T> 传T、T，返回T
     * BiConsumer<T,R>   传T、R，返回void
     * ToIntFunction<T> ToLongFunction<T> ToDoubleFunction<T> 传T，返回int、long、double
     *ToIntBiFunction<T,U> ToLongBiFunction<T,U> ToDoubleBiFunction<T,U> 传T、U，返回int、long、double
     * IntFunction<R> LongFunction<R> DoubleFunction<R> 传int、long、double，返回R
     */



    @Test
    public void  test(){
        function(1000D,x -> System.out.println(x));
        System.out.println("............................................................");

        List<Integer> integerList = function2(10,() -> (int)(Math.random() * 100));
        for (Integer integer : integerList){
            System.out.println(integer);
        }
        System.out.println("............................................................");

        Integer result = function3(10,(x) -> x * 100);
        System.out.println(result);
        System.out.println("............................................................");


        List<Integer> integerList1 = Arrays.asList(10,23,45,90,100);
        List<Integer> integerList2 = function4(integerList1,(x) -> x.intValue() > 50);
        for (Integer integer : integerList2){
            System.out.println(integer);
        }
    }

    /**
     * 消费型接口
     */
    public void function(Double money, Consumer<Double> com){
        com.accept(money);
    }

    /**
     * 供给型接口
     * @param num
     * @param supplier
     * @return
     */
    public List<Integer> function2(Integer num, Supplier<Integer> supplier){
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < num; i++){
            Integer resulit = supplier.get();
            integerList.add(resulit);
        }
        return integerList;
    }

    /**
     * 函数式接口
     * @param integer
     * @param function
     * @return
     */
    public Integer function3(Integer integer, Function<Integer,Integer> function){
       return function.apply(integer);
    }

    /**
     * 断言型接口
     * @param integers
     * @param predicate
     * @return
     */
    public List<Integer> function4(List<Integer> integers, Predicate<Integer> predicate){
        List<Integer> integerList = new ArrayList<>();
        for (Integer integer : integers){
            if(predicate.test(integer)){
                integerList.add(integer);
            }
        }
        return integerList;
    }
}
