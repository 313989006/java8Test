package test;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/*
 * @Author liuyang
 * @Description : forkJoinTest$
 * @Title : forkJoinTest$
 * @Date 2020/9/13 15:57
 **/
public class ForkJoinThreadPoolTset {
    @Test
    public void test(){
        ForkJoinPool forkJoinThreadPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinThreadPool(0L,1000000000L);
        Long resultTotal = forkJoinThreadPool.invoke(forkJoinTask);
        System.out.println(resultTotal);
    }

    /**
     * parallel实现并行流
     */
    @Test
    public void test1(){
        Long result = LongStream.range(0L,1000000001L).parallel().reduce(0,Long::sum);
        System.out.println(result);
    }
}
