# Scala 介绍

##### Scala语言的特点

Scala是一门以JVM为运行环境并将**面向对象**和**函数式编程**的最佳特性结合在一起的静态类型编程语言。
1. Scala是一门多范式(multi-paradigm)的编程语言，Scala支持面向对象和函数式编程。
2. Scala源代码会被编译成java字节码，然后运行与JVM之上，并可以调用现有的Java类库，实现两种语言的无缝对接。
3. Scala在设计时，作者是参考了Java的设计思想，可以说Scala源于Java，同时他也加入了自己的设计思想，将函数式编程语言的特点融合到Java中。

# 第一章：注释

单行注释
```shell 
// 
```

多行注释
```shell 
/* */
```

文档注释
```shell 
/**
*/

scaladoc -d target_path source.scala
```

# 第二章：变量

```scala
val a:Short = 1

val b:Byte = 1

val age:Int = 10

val c:Long = 10

// 在scala中，小数默认为double类型，整数默认为Int类型
var score:Float = 99.9f

val salary:Double = 10.0

val isPass:Boolean = true

val gender:Char = 'M'

val name:String = "zhang san"
```


变量声明基本语法：
- var | val 


注意事项：
- 声明变量时，类型可以省略（编译器自动推导，即类型推导）
- 类型确定后，就不能修改，说明Scala是强数据类型语言
- 在声明一个变量时，可以使用var或者val来修饰，var修饰可变变量，val修饰不可变变量
- val修饰的变量在编译后，等同于加上了final
- 变量声明时，需要初始值。这里与Java不同。


##### 数据类型
- Scala 与 Java 有着相同的数据类型，在Scala中数据类型都是对象，也就是说Scala中没有Java中的原生类型
- Scala数据类型分为两大类，他俩都是对象
  - AnyVal （值类型）
  - AnyRef  (引用类型)
- 相对于java的类型系统，Scala更复杂，也正是这复杂多变的类型系统才让面向对象和函数式完美的融合在了一起


Scala数据类型
Any <-> Nothing
- AnyVal
  - Unit
  - StringOps
  - Char
  - Boolean
  - Byte
  - Short
  - Int
  - Long
  - Float
  - Double
- AnyRef <-> Null <- Nothing
  - Scala collections
  - all java classes
  - Other Scala classes


小结：
- 在Scala中有一个根类型Any，他是所有类的父类
- Scala中一切皆为对象，分为两大类 AnyVal(值类型)，AnyRef(引用类型)，它们都是Any的子类
- Null 是scala的特别类型，它只有一个值 null，它是是一个bottom class，是所有AnyRef的类型的子类
- Nothing 类也是 bottom class， 它是所有类的子类，在开发中通常可以将Nothing类型的值返回给任意变量或者函数，是抛异常时使用较多。
- 在Scala中仍然遵守，低精度向高精度自动转换（implicit conversion 隐式转换）


##### 布尔类型
1. 在Scala中，boolean类型只能取true 或 false。
2. boolean类型占1个字节。

##### Scala中的特殊类型

Unit、Null和Nothing

| 类型      |                                                       说明                                                       |
|:--------|:--------------------------------------------------------------------------------------------------------------:|
| Unit    |                             表示无值，和其他语言中的void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()                              |
| Null    |                                             null,Null类型只有一个实例值null                                             |
| Nothing | Nothing类型在Scala的类层级最低端；它是任何类型的子类型。当一个函数，我们确定没有正常的返回值，可以用Nothing来指定返回类型。这样有一个好处，就是我们可以把返回的值（异常）赋给其它的函数或者变量（兼容性）<br/> |


1. Null 类型只有一个实例对象，null，类似于java中的null引用。null可以赋值给任意的 **引用类型(AnyRef)**, 但是不能复制给**值类型(AnyVal; 比如：Int,Float,Char,Boolean,Long 等等)**
2. Nothing，可以作为没有正常返回值的方法的返回类型，非常只管的告诉你这个方法不会正常返回，而且由于Nothing是其他任意类型的子类型，他还能跟要求返回值的方法兼容。简单说，Nothing主要用来抛异常用的。

##### 强制类型转换
1. 当进行数据的从 大 --> 小， 就需要强制类型转换
2. 强转符号只针对最近的操作数有效，往往会使用小括号提升优先级
3. Char类型可以保存Int的常量值，但不能保存Int的变量值，需要强转
4. Byte和Short类型在进行运算时，当做Int类型处理

# 第五章： 函数式编程（基础）

本章内容：
- 函数式编程基础
  - 函数定义/声明
  - 函数运行机制
  - *** 递归 [马丁强烈推荐使用递归来解决问题]
    - 递归是算法基础，如 邮差问题，最短路径，背包问题，迷宫问题回溯，
  - 过程
  - 惰性函数和异常
- 函数式编程高级
  - 值函数（函数字面量）
  - 高阶函数
  - 闭包
  - 应用函数
  - 柯里化函数，抽象控制。。。


##### 需要明确的概念
在Scala中需明确方法、函数、函数式编程和面向对象编程：
- 在Scala中，方法和函数几乎可以等同（比如它们的定义、使用、运行机制都一样），只是函数的使用更加灵活（方法转函数）
- 函数式编程是从编程范式的角度来谈的，可以这样理解：函数式编程把函数当做一等公民，充分利用函数、支持函数的多种使用方式
  - 比如：在Scala中函数像变量一样，即可以当做函数的参数使用，也可以将函数赋值给一个变量，函数的创建不依赖类或对象，而在Java中，函数的创建则要依赖于类或者接口
- 面相对象编程是以对象为基础的编程方式
- 在Scala中函数式编程和面向对象编程融合在了一起
- 函数式编程介绍
  - 函数式编程是一种编程范式属于”结构化编程“的一种，主要思想是把运算过程尽量写成一些列嵌套的函数调用
  - 函数式编程中，将函数也当做数据类型，因此可以接收函数当做输入和输出

##### 递归
递归：是一种解决复杂问题的方法
1. 将一个复杂问题拆解成多个解决方法一致的小问题，从而简化问题
2. 定义一个解决小问题的方法，然后在这个方法内再去嵌套调用自身方法
3. 定义方法时需要注意：
3.1 明确递归调用方法的结束条件，不然会无限递归
3.2 递归不能使用类型推导，必须指定返回的数据类型
4. 运行机制：
4.1 将方法按照递归调用条件依序压入栈中去执行方法

##### 过程
将函数的返回类型为Unit的函数称之为过程(Procedure)，如果明确函数没有返回值，那么等号可以省略

函数递归需要遵守的重要原则：
1. 执行一个函数时，就创建一个新的受保护的独立空间（stack）
2. 函数的局部变量时独立的，不会互相影响
3. 递归必须向退出递归的条件逼近，否则就是无限递归
4. 当一个函数执行完毕，或者遇到return，就会返回，遵守谁调用就把结果返回给谁。


