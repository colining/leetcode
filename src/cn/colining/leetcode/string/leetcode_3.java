package cn.colining.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by colin on 2017/7/9.
 */
public class leetcode_3 {
    public static void main(String[] args) {
        String a = "abcabcdddde";
        System.out.println(lengthOfLongestSubstring(a));
        HashSet hashSet = new HashSet();
    }
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
