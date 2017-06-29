package cn.colining.bat.sortchange2;

/**
 * Created by colin on 2017/6/29.
 */
public class Finder {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4, 5, 6,}, {2, 3, 4, 5, 6, 21}, {11, 22, 33, 55, 66}};
        System.out.println(findX(array, 6, 3, 23));
    }
    public static boolean findX(int[][] mat, int n, int m, int x) {
        int row  = mat.length;          //有这么多行
        int col = mat[0].length;        //有这么多列
        int X = row-1;
        int Y = 0;
        while (Y < col && X >= 0) {
            if (mat[X][Y] < x) {
                Y++;
            } else if (mat[X][Y] > x) {
                X--;
            }
            else
                return true;
        }
        return false;
    }
}
