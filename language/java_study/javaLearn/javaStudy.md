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


xxx.java --> java.class --> jvm(java.class)

##### Java 开发环境搭建

