package cn.colining.leetcode.array;

/**
 * Created by colin on 2017/7/18.
 */
public class leetcode_80 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,2};
        System.out.println(removeDuplicates(array));
    }

    public static int simpleRemoveDuplicates(int[] nums) {
        int length = 0;
        if (nums == null || nums.length == 0) {
            return length;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != nums[length]) {
                nums[++length] = nums[i];
            }
        }
        return length + 1;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int j = 0;
        int step = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
                step = 0;
            }
            else if (nums[i] == nums[j] && step == 0) {
                nums[++j] = nums[i];
                step++;
            }

        }
        return ++j;
    }
}
