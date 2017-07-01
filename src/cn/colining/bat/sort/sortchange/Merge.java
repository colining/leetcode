package cn.colining.bat.sort.sortchange;

import java.util.Arrays;

/**
 * Created by colin on 2017/6/27.
 */
public class Merge {
    /** 题目：
     * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
        给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = new int[]{17413,26696,27419,0,0,0,0};
        int[] array2 = new int[]{15181,17413,20937,26696};
        mergeAB(array1, array2, 3, 4);
    }

    /**
     * 主要思路：两个数组依次比较最大的数没然后放入第一个数组的末尾<br>
     * 由于数组本来就是有序的，所以当B数组没有可比较元素时，不许操作，<br>
     * A数组没有元素，则需要将B中元素复制到A中
     * @param A 数组A
     * @param B 数组B
     * @param n 数组A的真实长度
     * @param m 数组B的真实长度
     * @return
     */
    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
        int i, j, index = 0;
        for (i = n - 1, j = m - 1, index = A.length - 1; j >= 0 && i >= 0; ) {
            System.out.println(index);
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}