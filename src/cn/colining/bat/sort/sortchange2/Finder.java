package cn.colining.bat.sort.sortchange2;

/**
 * Created by colin on 2017/6/29.
 */
public class Finder {
    /**
     * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。
     * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，
     * 代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
     * @param args
     */
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
