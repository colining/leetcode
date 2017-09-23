package cn.colining.leetcode.string;

import cn.colining.justtest.HeapBigSort;

/**
 * Created by colin on 2017/9/10.
 */
public class leetcode_28 {
    public static void main(String[] args) {
        String s = new String();
        System.out.println(strStr("134561345678", "134567"));
        System.out.println(strStr1("134561345678", "134567"));
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length())
                    return i;
                if (i + j >= haystack.length())
                    return -1;
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
        }
    }

    public static int strStr1(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    public static void makeNext(char[] P, int[] next) {
        int q, k;
        int m = P.length;
        next[0] = 0;
        for (q = 1, k = 0; q < m; ++q) {
            while (k > 0 && P[q] != P[k])
                k = next[k - 1];
            if (P[q] == P[k]) {
                k++;
            }
            next[q] = k;
        }
    }

    public static int kmp(String s, String pattern) {
        if (s.length() < pattern.length()) {
            return -1;
        }
        if (pattern.length() == 0) {
            return 0;
        }
        int next[] = new int[s.length()];
        int n, m;
        int i, q;
        n = s.length();
        m = pattern.length();
        char[] P = pattern.toCharArray();
        char[] T = s.toCharArray();
        makeNext(P, next);
        for (i = 0, q = 0; i < n; ++i) {
            while (q > 0 && P[q] != T[i])
                q = next[q - 1];
            if (P[q] == T[i]) {
                q++;
            }
            if (q == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
