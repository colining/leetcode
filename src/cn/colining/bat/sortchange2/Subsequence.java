package cn.colining.bat.sortchange2;

/**
 * Created by colin on 2017/6/30.
 */
public class Subsequence {
    /**
     * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
     给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。
     (原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,5,8,9};
        System.out.println(shortestSubsequence(array, array.length));
    }

    /**
     * 对于需要排序的最短子数组来说，它的最大值最小值确定了它的边界；<br>
     * 所以我们要关注的其实就是所需排序的最小值和最大值的位置；
     * @param array
     * @param n
     * @return
     */
    public static int shortestSubsequence(int[] array, int n) {
        int max = array[0];
        int index1 = 0;
        int min = array[array.length - 1];
        int index2 = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else if (array[i] < max) {
                index1 = i;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else if (array[i] > min) {
                index2 = i;
            }
        }
        return index1 - index2 == 0 ? 0 : Math.abs(index1 - index2) + 1;
    }
}