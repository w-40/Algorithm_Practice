package 实验.实验六;

import java.util.Scanner;
/**
 * 最大团（最大完全子图）问题
 */
import static java.lang.Math.max;

public class MaxRegiment {
    //全局变量
    public static boolean[][] mp = new boolean[20][20];
    public static int n, m;//顶点数，边数
    public static boolean[] visited = new boolean[20];
    public static int num, res;

     /*
     *  输入顶点数：5
        输入边数：8
        请输入图的边（两两一组用空格隔开）：
1 2
1 5
2 5
5 3
1 3
2 3
3 4
2 4
        最大团中定点的个数为：4
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入顶点数：");
        n = sc.nextInt();
        System.out.print("输入边数：");
        m = sc.nextInt();
        System.out.println("请输入图的边（两两一组用空格隔开）：");
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            mp[a][b] = mp[b][a] = true;
        }
        dfs(1);
        System.out.println("最大团中定点的个数为：" + res);
    }

    public static void dfs(int k) {
        if (k > n)//临界条件
        {
            res = max(res, num);
            return;
        }
        boolean flag = true;//假设当前点k可以放入团中
        for (int i = 1; i < k; i++){//遍历当前点之前的所有点是否与点k可以构成完全子图（团）
            if (visited[i] && !mp[i][k]){//之前的点已放入团中且与点k相连
                flag = false;
                break;//不满足条件退出
            }
        }
        if (flag){//满足条件
            num++;//当前点入团
            visited[k] = true;
            dfs(k + 1);//继续找下一个点
            num--;
            visited[k] = false;//回溯
        }
        dfs(k + 1);//不满足条件直接找下一个点
    }
}
