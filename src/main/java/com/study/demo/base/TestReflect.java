package com.study.demo.base;

import com.study.demo.bean.Person;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName TestReflect
 * @Description TODO 反射
 * @Author dongzhanjun
 * @Date 2020/12/21 16:00
 * @Version 1.0
 */
public class TestReflect {


    public static void main(String[] args) throws Exception {
        String name = "huanghuai";
        Class c = name.getClass();
        System.out.println("classname = "+c.getName());
        Class p = Class.forName("com.study.demo.bean.Person");
        //获取构造函数
        Constructor<Person>[] pc = p.getConstructors();
        for (int i = 0; i < pc.length; i++) {
            Class[] classes =  pc[i].getParameterTypes();
            for (int j = 0; j < classes.length; j++) {
                System.out.println(classes[j].getName());
            }
        }
        //获取指定的构造函数
        Class[] paramType = {String.class,int.class};
        Constructor constructor = p.getDeclaredConstructor(paramType);
        Object object = constructor.newInstance("dzj",32);
        if(object instanceof Person){
            Person op = (Person)object;
            System.out.println(op.getName());
            System.out.println(op.getAge());
        }
        //获取私有构造函数
        Class[] paramPri = {String.class};
        Constructor constructorPri = p.getDeclaredConstructor(paramPri);
        constructorPri.setAccessible(true);
        Object objectPri = constructorPri.newInstance("haha");
        if(objectPri instanceof Person){
            Person oppri = (Person)objectPri;
            System.out.println(oppri.getName());
        }
        //调用类的私有方法
        Class[] paramMeth = {String.class};
        Method welcome = p.getDeclaredMethod("welcome",paramMeth);
        welcome.setAccessible(true);
        Object[] param = {"hello world"};
        welcome.invoke(new Person(),param);
        //设置私有属性
        Field field = p.getDeclaredField("name");
        field.setAccessible(true);
        Person pField = new Person();
        field.set(pField,"test_guoguo");
        System.out.println(field.get(pField).toString());
    }
}