##### 惰性函数

惰性计算（尽可能延迟表达式求值）是许多函数式编程语言的特性。惰性集合在需要时提供其元素，无需预先计算它们，这带来了一些好处。首先，可以将耗时计算推迟到
绝对需要的时候。其次，可以创造无限个集合，只要它们继续收到请求，就会继续提供元素。函数的惰性使用能够得到更搞笑的代码。Java并没有为惰性提供原生支持，但Scala提供了

注意事项：
> 1. lazy 不能修饰 var 类型的变量
> 2. 不单是在调用函数时，加了lazy会导致函数的执行被退出，在声明一个变量时，如果加了lazy，那么变量值的分配也会被推迟

##### 异常处理

Scala异常处理小结：
1. > 我们将可以代码封装在try中。在try块之后使用了catch处理程序来捕获异常。如果发生任何异常，catch处理程序将它处理，程序将不会异常终止。
2. > Scala的异常的工作机制和Java一样，但是Scala没有 "checked(编译期)" 异常，即Scala没有编译异常这个概念，异常都是在运行时捕获处理。
3. > 用 `throw` 关键字，抛出一个异常对象。 所有异常都是Throwable的子类型。throw表达式没有类型的，就是Nothing，因为Nothing是所有类型的子类型，所以 throw 表达式可以唵在任何需要类型的地方
4. > 在Scala里，借用了模式匹配的结果来做异常工作，因此，在catch的代码里，是一系列case子句来匹配异常。
5. > 异常捕获的机制与其他语言一样，如果有异常发生，catch子句是按次序捕获的。因此，在catch子句中，越具体的异常越要靠前，越普遍的异常越靠后，如果把越普遍的异常写在前，把具体异常写在后，也不会报错. !但是，这是非常不好的编码风格。
6. > finally 子句用于执行不管时正常处理还是异常发生时都需要执行的步骤，一般用于对象的清理工作和Java一样
7. > Scala提供了throws关键字来声明异常。可以使用方法定义声明异常。它向调用者函数提供了此方法可能引发的异常信息。它有助于调用函数处理并将该代码包含在try-catch中以避免程序异常终止
```scala 
@throws(classOf[NumberFormatException]) // 等同于 NumberFormatException.class
def test2(): Unit = {
    println("提示可能抛出NumberFormatException异常")
}
```

# 第六章： 面相对象编程（基础）

Scala语言面向对象
1. Java是面向对象的，由于历史原因，Java中还存在着非面向对象的内容如：int, null, 和 静态方法 等。
2. Scala是纯粹的面向对象，真正做到万物皆对象。

##### 构造器

和Java一样，Scala构造器也需要调用构造方法，并且可以由任意多个构造器

Scala构造器有两种：主构造器 和 辅助构造器

```scala 
class 类名(形参列表){ // 主构造器
  
  def this(形参列表) {} // 辅助构造器
  
  def this(形参列表) {} // 辅助构造器
}
```

构造器注意事项和细节：
1. Scala构造器作用是完成对新对象的初始化，构造器没有返回值。
2. 主构造器的声明直接放置于类名之后
3. 主构造器会执行类定义中的所有语句，这里可以体会得到Scala函数式编程和面向对象编程的融合，即：构造器也是方法，传参和使用方法和函数没有区别
4. 如果主构造器无参数，小括号可以省略，构建对象时调用的构造方法小括号可以省略
5. 辅助构造器名称为this，多个辅助构造器通过不同的形参列表进行区分，底层类似于java的构造器重载。
6. 如果想让主构造器变成私有的，可以在 () 之前加上private，这样用户只能通过辅助构造器来构造对象
7. 辅助构造器的声明不能和主构造器的声明一致，会发生错误

构造器参数
1. Scala类的主构造器函数的形参未用任何修饰符修饰，那么这个参数时局部变量
2. 如果参数使用val关键字声明，那么Scala会将参数作为类的私有的只读属性使用
3. 如果参数使用var关键字声明，那么Scala会将参数作为类的成员属性使用，并会提供属性对应的xxx()类似getter setter方法，即这时的成员属性是私有的，但是可以读写

```scala
// 如果主构造器的形参没有使用任何修饰符，
// 那么这个参数就是一个局部变量，范围就是主构造器中。
class ConstructorParamsDemo01(name: String) {

}

// 如果主构造器的形参用val修饰
// 那么这个形参会成为这个类的只读的私有属性 即 private final String name
// 实例化后可以直接访问这个属性
class ConstructorParamsDemo02(val name: String) {

}


// 如果主构造器的形参用var修饰
// 那么这个参数就是一个private 可读写的属性
class ConstructorParamsDemo03(var name: String) {

}

// BeanProperty 会自动生成 类似Java 的 Getter Setter 方法
class Car(
  @BeanProperty val car: String,
  @BeanProperty val color: String
) { }
```

##### Scala 创建对象的流程
1. 加载类的信息（属性信息，方法信息）
2. 在内存中（堆）开辟空间
3. 使用父类的构造器（主和辅助）进行初始化
4. 使用主构造器对属性进行初始化
5. 使用辅助构造器对属性进行初始化
6. 将开辟的对象地址赋值给xxx这个常量/变量进行引用

# 第七章：Scala 面向对象中级

##### Scala 包

Scala的包比Java更加强大且相对复杂一些

包的注意事项和使用细节:
1. 包也可以像嵌套类那样嵌套使用，这样做的好处是，可以在同一个文件中将 class object trait 创建在不同包中，这样非常灵活
2. 作用域原则：可以直接向上访问。即：Scala中子包可以直接访问父包中的内容。在子包和父包类重名时，默认采用就近原则，如果希望指定某个类，则带上包名即可
3. 父包要访问子包内容时，需要import对应的类
4. 可以在同一个.scala文件中，声明多个并列的package

##### 包对象
基本介绍：包可以包含类、对象和特质，但不能包含函数或变量的定义。这是JVM的局限。为了弥补这一点不足，Scala提供了包对象的概念来解决这个问题

注意事项：
1. 每个包都可以有一个包对象。你需要在父包中定义它
2. 包对象名称需要和包名一致，一般用来对包的功能补充

##### 包的可见性
1. 当属性访问权限为默认时，底层看是private的，但是提供了 xxx_$eq() 类似getter setter方法，因此从使用效果看任何地方都可以访问
2. 当方法访问权限为默认时，默认为public访问权限
3. private为私有权限，只在类的内部和伴生对象中使用
4. protected 在Scala中比Java要严格，只能子类访问，同包无法访问
5. 在Scala中没有public关键字，即不能用public显示的修饰属性和方法
6. 包访问权限（表示属性有了限制。同时包也有了限制），这点和Java不同。
```scala
package visit

class TestPerson {
    // 这是限制了只有类内部和伴生对象中访问
    private val name:String = "zhang san"
    
    // private[visit] : 此时 age 属性仍然是私有的，但是在visit包下也可以使用这个属性 
    // 相当于扩大了访问烦我
    private[visit] val age:Int = 10 
    
}

class Test {
  def main(args: Array[String]): Unit = {
    val person: TestPerson = new TestPerson
    println(person.age)
  }
}
```

