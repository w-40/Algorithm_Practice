package 实验.实验一;

import java.util.Scanner;
/**
 * BF算法
 */
public class TestBF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int result = BF(S, T);
        if (result != -1) {
            System.out.println("匹配成功，实际位置（从1开始）为：" + (result + 1));
        } else {
            System.out.println("匹配失败");
        }
    }

    public static int BF(String S, String T) {
        char[] charS = S.toCharArray();
        char[] charT = T.toCharArray();

        int i = 0, j = 0;
        int index;
        while (i < charS.length && j < charT.length) {
            if (charS[i] == charT[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (i <= charS.length) {
            index = i - charT.length;
        } else {
            index = -1;
        }
        return index;
    }
}
