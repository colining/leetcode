package cn.colining.leetcode.dfs;

import cn.colining.myjar.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;

/**
 * Created by colin on 2017/8/7.
 */
public class leetcode_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.left.right.left = new TreeNode(4);
//        root.right = new TreeNode(2);
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root, 0);
        return flag;
    }

    public static boolean flag = true;
    public static int maxDepth(TreeNode root,int d) {
        if (root == null) {
            return d;
        }
        d++;
        int d2 = maxDepth(root.left, d);
        int d3 = maxDepth(root.right, d);

        if (Math.abs(d2 - d3) > 1) {
            flag = false;
        }
        return Math.max(d2, d3);
    }
}
