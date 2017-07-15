package cn.colining.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by colin on 2017/7/15.
 */
public class leetcode_127 {
    public static void main(String[] args) {
        String startString = "hit";
        String endString = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        leetcode_127 leetcode_127 = new leetcode_127();
        System.out.println(leetcode_127.ladderLength(startString, endString, list));
    }

     ArrayList<String> arrayList = new ArrayList<>();
     ArrayList<Integer> integerArrayList = new ArrayList<>();

    public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        arrayList.add(beginWord);
        arrayList.add(endWord);
        findLength(beginWord, endWord, wordList);
        Collections.sort(integerArrayList);
        return integerArrayList.size()==0?0:integerArrayList.get(0);
    }

    private  void findLength(String beginWord, String endWord, List<String> wordList) {
        if (isOneChange(beginWord,endWord)) {
            integerArrayList.add(arrayList.size());
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (isOneChange(endWord, wordList.get(i)) && !arrayList.contains(wordList.get(i))) {
                arrayList.add(wordList.get(i));
                findLength(beginWord, wordList.get(i), wordList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    public  boolean isOneChange(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
            }
            if (num > 1) {
                return false;
            }
        }
        return true;
    }

}
