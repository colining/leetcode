package cn.colining.leetcode.dynamicprogramming;

import java.util.*;

/**
 * Created by colin on 2017/8/3.
 */
public class leetcode_392 {
    /*
    Given a string s and a string t, check if s is subsequence of t.

    You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:
    s = "abc", t = "ahbgdc"

    Return true.

    Example 2:
    s = "axc", t = "ahbgdc"

    Return false.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(Collections.binarySearch(Arrays.asList(5,7,8,10), 6));
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(isSubsequence1(a, b));
    }

    /*
    双指针搜索
     */
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            while (s.charAt(sIndex) != t.charAt(tIndex)) {
                tIndex++;
                if (tIndex >= t.length()) {
                    return false;
                }
            }
            sIndex++;
            tIndex++;
        }
        return sIndex >= s.length();
    }
    /*
    其实我看到说只有小写字母就知道要存表了，不过没想到是list的数组
    这样做的话，数据量即便很大，也只需要建立一次表格
     */
    public static boolean isSubsequence1(String s, String t) {
        List<Integer>[] helper = new List[256];
        for (int i = 0; i < t.length(); i++) {
            if (helper[t.charAt(i)] == null) {
                helper[t.charAt(i)] = new ArrayList<>();
            }
            helper[t.charAt(i)].add(i);
        }
        int indexT = 0;
        for (int i = 0; i < s.length(); i++) {
            if (helper[s.charAt(i)] == null)
                return false;
            int j = Collections.binarySearch(helper[s.charAt(i)], indexT);
            if (j < 0) {
                j = -j - 1;
            }
            if (j== helper[s.charAt(i)].size())
                return false;
            indexT = helper[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}
