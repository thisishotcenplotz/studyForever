package com.iamhotcenplotz.chapter27.atraction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 10:08
 * @description: 体验正则表达式
 */


public class RegularExpressionDemo01_ {
    public static void main(String[] args) throws IOException {

        String content = "Rust的类型系统支持一种类似类型类的机制，叫“traits”，是被Haskell激发灵感的。" +
                "这是一种用于特定同质法的设施，通过给类型变量声明添加约束来实现。其它来自Haskell的特性，如更高类型多态还没有支持。\n" +
                "Rust为以let关键字声明的变量而产生类型推导特性。" +
                "这样的变量不需要赋初值来判断类型。如果某个分支代码没能给变量赋初值将会产生一个编译时错误。对变量进行多次赋值要使用mut关键字标记。\n" +
                "函数可以接收泛型参数，但通常要求泛型实现某种特性或者几种特性。" +
                "在这种函数里面，这种泛型值只能通过这些特性来使用。" +
                "这就是说一个泛型函数在定义的时候就能完成类型检查。" +
                "这是对标C++模板，那种本质鸭式，只能在以具体类型实例化后完成检查。" +
                "C++概念解决同样的问题，并且有希望能成为C++20标准的一部分。\n" +
                "然而，Rust泛型的实现与C++模板的典型实现类似：每次实例化都会生成一份单独的代码这被称作单态，和经常在Java和Haskell中使用的类型擦除方案类比。" +
                "单态的好处是为每一个具体用例提供优化代码，缺点是增长了运行时和很多结果文件。\n" +
                "Rust里面的对象系统是基于实现，特性和结构化类型的。" +
                "实现扮演的角色跟其它语言中的类相似，以关键字impl来定义。继承和多态是由特性提供；" +
                "它们允许方法被定义或者混合在实现里面。结构类型用于定义字段。" +
                "实现和特性自己无法定义字段，而且只有特性能够提供继承。" +
                "至于其它好处，这个阻止了多继承中的菱形继承问题，像C++一样。" +
                "换句话说，Rust支持接口继承，但是通过复合替代实现继承；参见继承复合。";

        String s = Files.readString(Paths.get("src/main/java/com/iamhotcenplotz/chapter27/atraction/a.html"));

        String s1 = "私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0-10.255.255.255\n" +
                "B类 172.16.0.0-172.31.255.255\n" +
                "C类 192.168.0.0-192.168.255.255";


        // (1) 先创建一个Pattern 对象
//        Pattern compile = Pattern.compile("[a-zA-Z]+"); // 提取所有的英文单字
//        Pattern compile = Pattern.compile("[0-9]+"); // 提取文章中所有数字
//        Pattern compile = Pattern.compile("([0-9]+)|([a-zA-Z]+)"); // 数字和英文单词
//        Pattern compile = Pattern.compile("\\btitle\\s*=\\s*\"([^\"]+)\"");// 数字和英文单词
        Pattern compile = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+"); // ip 地址

        // (2) 创建一个匹配器
        Matcher matcher = compile.matcher(s1);

        // (3) 开始循环匹配
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
