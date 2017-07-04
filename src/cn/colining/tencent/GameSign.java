package cn.colining.tencent;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by colin on 2017/7/3.
 */
public class GameSign {
    /**
     * 游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。
     * 请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。
     * 输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。
     * 输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println("check"+check(i, j));
//            System.out.println("check"+check1(i, j));
        }

    }

    static int[] map = new int[1024];

    private static int check(int i, int j) {
        if (i > 1024 || i < 1 || j > 1024 || j < 1) {
            return -1;
        }
        map[i - 1] = 1;

        return map[j - 1] == 1 ? 1 : 0;
    }

    /**
     * 首先我们得知道无符号整数位数32位，32*32 = 1024；<br>
     * 所以我们要做的就是将0,1，存在着1024中；由于数组从零开始<br>
     * 所以我们除以32，找到该任务要储存在哪个32中；然后再求余<br>
     * @param i
     * @param j
     * @return
     */
    private static int check1(int i, int j) {
        int indexa1 = (i - 1) / 32;
        int indexa2 = i % 32 == 0 ? 32 : i % 32;

        int indexb1 = (j - 1) / 32;
        int indexb2 = j % 32 == 0 ? 32 : j % 32;

        map[indexa1] |= 1<<(32 - indexa2);
        return map[indexb1] & 1<<(32 - indexb2);

    }

}
