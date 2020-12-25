package com.study.demo.generics;


/**
 * @ClassName GenericsClass
 * @Description 泛型类
 * @Author dongzhanjun
 * @Date 2020/12/11 9:53
 * @Version 1.0
 * 泛型类的基本结构
 * class 类名称<泛型标识：可以随意写任意标识，标识指定泛型的类型>{
 * //泛型成员变量
 *     private 泛型标识  var
 * }
 * 泛型的类型参数只能是类类型，不能是简单类型
 *
 */
public class GenericsClass<T> {

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public GenericsClass(T key) {
        this.key = key;
    }

    public static void main(String[] args) {
//        传入对额实际参数类型需要与泛型的类型参数相同
//        GenericsClass<Integer> genericsClass = new GenericsClass<>(111);
//        GenericsClass<String> genericsClassString = new GenericsClass<String>("adcd");
//      定义的泛型类，只有在使用泛型类定义的时候，才会对参数做对应的限制，不定义泛型实参。方法和成员变量可以是任意类型
//        GenericsClass generic = new GenericsClass("111111");
//        GenericsClass generic1 = new GenericsClass(4444);
//        GenericsClass generic2 = new GenericsClass(55.55);
//        GenericsClass generic3 = new GenericsClass(false);
//        System.out.println("generic = " + generic.getKey());
//        System.out.println("generic1 = " + generic1.getKey());
//        System.out.println("generic2 = " + generic2.getKey());
//        System.out.println("generic3 = " + generic3.getKey());
//      不能对确切的泛型类型使用instanceof ，参数非法
//        if(generic3 instanceof GenericsClass<String>){}
//      泛型通配符
//      虽然Integer是Number的子类，但是并不能使用GenericsInterface<Integer> 当作GenericsInterface<Number>
//      的参数，showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
//      cannot be applied to Generic<java.lang.Number>
//      通过提示信息我们可以看到Generic<Integer>不能被看作为`Generic<Number>的子类。
//      由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
        GenericsClass<Integer> integerGenericsClass = new GenericsClass<>(123);
//        showKeyValue1(integerGenericsClass);
        //此处’？’是类型实参，而不是类型形参 ！再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，
        // 可以把？看成所有类型的父类。是一种真实的类型。下面的不会报错
        showKeyValue2(integerGenericsClass);


    }

    public static void showKeyValue1(GenericsClass<Number> obj){
        System.out.println("泛型测试,key value is" + obj.getKey());
    }

    public static void showKeyValue2(GenericsClass<?> obj){
        System.out.println("泛型测试,key value is" + obj.getKey());
    }
}
