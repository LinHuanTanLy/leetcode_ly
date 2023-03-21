package leeCode01.p03;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class P03 {
    public static void main(String[] args) {
//        String s = "dvdf";
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "anviaj";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);

    }


    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        String[] sArray = s.split("");
        List<String> cacheArray = new ArrayList<>();
        for (String value : sArray) {
            if (cacheArray.contains(value)) {
                if (cacheArray.size() > maxLength) {
                    maxLength = cacheArray.size();
                }
                int keyIndex = cacheArray.indexOf(value);
                cacheArray = cacheArray.subList(keyIndex + 1, cacheArray.size());
            }
            cacheArray.add(value);
        }
        System.out.println(cacheArray);
        if (cacheArray.size() > maxLength) {
            maxLength = cacheArray.size();
        }
        return maxLength;

    }
}
