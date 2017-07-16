package cn.colining.leetcode.bfs;

import sun.rmi.runtime.Log;

import java.util.*;

/**
 * Created by colin on 2017/7/16.
 */
public class leetcede_127 {


    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 1;
        int strLen = beginWord.length();

        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String string : beginSet) {
                char[] chs = string.toCharArray();
                for (int i = 0; i < chs.length; i++) {

                    for (char c = 'a'; c<= 'z';c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }

                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "hit";
        String b = "dot";
        Set<String> dict = new LinkedHashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        System.out.println(ladderLength1(a, b, dict));
    }
    public static int ladderLength1(String start, String end, Set<String> dict) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(start);

        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {
                // Modify str's each character (so word distance is 1)
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;

                        String word = new String(chars);

                        // Found the end word
                        if (word.equals(end)) return level + 1;

                        // Put it to the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return 0;
    }
}
