package cn.colining.bat.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by colin on 2017/7/1.
 */
public class Prior {
    /**
     * 对于一个给定的字符串数组，请找到一种拼接顺序，
     * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
     * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
     * @param args
     */
    public static void main(String[] args) {
        String[] strings = new String[]{"ba", "b"};
        System.out.println(findSmallest(strings, strings.length));
    }

    /**
     * 思路：通过strs[] 拼接比较，即可将strs[]以正确顺序排列
     * @param strs
     * @param n
     * @return
     */
    public static String findSmallest(String[] strs, int n) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
