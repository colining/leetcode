package cn.colining.justtest;

/**
 * Created by colin on 2017/7/19.
 */
public class test1 {
    public static void main(String[] args) {
        int a = 1;
        int b = ++a;
        System.out.println(a/6.0);
        System.out.println(null == null);
    }
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private static int s(int[] arr, int i, int i1) {
        if (i == i1) {
            return 0;
        }
        return Math.min(f(arr, i + 1, i1), f(arr, i, i1 - 1));
    }

    private static int f(int[] arr, int i, int i1) {
        if (i == i1) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, i1), arr[i1] + s(arr, i, i1 - 1));
    }
}
