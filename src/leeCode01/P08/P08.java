package leeCode01.P08;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P08 {


    public static void main(String[] args) {
//        String s = "-91283472332";
//        String s = "00000-42a1234";


        String s = "-9223372036854775809";
        int result = myAtoi(s);
        System.out.println(result);

    }

    public static int myAtoi(String s) {
        s = s.trim();
        Boolean ifNegative = null;
        ArrayList<Character> filterArray = new ArrayList<>();
        boolean outZero = false;
        for (int i = 0; i < 10; i++) {
            filterArray.add((char) ('0' + i));
        }
        StringBuilder sb = new StringBuilder();
        for (char str : s.toCharArray()) {
            boolean ifEndOfS = s.indexOf(str) == s.length() - 1;
            if (str == '-' && ifNegative == null && !outZero && !ifEndOfS) {
                ifNegative = true;
            } else if (str == '+' && ifNegative == null && !outZero && !ifEndOfS) {
                ifNegative = false;
            } else {
                if (filterArray.contains(str)) {
                    ///是0-9
                    if (str == '0') {
                        if (sb.length() > 0) {
                            sb.append(str);
                        } else {
                            outZero = true;
                        }
                    } else {
                        sb.append(str);
                    }
                } else {
                    break;
                }
            }
        }
        if (sb.length() >= 1) {
            int result;
            BigInteger a = new BigInteger(sb.toString());
            BigInteger longMax = new BigInteger(String.valueOf(Long.MAX_VALUE));
            if (a.compareTo(longMax) > 0) {
                if (Boolean.TRUE.equals(ifNegative)) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }


            long l
                    = Long.parseLong(sb.toString()) * ((ifNegative != null ? ifNegative : false) ? -1 : 1);

            if (l > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            } else if (l < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            } else {
                result = Math.toIntExact(l);
            }
            return result;
        } else {
            return 0;
        }
    }

}
