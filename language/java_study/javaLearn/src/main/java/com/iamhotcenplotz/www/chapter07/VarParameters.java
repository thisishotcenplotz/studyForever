package com.iamhotcenplotz.www.chapter07;

public class VarParameters {
    public static void main(String[] args) {
        SomeMethod someMethod = new SomeMethod();
        System.out.println(someMethod.sum(1, 2, 3, 4, 5));
        System.out.println(someMethod.sum(1));
        System.out.println(someMethod.sum(1, 2));

        int[] num = {1,2,3,4,5};
        System.out.println(someMethod.sum(num));
    }
}

class SomeMethod {
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int... nums) {
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            rst += nums[i];
        }
        return rst;
    }
}
