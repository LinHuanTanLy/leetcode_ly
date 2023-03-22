package leeCode01.P09;

import java.util.ArrayList;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class P09 {
    public static void main(String[] args) {
        int x = 1001;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        boolean isPalindrome = false;
        String xStr = String.valueOf(x);
        char[] array = xStr.toCharArray();
        int i = 0;
        while (array[i] == array[array.length - 1 - i]) {
            if ((array.length - 1 - i == i) || (array.length - 1 - i - 1 == i)) {
                isPalindrome = true;
                break;
            }
            i++;
        }
        return isPalindrome;
    }
}
