package cn.colining.justtest;

/**
 * Created by colin on 2017/7/15.
 */
public class HelloSogou{
    public static synchronized void main(String[] a){
        Thread t=new Thread(){
            public void run(){Sogou();}
        };
        t.start();
        System.out.print("Hello");
    }
    static synchronized void Sogou(){
        System.out.print("Sogou");
    }


}