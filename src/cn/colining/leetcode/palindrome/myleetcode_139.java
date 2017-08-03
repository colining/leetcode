package cn.colining.leetcode.palindrome;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by colin on 2017/7/12.
 */
public class myleetcode_139 {
    /*
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     Return all possible palindrome partitioning of s.
     For example, given s = "aab",
     Return
     [
     ["aa","b"],
     ["a","a","b"]
     ]
     *
     */
    public static void main(String[] args) {
        myleetcode_139 myleetcode_139 = new myleetcode_139();
        myleetcode_139.partition("aba");
    }
    ArrayList<ArrayList<String>> resultList;
    ArrayList<String> current;

    /*
    主要思路是回溯：
    leetcode_647 大神代码，还有配图，我就改成了ArrayList
    https://leetcode.com/problems/palindrome-partitioning/#/solutions

     */
    public ArrayList<ArrayList<String>> partition(String s) {
        resultList = new ArrayList<ArrayList<String>>();
        current = new ArrayList<String>();
        findPalindrome(s, 0);
        return resultList;
    }

    /**
     * 主要思路是回溯
     * @param str
     * @param left
     */
    private void findPalindrome(String str, int left) {
        //回溯返回条件，left指针已到最后，也就是回溯到底了
        if (current.size() > 0 && left >= str.length()) {
            ArrayList<String> tempList = (ArrayList<String>) current.clone();
            resultList.add(tempList);
        }
        for (int right = left; right < str.length(); right++) {
            //不是回文的话，直接right++；
            if (isPalindrome(str, left, right)) {
                //添加回文
                if (left == right) {
                    current.add(Character.toString(str.charAt(left)));
                }else{
                    current.add(str.substring(left, right +1));
                }
                //进行回溯
                findPalindrome(str, right + 1);
                //移除刚刚添加的元素，也就是回到之前的状态，以便走其他分支
                current.remove(current.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String str, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
