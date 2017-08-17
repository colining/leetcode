package cn.colining.bat.binarytree;

import cn.colining.myjar.TreeNode;

/**
 * Created by colin on 2017/8/17.
 */
public class LongestDistance {
    private int longest = 0;

    public int findLongest(TreeNode root) {
        findDist(root);
        return longest;

    }

    private int findDist(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //对于某个结点它的左右最大距离
        int left = findDist(root.left);
        int right =findDist(root.right);
        longest = Math.max(left + right + 1, longest);
        //返回到上一层的话，就是要返回这层所能提供的最大距离；
        return Math.max(left, right) + 1;

    }
}
