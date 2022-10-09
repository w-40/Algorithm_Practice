package 实验.实验三;

import java.util.Arrays;
import java.util.Scanner;

public class PostAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入居民点的个数：");

        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        System.out.println("请依次输入居民点的位置");
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);

        double Zx = 0;
        double Zy = 0;
        //求中位数
        if (N % 2 == 0) {
            Zx = 1.0 * (x[N / 2 - 1] + x[N / 2]) / 2;
            Zy = 1.0 * (y[N / 2 - 1] + y[N / 2]) / 2;
        } else {
            Zx = x[N / 2];
            Zy = y[N / 2];
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(x[i] - Zx);
            sum += Math.abs(y[i] - Zy);
        }

        System.out.println("距离总和的最小值：" + (int) sum);
    }
}
