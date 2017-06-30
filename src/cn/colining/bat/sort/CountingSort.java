package cn.colining.bat.sort;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**
 * Created by colin on 2017/6/27.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28};
        countingSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 计数排序，桶排序的一种，在数据范围不大时，直接借助一堆桶<br>
     * 将每个数扔到对应的桶中；这样这样因为桶是有序的，所以原数组的元素就排好了序
     * @param array
     * @param n
     * @return
     */
    public static int[] countingSort(int array[], int n) {
        int max = array[0];
        int min = array[0];
        //获取最大最小值，用以开辟数组的大小
        for (int i = 0; i < array.length; i++) {
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }
        int[] countArray = new int[max - min + 1];

        //将数组元素依次放到对应的桶中
        for (int i = 0; i < array.length; i++) {
            //array[i]应该放入的桶
            int position = array[i] - min;
            countArray[position]++;
        }
        //将桶中的元素再次倒出来，这样就有序了
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i]-- > 0) {
                array[index++] = min + i;
            }
        }
        return array;
    }
}
