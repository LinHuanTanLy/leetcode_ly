package leeCode01.p05;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class P05 {
    public static void main(String[] args) {
        String s = "cbbd";
//        String s = "aacabdkacaa";
        String palindrome = longestPalindrome(s);
        System.out.println(palindrome);


    }

    public static String longestPalindrome(String s) {
        String palindrome = "";
        int maxLength = 0;
        int begin = 0;
        int cacheRight;
        for (int i = 0; i < s.length(); i++) {
            int left = i;

            int right = s.length() - 1;
            cacheRight = right - 1;
            while (left < right) {
                System.out.println(i + "---" + left + "-" + right + " " + s.charAt(left) + "    " + s.charAt(right) + "     cacheRight is " + cacheRight);
                if (s.charAt(left) == s.charAt(right)) {
                    if (maxLength < (right - left)) {
                        maxLength = right - left;
                        begin = left;
                    }
                    left++;
                    right--;

                } else {
                    maxLength = 0;
                    begin = 0;
                    left = i;
                    right = cacheRight;
                    cacheRight = right - 1;
                }
                if (right - left == 0) {
                    break;
                }
            }

            String tempPalindrome = s.substring(begin, begin + maxLength + 1);
            if (palindrome.isEmpty() || tempPalindrome.length() > palindrome.length()) {
                palindrome = tempPalindrome;
            }

        }
        return palindrome;
    }
}