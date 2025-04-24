package com.iamhotcenplotz.chapter23.reflection.class_;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示哪些类型有class对象
 */
public class WhoHasClass_ {
    public static void main(String[] args) {
        // 1.
        Class<String> cls1 = String.class;

        // 2.
        Class<Serializable> serializableClass = Serializable.class;

        // 3.
        Class<Integer[]> aClass = Integer[].class;

        // 4.
        Class<float[][]> aClass1 = float[][].class;

        // 5. annotation
        Class<Deprecated> deprecatedClass = Deprecated.class;

        // 6. Enum
        Class<Thread.State> stateClass = Thread.State.class;

        // 7.
        Class<Long> longClass = long.class;

        // 8.
        Class<Void> voidClass = void.class;

        // 9.
        Class<Class> classClass = Class.class;


    }
}
