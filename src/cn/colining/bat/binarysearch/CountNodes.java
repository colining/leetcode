package cn.colining.bat.binarysearch;

import cn.colining.myjar.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by colin on 2017/7/7.
 */
public class CountNodes {
    /**
     * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
     * 给定树的根结点root，请返回树的大小。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);

        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);

        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(5);

        treeNode.left.right.left = new TreeNode(6);
        treeNode.left.right.right = new TreeNode(7);


        treeNode.right = new TreeNode(-1);
        treeNode.right.left = new TreeNode(-3);
        treeNode.right.right = new TreeNode(-4);
        treeNode.right.left.left = new TreeNode(-5);
        treeNode.right.left.right = new TreeNode(-6);

        System.out.println(count(treeNode));
    }

    /**
     * 条件：完全二叉树<br>
     * 因为如果是完全二叉树，同一层，对半来看，总有一侧会形成一个小的完全二叉树<br>
     * 如果左右子树高度相同，左子树就是完全二叉树；<br>
     * 如果左边大，右边小，右子树是一个完全二叉树<br>
     * @param root
     * @return
     */
    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        TreeNode mostLeft = null;
        TreeNode node = root;
        int heightLeft = 0;
        while (node != null) {
            mostLeft = node;
            heightLeft++;
            node = node.left;
        }
        int heightRight = 1;
        node = root.right;
        TreeNode mostLeftOfRIghtTree = null;
        while (node != null) {
            mostLeftOfRIghtTree = node;
            heightRight++;
            node = node.left;
        }

        if (heightLeft == heightRight) {
            count = (int) (Math.pow(2, heightLeft-1) - 1);
            return count + count(root.right)+1;
        }
        else {
            count = (int) (Math.pow(2, heightRight - 1) - 1);
            return count + count(root.left) + 1;
        }

    }
}
