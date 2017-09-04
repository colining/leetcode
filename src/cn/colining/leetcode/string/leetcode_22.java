package cn.colining.leetcode.string;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by colin on 2017/9/4.
 */
public class leetcode_22 {
    public static void main(String[] args) {
        for (String s : generateParenthesis1(3)) {
            System.out.println(s);
        }
    }
    public static List<String> generateParenthesis(int n) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("");
        for (int i = 0; i < n; i++) {
            while (linkedList.peek().length() == i*2) {
                String s = linkedList.removeFirst();
                for (int j = 0; j <= s.length(); j++) {
                    String t = s.substring(0, j) + "()" + s.substring(j, s.length());
                    if (!hashSet.contains(t)) {
                        linkedList.add(t);
                        hashSet.add(t);
                    }
                }
            }
        }
        return linkedList;
    }

    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public  static void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
