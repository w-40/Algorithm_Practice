package 课堂练习.查找;

/**
 * 顺序检索问题
 */

import java.util.Scanner;

public class SequentialRetrieval {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("input:");
        Scanner sc = new Scanner(System.in);
        float in = sc.nextFloat();
        int i = 1;
        while (i < 6) {
            System.out.println("第" + (i) + "次");
            if (arr[i] == in) {
                System.out.println("找到了");
                return;
            }
            if (arr[i] > in) {
                System.out.println("没找到，找了" + i + "次");
                return;
            }
            i++;
        }
    }
}
