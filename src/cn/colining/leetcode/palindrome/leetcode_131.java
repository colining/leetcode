package cn.colining.leetcode.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 2017/7/11.
 */
public class leetcode_131 {
    public static void main(String[] args) {
        leetcode_131 leetcode_131 = new leetcode_131();
        leetcode_131.partition("aabbcc");
    }
    List<List<String>> resultList;
    ArrayList<String> currList;

    public List<List<String>> partition(String s) {
        resultList = new ArrayList<List<String>>();
        currList = new ArrayList<String>();
        backTrack(s, 0);
        return resultList;
    }

    private void backTrack(String s, int left) {
        //如果left指针已经走到最后，就可以将当前ArrayList中的元素添加了；
        if (currList.size() > 0 && left >= s.length()) {
            List<String> r = (ArrayList<String>) currList.clone();
            resultList.add(r);
        }
        //如果left未到最后，就继续向后
        for (int i = left; i < s.length(); i++) {
            //如果不是回文字符串，就直接i++;
            //否则就从i开始进行回溯
            if (isPalindrome(s, left, i)) {
                if (left == i) {
                    currList.add(Character.toString(s.charAt(i)));
                }else {
                    currList.add(s.substring(left, i + 1));
                }
                //回溯，一直到该路线走到底才返回，也就是得到了一个解
                backTrack(s, i + 1);
                //然后弹出顶端元素，进行其他分支搜索
                currList.remove(currList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
