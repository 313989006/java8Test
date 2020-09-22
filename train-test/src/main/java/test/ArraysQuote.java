package test;

import org.junit.Test;

import java.util.function.Function;

/*
 * @Author liuyang
 * @Description : 数组引用$
 * @Title : 数组引用$
 * @Date 2020/9/10 10:09
 **/
public class ArraysQuote {

    /**
     * 数组引用
     */
    @Test
    public void test(){
        /**
         * 传统Lambda实现
         */
        Function<Integer,String[]> function = x -> new String[x];
        String[] strA = function.apply(10);
        System.out.println(strA.length);

        /**
         * 数组引用实现
         */
        Function<Integer,String[]> function1 = String[]::new;
        String[] strA1 = function1.apply(20);
        System.out.println(strA1.length);
    }
}
