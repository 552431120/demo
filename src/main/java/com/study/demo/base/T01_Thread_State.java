package com.study.demo.base;

/**
 * @ClassName T01_Thread_State
 * @Description 线程状态
 * new，runnalble(ready-running),timeWaiting,waiting,block
 * @Author dongzhanjun
 * @Date 2020/5/2 16:59
 * @Version 1.0
 */
public class T01_Thread_State {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        t1.start();
        System.out.println(t1.getState());
        for (int i = 0; i <10 ; i++) {
            System.out.println("输出日志"+i);
            Thread.sleep(50);

        }
        System.out.println(t1.getState());
    }



}
