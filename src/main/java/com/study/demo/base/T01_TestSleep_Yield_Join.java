package com.study.demo.base;

/**
 * @ClassName T01_TestSleep_Yield_Join
 * @Description 测试sleep yield join
 * sleep 当前行程进入睡眠
 * yield 谦让，当前线程进入就绪状态
 * join 其他线程加入，运行结束后继续当前线程
 * @Author dongzhanjun
 * @Date 2020/5/2 13:27
 * @Version 1.0
 */
public class T01_TestSleep_Yield_Join {

    public static void main(String[] args) {
//        testSleep();
//        testYield();
        testJoin();
    }


    static  void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("testSleep" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /**
    *@Description:
    *@Param: []
    *@return: void
    *@Author: dzj
    *@date: 2020/5/2
    */
   static void testYield(){
       new Thread(()->{
           for (int i = 0; i < 10; i++) {
               System.out.println("testYieldA"+i);
               Thread.yield();
           }

       }).start();

       new Thread(()->{
           for (int i = 0; i < 10; i++) {
               System.out.println("testYieldB"+i);
               Thread.yield();
           }

       }).start();
    }


    static void  testJoin(){
      Thread t1 =  new Thread(()->{
          for (int i = 0; i < 10; i++) {
              System.out.println("thread_t1_"+i);
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
       });

        Thread t2 = new Thread(()->{
            System.out.println("Thread_t2_start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread_t2_end");
        });
        t2.start();
        t1.start();

    }


}
