package cn.colining.bat.string;

/**
 * Created by colin on 2017/7/1.
 */
public class Translation {
    /**
     * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
     给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
     * @param args
     */
    public static void main(String[] args) {
        String abcde = "ABCDE";
        System.out.println(stringTranslation(abcde, abcde.length(), 3));
    }

    /**
     * 依旧是字符串反转的那些事，代码不想改了，<br>
     * 其实直接变成char[]更加节省空间
     * @param string
     * @param n
     * @param len
     * @return
     */
    public static String stringTranslation(String string, int n, int len) {
        string = reverse(string, 0, len - 1);
        string = reverse(string, len, string.length()-1);
        string = reverse(string, 0, string.length()-1);
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
