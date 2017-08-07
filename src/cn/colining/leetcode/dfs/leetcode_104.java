package cn.colining.leetcode.dfs;

import cn.colining.myjar.TreeNode;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by colin on 2017/8/7.
 */
public class leetcode_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(2);
        System.out.println(maxDepth(root,0));
    }
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    public static int maxDepth(TreeNode root,int d) {
        if (root == null) {
            return d;
        }
        d++;
        return Math.max(maxDepth(root.left, d), maxDepth(root.right, d));
    }
}