##### 包的引入

1. 在Scala中，import语句可以出现在任何地方，并不仅限于文件顶部。import语句的作用一致眼神到包含该语句块的末尾。这种语法的好处是：在需要时引入，缩小import的作用范围，提高效率
2. 如果不想要某个包中的全部类，而是其中几个类，可以采用选择器 
```scala
import scala.collection.mutable.{HashMap,HashSet}
```
3. 如果引入多个包含有相同的类，那么可以将不需要的类进行重命名进行分区

```scala
import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable._

var map = new HashMap() // scala HashMap
var m1 = new JavaHashMap() // java HashMap
```
4. 如果某个冲突的类根本就不会用到，那么可以直接隐藏掉该类
```scala
import java.util.{ HashMap => _,_} // 含义为 引入java.util包的所有类，但忽略掉hashMap 这个类

var map = new HashMap() // scala HashMap ,而且idea也不会提示有java HashMap
```


##### Scala 抽象
把一类事物的共同属性和方法提取出来，形成一个屋里模型。这种研究问题的方法称为抽象

举例：不管是工行还是Chase的银行账号，都应该有 [账号，余额，...] 等属性 以及 [存款，取款，...] 等方法


##### Scala 继承

当修改父类时，对应的子类就会继承想用的方法和属性，从而提高了扩展性和维护性。

Scala中超类的构造
1. 类有一个主构造器和任意数量的辅助构造器，而每个辅助构造器都要先调用主构造器
2. 只有主构造器可以调用父类构造器。辅助构造器不能直接调用父类的构造器。即不能 super(params)

覆写字段：
1. 在Scala中，子类改写父类的字段，称之为覆写字段。需要使用override修饰
2. def 只能覆写另一个def
3. val 只能覆写另一个val 或不带参数的def
4. var 只能重写另一个抽象的var属性 【抽象属性：声明未初始化的变量就是抽象的属性，抽象属性在抽象类】
   - 一个属性没有初始化，那么这个属性就是抽象属性
   - 抽象属性在编译成字节码文件时，属性并不会声明，但是会自动生成抽象方法，所以类必须声明为抽象类
   - 如果是覆写一个父类的抽象属性，那么override关键字可以省略（因为父类的抽象属性，生成的是抽象方法，因此就不涉及到方法的重写概念，因此override可以省略）

##### 抽象类
在Scala中通过abstract关键字标记不能被实例化的类。 方法 `不用标记` abstract，只要省掉方法体即可。抽象类可以拥有抽象字段，抽象字段就是没有初始值的字段。

抽象类的价值更多是在于设计层面，是设计者设计好后，让子类继承并实现抽象。

使用细节：
1. 抽象类不能实例化
2. 抽象类不一定包含abstract方法。也就是说，抽象类可以没有abstract方法
3. 一旦包含了抽象方法或抽象属性，则这个类必须声明abstract
4. 抽象方法不能有主题，不允许使用abstract修饰
5. 如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法和抽象属性，除非它自己也声明为abstract类
6. 抽象方法和抽象属性不能使用private、final来修饰，因为这些关键字是和重写/实现相违背的
7. 抽象类中可以实现的方法
8. 子类重写抽象方法不需要override，但是写上也不会报错


# 第八章：面向对象（高级）

##### 伴生对象
Scala语言是完全面向对象的（万物皆对象）语言，所以并没有静态的操作（即，在Scala中没有静态的概念）。但是为了能够和Java语言交互，就产生了一种特殊的对象来模拟类对象，我们
称之为`伴生对象`。这个类的所有静态内容都可以防止在它的伴生对象中声明和调用

小结：
1. Scala中伴生对象采用object关键字声明，伴生对象中声明的全是“静态”内容，可以通过伴生对象名称直接调用。
2. 伴生对象对应的类称之为伴生类，伴生对象的名称应该和伴生类名一致。
3. 伴生对象中的属性和方法都可以通过`伴生对象名（类名）直接调用`访问
4. 从语法角度来讲，所谓的伴生对象其实就是类的静态方法和成员的集合
5. 从技术角度来讲，Scala还是没有生成静态的内容，只不过是将伴生对象生成了一个新类，实现了属性和方法的调用。
6. 从底层原理看，伴生对象实现静态特性依赖于 public static final MODULE$ 实现的。
7. 伴生对象的声明和伴生类的声明在同一个元阿莫文件中（如果不再同一个文件中会运行错误！），但是如果没有伴生类，也就没有所谓的伴生对象了，所以放在哪都无所谓。
8. 如果classA独立存在，那么A就是一个类，如果objectA独立存在，那么A就是一个 “静态” 性质的对象【即，类对象】，在objectA中声明的属性和方法都可以通过A.属性来实现调用。
9. 当一个文件中，存在伴生类和伴生对象时，文件图标就会发生变化。

##### 伴生对象apply()方法
在伴生对象中定义apply()方法，可以实现，类名() 方式来创建实例。


##### Scala特质

从面向对象来看，接口并不属于面向对象的范畴，Scala是纯面向对象的语言，在Scala中，没有接口。

Scala中，采用trait来代替接口的概念，也就是说，多个类具有共同的特征时，就可以独立出来，采用trait（等价于 interface + abstract class）声明。

在Scala中，Java 的interface 都可以当做特质来使用。

##### Scala中trait的使用
一个类具有某种特质，就以为着这个类满足了这个特质的所有要素，所以在使用时，也采取了extends关键字，如果多个特质或存在父类，那么需要采用with关键字链接

##### trait 细节
1. trait可以同时拥有抽象方法和具体方法，一个类可以实现/继承多个特质。
2. 特质中没有实现的方法就是抽象方法。类通过extends继承特质，通过with可以继承多个特质。
3. 所有java接口都可以当做Scala特质使用。

##### 动态混入
1. 除了可以在类声明时继承特质以外，还可以在构建对象时混入特质，扩展目标类的功能
2. 此种方式也可以用于对抽象类功能进行扩展
3. 动态混入是Scala特有的方式（Java没有），可以在不修改类声明/定义的情况下，扩展类的基本功能，非常灵活，耦合性低
4. 动态混入可以在不影响原有的继承关系的基础上，给制定的类扩展功能。

##### 叠加特质
构建对象的同时混入多个特质，称之为叠加特质，那么特质声明的顺序是从左到右，方法从右到左。
1. 特质的声明顺序是从左到右。
2. Scala在执行叠加对象方法时，会首先从后面的特质（从右向左）开始执行
3. Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
4. 如果向要调用具体特质的方法，可以指定：super[特质].xxx(...) 其中的泛型必须是该特质的直接超类类型
5. abstract override: 可以这样理解，当我们给某个方法增加了abstract override后，就是明确的告诉编译器，该方法确实是重写了父特质的抽象方法，但是重写后，该方法仍然是一个抽象方法（因为完全没有实现，需要其他特质继续实现）

