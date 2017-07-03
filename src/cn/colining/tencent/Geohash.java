package cn.colining.tencent;

import java.util.Scanner;

/**
 * Created by colin on 2017/7/3.
 */
public class Geohash {
    /**
     * geohash编码：geohash常用于将二维的经纬度转换为字符串，分为两步：第一步是经纬度的二进制编码，第二步是base32转码。
     此题考察纬度的二进制编码：算法对纬度[-90, 90]通过二分法进行无限逼近（取决于所需精度，本题精度为6）。
     注意，本题进行二分法逼近过程中只采用向下取整(并不是)来进行二分，针对二分中间值属于右区间。算法举例如下：
     针对纬度为80进行二进制编码过程：
     1) 区间[-90, 90]进行二分为[-90, 0),[0, 90]，成为左右区间，可以确定80为右区间，标记为1；
     2) 针对上一步的右区间[0, 90]进行二分为[0, 45),[45, 90]，可以确定80是右区间，标记为1；
     3) 针对[45, 90]进行二分为[45, 67),[67,90],可以确定80为右区间，标记为1；
     4) 针对[67,90]进行二分为[67, 78),[78,90]，可以确定80为右区间，标记为1；
     5) 针对[78, 90]进行二分为[78, 84),[84, 90]，可以确定80为左区间，标记为0；
     6) 针对[78, 84)进行二分为[78, 81), [81, 84)，可以确定80为左区间，标记为0；
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        System.out.println(fun(dimension));
        System.out.println(180 / 32.0);
    }

    /**
     * 其实就是在考二分嘛；题目根本就不是向下取整<br>
     * 调了半天。。。。。
     * 另外我认为的精度6是指进行6次编码；180/2^6=5.625<br>
     * 所以看起来和6也差不多
     * @param dimension
     * @return
     */
    private static String fun(int dimension) {
        StringBuilder stringBuilder = new StringBuilder();
        double min = -90;
        double max = 90;
        int i = 6;
        while (i > 0) {
            int mid = (int) (min + max)/2;
            if (dimension >= mid) {
                stringBuilder.append(1);
                min = mid;
            } else if (dimension < mid) {
                stringBuilder.append(0);
                max = mid;
            }
            i--;

        }
        return stringBuilder.toString();
    }

}
