package cn.colining.bat.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 2017/8/17.
 */
public class FoldPaper {
    public static void main(String[] args) {
        FoldPaper foldPaper = new FoldPaper();
        String [] a = foldPaper.foldPaper(2);
        for (String s : a) {
            System.out.println(s);
        }
    }
    public String[] foldPaper(int n) {
        // write code here
        List<String> list = new ArrayList<>();
        func(1, n, true, list);
        String[] strings = new String[list.size()];
        for (int s = 0; s < strings.length; s++) {
            strings[s] = list.get(s);
        }
        return strings;
    }

    private void func(int i, int n,boolean down, List<String> list) {
        if (i > n) {
            return;
        }
        func(i + 1, n, true, list);
        list.add(down ? "down" : "up");
        func(i + 1, n, false, list);
    }
}