##### 富接口
即该特质中既有抽象方法，又有非抽象方法

##### 特质中的具体字段
特质中可以定义具体字段，如果初始化了就是具体字段，如果不初始化就是抽象字段。混入该特质的类就具有了该字段，字段不是继承的，而是直接加入类，成为自己的字段。

##### 特质构造顺序

特质也是有构造器的，构造器中的内容由 “字段的初始化和一些其他语句构成”。

第一种特质构造顺序（声明类的同时混入特质）：
1. 当调用当前类的超类构造器
2. 第一个特质的父特质构造器
3. 第一个特质构造器
4. 第二个特质构造器的父特质构造器，如果已经执行过，就不再执行
5. 第二个特质够再起
6. 重复...
7. 当前构造器

```scala
object Demo05_ {
    def main(args: Array[String]): Unit = {
        // 1. 首先调用超类构造器 E...
        // 2. 然后从左往右找第一个特质的C的超类构造器，找到C，发现C的超类构造器是B，
        //    然后B的超类构造器是A，所以执行A...
        // 3. B...然后 C...
        // 4. 执行完C后找D，然后又寻根溯源找到A，B，但是发现都执行过就跳过了。 直接执行D...
        // 5. 最后执行自己 F...
        val ff: FF = new FF()
    }
}

// traits ...
trait A {
    println("A...")
}

trait B extends A {
    println("B...")
}

trait C extends B {
    println("C...")
}

trait D extends B {
    println("D...")
}

// classes ...

class EE {
    println("E...")
}

class FF extends EE with C with D {
    println("F...")
}

class KK extends EE {
    println("K...")
}
```

第二种特质的构造顺序（在构建对象时，动态混入特质）
1. 调用当前类的超类构造器
2. 当前类构造器
3. 第一个特质构造器的父构造器
4. 第一个特质构造器
5. 第二特构造器的父构造器，如果已经执行，就不再执行
6. 第二个特质构造器
7. 重复...
8. 当前构造器

```scala
// 动态混入
// 这里先创建KK,然后再混入
// 1. 调用当前类的超类构造器
// 2. 当前类构造器
// 3. 第一个特质构造器的父构造器
// 4. 第一个特质构造器
// 5. 第二特构造器的父构造器，如果已经执行，就不再执行
// 6. 第二个特质构造器
// 7. 重复...
// 8. 当前构造器
// E...
// K...
// A...
// B...
// C...
// D...
val kk:KK = new KK() with C with D
```

区别：
1. 第一种方式实际是构建类对象，在混入特质时，该对象还没创建。
2. 第二种方式是构造匿名子类，可以理解成在混入特质时，对象已经创建了。


##### 扩展类的特质

特质可以继承类，用以来拓展该类的一些功能。

所有混入该特质的类，会自动成为那个特质所继承的超类的子类。

如果混入特质的类，已经继承了另一个类（A类）, 则要求A类是特质超类的子类，否则就会出现了多继承现象，发生错误。
```scala
trait LoggedException extends Exception {
  def log():Unit = {
    println(getMessage) // 这个方法来自Exception 类
  }
}

// 如果混入特质的类，已经继承了另一个类（A类）,
// 则要求A类是特质超类的子类，否则就会出现了多继承现象，发生错误。
class GoodHappyException extends IndexOutOfBoundsException with LoggedException {}

// 错误！
class CCC {}

// 这样不对。不行。 CCC 不是Exception 的子类
// class BadHappyException extends CCC with LoggedException{}
```

##### 特质的自身类型
自身类型：主要是为了解决特质的循环依赖问题，同时可以确保特质在不扩展某个类的情况下，依然可以做到限制混入该特质的类的类型

```scala
// Logger就是自身类型特质，当做了自身类型后，
// 那么 trait Logger extends Exception，要求混入该特质的类也是Exception子类
trait Logger {
    // 明确告诉编译器，我就是Exception，如果没有这句话，下面的getMessage不能调用
    this: Exception =>
    
    def log():Unit = {
        // 既然我就是Exception，那么就可以调用其中的方法
        println(getMessage)
    }
}

// 不对！！！因为Console 不是Exception的子类
// class Console extends Logger{}

// 对。因为先继承了Exception再混入的
class Consoles extends Exception with Logger
```

##### 嵌套类

在Scala中，几乎可以在任何语法结构中内嵌任何语法结构。如果类中可以再定义一个类，这样的类就是嵌套类。类似Java中的内部类。

在Java中，一个类的内部又完整的嵌套了另一个完整的类结构。被嵌套的类称为内部类，嵌套其他类的类称为外部类。内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系。

```scala
class Outer {
    Temp =>  // 起别名，别名必须写在最前面 等价于 Outer.this
    val name: String = "zhang san"
    private val salary: Double = 35000.00
    
    class Inner {
        def into(): Unit = {
            println(s"name= ${Outer.this.name}; salary:${Outer.this.salary}")
        }
        
        def show():Unit = {
            println(s"Name = ${Temp.name}; Salary: ${Temp.salary}")
        }
    }
}
```


# 第九章：隐式转换和隐式值

##### 注意事项和细节
1. 隐式转换函数的函数名可以任意取，隐式转换与函数名无关，只与函数签名（函数参数类型和返回值类型）有关。
2. 隐式函数可以有多个（即：隐式函数列表），但是需要保证在当前环境下，只有一个隐式函数被识别。

##### 隐式转换丰富类库功能

如果需要为一个类增加一个方法，可以通过隐式转换来实现（动态增加功能）比如向为MySQL增加一个delete方法

```scala
class Demo01_ {
    implicit def addDelete(m:MySQL):DB = new DB
    
    def main(args: Array[String]): Unit = {
        val mysql: MySQL = new MySQL
        mysql.insert()
        mysql.delete()
    }
}

class MySQL {
    def insert():Unit = {}
}

class DB {
    def delete():Unit = {}
}
```

##### 隐式值

隐式值也叫隐式变量，将某个形参标记为Implicit，所以编译器会在方法省略隐式参数的情况下去搜索作用域内的隐式值作为却省参数

##### 隐式类
隐式类非常强大，同样可以扩展类的功能，比 前面使用隐式转换丰富类库功能更加方便，在集合中隐式类会发挥重要作用。

隐式类的几个特点：
1. 其所带的构造参数有且值能有一个
2. 隐式类必须定义在类 或 伴生对象 或 包对象里，即饮食类不能是顶级的
3. 隐式类不能是case class
4. 作用域内不能有与之相同名称的标识符

# 第十章：集合

