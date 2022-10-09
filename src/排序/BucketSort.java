package 排序;

import java.util.Scanner;

/**
 * 桶排序-基础版
 */
public class BucketSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[10];
        for (int i = 1; i <= n; i++) {
            int t = sc.nextInt();
            arr[t]++;//用arr[t]记录每一个数出现的次数
        }
        for (int i = 1000; i >= 0; i--) {
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
