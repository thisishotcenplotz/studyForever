#  内容介绍
Java技术体系导图:
- java基础
  - 第一阶段：建立编程思想
    - java 概述
      - 如何快速学习java技术
      - java历史
      - java特点
      - java运算机制
      - JDK
      - 转义字符
      - java开发规范
      - java API
    - 变量
      - 数据类型
      - 变量基本使用
      - 数据类型转换
    - 运算符
      - 运算符介绍
      - 算数运算符
      - 关系运算符
      - 逻辑运算符
      - 赋值运算符
      - 三元运算符
      - 优先级
      - 二进制 *
      - 位运算符
    - 控制结构
      - 顺序
      - 分支
      - 循环
      - break
      - continue
      - return
    - 数组、排序和查找
      - 数组 *
      - 排序
      - 查找
    - 面相对象编程（基础）
      - 类与对象
      - 成员方法
      - 成员方法传参机制
      - overload
      - 可变参数
      - 作用域
      - 构造器
      - this
    - 面相对象编程（中级）
      - 包
      - 访问修饰符
      - 封装
      - 继承
      - 多态
      - Super
      - overwrite
      - Object类详解
      - 断点调试
    - 项目&学以致用-编程之乐
      - 零钱通
      - 房屋出租系统
  - 第二阶段：提升编程能力
    - 面相对象编程（高级）
      - 类变量和类方法
      - 理解main方法语法
      - 代码块
      - 单例设计模式
      - final关键字
      - 抽象类
      - 接口
      - 内部类
    - 枚举和注解
      - 自定义类实现枚举
      - enum关键字实现枚举
      - JDK内置的基本注解类型
      - 元注解：对注解进行注解
    - Exception
      - 异常的概念
      - 异常体系图
      - 常见的异常
      - 异常处理
      - 自定义异常
      - throw和throws的对比
    - 常用类
      - 包装类
      - String
      - StringBuffer
      - StringBuilder
      - Math
      - Date、Calendar、LocalDate
      - System
      - Arrays
      - BigInteger、BigDecimal
    - 集合
      - 集合框架体系
      - Collection
        - List
          - ArrayList
          - LinkedList
          - Vector
        - Set
          - HashSet
          - LinkedHashSet
          - TreeSet
      - Map
        - HashMap
        - Hashtable
        - LinkedHashMap
        - TreeMap
        - Properties
      - Collections
    - 泛型
      - 泛型语法
      - 自定义泛型
        - 泛型类
        - 泛型接口
        - 泛型方法
      - 泛型继承和通配符
    - 线程（基础）
      - 线程介绍
      - 线程使用
        - 继承Thread
        - 实现Runnable
      - 线程方法
      - 线程生命周期
      - Synchronized
      - 互斥锁
      - 死锁
    - IO流
      - 文件
      - IO流原理及流的分类
      - 节点流和处理流
      - 输入流
        - InputStream
          - FileInputStream
          - BufferedInputStream
          - ObjectInputStream
        - Reader
          - FileReader
          - BufferedReader
          - InputStreamReader
      - 输出流
        - OutputStream 
          - FileOutputStream
          - BufferedOutputStream
          - ObjectOutputStream
        - Write
          - FileWriter
          - BufferedWriter
          - OutputStreamWriter
      - Properties类
    - 项目&学以致用-编程之乐
      - 坦克大战
  - 第三阶段：分析需求，代码实现能力
    - 网络编程
      - 网络基础
      - InetAddress
      - Socket
      - TCP编程
        - 字节流
        - 字符流
      - UDP编程
    - 反射
      - 反射机制
      - class类
      - 类的加载
      - 反射获取类的结构信息
        - Class
        - Field
        - Method
        - Constructor
        - 访问属性
        - 访问方法
    - mysql基础
      - mysql安装和配置
      - 数据库
      - 表
      - mysql数据类型
      - crud
      - 函数
      - 内连接
      - 外连接
      - 约束
      - 索引
      - 事务
    - JDBC和连接池
      - JDBC概述
      - JDBC快速入门
      - JDBC API
        - PreparedStatement
        - DriverManager
        - Statement
        - ResultSet
      - JDBCUtils
      - 事务
      - 批处理
      - 连接池
        - DataSource
        - DBCP
        - C3P0
        - Proxool
        - BoneCP
        - Druid
      - Apache DBUtils
      - DAO增删改查-BasicDAO
    - 正则表达式（非常实用）
      - 快速入门
      - 正则表达式基本语法
      - 三个常用类
        - Pattern
        - Matcher
        - PatternSyntaxException
      - 分组、捕获、反向引用
      - 元字符
        - 限定符
        - 选择匹配符
        - 分组组合和反向引用符
        - 特殊字符
        - 字符匹配符
        - 定位符
      - 应用实例
    - Java8 & 11 新特性
      - java8
        - lambda
        - 函数式接口
        - 接口静态方法
        - 接口默认方法
        - 方法引用
        - 构造器引用
        - Stream API
        - 并行流
        - 串行流
        - Optional
        - 新时间日期API
      - java11
        - 代码层面
          - JShell
          - 类型推断
          - 集合增强API
          - Stream 加强
          - 新增字符串处理方法
          - Optional 加强
          - InputStream 增强API
          - 标准Java异步HTTP客户端
        - 其他新特性
          - 简化的编译运行
          - 支持 Unicode10
          - Epsilon垃圾回收器
          - ZGC
          - JFR
          - 支持linux容器
          - 支持G1上的并行完全垃圾收集
          - 增加加密算法，代替RC4
          - 最新HTTPS安全协议TLS1.3
          - 移除和废弃的内容
    - 项目&学以致用-编程之乐
      - 骑士周游问题（算法-优化）
      - 满汉楼
      - 多用户通信系统-推消息 私聊 发文件