1. Scala 同时支持`不可变集合` 和 `可变集合`，不可变集合可以安全的并发访问。
2. Scala默认采用不可变集合，对于几乎所有的集合类，Scala都同时提供了可变和不可变的版本
3. Scala集合有三大类 `序列Seq`, `集Set`,和 `映射Map`，所有的集合都扩展自 Iterable特质。

##### 结构概览

- Traversable
  - Iterable
    - Set
      - HashSet
      - SortedSet
        - TreeSet
      - BitSet
      - LIstSet
    - Map
      - HashMap
      - SortedMap
        - TreeMap
      - ListMap
    - Seq
      - IndexedSeq
        - Vector
        - NumericRange
        - Array
        - String
        - Range
      - LinearSeq
        - List
        - Stream
        - Queue
        - Stack


##### 可变和不可变
1. 不可变集合：Scala 不可变集合，就是这个集合本身不能动态变化。就是集合的长度不能变。
2. 可变集合：可变集合，就是这个集合长度可以变化，能动态增长。

java回顾
```java
public class JavaCollectionReview_ {
    public static void main(String[] args) {
        //不可变集合，类似于Java数组
        int[] nums = new int[3];
        nums[0] = 1;
        String[] names = {"a","b"};
        System.out.println(nums + " " + names);

        // 可变集合举例
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        System.out.println(strings + " " + strings.hashCode());
    }
}

```

##### Scala 元组

元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据。简单说，就是将多个无关的数据封装为一个整体，称之为元组

注意：元组中最大只能有22个元素


# 第十一章：集合操作

在Scala中可以通过map映射操作，将集合中的没一个元素通过指定功能映射成新的结果集合，即将函数作为参数传递给另一个函数，这是函数式编程的特点。

##### 流-Stream

stream 是一个集合。这个集合，可以用于存放无穷多个元素，但是这无穷个元素并不会一次性生产出来，而是需要用到多大的区间，就会动态的产生，末尾元素遵循lazy规则
1. Stream集合存放的数据类型Bigint
2. numsForm是一个自定义的函数，函数名是程序指定的
3. 创建的集合的第一个元素时n，后续元素生成的规则是n+1
4. 后续元素生成的规则是可以程序员指定的，比如numsForm(n*4)

##### 视图-View
Stream的懒加载特性，也可以对其他集合应用view方法来得到类似效果，具有一下特点：
1. view方法产出一个总是被懒执行的集合。
2. view不会缓存数据，每次都要重新计算，比如重新遍历view时。

##### 线程安全的集合
1. SynchronizedBuffer
2. synchronizedMap
3. SynchronizedPriorityQueue
4. SynchronizedQueue
5. SynchronizedSet
6. SynchronizedStack

##### 并行集合
1. Scala为了充分使用多核CPU，提供了并行集合，用于多核环境的并行计算
2. 主要用到的算法有： Divide and conquer（分治算法），Scala通过splitters，combiners等抽象层来实现，
主要原理是将计算工作分解很多任务，分发给一些处理器去完成，并将它们处理结果合并返回。
Work stealin算法，主要用于任务调度负载均衡，通俗点完成自己的所有任务之后，发现其他人还有没干完的活，主动活被动帮他人一起干，这样达到今早干完的目的。

# 第十二章：模式匹配

模式匹配语法中，采用match关键字声明，每个分支采用case关键字进行声明，当需要匹配时，会从第一个case分支开始，如果匹配成功后，那么执行对应的逻辑代码，如果
匹配不成功，会执行下一个分支进行判断。如果所有case都不匹配，那么会执行 case _ 这个默认分支。

##### 样例类

1. 样例类仍然是类
2. 样例类用case关键字进行声明
3. 样例类是为匹配模式而优化的类
4. 构造器中每一个参数都成为val，除非被显式定义为var（不推荐这样做）
5. 在样例类对应的伴生对象中提供apply方法，让你不用new关键字就能构造出对应的对象
6. 提供unapply方法，让模式匹配可以工作
7. 将自动生成toString，equals，hashCode，和copy等方法（有点类似模板类，直接给生成）
8. 除上述外，样例类和其他类型完全一样。可以添加任何方法和字段，来进行扩展。

##### 密封类
1. 如果向让case类的所有子类都必须在申明该类的相同的源文件中定义，可以将样例类的通用超类声明为sealed，这个超类称之为密封类
2. 密封就是不能在其他文件中定义子类。


# 第十三章：函数式编程

##### 偏函数
1. 在对符合某个条件，而不是所有情况进行逻辑操作时，使用偏函数是一个不错的选择
2. 将包在大括号内的一组case语句封装为函数，我们称之为偏函数，它只对会作用与指定类型的参数或指定范围值的参数实施计算，超出范围的值会忽略。
3. 偏函数在Scala中是一个特质PartialFunction

```scala

val list: List[Any] = List(1, 2, 3, 4, 5, "abc")

// 使用偏函数
// 表示偏函数接收的类型是Any，返回的类型是Int类型
// def isDefinedAt(x: Any): Boolean 如果返回true，就会去调用apply方法，构建对象实例，如果是false 就过滤
//
val partialFunc: PartialFunction[Any, Int] = new PartialFunction[Any, Int] {
    override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Int]
    
    override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1
}
// 如果是使用偏函数，则不能使用map，而是使用collect
list.collect(partialFunc).foreach(println)

// 简化形式
list.collect{case i:Int => i + 1}.foreach(println)
```

##### 作为参数的函数
在Scala中，函数也是有类型的
```scala
def plus(x:Int):Int = x + 3
```
比如plus就是function1.因为只有一个参数，如果有2个参数就是function2。

##### 匿名函数
没有名字的函数就是米明函数，通过函数表达式来设置米明函数
```scala
val triple = (x:Double) => x * 3
```


##### 高阶函数

能够接受函数作为参数的函数就是高阶函数（higher-order function)。 可使应用程序更加健壮。

##### 闭包
闭包就是一个函数和与其相关的引用环境组合的一个整体

```scala
def aFunc(x: Int): Int => Int = (y: Int) => x + y

// f 就是闭包
// 函数[(y:Int) => x -y] + 外部变量x[20] 构成了一个闭包
val f: Int => Int = aFunc(20)

/* 小结 
1. （y:Int） => x + y 返回的是一个匿名函数，因为该函数引用到函数外的x，那么该函数和x整体形成一个闭包
2. 可以这样理解，返回函数是一个对象，而x就是该对象的一个字段，他们共同形成一个闭包
3. 当多次调用f时，发现使用的是同一个x，所以x不变
4. 在使用闭包时，主要搞清楚函数引用了函数外的哪些变量，因为他们会组合成一个整体（实体），形成一个闭包
*/

println(f(5))
```

闭包的好处：
一次定义定义到处使用。


##### 函数柯里化(curry)

