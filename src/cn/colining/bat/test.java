package cn.colining.bat;

import java.io.File;

/**
 * Created by colin on 2017/6/26.
 */
public class test {
    public  static  void  main(String [] arg)
    {
        File dir = new File("");
        dir.listFiles((File f)->f.getName().endsWith("Java"));
        dir.listFiles( f->f.getName().endsWith("Java"));
        int a = 010;
        System.out.println(a);
    }

}