- java高级
  - java多线程/高并发
  - 数据结构和算法
    - 数据结构
      - 数组（系数数组）
      - 队列
      - 栈
      - 链表
      - 树
      - 散列
      - 堆
      - 图
    - 算法
      - 排序（8种）
      - 查找
      - 分治
      - 动态规划（背包问题）
      - 回溯（骑士周游问题）
      - 贪心算法
      - KMP
      - Prim
      - Kruskal
      - floyd-最短路径
      - 迪杰斯拉特-最短路径
  - 设计模式（23种）
  - JVM
- javaWEB
- 主流的框架和项目管理
  - Linux
  - Nginx（做反向代理和web服务）
  - SSM
    - Spring
    - SpringMVC
    - MyBatis
  - 项目管理
  - 数据库
  - 其他框架
- 分布式 微服务 并行架构
- DevOps，自动化部分管理项目，解决CI/CD
- 大数据技术
- 项目
- 高频面试题
- 底层源码/内核研究

# Java开发场景

举例1-SSM：
- Spring（轻量级的容器框架）
- SpringMVC（分层的web开发框架）
- MyBatis（持久化框架）

举例2-Android核心代码

举例3-大数据Hadoop

# 第二章 Java语言概述

##### Java 历史
Java 诞生小历史
- 1990年 sun公司启动绿色计划
- 1992年 创建oak语言 -> java
- 1994年 gosling 参加硅谷大会 演示java功能，震惊世界
- 1995年 sun正式发布java第一个版本
- 2009年，甲骨文宣布收购sun。2011，发布java7
- 2017年9月发布java8
- 2018年9月发布java11

Java技术体系平台
- JavaSE
  - 支持面相桌面级应用的java平台，提供了完整的java核心API
- JavaEE
  - 是为开发企业环境下的应用程序提供的一套解决方案。该技术体系中包含的技术如Servlet，Jsp等，主要针对web应用程序开发
- JavaME
  - 支持java程序运行在移动端上的平台，对Java API有所精简，并加入针对移动端的支持

##### Java 特点
1. Java语言是面向对象的
2. Java语言是健壮的。Java的强类型机制、异常处理、垃圾回收等特性是Java健壮性的重要保障
3. Java是跨平台的(一次编译，到处运行)。
4. Java语言是解释型的。

