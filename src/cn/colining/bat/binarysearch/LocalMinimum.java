package cn.colining.bat.binarysearch;

/**
 * Created by colin on 2017/7/7.
 */
public class LocalMinimum {
    /**
     * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
     * arr的长度为N(N>1)时，如果arr[0]< arr[1]，那么arr[0]是局部最小；
     * 如果arr[N-1]< arr[N-2]，那么arr[N-1]是局部最小；如果0< i< N-1，既有arr[i]< arr[i-1]又有arr[i]< arr[i+1]，那么arr[i]是局部最小。
     * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
     *
     * @param args
     */
    public static void main(String[] args) {

        int left = 5;
        int right = 9;
        int mid1 = (right + left) / 2;
        int mid2 = left + ((right - left) >> 1);
        int mid3 = (right - left) >> 1 + left;
        System.out.println(mid1+","+mid2+","+mid3);
        System.out.println( 0 & 0+1);
        //移位运算符级别比较低
    }

    /**
     * 考察点： 指针移动 +细心；重要条件：相邻元素不相等；如果两端不是局部最小值<br>
     * 这说明两端朝内趋势是下降的；两个下降的趋势最后中间一定会出现最小值；<br>
     * 对于局部来说，可以认为是凹凸不平的，还是会存在局部最小值<br>
     *
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
