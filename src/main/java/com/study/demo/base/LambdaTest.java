package com.study.demo.base;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName LambdaTest lambda表达式
 * @Description TODO
 * @Author dongzhanjun
 * @Date 2020/12/14 14:02
 * @Version 1.0
 */
public class LambdaTest {

    public static void  process(Runnable r){
        r.run();

    }

    public static void test(String[] args) {
        List<String> list = new ArrayList<>();
        list.forEach(p->{});
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("haa","");
        JSONObject test = jsonObject.getJSONObject("haa");
        System.out.println("args = " + Arrays.deepToString(args));
        Runnable r2 = ()-> System.out.println("hello world 2");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world 1");
            }
        };
        process(r1);
        process(r2);
    }

}