##### Java 运行机制及运行流程
- Java 核心机制---java虚拟机
  - JVM是一个虚拟的计算机，具有几零几并使用不同的存储区域。负责执行指令，管理数据、内存、寄存器，包含在JDK中。
  - 对于不同的平台，you不同的虚拟机。
  - Java虚拟机机制屏蔽了底层运行平台的区别，实现了"一次编译，到处运行"

什么是JDK，JRE
1. JDK的全称是 java development kit。<br> JDK = JRE + Java的开发工具（java,javac,javadoc,javap等）
2. JDK是提供给Java开发人员使用的，其中包含了java的开发工具，也包括了JRE。所以安装JDK，就不用单独再安装JRE了

JRE基本介绍
1. JRE （Java Runtime Environment）<br> JRE = JVM + Java核心的类库
2. 包括java虚拟机和java程序所需要的核心类库等，如果向要运行一个开发好的java程序，计算机中只需要安装JRE即可。

JDK、JRE和JVM的关系
1. JDK = JRE + 开发工具集
2. JRE = JVM + Java SE 标准类库
3. JDK = JVM + Java SE 标准类库 + 开发工具集
4. 如果只想运行开发好的.class文件 只需要JRE即可

xxx.java --> java.class --> jvm(java.class)

##### Java 开发环境搭建
略。。。

##### Java 快速入门

什么事编译
1. 有了java源文件，通过编译器将其编译成为JVM可以识别的字节码文件。
2. 在该源文件目录下，通过javac编译工具对Hello.java 文件进行编译。
3. 如果程序没有错误，没有任何提示，但在当前目录下会出现一个Hello.class 文件，该文件称为字节码文件，也是可以执行的java程序。

什么是运行
1. 有了可执行的java程序，就是把class文件放到jvm里执行，
2. 通过运行工具java对字节码文件进行执行。

java程序开发注意事项
1. 对修改后的Hello.java源文件需要重新编译，生成新的class文件后，再进行执行，才能生效。
2. java源文件以.java为扩展名。源文件的基本组成部分是类(class)，如本类中的Hello类。
3. java应用程序的执行入口是main()方法。它有固定的书写格式：public static void main(String[] args) {...}
4. java语言严格区分大小写。
5. java方法由一条条的语句构成，每个语句以;结束。
6. 大括号都是成对出现的，缺一不可。
7. 一个源文件中最多只能有一个public类。其他类的个数不限
8. 如果源文件包含一个public类，则文件名必须按该类名命名。
9. 一个源文件中最多值能有一个public类。其他类的个数不限，也可以将main方法卸载非public类中，然后指定非public类，这样入口方法就是非public的main方法。

##### Java 转义字符
1. \t： 一个制表位，实现对齐的功能
2. \n: 换行符
3. \\: 一个\
4. \": 一个"
5. \': 一个'
6. \r: 一个回车

##### 初学java易犯的错误
1. 找不到文件
<br>
解决方法：源文件名不存在或者写错，或者当前路径错误
2. 主类名和文件名不一致
<br>
解决方案：声明为public的主类应与文件名一致，否则编译失败。
3. 缺少分号
<br>
解决方法：编译失败，注意错误出现的行数，再到原码中指定位置改错。

##### 注释介绍
注释：用于注解说明解释程序的文字就是注释，注释提高了代码的阅读性；注释是一个程序员必须要具有的良好编程习惯。将自己的思想通过注释先整理出来，再用代码区体现。

java中的注释类型：
1. 单行注释<br>
格式： //注释文字
2. 多行注释<br>
格式：/* 注释文字 */
<br>

使用细节：
- 被注释的文字，不会被JVM解释执行
- 多行注释里面不允许有多行注释嵌套

