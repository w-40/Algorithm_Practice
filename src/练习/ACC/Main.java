package 练习.ACC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();//农田数
            int k = sc.nextInt();//装有洒水器的农田数
            List<Integer> list = new ArrayList<>();//有洒水器的农田
            for (int j = 0; j < k; j++) {
                list.add(sc.nextInt());
            }
            int res = 0;
            int max = 0;
            for (int a = 0; a < list.size() - 1; a++) {
                res = (list.get(a + 1) - list.get(a))/2;
                max = Math.max(res,max);
            }
            //找出边界两个洒水器与农田左右边界的最大距离
            max = Math.max(max, list.get(0) - 1);//只有一个洒水器

            max = Math.max(max,n - list.get(list.size() - 1));//农田的数量与最后一个元素和最大值比较

            System.out.println(max + 1);
        }
    }
}
