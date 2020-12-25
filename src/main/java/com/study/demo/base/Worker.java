package com.study.demo.base;

/**
 * @ClassName testAbstract
 * @Description 测试抽象类类
 * @Author dongzhanjun
 * @Date 2020/12/22 23:49
 * @Version 1.0
 */
public abstract class Worker {
    abstract void doWork();
}

class CxMonkey extends Worker{
    @Override
    void doWork() {

    }
}

abstract class PMOWork extends Worker{
    @Override
    void doWork() {

    }
    abstract void doSomeThing();
}
