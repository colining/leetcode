package cn.colining.bat.binarysearch;

import java.math.BigInteger;

/**
 * Created by colin on 2017/7/7.
 */
public class QuickPower {
    /**
     * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
     * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getPower(3, 3));
    }

    /**
     * 将N转化为二进制，比如 2的 5次方，<br>
     * 5次方即为101，即2^4*2^1;<br>
     * 2^4 = 2^2*2^2<br>
     * 2^2 = 2^1 *2^1;<br>
     * 最后可以将二进制中每一个1对应的平方求出；<br>
     * 最后将需要的乘起来即可；<br>
     * @param k
     * @param N
     * @return
     */
    public static int getPower(int k, int N) {
        BigInteger result = BigInteger.valueOf(1);
        BigInteger temp = BigInteger.valueOf(k);
        while (N > 0) {
            if ((N & 1) == 1) {
                result = result.multiply(temp);
            }
            N = N >> 1;
            temp = temp.multiply(temp);
            result = result.mod(BigInteger.valueOf(1000000007));
            temp = temp.mod(BigInteger.valueOf(1000000007));
        }
        return result.intValue();
    }
}
