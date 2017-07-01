package cn.colining.bat.sort.classicsort;

import java.util.Arrays;

/**
 * Created by colin on 2017/6/27.
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{5,2,20,300,200};
        radixSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 基数排序，几乎可认为是最原始的数比较方式<br>
     *     由于之前没接触过，所以写的稍微细一点好了
     * @param array
     * @param n
     * @return
     */
    public static int[] radixSort(int[] array, int n) {
        //0~9 十个桶，每个能放n个数
        int[][] radixArray = new int[10][n];
        //用以记录每个桶有几个值
        int[] count = new int[10];
        //用来处理是否需要继续比较的flag
        boolean flag = true;
        for (int a = 1; ; a*=10) {
            for (int anArray : array) {
                //求得该位置的值，用以进行比较
                int p = anArray / a % 10;
                //当所有值模10为零，就判断是否还有位数更大的整数
                //比如【5,2,20,300,200】 很显然，200,300,模10都是0，
                //但仍然需要比较
                if (p == 0 && anArray / a > 0) {
                    flag = false;
                }
                radixArray[p][count[p]++] = anArray;
            }

            if (count[0] == array.length && flag) {
                System.out.println(a);
                break;
            }
            flag = true;
            int index = 0;
            for (int i = 0; i < radixArray.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    array[index++] = radixArray[i][j];
                    radixArray[i][j] = 0;
                }
                count[i] = 0;
            }
        }
        return array;
    }
}
