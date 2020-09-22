package entity;

import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * @Author liuyang
 *
 * @Description : 汽车实体类$
 *
 * @Title : 汽车实体类$
 *
 * @Date 2020/8/26 17:15
 **/
public class Car {

    private BigDecimal money;

    private Integer year;

    private String color;

    private String state;

    public Car(BigDecimal money, Integer year, String color, String state) {
        this.money = money;
        this.year = year;
        this.color = color;
        this.state = state;
    }

    public Car(BigDecimal money, Integer year, String color) {
        this.money = money;
        this.year = year;
        this.color = color;
    }

    public Car(BigDecimal money) {
        this.money = money;
    }

    public Car(BigDecimal money, Integer year) {
        this.money = money;
        this.year = year;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Car{" +
                "money=" + money +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equal(money, car.money) &&
                Objects.equal(year, car.year) &&
                Objects.equal(color, car.color) &&
                Objects.equal(state, car.state);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money, year, color, state);
    }

    public static Car getNormalCar(Car car){
        if(car.getYear() != null)
            return car;
        else return new Car(new BigDecimal(1),1,"我是没有的Car");
    }

}
