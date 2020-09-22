package test;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @Author liuyang
 * @Description : 指定线程池$
 * @Title : 指定线程池$
 * @Date 2020/9/13 13:27
 **/
public class FixedThreadPool {
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void test(){
        for (int i = 0; i <= 100000; i++) {
            executorService.submit(new Task(i));
        }
        executorService.shutdown();
    }
}

class Task implements Runnable{

    Integer thisX;
    public Task(Integer x){
        this.thisX = x;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "的结果为" +":" + thisX);
    }
}


