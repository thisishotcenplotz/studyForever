package com.iamhotcenplotz.chapter15.custom;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class CustomGeneric01_ {

}

// 1. 普通成员可以使用泛型（属性、方法）
// 2. 使用泛型的数组，不能初始化
// 3. 静态方法无法使用泛型
class Tiger<T,R,M>{
    String name;
    R r; // 属性使用泛型
    M m;
    T t;

    // 因为数组在new 的时候不能确定T的类型，就无法在内存开空间
    // T[] = new T[8];   wrong!!!
    T[] ts;




    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    // 方法使用泛型
    public R getR() {
        return r;
    }

    // 因为静态是和类相关的，在类加载时，对象还没有创建
    // 所以，如果静态方法和静态属性使用了泛型，那么JVM就无法完成初始化。
    //public static void m1(M m){} wrong

}