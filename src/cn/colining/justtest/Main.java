package cn.colining.justtest;

/**
 * Created by colin on 2017/7/30.
 */
import java.util.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int cut(int[] parts) {
        /*
        类似霍夫曼树？这题真的没看懂啊
         */
        if (parts == null || parts.length == 0) {
            return 0;
        }
        if (parts.length == 1) {
            return parts[0];
        }
        int sum = 0;
        for (int i = 0; i < parts.length-1; i++) {
            Arrays.sort(parts, i, parts.length);
            parts[i+1] = parts[i] + parts[i+1];
            sum += parts[i+1];
        }
        return sum;
    }

    static int cut1(int[] parts){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < parts.length; i++) {
            priorityQueue.add(parts[i]);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            int m = priorityQueue.poll();
            int n = priorityQueue.poll();
            priorityQueue.add(m + n);
            sum += (m + n);
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
        System.out.println(cut1(parts));
    }
}
