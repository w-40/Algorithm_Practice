package 练习.最长子序列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a1 = new int[m];
        for (int i = 0; i < a1.length; i++) {
            a1[i] = sc.nextInt();
        }
        int[] a2 = new int[n];
        for (int i = 0; i < a2.length; i++) {
            a2[i] = sc.nextInt();
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a2[i] == a1[j]) {
                    res = a2[i] + " " + res;
                }
            }
        }
        System.out.println(res);
    }
}
