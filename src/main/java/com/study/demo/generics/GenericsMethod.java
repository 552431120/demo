package com.study.demo.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName GenericsMethod
 * @Description 泛型方法
 * @Author dongzhanjun
 * @Date 2020/12/11 13:20
 * @Version 1.0
 * 泛型的基本方法介绍
 *
 */
public class GenericsMethod<T> {

    private T key;

    /**
     *泛型的基本方法介绍
     * 说明：1.public 和 返回值直接的<T>声明此方法是泛型方法
     *      2.只有声明了<T>的方法才是泛型方法，泛型类中使用了泛型的成员方法并不是泛型方法
     *      3.<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *      4.与泛型类的定义一样，T可以随便写成任意标识，T,E,K,V等形式的参数常用于表示泛型。
     *
     */
    public <T> T genericsMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T instance = tClass.newInstance();
        return instance;
    }

    public GenericsMethod(T key) {
        this.key = key;
    }
    //这个方法并不是泛型方法，只是一个普通的成员方法，因为在声明泛型类的时候已经声明了泛型，
    //才可以继续使用
    public T getKey() {
        return key;
    }
//    这个方法因为在类声明时候没有声明泛型E,所以在使用E作为形参和
//    返回值的时候，编译器无法识别
//    public E setKey(E key){
//        this.key = key;
//    }

    public void setKey(T key) {
        this.key = key;
    }
    //泛型的数量可以是任意多个
//    public <T,K> K showKeyName(GenericsClass<T> genericsClass){
//
//    }
    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(GenericsClass<Number> obj){
        System.out.print("泛型测试key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(GenericsClass<?> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     public <T> T showKeyName(Generic<E> container){
     ...
     }
     */

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
     public void showkey(T genericObj){

     }
     */
    //泛型方法的可变参数
    public <T> void showMag(T...args){
        for (int i = 0; i < args.length ; i++) {
            System.out.println("args = " + Arrays.deepToString(args));
        }
    }





}