1. 函数编程中，接受多个参数的函数都可以转化为接受单个参数的函数，这个转化过程就叫柯里化
2. 柯里化就是证明了函数值需要一个参数而已。其实我们刚才的学习过程中，已经设计到了柯里化操作。
3. 不用设立柯里化存在的意义这样的命题。柯里化就是以函数为主题这种思想发展的必然结果（即：柯里化是面向函数思想的必然结果）

##### 抽象控制基本介绍

控制抽象是这样的函数，满足如下条件：
1. 参数是函数
2. 函数参数没有输入值夜没有返回值

```scala
// 抽象控制demo

// 1.输入是一个函数
// 2. 输入的函数没有形参也没有返回值
def myAbstractControlDemo(f: => Unit): Unit = {
    new Thread {
        override def run(): Unit = f
    }.start()
}

// 这玩意跑多线程很不错。
// 使用案例

(1 to 200).foreach{ _ =>
    myAbstractControlDemo {
        println("Hello World...")
        Thread.sleep(1000)
        println("Rock the JVM...")
    }
}
```

高阶玩法

```scala
// 传统写法
var x: Int = 10
while (x > 0) {
    x -= 1
    println(s"x = $x")
}

// 控制抽象写法
def myUntil(condition: => Boolean)(block: => Unit): Unit = {
    if (condition) {
        block
        myUntil(condition)(block)
    }
}

var y = 100
myUntil(y > 0) {
    y -= 1
    println(s"y = $y")
}
```


# 第十四章：使用递归去思考去编程
Scala 是运行在JVM机之上，因此具有如下特点：
1. 轻松实现和丰富的Java类库互联互通
2. 它既支持面向对象，又支持函数式
3. 它写出的程序像动态语言一样简洁，但事实上它确实严格意义上的静态语言。
4. Scala就像一位武林中的集大成者，将过去几十年计算机语言发展历史中精粹集于一身，化繁为简。设计者老马，希望Scala是一门作为简洁、高效、令人愉快的语言。同时也在启发者使用者的编程思想。

再说一下编程范式：
1. 在所有的编程范式中，面向对象编程无疑是最大的赢家。
2. 但其实面向对象编程并不是一种严格意义上的编程范式，严格意义上的编程范式分为：命令式编程（Imperative Programming）、函数式编程（Functional Programming）和 逻辑是编程 （Logic Programming）. 
面相对象编程只是上述几种范式的一个较差产物，更多的还是继承了命令式编程的基因。
3. 在传统语言设计中，只有命令式编程得到了强调，那就是程序员要告诉计算机应该怎么做。而递归则通过灵巧的函数定义，告诉计算机做什么。因此在使用命令式编程思维中，是现在多数人采用的编程方式，递归出镜率比较低， 
而在函数式编程中，递归随处可见。

来看一个案例：
```scala
 // 传统办法: 
val now: Date = new Date()
val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
val strNow: String = dateFormat.format(now)
println(s"start time: $strNow")

var res: BigInt = BigInt(0)
var num: BigInt = BigInt(1)
var maxVal = BigInt(100000000l)

while (num <= maxVal) {
    res += num
    num += 1
}
val done: String = dateFormat.format(new Date())
println(s"result: $res")
println(s"completed at: $done")

// 递归方式计算
def mySum(num:BigInt,sum:BigInt):BigInt = {
    if(num <= 100000000l) mySum(num+1,sum + num)
    else sum
}

println(s"recursive start: ${dateFormat.format(new Date())}")
mySum(BigInt(0),BigInt(1))
println(s"recursive complete: ${dateFormat.format(new Date())}")
```

输出： 

```text
start time: 2025-05-24 10:48:19
completed at: 2025-05-24 10:48:19

recursive start: 2025-05-24 10:48:19
recursive complete: 2025-05-24 10:48:20
```

结论：
函数式编程的重要思想就是尽量不要产生额外的影响，传统方式的代码不太符合函数式编程的思想。使用递归看起来在性能上并不比传统方式慢，但是要注意递归使用陷阱。


# 第十五章：练手项目实践

一个简单的CRM

# 第十六章：AKKA - 一个并发编程模型

##### AKKA介绍
1. Akka是JVM平台上构建高并发、分布式和容错应用的工具包和运行时，可以理解为：Akka是编写并发程序的框架
2. Akka用Scala语言写成，同时提供了Scala和Java开发接口
3. Akka主要解决的问题是：可以轻松的写出高效稳定的并发程序，程序员不再过多的考虑线程、锁和资源竞争的细节。


##### Akka中的Actor模型以及用于解决什么问题：
1. 处理并发问题关键是要保证共享数据的一致性和正确性，因为程序是多线程时，多个线程对同一个数据进行修改，若不加同步条件，势必会造成数据污染。但是当我们对关键代码加入同步条件synchronized
后，实际上并发就会阻塞在这段代码，对程序效率有很大影响
2. 若是用单线程处理，不会有数据一致性问题，但是系统的性能有不能保证。
3. Actor模型的出现就解决了这个问题，简化并发编程，提高程序性能。可以这样理解：Actor模型是一种处理并发问题的解决方案。

##### Actor模型说明：
1. Akka处理并发的方法是基于Actor模型
2. 在基于Actor的系统里，所有的事务都是Actor，就好像在面向对象设计里面所有的事务都是对象一样。
3. Actor模型是作为一个并发模型设计和架构的。Actor与Actor之间只能通过消息通信。
4. Actor与Actor之间只能通过消息进行通讯，当一个Actor给另一个Actor发消息时，消息是有序的，只需要将消息投寄响应邮箱即可。
5. 怎么处理消息是由接收消息的Actor决定的，发送消息Actor可以等待回复，也可以异步处理。
6. ActorSystem的职责是负责创建并管理其创建的Actor，ActorSystem是单例的，一个JVM进程中有一个即可，而Actor是可以有多个的。
7. Actor模型是对并发模型进行了更高的抽象。
8. Actor模型是异步、非阻塞、高性能的事件驱动编程模型。
9. Actor模型是轻量级事件处理（1G内存可以容纳百万级别个Actor）因此处理大并发性能高。

##### Actor 模型工作机制说明：
1. ActorSystem创建Actor
2. ActorRef：可以理解成Actor的代理或者引用。消息通过ActorRef来发送，而不能通过Actor发消息，通过哪个ActorRef发消息，就表示把消息发给哪个Actor
3. 消息发送到Dispatcher Message（消息分发器），它得到消息后，会将消息进程分发到对应的Mailbox。（注：Dispatcher Message 可以理解成一个线程池，Mailbox可以理解成消息队列缓冲多个消息遵守FIFO）
4. Actor可以通过receive方法来获取消息，然后进行处理。3

##### Actor 间传递消息机制
1. 每一个消息就是一个Message对象。Message继承了Runnable，因为Message就是线程类
2. 从Actor模型工作机制看上去很麻烦，但是程序员编程时值需要编写成Actor就可以了，其它的交给Actor模型完成即可。
3. A Actor要给B Actor发消息，那么 A Actor要先拿到（也称为持有）B Actor 的代理对象 ActorRef 才能发消息

