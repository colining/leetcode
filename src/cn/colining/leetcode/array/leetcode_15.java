package cn.colining.leetcode.array;

import java.util.*;

/**
 * Created by colin on 2017/9/4.
 */
public class leetcode_15 {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
    public static List<List<Integer>> threeSum(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ArrayList<List<Integer>> arrayLists = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i+2 < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int j = i + 1, k = array.length - 1;
            int target = -array[i];
            while (j < k) {
                if (array[j] + array[k] == target) {
                    arrayLists.add(Arrays.asList(array[i], array[j], array[k]));
                    j++;
                    k--;
                    while (j < k && array[j] == array[j - 1]) {
                        j++;
                    }
                    while (j < k && array[k] == array[k+1]) {
                        k--;
                    }
                } else if (array[j] + array[k] > target) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return arrayLists;
    }
}
