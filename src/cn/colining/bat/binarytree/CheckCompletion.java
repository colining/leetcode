package cn.colining.bat.binarytree;

import cn.colining.myjar.TreeNode;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by colin on 2017/8/17.
 */
public class CheckCompletion {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
//        treeNode.left.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        CheckCompletion checkCompletion = new CheckCompletion();
        System.out.println(checkCompletion.chk(treeNode));
    }
    public boolean chk(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = queue.peek();
        while (cur != null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
            queue.poll();
            cur = queue.peek();
        }
        while (!queue.isEmpty()) {
            queue.poll();
            if (queue.peek() != null) {
                return false;
            }
        }
        return true;
    }
}
