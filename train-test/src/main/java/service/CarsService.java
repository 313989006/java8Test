package service;

/*
 * @Author liuyang
 * @Description : 汽车接口$
 * @Title : 汽车接口$
 * @Date 2020/8/26 17:32
 **/
@FunctionalInterface
public interface CarsService<T> {

    /**
     * 操作汽车接口
     * @param t
     * @return
     */
    public boolean operationCar(T t);

    /**
     * 接口中的默认方法
     */
    default void show(){
        System.out.println("我是默认方法");
    }

    /**
     * 接口中的静态方法
     */
    public static void happy(){
        System.out.println("我是静态方法");
    }

}
