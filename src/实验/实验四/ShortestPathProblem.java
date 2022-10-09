package 实验.实验四;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 多源点最短路径问题
 * 给定带权有向图 G=（V，E），对任意顶点Vi和Vj（i！=j）
 * 求出顶点Vi 到顶点 Vj的最短路径长度，输出结果，输出时要求有文字说明。请任选一种语言编写程序实现上述算法，并分析其算法复杂度。
 */
public class ShortestPathProblem {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入图的结点数：");
        int n = Integer.parseInt(br.readLine());
        int INF = 65535;
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(split[j]) == 0) {
                    dis[i][j] = INF;
                } else {
                    dis[i][j] = Integer.parseInt(split[j]);
                }
            }
        }
        Graph graph = new Graph(dis);
        graph.floyd();
        graph.print();
    }
}

class Graph {
    int n;
    int[][] dis;
    int INF = 65535;

    public Graph(int[][] dis) {
        this.dis = dis;
        n = dis.length;
    }

    public void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                    }
                }
            }
        }
    }

    /*
     * 输出n行，第i行表示第i个点到其他点的最短路径长度，如果没有可达的路径，则输出-1
     */
    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print("第" + i + "个点：");
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print("0 ");
                } else if (dis[i][j] == INF) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(dis[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
