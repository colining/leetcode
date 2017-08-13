package cn.colining.bat.binarytree;

import cn.colining.bat.string.RotatingWord;
import cn.colining.myjar.TreeNode;

/**
 * Created by colin on 2017/8/13.
 */
public class TreeToString {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        TreeToString treeToString = new TreeToString();
        System.out.println(treeToString.toString(treeNode));
    }
    public String toString(TreeNode root) {
        func1(root);
        return stringBuilder.toString();
    }

    public StringBuilder stringBuilder = new StringBuilder();


    public void func1(TreeNode root) {
        if (root == null) {
            stringBuilder.append("#!");
            return;
        }
        stringBuilder.append(root.val + "!");
        func1(root.left);
        func1(root.right);
        return;
    }
}