流程示意：

A Actor 发消息给 B Actor

ActorSystem -> A Actor -> A ActorRef B ActorRec -> Dispatcher Message(Thread pool) -> B Mailbox (a queue) -> B Actor


##### 两个Actor的通讯机制
1. 两个Actor通讯机制和Actor自身发送消息机制基本一样。只是需要注意如下。
2. 如果A Actor 在需要给B Actor 发消息，则需要B Actor的 ActorRef，可以通过创建时传入B Actor的代理对象(ActorRef)
3. 当B Actor 在receive 方法中收到消息，需要回复时，可以通过 sender() 获取到发送Actor的代理对象。

##### 如何理解Actor的receive方法被调用
1. 每个Actor对应Mailbox
2. Mailbox 实现了Runnable接口，处于运行状态
3. 当有消息发送到Mailbox，就会去调用Actor的receive方法，将消息推送给receiver

##### Akka网络编程基本介绍：

Akka支持面向大并发后端服务程序，发网络通信这块是服务端程序重要的一部分。

网络编程有两种：
1. TCP socket 编程，是网络程序的主流。之所以叫TCP socket编程，是因为底层是基于tcp/ip协议的。比如QQ聊天
2. b/s 结构的 http编程，我们使用浏览器去访问服务器时，使用的就是http协议，而http底层依旧是tcp socket实现的。


##### TCP/IP 三本书
1. TCP/IP详解，卷1：协议
2. TCP/IP详解，卷2：实现
3. TCP/IP详解，卷3：TCP事务协议 

作者：瑞查德 史蒂芬

##### 简单模拟Spark
1. Worker 注册到Master，Master完成注册，并回复Worker注册成功
2. Worker定时发送心跳，并在Master能接受到
3. Master接收到Worker心跳后，要更新该Worker的最近一次发送心跳的时间。
4. 给Master启动定时任务，定时检测注册的Worker有哪些没有更新心跳，并将其从HashMap中删除
5. Master、Worker进行分布式部署。

# 第十七章：设计模式

##### 设计模式的必要性
1. 一些框架大量使用设计模式，不学读不懂
2. 设计模式能能让专业人士交流方便
3. 提高代码的维护性
4. 设计模式是编程经验的总结，就好像对于一些应用场景的套路化（站在框架工程化层面思考）

##### 掌握设计模式的层次
1. 第一层：刚开始学编程不久，听说过什么是设计模式
2. 第二层：有很长时间的编程经验，自己写了很多代码，其中用到了设计模式，但是自己却不知道
3. 第三层：学过了设计模式，发现自己已经在使用了，并且发现了一些新的模式挺好用
4. 第四层：阅读了很多别人写的原码和框架，在情况中看到别人设计模式，并且能够领会设计模式的精妙和带来的好处。
5. 第五层：代码写着写着，自己都没意识到使用了设计模式，并且熟练的写了出来。

##### 设计模式简介
1. 设计模式是程序员面在面对同类软件工程设计问题所总结出来的有用经验，设计模式不是代码，而是某类问题的通用解决方案，设计模式代表了最佳实践。
这些总结方案是众多开发人员经过相当长的一段时间的经验和错误的总结出来的
2. 设计模式本质是提高软件的维护性，通用性和扩展性，并降低软件的复杂度
3. <<设计模式>> 是经典的书，作者是Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides (俗称四人组)
4. 设计模式并不局限于某种语言，其他语言也有设计模式

##### 设计模式类型
1. 创建型模式：单例模式、抽象工厂模式、建造者模式、工厂模式、原型模式
2. 结构型模式：适配器模式、桥接模式、装饰模式、组合模式、外观模式、亨元模式、代理模式
3. 行为型模式：模板方法模式、命令模式、迭代器模式、观察者模式、中介者模、备忘录模式、解释器模式、状态模式、策略模式、职责链模式、访问模式

##### 简单工厂模式
1. 简单工厂模式属于创建类型模式。简单工厂模式是由一个工厂对象决定创建出哪一类的实例。简单工厂模式是工厂模式家族中最简单实用的模式。
2. 简单工厂模式：定义了一个类创建对象的类，由这个类来封装实例化对象的行为
3. 当需要大量创建某种、某类、或者某批对象时，就会用到工厂模式。

##### 工厂方法模式
定义了一个创建对象的抽象方法，由子类决定实例化的类。即将具体如何实例化类的方法让子类重写。

```scala
abstract class OrderPizza(
    var orderType: String = "", var pizza: pizza_.Pizza = null
) {
    breakable {
        do {
            print("请输入:")
            orderType = StdIn.readLine()
            
            pizza = this.createPizza(orderType)
            
            pizza.prepare()
            pizza.bake()
            pizza.cut()
            pizza.box()
        } while (true)
    }
    
    def createPizza(name:String):Pizza
}

class ShenzhenOrderPizza extends OrderPizza {

  override def createPizza(name: String): Pizza = {
    name.toLowerCase match {
      case "greek" => new ShenzhenCheesePizza("greek")
      case "pepper" => new ShenzhenPepperPizza("pepper")
      case "cheese" => new ShenzhenCheesePizza("cheese")
      case _ => throw new IllegalArgumentException(s"invalid pizza type $name")
    }
  }
}

class NewYorkOrderPizza extends OrderPizza {

  override def createPizza(name: String): Pizza = {
    name.toLowerCase match {
      case "greek" => new NewYorkCheesePizza("greek")
      case "pepper" => new NewYorkPepperPizza("pepper")
      case "cheese" => new NewYorkCheesePizza("cheese")
      case _ => throw new IllegalArgumentException(s"invalid pizza type $name")
    }
  }
}

```

##### 抽象工厂模式
1. 抽象工厂模式：定义了一个trait用于创建相关或有依赖关系的对象簇，而无需指明具体的类
2. 抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合。
3. 从设计层面看，抽象工厂模式就是对简单工厂模式的改进
4. 将工厂抽象成两层，absFactory(抽象工厂) 和 具体实现的工厂子类。程序员可以根据创建对象类型使用相应的工厂子类。这样将单个的简单工厂类变成了工厂簇，更利于代码的维护和扩展。

小结：
1. 工厂模式的意义在于，将实例化对象的代码提取出来，放到一个类中统一管理和维护，达到和主项目的依赖关系解耦。从而提高代码维护性
2. 各种模式：
   - 简单工厂：简单粗暴，要什么我给你new什么
   - 工厂：要实例化哪个类，方法你自己实现，我只提供抽象方法名称
   - 抽象工厂：构建抽象工厂，根据不同类型实构建多个不同类型的子工厂。用时候通过多态调用，不影响业务逻辑。

