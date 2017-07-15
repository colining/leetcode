package cn.colining.justtest;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by colin on 2017/7/15.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(~5);
//        int a = 5;
//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(Integer.toBinaryString(~5));
//
//
//        int b = 3;
//        System.out.println(Integer.toBinaryString(1 << (b + 1)));
//        System.out.println(Integer.toBinaryString((1 << (b + 1))-1));
//        System.out.println(Integer.toBinaryString(~((1 << (b + 1))-1)));
//
//        int c = 123;
//        int d = 789;
//        System.out.println(Integer.toBinaryString(c));
//        System.out.println(Integer.toBinaryString(d));
//
//        System.out.println(Integer.toBinaryString(c & (~d)));

        Byte a = 4;
        a++;
        add(a);
        System.out.println(a);
    }
    private static void add(Byte a) {
        a++;
    }
}
