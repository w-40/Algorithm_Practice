package 实验.实验九;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    public static int n;
    public static int[] a = new int[501];
    public static int[] b = new int[501];
    public static int[][] dp = new int[501][501];


    public static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) {

    }


    public static boolean cmp(int a, int b) {
        return a > b;
    }

    public static int solve() {
        int tmp;
        for (int i = 1; i <= n; i++) {
            dp[1][i] = abs(a[1] - b[i]);
        }
        for (int i = 2; i <= n; i++) {
            tmp = INF;
            for (int j = 1; j <= n; j++) {
                tmp = min(tmp, dp[i - 1][j]);//tmp求出了把第i-1段路修成不超过b[j]的最小花费
                dp[i][j] = abs(a[i] - b[j]) + tmp;
            }
        }
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = min(ans, dp[n][i]);
        }
        return ans;
    }

}
