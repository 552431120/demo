package com.study.demo.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Person
 * @Description 测试反射获取构造方法，方法参数
 * @Author dongzhanjun
 * @Date 2020/12/15 17:05
 * @Version 1.0
 */
public class Person {

    private String name;
    private Integer age;
    private Date birthday;
    private double money;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name = " + name + ", age = " + age);
    }

    private Person(String name) {
        this.name = name;
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

    private void welcome(String msg){
        System.out.println(msg);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Map<String,Object> param = new HashMap<>(2,0.75f);
        System.out.println("args = " + Arrays.deepToString(args));
    }
}
