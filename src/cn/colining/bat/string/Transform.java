package cn.colining.bat.string;

/**
 * Created by colin on 2017/6/30.
 */
public class Transform {
    /**
     * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
     * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
     * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
     * @param args
     */
    public static void main(String[] args) {
        String abbc = "abbc";
        String str1 = abbc;
        String str2 = "bcbc";
        System.out.println(chkTransform(str1, str1.length(), str2, str2.length()));
    }


    /**
     *  思路：通过hashmap来储存每一个字符出现的个数，然后比较<br>
     *  这里简单的使用了map数组，可以看作是计数排序，大同小异的啦
     * @param A
     * @param lena
     * @param B
     * @param lenb
     * @return
     */
    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        if (lena != lenb || A == null || B == null) {
            return false;
        }

        int[] map = new int[256];
        for (int i = 0 ; i<lena;i++) {
            map[A.charAt(i)]++;
            map[B.charAt(i)]--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