3. 文档注释
定义：注释内容可以被JDK提供的工具`javadoc`所解析，生成一套以网页文件形式体现的该程序的说明文档，一般写在类
<br>
```java
javadoc -d 文件名 -author -version ...  Demo.java
```
| 标签          | 描述                                       | 示例代码                                                           |
|:------------|:-----------------------------------------|:---------------------------------------------------------------|
| @author     | 标记一个类的作者                                 | @author description                                            |
| @deprecated | 描述一个过期的类或成员                              | @deprecated description                                        |
| @docRoot    | 指明当前文档根目录的路径                             | Directory Path                                                 |
| @exception  | 标志一个类抛出的异常                               | @exception exception-name explanation                          |
| @inheritDoc | 从直接父类继承的注释                               | Inherits a comment from the immediate super class.             |
| @link       | 插入一个到另一个主题的链接                            | {@link name text}                                              |
| @linkplain  | 插入一个到另一个主题的链接,但是该链接显示纯文本文字               | Insert an in-line link to another topic                        |
| @param      | 说明一个方法的参数                                | @param parameter-name explanation                              |
| @return     | 说明返回值类型                                  | @return explanation                                            |
| @see        | 执行到另一个主题的链接                              | @see author                                                    |
| @serial     | 说明一个序列化属性                                | @serial description                                            |
| @serialData | 说明通过writeObject() 和writeExternal()方法写的数据 | @serialData description                                        |
| @since      | 表一当前引入一个特定的变化时                           | @since release                                                 |
| @throws     | 和 @exception 标签一样                        | the @throw tag has the same meaning as the @exception tag.     |
| @value      | 显示常量的值，该常量必须是static属性。                   | Display the value of a constant, which must be a static field. |
| @version    | 指定类的版本                                   | @version info                                                  |

<br>
<br>
<br>
<br>
##### Java 代码规范

1. 类、方法的注释，要以javadoc的方式来写。
2. 非 Java Doc的注释，往往是给代码的维护者看的，着重告诉读者为什么这样写
3. 使用tab操作，实现缩进，默认整体向右边移动，使用 `shift + tag` 整体向左移动
4. 运算符和 = 两边习惯各加一个空格。
5. 源文件使用utf-8编码
6. 行宽高度不要超过80字符
7. 代码编写次行风格和尾行风格


# 第三章 变量
目录：
- 变量介绍
- +号的使用
- 数据类型
- 编码
- 数据类型转换

##### 变量的介绍
- 概念：
  - 变量相当于内存中一个数据存储空间的表示，你可以把变量看做是一个房间的门牌号，通过门牌号我们可以找到房间，而通过变量名可以访问到变量（值）。 
-  变量使用细节
  - 变量表示内存中的一个存储区域【不同的变量，类型不同，占用的空间大小不同，比如int 4个字节，double 8个字节】
  - 该区域有自己的名称[变量名] 和 类型[数据类型]
  - 变量必须先声明，后使用，既有顺序
  - 该区域的数据可以在同一类型范围内不断变化
  - 变量在同一个作用域内不能重名
  - 变量=变量名+值+数据类型。`（变量三要素）` 

##### `+` 号的使用
1. 当左右两边都是数值时，则做加法运算
2. 当左右两边一方为字符串，则做拼接。
3. 运算顺序，是从左往右

##### `Java` 数据类型


Java 数据类型

- 基本数据类型
  - 数值型
    - 整数类型（byte[1],short[2],int[4],long[8]）
    - 浮点类型（float[4],double[8]）
  - 字符类型（char[2]）
  - 布尔型(boolean[1])
- 引用数据类型
  - 类（class）
  - 接口（interface）
  - 数组（[]）

>整数的类型

|类型|占用空间| 范围                                            |
|:-----|:-----|:----------------------------------------------|
|byte[字节]|1字节| -2^8 ~ 2^8 -1  <br> -128 ~ 127                |
|short[短整形]|2字节| -（2^15）~ （2^15）-1 <br> -32768 ~ 32767         |
|int[整形]|4字节| -（2^31）~ （2^31）-1 <br> -213783648 ~ 213783647 |
|long[长整形]|8字节| -（2^63）~ （2^63）-1        |


<br>

使用细节：
- java各整数类型有固定的范围和字段长度，不受具体操作系统的影响，以保证java程序的可移植性。
- java的整型常量默认为int型，声明long型常量须后加`L`
- java程序中限量常声明为int型，除非不足以表示大数，才使用long
- bit：计算机中最小存储单位。byte：计算机中基本存储单元，1byte=8bit。


>浮点类型

