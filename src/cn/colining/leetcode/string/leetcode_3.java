package cn.colining.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by colin on 2017/7/9.
 */
public class leetcode_3 {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param args
     */
    public static void main(String[] args) {
        String a = "abba";
        System.out.println(lengthOfLongestSubstring1(a));
        HashSet hashSet = new HashSet();
    }

    /**
     * 首先我们要铭记一点，去重首先要想到hash，我就是连hash都没有想到的人
     * 对于这到题，好的方法是滑动窗口；通过set作为窗口，决定谁去谁留；
     * 以[a,b,c,a,b,c,d,d,e,f]为例；先是加入a,b,c 然后发现来得是 a,
     * 就弹出a，然后再添加a;现在的窗口就变成了 b,c,a;然后依次弹出添加b,c,d
     * 然后又遇到了d,这是就要把前一个d和它之前的元素都弹出，因为窗口要重新从
     * 新来的d开始算了；
     * @param s
     * @return
     */
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


    /**
     * 使用hashmap的好处是不需要弹出过程，直接移动位置，这样的话，时间复杂度会更低<br>
     * 不过应该要注意指针位置；
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int result=0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i+1);
            map.put(s.charAt(j), j+1);
        }
        return result;
    }
}
