package com.iamhotcenplotz.chapter13.string_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class StringBuilder_ {
    public static void main(String[] args) {
        // 它继承了AbstractStringBuilder
        // 实现了 Serializable 接口
        // 是final类，不能被继承
        // StringBuilder 对象的字符序列仍然是存放在其父类，AbstractStringBuilder char[] value; 中
        // 因此，这个字符序列是存放在堆中。
        // StringBuilder 的方法 没有做互斥的处理，即 没有synchronized 关键字
        // 所以一般在单线程的情况下使用
        StringBuilder str = new StringBuilder();
    }
}
