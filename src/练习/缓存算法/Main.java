package 练习.缓存算法;
/**
 * 设计缓存（长度一样)，添加、查询
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] a = new int[3];
    // 指针
    static int h = 0;
    static int[] b = new int[1000010];

    public static void add(int x) {
        if (h < 3) {
            a[h++] = x;
            b[x]++;
        } else {
            h = 0;
            b[a[h]]--;
            a[h++] = x;
            b[x]++;
        }
    }

    public static boolean find(int x) {
        if (b[x] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 要存入几个数字
        int x = Integer.parseInt(bf.readLine());
        while (x-- != 0) {
            int a = Integer.parseInt(bf.readLine());
            add(a);
        }
        boolean flag = find(5);
        System.out.println(flag);
    }

}

