package cn.colining.tencent;

import java.util.Scanner;

/**
 * Created by colin on 2017/7/3.
 */
public class LexicographicalCode {
    /**
     * 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，
     * 如果我们把该编码按字典序排序，形成一个数组如下：
     * a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy
     * 其中a的Index为0，aa的Index为1，aaa的Index为2，
     * 以此类推。 编写一个函数，输入是任意一个编码，
     * 输出这个编码对应的Index.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String i = scanner.next();
        System.out.println(codeIndex(i));
    }

    /**
     * 思路：排列组合的思想<br>
     * a和b之间 有25+25*25+25*25*25个数  (25:aa,ab……ay),<br>
     * (25*25: aaa,aab……aba……ayy);(25*25*25: aaaa,……ayyy)<br>
     * 所以b的位置是 a+ 25+25*25+25*25*25+1<br>
     * 以此类推：ab = aa +25+25*25 +1 <br>
     * aab = aaa + 25 + 1<br>
     * aaab + aaaa + 1;<br>
     * 然后索引从a, aa,aaa开始 0,1,2，可以认为是长度-1<br>
     * @param code
     * @return
     */

    public static int codeIndex(String code) {
        int factor[] = {1 + 25 + 25 * 25 + 25 * 25 * 25, 1 + 25 + 25 * 25, 1 + 25, 1};
        char[] codeArray = code.toCharArray();
        int index = 0;
        int len = 0;
        for (int i = 0; i < codeArray.length; i++) {
            index += factor[len++] * (codeArray[i] - 'a');
        }
        return index + (len - 1);
    }

    public static String deCode(int index) {
        int factor[] = {1 + 25 + 25 * 25 + 25 * 25 * 25, 1 + 25 + 25 * 25, 1 + 25, 1};
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (index > 0) {
            stringBuilder.append((char) ('a' + index / factor[i]));
            index %= factor[i++];
            index--;
        }
        return stringBuilder.toString();
    }
}
