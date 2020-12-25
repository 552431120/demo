package com.study.demo.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FanXing
 * @Description  java泛型
 * @Author dongzhanjun
 * @Date 2020/12/10 11:31
 * @Version 1.0
 */
public class GenericsTest {

    //类型转化错误
    public static void testCostError(){
        //限定类型，放入非对应类型编译报错，不需要取值时不需要转化
//       List<String> testList  = new ArrayList<>();
       //非限定类型，编译不报错，转化时报错
       List testList  = new ArrayList<>();
       testList.add("aaaa");
       testList.add(111);
       for (int i = 0; i < testList.size(); i++) {
         String ele = (String) testList.get(i);
           System.out.println(ele);
       }
    }

    //泛型只在编译阶段生效
    public static void testCompile() {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        Class stringArrayClass =  stringArrayList.getClass();
        Class intListClass = intList.getClass();
        if(stringArrayClass.equals(intListClass)){
            System.out.println("泛型只在编译的阶段生效");
        }
    }

    //



    public static void main(String[] args) {
//        testCostError();
        testCompile();
    }



}
