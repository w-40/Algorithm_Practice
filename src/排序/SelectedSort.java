package 排序;

import java.util.Arrays;
import java.util.Scanner;

public class SelectedSort {
    public static void main(String[] args) {
        //int[] arr = {2,5,9,1,6,3};
        System.out.println("请输入要排序的数的个数");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        selectedSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void selectedSort(int[] arr) {
        int min = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