java的浮点类型可以表示一个小数。

| 类型        | 占用空间 | 范围                     |
|:----------|:-----|:-----------------------|
| 单精度float  | 4字节  | -3.403E38 ~ -3.403E38  |
| 双精度double | 8字节  | -1.798E308 ~ -1.798E308 |

说明：
- 关于浮点数在机器中存放形式的简单说明，浮点数=符号位+指数位——尾数位
- 尾数部分可能丢失，造成进度损失（小数都是近似值 ）

使用细节：
- 与整数类型类似，java浮点类型也有固定的范围和字段长度，不受OS的影响。
- java的浮点型常量默认为double，声明float需要加后缀`f`
- 浮点型有两种表示方式
  - 十进制：5.12 ，512.0f，.512
  - 科学计数法: 5.12e2, 5.12E-2 
  - 通常情况下，应该使用double，因为比float更加精确。

>字符类型

基本介绍：<br>
字符类型可以表示单个字符，字符类型是char，char是两个字节（可以存放汉字），
多个字符我们用字符串String

<br>

字符类型使用细节：
1. 字符类型是用单引号括起来的单个字符
2. java中还允许使用转义字符来将其后的字变为特殊字符型常量  `char c3 = '\n'`
3. 在java中，char的本质是一个整数，在输出时，是unicode码对应的字符。
4. 可以直接给char赋一个整数，然后输出时，会按照对用的unicode字符输出。
5. char类型是可以进行运算的，相当于一个整数，因为它都对应有Unicode码。


<br>

字符本质探讨：
1. 字符型存储到计算机中，需要将字符对应的码值找出来
   - 存储：'a' ==> 码值97 ==> 二进制 ==> 存储
   - 读取：二进制 ==> 97 ==> 'a' ==> 显示
2. 字符和码值的对应关系是通过字符编码表决定的
- Unicode(Unicode编码表固定大小的编码，使用两个字节来表示字符，字母和汉字统一都是占用两个字节，这样浪费空间)
- utf-8:（编码表，大小可变的编码 字母使用1个字节，汉字使用3个字节）

<br>

>布尔类型:boolean

基本介绍：
1. 布尔类型类型数据只允许取true或false，无null
2. boolean占一个字节。
3. boolean类型适用于逻辑运算，一般用于程序流程控制
- if
- while
- do-while
- for

##### 基本数据类型转换

自动类型转换：<br>
当java程序在进行赋值或运算时，精度小的类型自动转换为精度大的数据类型，这个就是自动类型转换。
<br>
转换规则：
- char -> int -> long -> float -> double
- byte -> short -> int -> long -> float -> double


<br>

使用细节：
1. 有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种类型，然后再进行运算
2. 当我们把`精度大`的数据类型赋值给`精度小`的数据类型时，就会报错，反之就会进行自动类型转换。
3. （byte、short）和char 之间不会自动转换
4. byte、short、char它们可以计算，在计算时首先转换为int类型。
5. boolean不参与转换
6. 自动提升原则：表达式结果的类型自动提升为操作数中最大的类型


##### 强制类型转换

自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。使用时要加上强制转换符`()`，但可能造成精度降低或溢出，格外要注意。

<br>

强制类型转换细节：
1. 当进行数据的大小 从 大 -> 小， 就需要进行强制类型转换
2. 强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级。
3. char类型可以保存int的常量值，但不能保存int的变量值，需要强转
4. byte和short类型在进行运算时，当做int类型处理


##### 基本数据类型和String类型的转换

介绍：
- 在程序开发中，我们经常需要将基本数据类型转成String类型。或者将String类型转换成基本数据类型。

基本类型转String类型
- 语法：将基本数据类型的值 +"" 即可。

String类型转基本数据类型
- 通过基本类型的包装类调用parseXX方法即可。

<br>

基本数据类型和String类型的转换注意事项：
1. 在String乐行转成基本数据类型时，要确保String类型能够转成有效的数据，比如我们可以把"123" 转成一个整数，但不能把"hello" 转成一个整数
2. 如果格式不正确，就会抛出异常，程序就会终止，这个问题在异常处理章节中会处理。