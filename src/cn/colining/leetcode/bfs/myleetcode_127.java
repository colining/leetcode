package cn.colining.leetcode.bfs;

import java.util.*;

/**
 * Created by colin on 2017/7/15.
 */
public class myleetcode_127 {
    /**
     * Given:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log","cog"]
     As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     return its length 5.
     * @param args
     */
    public static void main(String[] args) {
        String startString = "hit";
        String endString = "dog";
        List<String> list = Arrays.asList("hot", "dog", "dot","hid");
        myleetcode_127 myleetcode_127 = new myleetcode_127();
        System.out.println(myleetcode_127.ladderLength(startString, endString, list));
    }

    //bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        queue.offer(beginWord);
        map.put(beginWord, 1);
        //如果一个元素，它往下没有路了，没有变换一次的单词了，
        //那就将其弹出；反之如果她还有向下的路径，就添加到队列
        //就好像按行二叉树一样，我们最终就会将所有可能路线都覆盖掉
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int dis = map.get(word);
            for (String str : wordList) {
                if (!map.containsKey(str)&&isOneChange(str,word)) {
                    if (str.equals(endWord)) {
                        return dis + 1;
                    }
                    queue.offer(str);
                    map.put(str, dis + 1);
                }
            }
        }
        return 0;
    }


    public boolean isOneChange(String a, String b) {
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
