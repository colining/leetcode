package cn.colining.leetcode.palindrome;

/**
 * Created by colin on 2017/7/11.
 */
public class leetcode_9 {
    /*
    Determine whether an integer is a palindrome. Do this without extra space.
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(22));
    }

    /**
     * 回文数，主要需要确定前后是否一致，前面的可以用除法得到，后面的使用求余得到
     * 下面的算法巧妙地借助了左右位数相等来作为边界；简化了运算
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 ||(x != 0 && x % 10 == 0)) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return (x == right || x == right / 10);
    }
}
