package com.hotcenplotz.chapter05.lazy_;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-10 08:05
 * @description: 懒加载Java示例代码
 *
 * 懒加载原理类似于单例模式中的懒汉模式
 */


public class LazyDemoJava {
    private String property;

    public String getProperty() {
        if (property == null) {
            property = initProperty();
        }
        return property;
    }

    private String initProperty() {
        return "Property";
    }
}
