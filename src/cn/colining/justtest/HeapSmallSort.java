package cn.colining.justtest;

import java.util.Scanner;

/**
 * Created by colin on 2017/9/2.
 */
public class HeapSmallSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HeapSmallSort heapBigSort = new HeapSmallSort();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            heapBigSort.heapSort(array, array.length);
        }
    }

    public   int []  heapSort(int[] arr, int n) {
        //构建大根堆，将原数组调整顺序
        int[] array = buildSmallHeap(arr);
        //调换头结点，然后继续调正顺序
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjust(array, 0, i);
        }
        for (int i : array) {
            System.out.println(i);
        }
        return array;
    }
    public static int[] buildSmallHeap(int[] array) {
        for(int i = array.length/2-1; i>=0;i--) {
            adjust(array, i, array.length);
        }
        return array;
    }
    //length 是截止位置，不包含它
    public static void adjust(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length; i = 2 * k + 1) {
             i = (i < length - 1 && array[i] > array[i + 1]) ? i + 1 : i;
            if (array[i] < temp) {
                array[k] = array[i];
                k = i;
                continue;
            }
            break;
        }
        array[k] = temp;
    }
}
