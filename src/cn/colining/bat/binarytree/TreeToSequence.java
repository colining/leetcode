package cn.colining.bat.binarytree;

import cn.colining.myjar.TreeNode;

import java.util.ArrayList;

/**
 * Created by colin on 2017/8/13.
 */
public class TreeToSequence {
//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(3);
//        TreeToSequence treeToSequence = new TreeToSequence();
//        int [][] array = treeToSequence.convert(treeNode);
//        System.out.println(array.toString());
//    }
    public int[][] convert(TreeNode root) {
        arrayLists.add(new ArrayList<Integer>());
        func1(root);
        arrayLists.add(new ArrayList<Integer>());
        func2(root);
        arrayLists.add(new ArrayList<Integer>());
        func3(root);
        int[][] array = new int[3][arrayLists.get(0).size()];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arrayLists.get(0).size(); j++) {
                array[i][j] = arrayLists.get(i).get(j);
            }
        }
        return array;
    }

    public static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

    public void func1(TreeNode root) {
        if (root == null) {
            return;
        }
        arrayLists.get(0).add(root.val);
        func1(root.left);
        func1(root.right);
    }
    public void func2(TreeNode root) {
        if (root == null) {
            return;
        }
        func2(root.left);
        arrayLists.get(1).add(root.val);
        func2(root.right);
    }
    public void func3(TreeNode root) {
        if (root == null) {
            return;
        }
        func3(root.left);
        func3(root.right);
        arrayLists.get(2).add(root.val);
    }
}
