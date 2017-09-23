package cn.colining.leetcode.math;

/**
 * Created by colin on 2017/9/12.
 */
public class leetcode_29 {
    public static void main(String[] args) {
        System.out.println(divide(100 ,5));
    }
    /*
    大面积的输入和输出检测
     */
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend < 0&& divisor>0 || divisor < 0&& dividend >0) {
            sign = -1;
        }
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if (lDividend == 0) {
            return Integer.MAX_VALUE;
        }
        if (lDividend < lDivisor || lDividend == 0) {
            return 0;
        }
        long result = ldivide(lDividend, lDivisor);
        if (result > Integer.MAX_VALUE) {
            result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else {
            result = sign * result;
        }
        return (int) result;
    }
    /*
    核心其实就是加法操作，只不过这里我们是平方的+，相当于2分了，这样就会快超级多；
     */
    public static long ldivide(long lDividend, long lDicisor) {
        if (lDividend < lDicisor) {
            return 0;
        }
        long multiple = 1;
        long sum = lDicisor;
        while ((sum + sum) <= lDividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(lDividend - sum, lDicisor);
    }

}
