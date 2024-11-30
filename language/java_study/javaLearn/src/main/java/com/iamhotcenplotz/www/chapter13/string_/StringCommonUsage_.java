package com.iamhotcenplotz.www.chapter13.string_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class StringCommonUsage_ {
    public static void main(String[] args) {
        String str = "HelloWorld";

        System.out.println(str.equals("HelloWorld"));
        System.out.println(str.equalsIgnoreCase("helloworld"));
        System.out.println(str.length());
        System.out.println(str.indexOf('o'));
        System.out.println(str.lastIndexOf('o'));
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));

        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.concat("hello").concat("flink"));
        System.out.println(str.replace("Hello", "Funk "));
        String[] os = str.split("o");
        for (String o : os) {
            System.out.println(o);
        }

        String s = "E:\\aaa\\bbb";

        for (String string : s.split("\\\\")) {
            System.out.println(string);
        }

        for (char c : str.toCharArray()) {
            System.out.println(Character.toUpperCase(c));
        }

        /*
         * %s -> String
         * %c -> Char
         * %d -> Int
         * %.2f -> Float
         * */

        String s1 = "hello %s how are you?";
        System.out.println(s1.formatted("Spark"));
    }
}
