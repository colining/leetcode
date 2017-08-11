package cn.colining;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by colin on 2017/8/11.
 */
public class KMP {
    public static void main(String[] args) {
        String a = "abcdddabce";
        System.out.println(Arrays.toString(findNext(a)));
    }

    public static int[] findNext(String a) {
        int[] next = new int[a.length()+1];
        char[] chars = a.toCharArray();
        for (int i = 1,k=0; i <chars.length; i++) {
            while (k > 0 && chars[k] != chars[i]) {
                k = next[k - 1];
            }
            if (chars[k] == chars[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
