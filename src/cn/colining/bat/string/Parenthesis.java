package cn.colining.bat.string;

/**
 * Created by colin on 2017/7/1.
 */
public class Parenthesis {
    /**
     * 括号合法性验证
     * @param args
     */
    public static void main(String[] args) {
        String string = "(()a())";
        System.out.println(chkParenthesis(string, string.length()));
    }

    /**
     * 终点站就在于num <0 这个判断，证明了前面这部分右括号数目大于左括号<br>
     * 不可能达到平衡了
     * @param A
     * @param n
     * @return
     */
    public static boolean chkParenthesis(String A, int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                num++;
            } else if (A.charAt(i) == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        return num == 0 ? true : false;
    }
}
