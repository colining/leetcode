package cn.colining.bat.sort.classicsort;

import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/27.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{14, 4, 14};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排思路，利用大根堆头结点最大的特性<br>
     * 首先将数组调换为大根堆，然后把头结点扔出去<br>
     * 重复这个过程
     *
     * @param array
     * @param n
     * @return
     */
    public static int[] heapSort(int[] array, int n) {
        array = buildMaxHeap(array, n);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
        return array;
    }

    private static int[] buildMaxHeap(int[] array, int n) {
        //这个边界坑坏我了，数组长度是从一开始计算的；
        //直接除以二就行了,其实k的起始边界并不重要；
        //很可能第一次压根就不会进行调换，实际上因为数组从零开始，
        // 所以有时会多一次调换
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
}