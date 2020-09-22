package test;
import java.util.concurrent.RecursiveTask;

/*
 * @Author liuyang
 * @Description : forkjoin线程池$
 * @Title : forkjoin线程池$
 * @Date 2020/9/13 14:03
 **/
public class ForkJoinThreadPool extends RecursiveTask<Long> {

    private Long x,y;
    private Long spilt = 1000L;
    ForkJoinThreadPool(Long x,Long y){
        this.x = x;
        this.y = y;
    }
    @Override
    protected Long compute() {
        Long result = y-x;
        if(result <= spilt){
            Long sum = 0L;
            for (long i = x; i <= y; i++){
                sum += i;
            }
            return sum;
        }else {
            Long z = (x + y) / 2;
            ForkJoinThreadPool forkJoinThreadPool = new ForkJoinThreadPool(x,z);
            forkJoinThreadPool.fork();

            ForkJoinThreadPool forkJoinThreadPool1 = new ForkJoinThreadPool(z+1,y);
            forkJoinThreadPool1.fork();

            return forkJoinThreadPool.join() + forkJoinThreadPool1.join();
        }
    }
}

