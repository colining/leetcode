package cn.colining.bat;

import cn.colining.myjar.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by colin on 2017/6/26.
 */
public class TreePrinter {
    /**
     * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
     * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left = new TreeNode(7);
    }

    /**
     * 解法重点是last 和nlast两个指针<br>
     * last是本行最右结点位置，当当前结点==last 换行<br>
     * nlast 是用来指向下一行的最右结点，当换行的时候将其赋给last<br>
     * nlast每次指向加入队列的新结点，最后就可以得到最有结点是哪个了；
     * @param root
     * @return
     */
    public static int[][] printTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        //将list转化为数组，通过List<List<Integer>>
        List<List<Integer>> outList = new ArrayList<List<Integer>>();
        List<Integer> inList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode last = root;
        TreeNode nlast = null;

        while (queue.peek() != null) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                nlast = treeNode.left;
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                nlast = treeNode.right;
            }
            inList.add(treeNode.val);
            if (treeNode == last) {
                last = nlast;
                outList.add(inList);
                inList = new ArrayList<Integer>();
            }
        }
        int[][] array = new int[outList.size()][];

        for(int i=0; i < outList.size(); i++){
            array[i] = new int[outList.get(i).size()];
            for(int j = 0; j < outList.get(i).size(); j++){
                array[i][j] = outList.get(i).get(j).intValue();
            }
        }
        return array;
    }
}