##### 装饰器模式
1. 装饰器模式：动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了开闭原则
2. 这里提到的动态的将新功能附加到对象和ocp原则，在后面的应用实例上会以代码形式体现。

##### 观察者模式
1. 观察者模式设计后，会以集合的方式来管理用户，包括注册，移除和通知。
2. 这样，我们增加观察者，就不需要去修改核心类。它可以作为一个独立进程保持运行，无需重新加载。

##### 代理模式
1. 为一个对象提供一个替身，以控制对这个对象的访问
2. 被代理的对象可以是远程对象，创建开销大的对象或需要安全控制的对象
3. 代理模式有不同的形式(远程代理，静态代理，动态代理)，都是为了控制与管理对象访问

# 第十八章：泛型、上下界、视图界定、上下文界定

##### 泛型
基本介绍
1. 如果我们要求函数的参数可以接收任意类型。可以使用泛型，这个类型可以代表任意的数据类型
2. 例如List，在创建时可以传入整形、字符串、浮点等类型。那是因为List在定义时引用了泛型。

##### 泛型上下界
泛型的上下界规定了当前类型是某类的子类类型或某类的父类类型

```scala
[A <: B] // A的类型是B的子类类型 
[C >: D] // C的类型是D的父类类型
```

##### 视图界定: Scala 中那些奇怪的符号。

视图界定其实就是泛型上下界带上了隐式转换。此法较前术更灵活。


demo 1
```scala
object ViewDemo01 {
    def main(args: Array[String]): Unit = {
        // 这样可以跑通  因为使用了隐式转换
        println(new ViewCompareDemo(1, 20).greater)
    }
}

// 说明：
// T <% Comparable[T] 与 T <: Comparable[T]  的区别是，前者支持隐式转换
class ViewCompareDemo[T <% Comparable[T]](obj1: T, obj2: T) {
    def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}
```

demo2

```scala
object ViewDemo02_ {
    def main(args: Array[String]): Unit = {
        val zhangsan: Person = new Person("Zhangsan", 20)
        val lisi: Person = new Person("Lisi", 30)
        
        println(new PersonCompare(zhangsan, lisi).greater)
        
        val aaabbbccc: Cat = new Cat("aaabbbccc")
        val abc: Cat = new Cat("abc")
        println(new PersonCompare(abc, aaabbbccc).greater2)
    }
}

class Cat(val name:String) extends Ordered[Cat] {
    override def compare(that: Cat): Int = this.name.length - that.name.length
    
    override def toString: String = this.name
}


class Person(val name:String,val age:Int) extends Ordered[Person] {
    
    override def compare(that: Person): Int = this.age - that.age
    
    override def toString: String = s"${this.name}   ${this.age}"
}

// 说明：
// 1. T <% Ordered[T]  表示 T 是 Ordered 的子类型
class PersonCompare[T <% Ordered[T]](zhangsan:T,lisi:T) {
    def greater:T = if(zhangsan > lisi) zhangsan else lisi
    def greater2:T = if(zhangsan.compareTo(lisi) > 0) zhangsan else lisi
}
```

demo 3 

```scala
object ViewDemo03_ {
    def main(args: Array[String]): Unit = {
        import Implicit._
        val zhangsan: PersonManual = new PersonManual("Zhangsan", 20)
        val lisi: PersonManual = new PersonManual("Lisi", 30)
        
        println(new PersonCompareManual(zhangsan, lisi).greater)
    }
}

object Implicit {
  implicit def personToOrderedPerson(p:PersonManual): Ordered[PersonManual] = new Ordered[PersonManual] {
    override def compare(that: PersonManual): Int = p.age - that.age
  }
}


class PersonManual(val name:String,val age:Int){
    
    override def toString: String = s"${this.name}   ${this.age}"
}

// 说明：
// 1. T <% Ordered[T]  表示 T 是 Ordered 的子类型
class PersonCompareManual[T <% Ordered[T]](zhangsan:T,lisi:T) {
    def greater:T = if(zhangsan > lisi) zhangsan else lisi
    def greater2:T = if(zhangsan.compareTo(lisi) > 0) zhangsan else lisi
}
```


##### 上下文界定 contest bound
与view bounds 一样，contest bound 也是隐式参数的语法糖


demo 
```scala
object ContextBoundDemo_ {
    
    // 定义两个person比较的隐式值
    implicit val personCompare = new Ordering[Person] {
        override def compare(x: Person, y: Person): Int = x.age - y.age
    }
    
    
    def main(args: Array[String]): Unit = {
        val zhangsan: Person = new Person("zhangsan", 10)
        val lisi: Person = new Person("lisi", 20)
        
        println(new CompareMethodOne(zhangsan, lisi).greater)
        println(new CompareMethodTwo(zhangsan, lisi).greater)
    }
}

class Person(val name: String, val age: Int) {
    override def toString: String = this.name + " \t" + this.age
}

// 方式1
// 说明：
// 1. [T: Ordering] -> 这是泛型
// 2. (a: T, b: T)  -> 这是形参
// 3. (implicit comparator: Ordering[T]) -> 这是隐式参数
// 4. 这种方法我最喜欢
class CompareMethodOne[T: Ordering](a: T, b: T)(implicit comparator: Ordering[T]) {
    def greater: T = if (comparator.compare(a, b) > 0) a else b
    
    def lower: T = if (comparator.compare(a, b) > 0) b else a
}

// 方式2
// 将隐式值写到了类里头
class CompareMethodTwo[T: Ordering](a: T, b: T) {
    // looks bad...
    def greater: T = {
        def f1(implicit c: Ordering[T]): Int = c.compare(a, b)
        
        if (f1 > 0) a else b
    }
}

// 方式3
// 使用implicitly语法糖，最简单（推荐使用）
class CompareMethodThree[T: Ordering](a: T, b: T) {
    def greater: T = {
        // 这句话会获取到上面的隐式值 personCompare
        val comparator: Ordering[T] = implicitly[Ordering[T]]
        
        if (comparator.compare(a, b) > 0) a else b
    }
}
```


##### 协变、逆变、不变

1. 在Scala中 协变(+) , 逆变(-); 协变covariant , 逆变contravariant, 不变invariant
2. 对于一个带类型参数的类型，比如List[T], 如果对于类型A及其子类型B，满足List[B] 也符合 List[A]的子类型，那么就称为covariant(协变)；
如果List[A] 是 List[B] 的子类型，即与原来的父子关系正相反，则称为contravariance (逆变);
如果一个类型支持协变和逆变则称这个类型为variance（可变 或 变型）,否则称之为invariance (不变)
3. 在Java中，泛型类型都是invariance. 比如 List<String> 并不是 List<Object> 的子类型。 而Scala支持，可以在定义类型时声明（用+表示协变，-表示逆变）。
比如 trait List[+T] // 在类型定义时声明为协变，这样会把List[String] 作为 List[Any] 的子类型。