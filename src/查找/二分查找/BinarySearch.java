package 查找.二分查找;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,8,11,19,22,31,35,40,45,48,49,50};
        int target = 48;
        int idx = binarySearch(arr,target);
        System.out.println(idx);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0,right = arr.length - 1;
        int m;
        while (left <= right) {
            /**
             * 初步优化解决整数溢出问题
             * (left + right) / 2 = left/2 + right/2 = left - left/2 + right/2
             * = left + (-left/2 + right /2)
             * = left + (right - left) / 2;
             */
            //m = left + (right - left) / 2;
            /**
             * 再优化：使用无符号（>>>）的右移运算，右移一位
             * 补充：有符号为：>>
             */
            m = (left + right) >>> 1;
            if (arr[m] == target) {
                return m;
            } else if(arr[m] > target) {
                right = m - 1;
            } else {
                left = m + 1;
            }
        }
        return -1;
    }
}
