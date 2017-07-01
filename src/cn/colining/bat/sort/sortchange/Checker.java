package cn.colining.bat.sort.sortchange;

/**
 * Created by colin on 2017/6/27.
 */
public class Checker {
    /** 题目
     * 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
     给定一个int数组A及它的大小n，请返回它是否有重复值。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(checkDuplicate(array, array.length));
    }

    /**
     * 因为堆排序是就地排序，所以空间复杂度可以认为是O(1)
     * @param array
     * @param n
     * @return
     */
    public static boolean checkDuplicate(int[] array, int n) {
        heapSort(array, n);
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]==array[i+1])
                return true;
        }
        return false;
    }

    public static int[] heapSort(int[] array, int n) {
        array = buildMaxHeap(array, n);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
        return array;
    }

    private static int[] buildMaxHeap(int[] array, int n) {
        for (int k = array.length >> 1; k >= 0; k--) {
            adjustHeap(array, k, array.length);
        }
        return array;
    }

    private static void adjustHeap(int[] array, int k, int length) {
        int temp = array[k];
        for (int j = 2 * k + 1; j < length; j = 2 * k + 1) {
            if (j < length - 1 && array[j] < array[j + 1]) {
                j++;
            }
            if (temp > array[j]) {
                break;
            } else {
                array[k] = array[j];
                k = j;
            }
        }
        array[k] = temp;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}