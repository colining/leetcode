package cn.colining.bat.sortchange2;


import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/6/29.
 */
public class ThreeColor {
    /** 题目描述
     * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
     给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,0,1,2,0,1,2,0,0,0,1,1,1,2,2,0,1,2,0};
        System.out.println(Arrays.toString(sortThreeColor(array, array.length)));
    }

    /**
     * 和快排一差不多；小的放在一边，大的放在另外一边；
     *
     * @param array
     * @param length
     * @return
     */
    public static int[] sortThreeColor(int[] array, int length) {
        int indexOf0 = -1;                  //放0的区域，每次放入就向后扩张；
        int indexOf2 = length;              //放2的区域，向前扩张；
        int index = 0;
        while (index < indexOf2) {
            if (array[index] < 1) {
                //小于一的话，就交换，然后继续遍历后面的
                swap(array, ++indexOf0, index++);
            } else if (array[index] > 1) {
                //大于1的话，由于交换过来的是没有进行遍历过的，所以我们需要检测交换过来的数
                swap(array, --indexOf2, index);
            }
            else
                index++;
        }
        return array;
    }


}
