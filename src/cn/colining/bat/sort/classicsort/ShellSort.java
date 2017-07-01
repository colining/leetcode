package cn.colining.bat.sort.classicsort;

import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/27.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28};
        shellSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序，有步长设置的插入排序而已，不太常见吧；
     * @param array
     * @param n
     * @return
     */
    public static int[] shellSort(int[] array, int n) {
        for (int step = 3;step>0;step--) {
            for (int i = step; i < array.length; i++) {
                int j=1;
                while (i - j * step >= 0) {
                    if (array[i-step*(j-1)] < array[i - step*j]) {
                        swap(array, i-step*(j-1), i - step*j);
                        j++;
                        continue;
                    }
                    break;
                }
            }
        }
        return array;
    }
}