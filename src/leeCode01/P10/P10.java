package leeCode01.P10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P10 {

    public static void main(String[] args) {
//        String s = "aa", p = "a";
//        String s = "aa", p = "a*";
//        String s = "ab", p = ".*";
        String s = "bbbba", p = ".*a*a";
        System.out.println(isMatch(s, p));

    }

        public static boolean isMatch(String s, String p) {
            char[] cs = s.toCharArray();
            char[] cp = p.toCharArray();

            // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
            boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];

            // 初期值
            // s为空，p为空，能匹配上
            dp[0][0] = true;
            // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)

            // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
            for (int j = 1; j <= cp.length; j++) {
                if (cp[j - 1] == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            // 填格子
            for (int i = 1; i <= cs.length; i++) {
                for (int j = 1; j <= cp.length; j++) {
                    // 文本串和模式串末位字符能匹配上
                    if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (cp[j - 1] == '*') { // 模式串末位是*
                        // 模式串*的前一个字符能够跟文本串的末位匹配上
                        if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                            dp[i][j] = dp[i][j - 2]      // *匹配0次的情况
                                    || dp[i - 1][j];     // *匹配1次或多次的情况
                        } else { // 模式串*的前一个字符不能够跟文本串的末位匹配
                            dp[i][j] = dp[i][j - 2];     // *只能匹配0次
                        }
                    }
                }
            }
            return dp[cs.length][cp.length];
        }
}
