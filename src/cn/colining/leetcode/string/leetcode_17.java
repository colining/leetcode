package cn.colining.leetcode.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by colin on 2017/9/4.
 */
public class leetcode_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            letterCombinations(scanner.next());
        }
    }
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        String[] map = new String[]{"0","1","abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i) {
                String t = list.remove();
                for (char c : map[x].toCharArray()) {
                    list.add(t + c);
                }
            }
        }
        return list;
    }


}
