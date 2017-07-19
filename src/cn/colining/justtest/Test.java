package cn.colining.justtest;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by colin on 2017/7/15.
 */
public class Test {
    public static void main(String[] args) {
        Object a = "123";
        int str = 123;
        Object b = str;
        Object c = new Object();
        c = "123";
        System.out.println(b == c);
        System.out.println(a == b);
    }



}
class B {

    public B() {
    }
}
