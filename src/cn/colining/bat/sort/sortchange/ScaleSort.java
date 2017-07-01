package cn.colining.bat.sort.sortchange;

import java.util.Arrays;

/**
 * Created by colin on 2017/6/27.
 */
public class ScaleSort {
    /**
     * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
     * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
     给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{2,1,4,3,6,5,8,7,10,9};
        sortElement(array, array.length, 2);
        int[] array1 = new int[]{10, 9};
    }

    public static int[] sortElement(int[] array, int n, int k) {
        int[] back = new int[k];
        System.arraycopy(array, 0, back, 0, k);
        back = buildMinHeap(back, k);
        int index=0;
        for (int i = 0; i < array.length-k; i++) {
            array[i] = back[0];
            back[0] = array[i + k];
            adjustHeap(back, 0, k);
            index = i;
        }
        for(int i=n-k;i<n;i++){
            array[i] = back[0];//heap[0] 仍然是最小数
            int temp = back[0];
            back[0] = back[k-1];
            back[k-1] = temp;
            adjustHeap(back, 0, --k);//k的长度不断减小
        }
        System.arraycopy(back, 0, array, array.length - k, k);
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int[] heapSort(int[] array, int n) {
        array = buildMinHeap(array, n);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
        return array;
    }

    private static int[] buildMinHeap(int[] array, int n) {
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
            if (j < length - 1 && array[j] > array[j + 1]) {
                j++;
            }
            if (temp < array[j]) {
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