package service;

/*
 * @Author liuyang
 * @Description : 汽车函数式接口$
 * @Title : 汽车函数式接口$
 * @Date 2020/9/10 11:10
 **/
@FunctionalInterface
public interface CarInterfaceService<T,U,I,R> {
    R carService(T t,U u,I i);
}
