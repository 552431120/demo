package com.study.demo.base;

/**
 * @ClassName T01_HowToCreateThread
 * @Description 如何创建一个线程，启动线程的三种方式
 * 1.继承Thread类
 * 2.实现Runnable 接口
 * 3.线程池启动（Executors.getCachedThread）
 * @Author dongzhanjun
 * @Date 2020/5/2 13:06
 * @Version 1.0
 */
public class T01_HowToCreateThread {

    static  class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("this is Mythread!");
        }
    }

    static  class  MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("this is my run");
        }
    }

    public static void main(String[] args) {
     new MyThread().start();
     new Thread(new MyRun()).start();
     new Thread(()->{
         System.out.println("helllo lambda");
     }).start();
    }





}
