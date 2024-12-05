package com.iamhotcenplotz.www.chapter14.list_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class LinkedListSimulation {
    public static void main(String[] args) {
        MyNode jack = new MyNode("jack");
        MyNode queen = new MyNode("queen");
        MyNode king = new MyNode("king");

        // 链接三个节点，形成双向链表
        jack.next = queen;
        queen.next = king;

        king.pre = queen;
        queen.pre = jack;

        MyNode first = jack;
        MyNode last = king;

        //iterate head -> tail
        while (true){
            if (first == null) break;

            System.out.println(first);
            first = first.next;
        }
        // tail -> head
        while (true){
            if (last == null) break;
            System.out.println(last);
            last = last.pre;
        }

        // add
        MyNode zhangfei = new MyNode("张飞");
        zhangfei.pre = queen;
        zhangfei.next = king;

        king.pre = zhangfei;
        queen.next = zhangfei;


        first = jack;
        while (true){
            if (first == null) break;

            System.out.println(first);
            first = first.next;
        }

        last = king;
        while (true){
            if (last == null) break;
            System.out.println(last);
            last = last.pre;
        }

    }
}

class MyNode {
    public Object item; // 存放数据的地方
    public MyNode next; // 指向上一个节点
    public MyNode pre; // 指向下一个节点

    public MyNode(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "item=" + item +
                '}';
    }
}
