package 实验.实验三;
/**
 *  汉诺塔问题的程序设计:
 *      在 A 上有按大小排序好的 n 个金碟，借助 B 的帮助，将 A 上的碟子移动到 C 上，在移动的过
 *      程中要严格按照大小顺序，不能将碟子放在比它小的上面，输出结果，输出时要求有文字说明。请
 *      任选一种语言编写程序实现上述算法，并分析其算法复杂度。
 */

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        System.out.println("请输入圆盘的个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("-------------------------");
        System.out.println("移动流程为：");
        hanoi(n, 'A', 'B', 'C');
    }

    private static void hanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("第1个盘从：" + a + "->" + c);
        } else {
            hanoi(n - 1, a, c, b);
            System.out.println("第" + n + "个盘从：" + a + "->" + c);
            hanoi(n - 1, b, a, c);
        }
    }
}
