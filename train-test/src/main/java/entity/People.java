package entity;

import java.util.Optional;

/*
 * @Author liuyang
 * @Description : 人$
 * @Title : 人$
 * @Date 2020/9/13 20:29
 **/
public class People {
    private Optional<Man> man = Optional.empty();

    private Optional<Woman> woman = Optional.empty();

    private String name;

    private  Integer age;

    public Optional<Man> getMan() {
        return man;
    }

    public void setMan(Optional<Man> man) {
        this.man = man;
    }

    public Optional<Woman> getWoman() {
        return woman;
    }

    public void setWoman(Optional<Woman> woman) {
        this.woman = woman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
