package cn.colining.myjar;

/**
 * Created by colin on 2017/6/26.
 */
public class Swap {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
