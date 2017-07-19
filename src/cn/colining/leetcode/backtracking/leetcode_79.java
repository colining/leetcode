package cn.colining.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 2017/7/19.
 */
public class leetcode_79 {
    /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
     */
    public static void main(String[] args) {
        char[][] array = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        char[][] chars = new char[][]{{'a', 'b'}};
        System.out.println(exist(chars, "ba"));
    }

    /**
     * 对每一个二维数组的元素，探测它是不是可以完成一个路径
     * 如果有，就返回true
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null || (board.length * board[0].length) < word.length()) {
            return false;
        }
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isHasPath(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  查询当前字符是不是能够有那么一条word路径
     *  查询的时候将其visited置为1；探测它的周边，
     *  如果没有找到路径，就退回到上一个位置；
     * @param index 当前索要查询的字符位置
     * @param visited   当前位置是否被探测过
     * @return
     */
    private static boolean isHasPath(char[][] board, int i, int j, String word, int index, int[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        boolean hashPath = false;
        if (i < board.length && j < board[0].length && i >= 0 && j >= 0 && board[i][j] == word.charAt(index) && visited[i][j] == 0) {
            index++;
            visited[i][j] = 1;
            hashPath = isHasPath(board, i + 1, j, word, index, visited) ||
                    isHasPath(board, i, j + 1, word, index, visited) ||
                    isHasPath(board, i - 1, j, word, index, visited) ||
                    isHasPath(board, i, j - 1, word, index, visited);

            if (!hashPath) {
                visited[i][j] = 0;
                index--;
            }
        }
        return hashPath;
    }

}
