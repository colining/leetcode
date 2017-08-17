package cn.colining.bat.binarytree;

import cn.colining.myjar.TreeNode;

/**
 * Created by colin on 2017/8/17.
 */
public class MaxSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(1);
        MaxSubtree maxSubtree = new MaxSubtree();
        System.out.println(maxSubtree.getMax(root).val);
    }
    public TreeNode getMax(TreeNode root) {
        // write code here
        if(root==null){
            return null;
        }
        return func(root);
    }

    int min;
    int max;
    int amount;
    private TreeNode func(TreeNode root) {
        if (root == null) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            amount = 0;
            return null;
        }

        TreeNode leftNode = func(root.left);
        int lmin = min;
        int lmax = max;
        int lamount = amount;
        TreeNode rightNode = func(root.right);
        int rmin = min;
        int rmax = max;
        int ramount = amount;

        max = Math.max(root.val, max);
        min = Math.min(root.val, min);

        //当前节点是一个搜索二叉树的根节点，所以可以继续向上寻找
        if (leftNode == root.left && rightNode == root.right && lmax < root.val && rmin > root.val) {
            amount = lamount + ramount + 1;
            return root;
        }
        //当前结点无法作为左右两个搜索二叉树的根节点，那就从左右选个大的返回；
        amount = Math.max(lamount, ramount);
        return ramount >= lamount ? rightNode : leftNode;
    }

}