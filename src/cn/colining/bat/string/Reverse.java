package cn.colining.bat.string;

/**
 * Created by colin on 2017/7/1.
 */
public class Reverse {
    /**
     * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
     * 也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
     * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
     *
     * @param args
     */
    public static void main(String[] args) {
        String string = "dog loves pig";
        System.out.println(reverseSentence(string, string.length()));

    }

    /**
     * 思路： 整体逆序 +部分逆序 == 调换顺序
     * 注意边界问题，空格和字符串到头
     *
     * @param string
     * @param n
     * @return
     */
    public static String reverseSentence(String string, int n) {
        string = reverse(string, 0, string.length() - 1);
        int begin = 0;
        for (int i = 0; i <= string.length(); i++) {
            if (i == string.length() || string.charAt(i) == ' ') {
                string = reverse(string, begin, i - 1);
                begin = i + 1;
            }
        }
        return string;
    }

    private static String reverse(String string, int left, int right) {
        char[] chars = string.toCharArray();
        while (left < right) {
            swap(chars, left++, right--);
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
