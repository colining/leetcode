package cn.colining.bat.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by colin on 2017/7/1.
 */
public class DistinctSubstring {
    public static void main(String[] args) {
        String string = "spnvw";
        System.out.println(longestSubstring(string, string.length()));
    }
    public static int longestSubstring(String A, int n) {
        char[] chars = A.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int pre = -1;
        int maxLength = 0;
        int length=0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                length = i-pre;
                maxLength = Math.max(length, maxLength);
                map.put(chars[i], i);
            }else {
                pre = Math.max(pre, map.get(chars[i]));
                length = i - pre;
                maxLength = Math.max(length, maxLength);
                map.put(chars[i], i);
            }
        }
        return maxLength;
    }

}
