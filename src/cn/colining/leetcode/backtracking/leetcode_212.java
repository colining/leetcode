package cn.colining.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 2017/7/19.
 */
public class leetcode_212 {
    /*
    Given a 2D board and a list of words from the dictionary, find all words in the board.
    Each word must be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring.
    The same letter cell may not be used more than once in a word.
    For example,
    Given words = ["oath","pea","eat","rain"] and board =

    [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    Return ["eat","oath"].
     */
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'a'}};
        String[] words = new String[]{"a"};
        leetcode_212 leetcode_212 = new leetcode_212();
        System.out.println(leetcode_212.findWords(chars, words).contains("a"));
    }

    /*
    对每一个二维数组中的元素进行探测
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTree(words);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findPath(board, root, i, j, arrayList);
            }

        }
        return arrayList;
    }

    /**
     * 通过构造字典树，每次检测时都与树节点进行比较；
     * 当到达最后是，word就不为null了
     *
     * @param root      当前的树的结点
     * @param arrayList
     */
    private void findPath(char[][] board, TrieNode root, int i, int j, ArrayList<String> arrayList) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {
            arrayList.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (j > 0) {
            findPath(board, root, i, j - 1, arrayList);
        }
        if (j < board[0].length - 1) {
            findPath(board, root, i, j + 1, arrayList);
        }
        if (i > 0) {
            findPath(board, root, i - 1, j, arrayList);
        }
        if (i < board.length - 1) {
            findPath(board, root, i + 1, j, arrayList);
        }
        board[i][j] = c;
    }

    /**
     * 构造字典树的过程，以每一个字符为结点，到达最后时
     * 赋值 word
     *
     * @param words
     * @return
     */
    public static TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

