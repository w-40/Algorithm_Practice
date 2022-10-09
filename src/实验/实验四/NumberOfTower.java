package 实验.实验四;


import java.util.Scanner;

/**
 * 数塔问题：
 * 给出一个数塔，从该数塔的顶层出发，在每一个节点可以选择向左走或向右走，一直走到该数
 * 塔的最底层，找出一条路径，使得路径上的数值和最大，输出最大数值及其路径，输出时要求有文
 * 字说明。请任选一种语言编写程序实现上述算法，并分析其算法复杂度。
 */
public class NumberOfTower {
    public static int[][] dp = new int[101][101];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("请输入数塔的层数：");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (dp[i + 1][j] > dp[i + 1][j + 1]){
                    dp[i][j] += dp[i + 1][j];
                }
                else
                    dp[i][j] += dp[i + 1][j + 1];
            }
        }
        System.out.println(dp[1][1]);
    }
}
