package com.iamhotcenplotz.chapter27.theory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 11:18
 * @description: 分析Java正则底层实现
 */


public class Theory02_ {
    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。" +
                "1999年6月，Sun公司发布了第二代Java平台（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型版），" +
                "应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的标准版），" +
                "应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应用于基于Java的应用服务器。" +
                "Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。";

        // 匹配所有四个数字的字符串
        // 1. \\d 表示一个任意数字
//        String regStr = "\\d\\d\\d\\d";
        String regStr = "(\\d\\d)(\\d\\d)";

        // 2. 创建模式对象
        Pattern compile = Pattern.compile(regStr);

        // 3. 创建匹配器
        Matcher matcher = compile.matcher(content);

        // 4. 开始匹配
        /**
         * 什么是分组：
         *   比如 (\d\d)(\d\d)， 正则中有小括号就是分组，第一个括号内是第一组，第二个括号内是第二组，以此类推
         * matcher.find() - 考虑分组
         * 1. 根据指定的规则，定位满足规则的子字符串(比如（19）（98）)
         * 2. 找到后，将子字符串开始的索引记录到matcher对象属性 int[] groups;
         *    2.1 groups[0] = 0 把该子字符串结束的索引+1的值记录到 groups[1]
         *    2.2 记录1组()匹配到的字符串 groups[1] = 0 groups[3] = 2
         *    2.3 记录2组()匹配到的字符串 groups[4] = 2 groups[5] = 4
         *    2.4 如果有更多分组... 依此类推
         * 3. 同时记录oldLast 的值为， 即子字符串的结束的索引+1, 即下次执行find时，就从这个值开始匹配
         *
         * matcher.group(0)
         *
         *     public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         * 1. 根据 groups[0] 和 group [1] 的记录的位置，从content开始截取子字符串返回 -> [group0,group1).
         *
         * 如果再次执行find() 方法，仍然按照上面的流程来执行。
         * */

        while (matcher.find()) {
            System.out.println(matcher.group(0) + " " + matcher.group(1) + " " + matcher.group(2));
        }
    }
}
