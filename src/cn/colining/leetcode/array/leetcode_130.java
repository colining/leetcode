package cn.colining.leetcode.array;

/**
 * Created by colin on 2017/7/12.
 */
public class leetcode_130 {
    /*
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

     A region is captured by flipping all 'O's into 'X's in that surrounded region.
     For example,
     X X X X
     X O O X
     X X O X
     X O X X
     After running your function, the board should be:
     X X X X
     X X X X
     X X X X
     X O X X
     *
     */
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'X', 'X','X','X'}, {'X', 'O','O','X'},{'X','O','X','X'},{'X','X','O','X'}};
        solve(chars);
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars[0].length;j++) {
                sb.append(chars[i][j] + " ");
            }
            System.out.println(sb);
        }
    }

    /**
     * 思路：如果一个O，它的路径中没有一个能到达边界，则可以认定这个O要转换的；
     * 否则的话，说明这个O可以活下去；
     * @param board
     */
    public static void solve(char[][] board) {
        if (board.length <= 2) {
            return;
        }
        int height = board.length;
        int weight = board[0].length;
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][weight - 1] == 'O') {
                boundaryDFS(board, i, weight - 1);
            }
        }
        for (int j = 0; j < weight; j++) {
            if (board[0][j] == 'O') {
                boundaryDFS(board, 0, j);
            }
            if (board[height - 1][j] == 'O') {
                boundaryDFS(board, height - 1, j);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }

        }

    }

    private static void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            boundaryDFS(board, i - 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            boundaryDFS(board, i, j - 1);
        }
        if (i < board.length-2 && board[i + 1][j] == 'O') {
            boundaryDFS(board, i + 1, j);
        }
        if (j < board[0].length-2 && board[i][j + 1] == 'O') {
            boundaryDFS(board, i, j + 1);
        }

    }

}
