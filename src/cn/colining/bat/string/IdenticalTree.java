package cn.colining.bat.string;

import cn.colining.myjar.TreeNode;

/**
 * Created by colin on 2017/6/30.
 */
public class IdenticalTree {
    /**
     * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
     * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(7);
        treeNode.left.right = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(6);
        treeNode1.right = new TreeNode(1);
        System.out.println(chkIdentical(treeNode, treeNode1));
    }

    /**
     * 思路：将二叉树序列化，因为序列化可以完全体现特征<br>
     *     只要比较两个字符串是否一样即可
     * @param A
     * @param B
     * @return
     */
    public static boolean chkIdentical(TreeNode A, TreeNode B) {
        String strA = serialize(A, new StringBuilder()).toString();
        String strB = serialize(B, new StringBuilder()).toString();
        return strA.contains(strB);
    }

    private static StringBuilder serialize(TreeNode a, StringBuilder s) {
        if (a == null) {
            s.append("#!");
            return s;
        } else
            s.append(a.val + "!");
        serialize(a.left, s);
        serialize(a.right, s);
        return s;
    }
}
