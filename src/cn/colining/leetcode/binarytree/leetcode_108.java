package cn.colining.leetcode.binarytree;

import cn.colining.myjar.TreeNode;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_108 {
    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1,3};
        sortedArrayToBST(array);
    }

    /**
     * 这道题的思路其实就是平衡二叉树平衡，所以二分找根节点
     * 递归寻找；实际意义不大，因为这样建立的二叉树有多种；
     * 比如数组[1,3] 1,3和3,1都是平衡的；但是却不一样
     * 在算mid的时候可以+1，这样得到的就是靠后的中位数了，上面就会比较大；
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = ((right - left) >> 1) + left;
        TreeNode head = buildTree(0, nums.length-1, nums);
        return head;
    }

    private static TreeNode buildTree(int left, int right, int[] nums) {
        if (left >right) {
            return null;
        }

        int mid = ((right - left) >> 1) + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(left, mid-1, nums);
        node.right = buildTree(mid + 1, right, nums);
        return node;
    }
}
