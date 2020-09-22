package entity;

import java.util.Optional;

/*
 * @Author liuyang
 * @Description : 男人$
 * @Title : 男人$
 * @Date 2020/9/13 20:29
 **/
public class Man {

    private String name;

    private Integer age;

    Optional<Child> child = Optional.empty();

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
        age = age;
    }

    public Optional<Child> getChild() {
        return child;
    }

    public void setChild(Optional<Child> child) {
        this.child = child;
    }
}
