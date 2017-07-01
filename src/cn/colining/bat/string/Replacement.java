package cn.colining.bat.string;

/**
 * Created by colin on 2017/7/1.
 */
public class Replacement {
    /**
     *  空格替换
     * @param args
     */
    public static void main(String[] args) {
        String string = "qw";
        System.out.println(replaceSpace(string, string.length()));
        System.out.println(replaceSpace1(string, string.length()));
    }

    /**
     * 使用Java的StringBuilder类，直接append
     * @param iniString
     * @param length
     * @return
     */
    public static String replaceSpace(String iniString, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iniString.length(); i++) {
            if (iniString.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(iniString.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Java中原地的调换不现实，所以添加了新的数组，假装实现一下好了
     * @param string
     * @param length
     * @return
     */
    private static String replaceSpace1(String string, int length) {
        char[] chars = string.toCharArray();
        int num = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                num++;
            }
        }
        char[] afterChars = new char[chars.length + num * 2];
        int index = afterChars.length-1;
        for (int i = chars.length-1; i >=0; i--) {
            if (chars[i] != ' ') {
                afterChars[index--] = chars[i];
            } else if (chars[i] == ' ') {
                afterChars[index--] = '0';
                afterChars[index--] = '2';
                afterChars[index--] = '%';
            }
        }
        return String.valueOf(afterChars);
    }
}
