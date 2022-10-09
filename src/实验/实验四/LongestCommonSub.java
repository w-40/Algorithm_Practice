package 实验.实验四;

import java.util.Scanner;

public class LongestCommonSub {

    public static void main(String[] args) {
        //String s1 = "hero";
        //String s2 = "hello";
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个字符串：");
        String s1 = sc.next();
        System.out.print("请输入第二个字符串：");
        String s2 = sc.next();
        int dpHeight = s1.length() + 1;
        int dpWidth = s2.length() + 1;
        String res = lcs(s1, s2, dpHeight, dpWidth);
        System.out.println("最长公共子序列为："+ res);
    }

    private static String lcs(String s1, String s2, int height, int width) {
        int[][] dp = new int[height][width];

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        String lcs = getLcs(dp, s1, s2);
        return lcs;
    }

    private static String getLcs(int[][] dp, String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        StringBuilder sb = new StringBuilder();
        while (i >= 1 && j >= 1) {
            if (s1.charAt(i - 1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if(dp[i][j-1] > dp[i-1][j]) {
                    // 说明相同的字符在行这边，下次遍历的时候应该是同一行，列向前退一格，所以j--
                    j--;
                } else {
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}