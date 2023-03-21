package leeCode01.P06;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P06 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String convertString = convert(s, numRows);
        System.out.println(convertString);
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        //拆分起来 第一个等于numRows+(numRows-2)
        ///每一束数字一共有多少字（包括中间的横栏）
        int rowsCharNums = numRows + numRows - 2;
        ///一共有这么多束数字
        int rowsCount = len / rowsCharNums;
        ///除开后的余数
        int residue = len % rowsCharNums;

        ///把每束字丢进去
        List<String> array = new ArrayList<>();
        System.out.println("rowsChatNums=" + rowsCharNums + "  rowsCount=" + rowsCount + "  residue=" + residue);
        for (int i = 0; i < rowsCount; i++) {
            String charStr = s.substring(i * (rowsCharNums), rowsCharNums * (i + 1));
            String fullCharStr = charStr.substring(0, numRows);
            String residueStr = charStr.substring(numRows);
            array.add(fullCharStr);
            for (int j = 0; j < residueStr.length(); j++) {
                int index = 1 + j;
                char[] arrayChar = new char[numRows];
                for (int k = 0; k < numRows; k++) {
                    if (index == k) {
                        arrayChar[k] = residueStr.charAt(j);
                    } else {
                        arrayChar[k] = '-';
                    }
                }
                array.add(String.valueOf(arrayChar));

            }
        }
        array.add(s.substring(s.length() - 2) + "-".repeat(Math.max(0, numRows - residue)));

        for (String str :
                array) {
            System.out.println(str);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (String value : array) {
                if (value.charAt(i) != '-') {
                    sb.append(value.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
