package com.study.demo.base;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01_WhatIsThread 什么是线程
 * @Description TODO
 * @Author dongzhanjun
 * @Date 2020/5/2 12:56
 * @Version 1.0
 */
public class T01_WhatIsThread {

    static class  T1 extends Thread{
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                    System.out.println("t1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        new T1().run();
        new T1().start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
                System.out.println("main");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
