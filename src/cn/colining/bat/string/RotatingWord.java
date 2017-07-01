package cn.colining.bat.string;

/**
 * Created by colin on 2017/6/26.
 */
public class RotatingWord {
    public static void main(String[] args) {
        String a = "1234";
        String b = "2314";
//        System.out.println(isRotateSting1(a, b));
        getNext("ABACABABAC");
    }

    private static boolean isRotateSting1(String originSting, String rotateSting) {
        if (originSting == null || rotateSting == null || originSting.length() != rotateSting.length()) {
            return false;
        }
        originSting = originSting + originSting;
        return originSting.contains(rotateSting);
    }

    private static boolean isRotateSting2(String originSting, String rotateSting) {
        if (originSting == null || rotateSting == null || originSting.length() != rotateSting.length()) {
            return false;
        }
        originSting = originSting + originSting;
        return KMP(originSting, rotateSting);
    }


    public static int[] getNext(String ps) {
        char[] strKey = ps.toCharArray();
        int[] next = new int[strKey.length];

        // 初始条件
        int j = 0;              //j就是当前字符的位置，
        int k = -1;             //k指的是当前字符所能匹配的最长串的位置，
        next[0] = -1;

        // 根据已知的前j位推测第j+1位
        while (j < strKey.length - 1) {
            if (k == -1 || strKey[j] == strKey[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    public static boolean KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return true;
        } else {
            return false;
        }

    }

}
