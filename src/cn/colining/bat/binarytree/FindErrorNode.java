package cn.colining.bat.binarytree;

import cn.colining.myjar.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 2017/8/17.
 */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        mindOrder(root, list);
        int a = -1;
        int b = -1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                a = a == -1 ? list.get(i - 1):a;
                b = list.get(i);
            }
        }
        return new int[]{a, b};
    }

    private void mindOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        mindOrder(root.left,list);
        list.add(root.val);
        mindOrder(root.right, list);
    }
}
